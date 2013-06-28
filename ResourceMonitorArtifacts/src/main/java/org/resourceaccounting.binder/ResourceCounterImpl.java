package org.resourceaccounting.binder;

import org.resourceaccounting.ObjectSizeProvider;
import org.resourceaccounting.contract.ResourceContract;
import org.resourceaccounting.contract.ResourceContractProvider;
import org.resourceaccounting.ResourcePrincipal;
import org.resourceaccounting.utils.HashMap;
import org.resourceaccounting.utils.Map;
import org.resourceaccounting.utils.MyList;
import org.resourceaccounting.utils.MyTimerTask;

import java.util.Iterator;


/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 5/13/13
 * Time: 12:01 PM
 *
 * Performs the accounting. it is a package class
 */
class ResourceCounterImpl {


    /**
     * Keep all alive invocations
     */
    private HashMap<Thread, InvocationResourcePrincipal> activatedInvocations;

    int currentTimeStamp = 0;

    private HashMap<ResourcePrincipal, LastMeasurements> lastMeasurements;

    private int countOfPrincipals = 0;
    private long totalReceived = 0;
    private long totalSent = 0;

    long getTotalReceived() {
        return totalReceived;
    }

    long getTotalSent() {
        return totalSent;
    }



    private class LastMeasurements {

        int timeStamp;

        long cpu;
        long sent;
        long received;
        private LastMeasurements(long cpu, long sent, long received) {
            this.cpu = cpu;
            this.sent = sent;
            this.received = received;
        }

    }
    private ResourcePrincipal[] principals = new ResourcePrincipal[1000];
    private ResourcePrincipal[] cachePrincipals = new ResourcePrincipal[0];

    private ResourceContractProvider resourceContractProvider;

    private ObjectSizeProvider objectSizeProvider = new ObjectSizeProvider() {
        public long sizeOf(Object obj) {
            return 1; // account the number of Objects
        }
    };

    ResourceCounterImpl() {
        activatedInvocations
                = new HashMap<Thread, InvocationResourcePrincipal>();

        lastMeasurements
                = new HashMap<ResourcePrincipal, LastMeasurements>();

        // Invocation can spawn new threads and the system can only discard
        // such invocations when every thread is done
        // this simple task in in charge of performing such a task
        // Additionally, this task is in charge of
        MyTimerTask tt = new MyTimerTask() {
            public void run() {
                MyList<Thread> l = new MyList<Thread>();
                synchronized (ResourceCounterImpl.this) {
                    // 1 - free all invocations you can
                    for (Thread th :activatedInvocations.keySet())
                        if (!th.isAlive()) l.add(th);
                    for (int i = 0 ; i < l.size() ; i++) {
                        Thread t = l.get(i);
                        InvocationResourcePrincipal rp = activatedInvocations.remove(t);
                        rp.decreaseUsers();
                        if (rp.isReadyToBeFree()) {
                            processInvocation(rp);
                        }
                    }
                    // 2 - check if everybody is meeting the contract
                    checkContract();
                }
            }
        };
        tt.executeAtFixedRate(1000);
    }
    private void checkContract() {
        currentTimeStamp++;
        // update
        for (int i = 0 ; i < countOfPrincipals; i++) {
            ResourcePrincipal principal = principals[i];
            ResourceContract contract = principal.getContract();
            if (contract == null) continue;
            long memory = principal.getAllocatedObjects();
            long sent = principal.getBytesSent();
            long received = principal.getBytesReceived();
            long cpu = principal.getExecutedInstructions();
            LastMeasurements l = null;
            if (lastMeasurements.containsKey(principal)) {
                l = lastMeasurements.get(principal);
                sent -= l.sent;
                received -= l.received;
                cpu -= l.cpu;
                l.cpu += cpu;
                l.sent += sent;
                l.received += received;
            }
            else {
                l = new LastMeasurements(cpu,sent,received);
                lastMeasurements.put(principal, l);
            }
            if (contract != null) {
                if (memory > contract.getMemory())
                    System.out.printf("Memory Violation in %s because it was expecting %d but %d was found\n",
                            principal.toString(),
                            contract.getMemory(),
                            memory);
                if (sent > contract.getNetworkOut())
                    System.out.printf("Sent Violation in %s because it was expecting %d but %d was found\n",
                            principal.toString(),
                            contract.getNetworkOut(),
                            sent);
                if (received > contract.getNetworkIn())
                    System.out.printf("Received Violation in %s because it was expecting %d but %d was found\n",
                        principal.toString(),
                        contract.getNetworkIn(),
                        received);
                if (cpu > contract.getCPU())
                    System.out.printf("CPU Violation in %s because it was expecting %d but %d was found\n",
                            principal.toString(),
                            contract.getCPU(),
                            cpu);
            }
            l.timeStamp = currentTimeStamp;
        }

        // update
        for (InvocationResourcePrincipal rp : activatedInvocations.values()) {
            ResourceContract contract = rp.getContract();
            if (contract == null) continue;
            long memory = rp.getAllocatedObjects();
            long sent = rp.getBytesSent();
            long received = rp.getBytesReceived();
            long cpu = rp.getExecutedInstructions();
            LastMeasurements l = null;
            if (lastMeasurements.containsKey(rp)) {
                l = lastMeasurements.get(rp);
                sent -= l.sent;
                received -= l.received;
                cpu -= l.cpu;
            }
            if (contract != null) {
                if (memory > contract.getMemory()) {
                    System.out.println("Memory Violation in " + rp.toString());
                }
                if (sent > contract.getNetworkOut()) {
                    System.out.println("Sent Violation in " + rp.toString());
                }
                if (received > contract.getNetworkIn()) {
                    System.out.println("Received Violation in " + rp.toString());
                }
                if (cpu > contract.getCPU()) {
                    System.out.println("CPU Violation in " + rp.toString());
                }
            }
            if (l == null) {
                l = new LastMeasurements(cpu,sent,received);
                lastMeasurements.put(rp, l);
            }else {
                l.cpu = cpu;
                l.sent = sent;
                l.received = received;
            }
            l.timeStamp = currentTimeStamp;
        }
        // TODO: if some data is recorded in lastMeasurement and it has not an associated principal then discard it
        Iterator it = lastMeasurements.entrySet().iterator();
        while (it.hasNext())
        {
            Map.Entry<ResourcePrincipal,LastMeasurements> lm = (Map.Entry<ResourcePrincipal, LastMeasurements>) it.next();
            if (lm.getValue().timeStamp != currentTimeStamp)
                it.remove();
        }
    }
    private static void processInvocation(InvocationResourcePrincipal rp) {
        // print basic information
        System.err.printf("Operation %s, %d %d %d %d\n",
                rp.getAssociatedObject(),
                rp.getExecutedInstructions(),
                rp.getAllocatedObjects(),
                rp.getBytesSent(),
                rp.getBytesReceived());
        // print external operations
//        rp.externalOperations.optimize();
//        rp.externalOperations.accept(new PrintExternalOperationsVisitor());
        rp.recordInParent();
        System.out.println();
    }

    ResourcePrincipal[] innerGetApplications() {
        synchronized (this) {

            if (cachePrincipals.length != countOfPrincipals)
                cachePrincipals = new ResourcePrincipal[countOfPrincipals];

            System.arraycopy(principals, 0 , cachePrincipals, 0, countOfPrincipals);
            return cachePrincipals;
        }
    }

    final void innerIncreaseInstructions(int n, ResourcePrincipal principal) {
        synchronized (principal) {
            principal.increaseExecutedInstructions(n);
        }
    }

    public void innerIncreaseObjects(Object object, ResourcePrincipal principal) {
        synchronized (principal) {
            int n = (int)objectSizeProvider.sizeOf(object);
            principal.increaseOwnedObjects(n);
        }
    }

    public void innerDecreaseObjects(Object object, ResourcePrincipal principal) {
        if (principal == null)
            return;
        synchronized (principal) {
            int n = (int)objectSizeProvider.sizeOf(object);
            principal.increaseOwnedObjects(-n);
        }
    }

    public void innerArrayAllocated(Object obj, ResourcePrincipal principal) {
        if (principal instanceof ThreadGroupResourcePrincipal) {
            int n = (int)objectSizeProvider.sizeOf(obj);
            ((ThreadGroupResourcePrincipal)principal).registerObject(obj, n);
        }
        else if (principal instanceof InvocationResourcePrincipal) {
            ThreadGroupResourcePrincipal p = (ThreadGroupResourcePrincipal)((InvocationResourcePrincipal)principal).parent;
            int n = (int)objectSizeProvider.sizeOf(obj);
            p.registerObject(obj, n);
        }
    }

    void innerIncreaseBytesSent(int n, ResourcePrincipal principal) {
        totalSent += n; // TODO : synchronize
        synchronized (principal) {
            principal.increaseBytesSent(n);
        }
    }

    void innerIncreaseBytesReceived(int n, ResourcePrincipal principal) {
        totalReceived += n; // TODO : synchronize
        synchronized (principal) {
            principal.increaseBytesReceived(n);
        }
    }

    public void innerIncreaseFileWrite(int n, ResourcePrincipal principal) {
        synchronized (principal) {
            principal.increaseFileWrite(n);
            System.out.println("Escribiendo a archivo : " + n);
        }
    }

    final long innerGetNbObjects(ResourcePrincipal principal) {
        synchronized (principal) {
            return principal.getAllocatedObjects();
        }
    }

    final long innerGetNbInstructions(ResourcePrincipal principal) {
        synchronized (principal) {
            return principal.getExecutedInstructions();
        }
    }

    long innerGetNbBytesSent(ResourcePrincipal principal) {
        synchronized (principal) {
            return principal.getBytesSent();
        }
    }

    long innerGetNbBytesReceived(ResourcePrincipal principal) {
        synchronized (principal) {
            return principal.getBytesReceived();
        }
    }

    /**
     * Find or create a ResourcePrincipal. This method is doing a very important assumption:
     * ResourcePrincipals are never removed from the set; hence, any new ResourcePrincipal must be
     * different to all previous
     *
     * @param principal
     * @return
     */
    ResourcePrincipal search(ResourcePrincipal principal) {
        synchronized (this) {
            ResourcePrincipal real = principal;
            if (principal == null) return null;

            boolean inInvocation = (principal instanceof InvocationResourcePrincipal);

            if (inInvocation)
                real = ((InvocationResourcePrincipal) principal).parent;

            for (int i = 0 ; i < countOfPrincipals; i++) {
                if (principals[i].equals(real))
                    return inInvocation? principal : principals[i];
            }
            if (countOfPrincipals == principals.length) {
                ResourcePrincipal[] pTmp = new ResourcePrincipal[countOfPrincipals *2];
                System.arraycopy(principals, 0 , pTmp, 0, countOfPrincipals);
                principals = pTmp;
            }
            principals[countOfPrincipals++] = real;

            return (inInvocation)?principal: principals[countOfPrincipals -1];
        }
    }

    public ResourcePrincipal search(String appId) {
        synchronized (this) {
            for (int i = 0 ; i < countOfPrincipals; i++)
                if (principals[i].toString().equals(appId))
                    return  principals[i];
            return null;
        }
    }

    public ResourcePrincipal search(int id) {
        synchronized (this) {
            for (int i = 0 ; i < countOfPrincipals; i++) {
                if (principals[i].getId() == id)
                    return principals[i];
            }
        }
        return null;
    }

    ResourcePrincipal get(Thread th) {
        synchronized (this) {
            if (activatedInvocations.containsKey(th)) {
                return activatedInvocations.get(th);
            }
            // not inside one invocation
            return ThreadGroupResourcePrincipal.get(th);
        }
    }

    void externalOperationCall(Thread th, String str) {
        synchronized (this) {
            if (activatedInvocations.containsKey(th)) {
                InvocationResourcePrincipal rp = activatedInvocations.get(th);
                rp.addCallToExternalOperation(str, th);
            }
        }
    }

    void push(Thread th) {
        synchronized (this) {
            if (activatedInvocations.containsKey(th)) {
                InvocationResourcePrincipal rp = activatedInvocations.get(th);
                rp.push(th);
            }
        }
    }

    void pop(Thread th) {
        synchronized (this) {
            if (activatedInvocations.containsKey(th)) {
                InvocationResourcePrincipal rp = activatedInvocations.get(th);
                rp.pop(th);
            }
        }
    }

    void stopInvocation(Thread th) {
        synchronized (this) {
            if (activatedInvocations.containsKey(th)) {
                InvocationResourcePrincipal rp = activatedInvocations.get(th);
                rp.decreaseUsers();
                activatedInvocations.remove(th);
                rp.stopInvocation(th);
                if (rp.isReadyToBeFree())
                    processInvocation(rp);
            }
        }
    }

    void associateToInvocation(Thread th, Thread newTh) {
        synchronized (this) {
            // Create a new Invocation if the current thread is not executing an operation
            if (activatedInvocations.containsKey(th)) {
                InvocationResourcePrincipal inv = activatedInvocations.get(th);
                inv.increaseUsers();
                activatedInvocations.put(newTh, inv);
            }
        }
    }

    void newInvocation(Thread th, String operation) {
        synchronized (this) {
            ResourcePrincipal parent = ThreadGroupResourcePrincipal.get(th);
            // Create a new Invocation if the current thread is not executing an operation
            if (!activatedInvocations.containsKey(th)) {
                InvocationResourcePrincipal inv = new InvocationResourcePrincipal(operation, parent);
                activatedInvocations.put(th, inv);
            }
        }
    }

    void setResourceContractProvider(ResourceContractProvider resourceContractProvider) {
        this.resourceContractProvider = resourceContractProvider;
    }

    public ResourceContract getContract(ResourcePrincipal rp) {
        if (resourceContractProvider != null)
            return resourceContractProvider.obtainContractFor(rp.toString());
        else
            return null;
    }

    public void setObjectSizeProvider(ObjectSizeProvider objectSizeProvider) {
        this.objectSizeProvider = objectSizeProvider;
    }
}
