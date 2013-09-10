package org.resourceaccounting.binder;

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
 * To change this template use File | Settings | File Templates.
 */
public class MonitoringStatusList {
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
        private static AtomicInteger lastId = new AtomicInteger(1);

        private final int id;
        public String className;
        public WeakReference<ClassLoader> loaderWeakReference;

        public MyKey(String className, ClassLoader loader) {
            this.className = className;
            loaderWeakReference = new WeakReference<ClassLoader>(loader);
            id = lastId.incrementAndGet();
        }

        @Override
        public int hashCode() {
            ClassLoader loader = loaderWeakReference.get();
            if (loader == null)
                return 0;
            return className.hashCode() ^ loader.hashCode();
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
        return  (classLoaderIdToPrincipalId.containsKey(idLoader))?
                classLoaderIdToPrincipalId.get(idLoader):
                "";
    }

    public synchronized void setMonitored(String appId, boolean on) {
        if (map.containsKey(appId)) {
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
            return s.monitored && s.memMonitored;
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
            set.add(new MyKey(className, loader));
        }
    }

    private synchronized void retransformClasses(String appId) {
        if (classes.containsKey(appId)) {
            ArrayList<Class<?>> clazzes = new ArrayList<Class<?>>();
            for (MyKey key : classes.get(appId)) {
                String name = key.getClassName();
                ClassLoader loader = key.getLoader();
                if (loader != null) {
                    try {
                        Class<?> clazz = loader.loadClass(name);
                        clazzes.add(clazz);
                    } catch (ClassNotFoundException e) {

                    }
                }
            }
            // now retransform all these classes
            Class<?>[] a = new Class[clazzes.size()];
            clazzes.toArray(a);

        }
    }


}
