package org.resourceaccounting.binder;

import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 9/8/13
 * Time: 10:59 PM
 */
public class MonitoringStatusList {


    private Instrumentation globalInst;
    private static MonitoringStatusList singleton = new MonitoringStatusList();
    private String properId;

//    {
//        System.err.printf("Loading class  MonitoringStatusList\n");
//        for (StackTraceElement e : Thread.currentThread().getStackTrace()) {
//            System.err.printf("\t %s \n", e.toString());
//        }
//    }

    private MonitoringStatusList() {

//        System.err.printf("Creating instance with hash=%d\n", this.hashCode());

    }

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

        @Override
        public boolean equals(Object obj) {
            if (obj == null)
                return false;
            if (!(obj instanceof MyKey))
                return false;
            MyKey k = (MyKey)obj;
            return k.id == id;
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
        assert this.getClass().getClassLoader() == null: String.format("In %s:%d the loader for MonitoringStatusList is %s", appId, idLoader, this.getClass().getClassLoader());
//        System.err.printf("Puta madre in includeApp app=%s, classloader=%d\n\n\n", appId, idLoader);
//        System.err.println("DOING MAGIC WITH " + appId);
        if (!classLoaderIdToPrincipalId.containsKey(idLoader))
            classLoaderIdToPrincipalId.put(idLoader, appId);
        map.put(appId, new Status(false,mem,instr));
    }

    public synchronized String getAppId(int idLoader) {
        assert this.getClass().getClassLoader() == null;
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
        assert this.getClass().getClassLoader() == null;
        if (map.containsKey(appId)) {
            Status s = map.get(appId);
            if (s.monitored != on) {
                s.monitored = on;
                retransformClasses(appId);
            }
        }
    }

    void setMonitoringAll(boolean on) {
        assert this.getClass().getClassLoader() == null;
        for (String appId : map.keySet()) {
            Status s = map.get(appId);
            System.err.printf(" 1 - PEPEPPEPEPEPEPE :%s, %b, %b\n", appId, s.monitored, s.cpuMonitored );
            if (s.monitored != on) {
                s.monitored = on;
                retransformClasses(appId);
            }
        }
    }

    public synchronized boolean isMonitored(String appId) {
        assert this.getClass().getClassLoader() == null;
        if (map.containsKey(appId)) {
            Status s = map.get(appId);
            return s.monitored;
        }
        return false;
    }

    public synchronized boolean isMemoryMonitored(String appId) {
        assert this.getClass().getClassLoader() == null;
        if (map.containsKey(appId)) {
            Status s = map.get(appId);
            return s.memMonitored;
        }
        return false;
    }

    public synchronized boolean isCPUMonitored(String appId) {
        assert this.getClass().getClassLoader() == null;
        if (map.containsKey(appId)) {
            Status s = map.get(appId);
            return s.monitored && s.cpuMonitored;
        }
        return false;
    }

    public synchronized void saveClassName(String appId, String className, ClassLoader loader) {
        assert this.getClass().getClassLoader() == null;
        if (appId.equals("")) return;

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
            if (appId.contains("ContractedConsole"))
                properId = appId;
        }
    }

    private void retransformClasses(String appId) {
        assert this.getClass().getClassLoader() == null;
//        System.err.printf("Puta madre in retransformClasses %s, %d, %s, classloader=%s\n\n\n", appId, this.hashCode(), globalInst, this.getClass().getClassLoader());
//        System.out.println(appId + " " + classes.containsKey(appId) + " ");
        Status status = map.get(appId);
        if (status.memMonitored && !status.cpuMonitored)
            return;
        boolean b = classes.containsKey(appId);
        Set<MyKey> myClasses = null;
        if (b)
            myClasses = classes.get(appId);
        else if (appId.contains("ContractedConsole")) {
            b = true;
            myClasses = classes.get(properId);
        }
        System.err.printf("3 - PEPEPPEPPEPEPEPEPEPEP : %b, %b, %s, %s\n", b, map.containsKey(appId),myClasses, globalInst);
        if (b && globalInst != null) {
//            System.out.println(appId + " " + (status.memMonitored && !status.cpuMonitored) + " ");
            if (status.cpuMonitored || status.memMonitored) {
                Class<?>[] a = new Class[myClasses.size()];
                System.out.printf("Classes for %s are %d\n", appId, a.length);
                int c = 0;
                for (MyKey key : myClasses) {
                    String name = key.getClassName();
                    ClassLoader loader = key.getLoader();
                    if (loader != null) {
                        try {
//                            System.out.println("Getting class "+name+" for retransformation by using loader: " + loader.hashCode());
                            Class<?> clazz = loader.loadClass(name.replace('/', '.'));
                            a[c++] = clazz;
                        } catch (ClassNotFoundException e) {

                        }
                    }
                }
                // now retransform all these classes
                try {
                    globalInst.retransformClasses(a);
                } catch (UnmodifiableClassException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void setGlobalInst(Instrumentation globalInst) {
        assert this.getClass().getClassLoader() == null;
        this.globalInst = globalInst;
    }

}
