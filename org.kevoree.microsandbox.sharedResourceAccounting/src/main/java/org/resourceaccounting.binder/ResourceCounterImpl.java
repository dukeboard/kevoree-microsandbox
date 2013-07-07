package org.resourceaccounting.binder;

import org.resourceaccounting.ObjectSizeProvider;
import org.resourceaccounting.contract.ResourceContract;
import org.resourceaccounting.contract.ResourceContractProvider;
import org.resourceaccounting.ResourcePrincipal;
import org.resourceaccounting.invocations.InvocationAmountTable;


/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 5/13/13
 * Time: 12:01 PM
 *
 * Performs the accounting. it is a package class
 */
class ResourceCounterImpl {

    private int countOfPrincipals = 0;
    private long totalReceived = 0;
    private long totalSent = 0;
    private long totalWritten = 0;
    private long totalRead = 0;
    private long lastTotalReceived;
    private long lastTotalSent;
    private long lastTotalRead;
    private long lastTotalWritten;

    public InvocationAmountTable senders = new InvocationAmountTable();
    public InvocationAmountTable receivers = new InvocationAmountTable();

    long getTotalReceived() {
        long tmp = totalReceived - lastTotalReceived;
        lastTotalReceived = totalReceived;
        return tmp;
    }

    long getTotalSent() {
        long tmp = totalSent - lastTotalSent;
        lastTotalSent = totalSent;
        return tmp;
    }

    long getTotalRead() {
        long tmp = totalRead - lastTotalRead;
        lastTotalRead = totalRead;
        return tmp;
    }

    long getTotalWritten() {
        long tmp = totalWritten - lastTotalWritten;
        lastTotalWritten = totalWritten;
        return tmp;
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
            int n = (int) objectSizeProvider.sizeOf(object);
            principal.increaseOwnedObjects(n);
        }
    }

    public void innerDecreaseObjects(Object object, ResourcePrincipal principal) {
        if (principal == null)
            return;
        synchronized (principal) {
            int n = (int) objectSizeProvider.sizeOf(object);
            principal.increaseOwnedObjects(-n);
        }
    }

    public void innerArrayAllocated(Object obj, ResourcePrincipal principal) {
        if (principal instanceof ThreadGroupResourcePrincipal) {
            int n = (int) objectSizeProvider.sizeOf(obj);
            ((ThreadGroupResourcePrincipal)principal).registerObject(obj, n);
        }
    }

    void innerIncreaseBytesSent(int n, ResourcePrincipal principal) {
        increaseTotalSent(n);
        synchronized (principal) {
            principal.increaseBytesSent(n);
        }
    }

    void innerIncreaseBytesReceived(int n, ResourcePrincipal principal) {
        increaseTotalReceived(n);
        synchronized (principal) {
            principal.increaseBytesReceived(n);
        }
    }

    public void innerIncreaseFileWrite(int n, ResourcePrincipal principal) {
        increaseTotalWritten(n);
        synchronized (principal) {
            principal.increaseFileWrite(n);
        }
    }

    public void innerIncreaseBytesRead(int n, ResourcePrincipal principal) {
        increaseTotalRead(n);
        synchronized (principal) {
            principal.increaseFileRead(n);
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

    long innerGetNbWrittenBytes(ResourcePrincipal principal) {
        synchronized (principal) {
            return principal.getWrittenBytes();
        }
    }

    long innerGetNbReadBytes(ResourcePrincipal principal) {
        synchronized (principal) {
            return principal.getReadBytes();
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

            for (int i = 0 ; i < countOfPrincipals; i++) {
                if (principals[i].equals(real))
                    return principals[i];
            }
            if (countOfPrincipals == principals.length) {
                ResourcePrincipal[] pTmp = new ResourcePrincipal[countOfPrincipals *2];
                System.arraycopy(principals, 0 , pTmp, 0, countOfPrincipals);
                principals = pTmp;
            }
            principals[countOfPrincipals++] = real;

            return principals[countOfPrincipals -1];
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
            // not inside one invocation
            return ThreadGroupResourcePrincipal.get(th);
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

    public synchronized void increaseTotalRead(int n) {
        totalRead += n;
    }

    public synchronized void increaseTotalReceived(int n) {
        totalReceived += n;
    }

    public synchronized void increaseTotalWritten(int n) {
        totalWritten += n;
    }

    public synchronized void increaseTotalSent(int n) {
        totalSent += n;
    }
}
