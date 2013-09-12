package org.resourceaccounting.binder;

import org.resourceaccounting.ResourcePrincipal;
import org.resourceaccounting.memory.PrincipalReferenceQueue;
import org.resourceaccounting.memory.ReferenceLostListener;
import org.resourceaccounting.memory.WeakReferenceToArray;
import org.resourceaccounting.utils.HashMap;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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
//    private Set<Long> threadsId = new HashSet<Long>();
    private transient PrincipalReferenceQueue principalReferenceQueue;

    private static transient Lock lock = new ReentrantLock();

    private transient Lock lockInstance = new ReentrantLock();

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
//        threadsId.add(object);
        principalReferenceQueue = new PrincipalReferenceQueue(this);
    }

    /**
     * Contains every resource principal of this category
     */
    private static HashMap<String, ResourcePrincipal> map = new HashMap<String, ResourcePrincipal>();
    private static HashMap<Integer, ResourcePrincipal> map2 = new HashMap<Integer, ResourcePrincipal>();
    private Vector<AtomicLong> counters = new Vector<AtomicLong>();

    private static ThreadGroupResourcePrincipal unique = new ThreadGroupResourcePrincipal(-1L);

    private static ThreadMXBean bean;

    static {
        map.put("MainThreadGroup",unique);
        map2.put(unique.getId(), unique);
    }


    private static String locateGroup(Thread th, String prefix) {
        ThreadGroup tg = th.getThreadGroup();
        while (tg != null && !tg.getName().startsWith(prefix)) {
            tg = tg.getParent();
        }
        return (tg == null)? null : tg.getName();
    }

//    public static AtomicLong getPrincipalCounter() {
//        ThreadGroupResourcePrincipal p = (ThreadGroupResourcePrincipal)get();
//        return p.nbInstructions;
//    }

    @Override
    public void increaseExecutedInstructions(int n) {
        throw new RuntimeException("Never call this in a ThreadGroupResourcePrincipal");
    }

    @Override
    public long getExecutedInstructions() {
        try {
            lockInstance.lock();
            long sum = 0;
            for (int i = 0 ; i < counters.size() ; ++i)
                sum += counters.get(i).getAndSet(0);
            return sum;
        }
        finally {
            lockInstance.unlock();
        }
    }

    private static class ThreadLocalInstructionCounter
            extends ThreadLocal<AtomicLong> {
        @Override
        protected AtomicLong initialValue() {
            ThreadGroupResourcePrincipal principal = null;
            Thread thread = Thread.currentThread();
            try {
                lock.lock();
                String nameOfGroup = locateGroup(thread, "kev/");
                if (nameOfGroup == null) {
                    principal = unique;
                }else if (map.containsKey(nameOfGroup)) {
                    principal = (ThreadGroupResourcePrincipal)map.get(nameOfGroup);
                } else {
                    principal = new ThreadGroupResourcePrincipal(thread.getId());
                    principal.text = nameOfGroup;
                    map.put(nameOfGroup, principal);
                    map2.put(principal.getId(), principal);
                }
            }
            finally {
                lock.unlock();
            }
            try {
                principal.lockInstance.lock();
                AtomicLong atomicLong = new AtomicLong();
                principal.counters.add(atomicLong);
//                principal.threadsId.add(thread.getId());
                return atomicLong;
            }
            finally {
                principal.lockInstance.unlock();
            }
        }
    }

    private static ThreadLocalInstructionCounter instructionsCounter = new ThreadLocalInstructionCounter();

    public static AtomicLong getThreadInstructionCounter() {
        return instructionsCounter.get();

    }

    private static class Principals extends ThreadLocal<ResourcePrincipal> {
        @Override
        protected ResourcePrincipal initialValue() {
            ThreadGroupResourcePrincipal principal = null;
            Thread thread = Thread.currentThread();
            try {
                lock.lock();
                String nameOfGroup = locateGroup(thread, "kev/");
                if (nameOfGroup == null) {
                    principal = unique;
                }else if (map.containsKey(nameOfGroup)) {
                    principal = (ThreadGroupResourcePrincipal)map.get(nameOfGroup);
                } else {
                    principal = new ThreadGroupResourcePrincipal(thread.getId());
                    principal.text = nameOfGroup;
                    map.put(nameOfGroup, principal);
                    map2.put(principal.getId(), principal);
                }
            }
            finally {
                lock.unlock();
            }
            try {
                AtomicLong atomicLong = new AtomicLong();
                principal.lockInstance.lock();
                principal.counters.add(atomicLong);
//                principal.threadsId.add(thread.getId());
                return principal;
            }
            finally {
                principal.lockInstance.unlock();
            }
        }
    }

    private static Principals principalsLocal = new Principals();

    public final static ResourcePrincipal get() {
        return principalsLocal.get();
//        //return unique;
//        try {
//            lock.lock();
//            String nameOfGroup = locateGroup(thread, "kev/");
//            if (nameOfGroup == null)
//                return unique;
//
//            if (map.containsKey(nameOfGroup)) {
//                ThreadGroupResourcePrincipal p = (ThreadGroupResourcePrincipal)map.get(nameOfGroup);
//                p.threadsId.add(thread.getId());
//                return p;
//            }
//
//            ThreadGroupResourcePrincipal tmp = new ThreadGroupResourcePrincipal(thread.getId());
//            tmp.text = nameOfGroup;
//            map.put(nameOfGroup, tmp);
//            map2.put(tmp.getId(), tmp);
////            tmp.contract = ResourceCounter.getResourceContract(tmp);
//
////            System.out.printf("Memory %d, CPU %d\n", tmp.contract.getMemory(), tmp.contract.getCPU());
//            return tmp;
//        }
//        finally {
//            lock.unlock();
//        }
    }

    public static ResourcePrincipal get(String appId) {
        try {
            lock.lock();
            if (map.containsKey(appId))
                return map.get(appId);
            return null;
        }
        finally {
            lock.unlock();
        }
    }

    public static ResourcePrincipal get(int appId) {
        try {
            lock.lock();
            if (map2.containsKey(appId))
                return map2.get(appId);
            return null;
        }
        finally {
            lock.unlock();
        }
    }

    public static ResourcePrincipal[] getAll() {
        try {
            lock.lock();
            int n = map.size();
            return map.values().toArray(new ResourcePrincipal[n]);
        }
        finally {
            lock.unlock();
        }
    }

    @Override
    public String toString() {
        return text;
    }

    @Override
    public long getCPUUsage() {
        long result = 0;
//        for (Long l : threadsId) {
//            if (l != -1) {
//                long r = bean.getThreadCpuTime(l);
//                if (r != -1)
//                    result += r;
//            }
//        }

        return result;
    }

    public void registerObject(Object obj, int size) {
        nbObjects.addAndGet(size);
        try {
            lockInstance.lock();
            new WeakReferenceToArray(obj,principalReferenceQueue, size);
        }
        finally {
            lockInstance.unlock();
        }
    }

    public void onReferenceLost(int size) {
        nbObjects.addAndGet(-size);
//        try {
//            lockInstance.lock();
//        }
//        finally {
//            lockInstance.unlock();
//        }
    }
}
