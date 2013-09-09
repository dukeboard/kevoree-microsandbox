package org.resourceaccounting.binder;

import java.util.HashMap;

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

    private HashMap<String, Status> map = new HashMap<String, Status>();
    private HashMap<Integer, String> classLoaderIdToPrincipalId =new HashMap<Integer, String>(10);

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
            s.monitored = on;
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


}
