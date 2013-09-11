package org.resourceaccounting.binder;

import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 9/8/13
 * Time: 10:59 PM
 */
public class MonitoringStatusList {


    private Instrumentation globalInst;
    private static MonitoringStatusList singleton = new MonitoringStatusList();
    private MonitoringStatusList() { }

    private class Status {
        boolean monitored;
        boolean memMonitored;
        boolean cpuMonitored;

        public Status(boolean monitored, boolean memMonitored, boolean cpuMonitored) {
            this.monitored = monitored;
            this.memMonitored = memMonitored;
            this.cpuMonitored = cpuMonitored;
        }
    }

    private static class MyKey {

        private final int id;
        public String className;
        public WeakReference<ClassLoader> loaderWeakReference;

        public MyKey(String className, ClassLoader loader) {
            id = className.hashCode() ^ loader.hashCode();
            this.className = className;
            loaderWeakReference = new WeakReference<ClassLoader>(loader);
        }

        @Override
        public int hashCode() {
            return id;
        }

        private String getClassName() {
            return className;
        }

        private ClassLoader getLoader() {
            return loaderWeakReference.get();
        }
    }

    private HashMap<String, Status> map = new HashMap<String, Status>(10);
    private HashMap<Integer, String> classLoaderIdToPrincipalId =new HashMap<Integer, String>(10);

    private HashMap<String, Set<MyKey>> classes = new HashMap<String, Set<MyKey>>(10);

    public static MonitoringStatusList instance() {
        return singleton;
    }

    public synchronized void includeApp(String appId, int idLoader, boolean mem, boolean instr) {
        classLoaderIdToPrincipalId.put(idLoader, appId);
        map.put(appId, new Status(false,mem,instr));
    }

    public synchronized String getAppId(int idLoader) {
        return classLoaderIdToPrincipalId.containsKey(idLoader)?
                classLoaderIdToPrincipalId.get(idLoader):
                "";
//        for (String appId : classLoaderIdToPrincipalId.keySet()) {
//            int idL = classLoaderIdToPrincipalId.get(appId);
//            if (idLoader == idL && classes.containsKey(appId) && classes.get(appId).contains(className))
//                return appId;
//        }
//        return "";
    }

    synchronized void setMonitored(String appId, boolean on) {
        if (map.containsKey(appId)) {
            Status s = map.get(appId);
            if (s.monitored != on) {
                s.monitored = on;
                retransformClasses(appId);
            }
        }
    }

    void setMonitoringAll(boolean on) {
        for (String appId : map.keySet()) {
            Status s = map.get(appId);
            if (s.monitored != on) {
                s.monitored = on;
                retransformClasses(appId);
            }
        }
    }

    public synchronized boolean isMonitored(String appId) {
        if (map.containsKey(appId)) {
            Status s = map.get(appId);
            return s.monitored;
        }
        return false;
    }

    public synchronized boolean isMemoryMonitored(String appId) {
        if (map.containsKey(appId)) {
            Status s = map.get(appId);
            return s.memMonitored;
        }
        return false;
    }

    public synchronized boolean isCPUMonitored(String appId) {
        if (map.containsKey(appId)) {
            Status s = map.get(appId);
            return s.monitored && s.cpuMonitored;
        }
        return false;
    }

    public synchronized void saveClassName(String appId, String className, ClassLoader loader) {
        if (map.containsKey(appId)) {
            Set<MyKey> set;
            if (classes.containsKey(appId)) {
                set = classes.get(appId);
            }
            else {
                set = new HashSet<MyKey>();
                classes.put(appId, set);
            }
            MyKey key = new MyKey(className, loader);
            set.add(key);
        }
    }

    private void retransformClasses(String appId) {
        if (classes.containsKey(appId) && globalInst != null) {
            Status status = map.get(appId);
            if (status.memMonitored && !status.cpuMonitored)
                return;
            if (status.cpuMonitored || status.memMonitored) {
                ArrayList<Class<?>> clazzes = new ArrayList<Class<?>>();
                for (MyKey key : classes.get(appId)) {
                    String name = key.getClassName();
                    ClassLoader loader = key.getLoader();
                    if (loader != null) {
                        try {
                            System.out.println("Getting class "+name+" for retransformation by using loader: " + loader.hashCode());
                            Class<?> clazz = loader.loadClass(name.replace('/', '.'));
                            clazzes.add(clazz);
                        } catch (ClassNotFoundException e) {

                        }
                    }
                }
                // now retransform all these classes
                Class<?>[] a = new Class[clazzes.size()];
                clazzes.toArray(a);
                try {
                    globalInst.retransformClasses(a);
                } catch (UnmodifiableClassException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void setGlobalInst(Instrumentation globalInst) {
        this.globalInst = globalInst;
    }

}
