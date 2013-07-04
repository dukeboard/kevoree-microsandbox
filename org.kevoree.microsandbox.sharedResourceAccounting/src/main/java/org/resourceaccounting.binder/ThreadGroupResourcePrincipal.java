package org.resourceaccounting.binder;

import org.resourceaccounting.ResourcePrincipal;
import org.resourceaccounting.behavior.BehaviorNode;
import org.resourceaccounting.memory.PrincipalReferenceQueue;
import org.resourceaccounting.memory.ReferenceLostListener;
import org.resourceaccounting.memory.WeakReferenceToArray;
import org.resourceaccounting.utils.HashMap;
import org.resourceaccounting.utils.Set;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 4/30/13
 * Time: 6:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class ThreadGroupResourcePrincipal extends AbstractResourcePrincipal<Long>
        implements ReferenceLostListener {

    /**
     * Name of the thread group
     */
    private String text = "MainThreadGroup";
    private transient HashMap<String, OperationSummary> operationMap = new HashMap<String, OperationSummary>(5);
    private Set<Long> threadsId = new Set<Long>();
    private transient PrincipalReferenceQueue principalReferenceQueue;

    /**
     * This is not thread safe
     *
     * @param object
     */
    protected ThreadGroupResourcePrincipal(Long object) {
        super(object);
//        accessController = new ReentrantLock(true);
        if (bean == null) {
            bean = ManagementFactory.getThreadMXBean();
            if (bean.isThreadCpuTimeSupported()) {
            }
            bean.setThreadCpuTimeEnabled(true);
        }
        threadsId.add(object);
        principalReferenceQueue = new PrincipalReferenceQueue(this);
    }

    /**
     * Contains every resource principal of this category
     */
    private static HashMap<String, ResourcePrincipal> map = new HashMap<String, ResourcePrincipal>();

    private static ResourcePrincipal unique = new ThreadGroupResourcePrincipal(-1L);

    private static ThreadMXBean bean;


    public static String locateGroup(Thread th, String prefix) {
        ThreadGroup tg = th.getThreadGroup();
        while (tg != null && !tg.getName().startsWith(prefix)) {
            tg = tg.getParent();
        }
        return (tg == null)? null : tg.getName();
    }

    public static ResourcePrincipal get(Thread thread) {
        //return unique;
        synchronized (map) {

            String nameOfGroup = locateGroup(thread, "kev/");
            if (nameOfGroup == null)
                return unique;

            if (map.containsKey(nameOfGroup)) {
                ThreadGroupResourcePrincipal p = (ThreadGroupResourcePrincipal)map.get(nameOfGroup);
                p.threadsId.add(thread.getId());
                return p;
            }

            ThreadGroupResourcePrincipal tmp = new ThreadGroupResourcePrincipal(thread.getId());
            tmp.text = nameOfGroup;
            map.put(nameOfGroup, tmp);
//            tmp.contract = ResourceCounter.getResourceContract(tmp);

//            System.out.printf("Memory %d, CPU %d\n", tmp.contract.getMemory(), tmp.contract.getCPU());
            return tmp;
        }
    }

    public void storeOperationInformation(String operationName, BehaviorNode behavior, ResourcePrincipal rp) {
        synchronized (map) {
            if (!operationMap.containsKey(operationName)) {
                operationMap.put(operationName,
                        new OperationSummary(behavior,
                        rp.getExecutedInstructions(),
                        rp.getAllocatedObjects(),
                        rp.getBytesSent(),
                        rp.getBytesReceived()
                ));
            } else {
                operationMap.get(operationName).merge(behavior,
                        rp.getExecutedInstructions(),
                        rp.getAllocatedObjects(),
                        rp.getBytesSent(),
                        rp.getBytesReceived()
                );
            }
            System.out.print("Result for " + text + "." + operationName);
            behavior.accept(new PrintExternalOperationsVisitor());
            OperationSummary summary = operationMap.get(operationName);
            System.out.printf("%f %f %f %f\n", summary.getExecutedInstructions(),
                    summary.getConsumedMemory(), summary.getBytesSent(),
                    summary.getBytesReceived());
            summary.getNode().accept(new PrintExternalOperationsVisitor());
        }
    }

    @Override
    public String toString() {
        return text;
    }

    @Override
    public long getCPUUsage() {
        long result = 0;
        for (int i = 0 ; i < threadsId.size() ; i++) {
            Long l = threadsId.getElement(i);
            if (l != -1) {
                long r = bean.getThreadCpuTime(l);
                if (r != -1)
                    result += r;
            }
        }
        return result;
    }

    public void registerObject(Object obj, int size) {
        nbObjects += size; // TODO : sincronizar
        WeakReferenceToArray weak = new WeakReferenceToArray(obj,principalReferenceQueue, size);
    }

    public void onReferenceLost(int size) {
        nbObjects -= size; // TODO : sincronizar
    }
}
