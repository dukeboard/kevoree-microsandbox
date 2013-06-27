package org.kevoree.monitoring.comp.viewer;

import org.kevoree.monitoring.AppBehaviorObserver;
import org.resourceaccounting.ResourceConsumptionRecorderMBean;
import org.resourceaccounting.ResourcePrincipal;

import java.util.HashSet;
import java.util.Set;

/**
* Created with IntelliJ IDEA.
* User: inti
* Date: 4/27/13
* Time: 2:23 PM
* To change this template use File | Settings | File Templates.
*/
class PollingConsumption extends Thread {
    private final ResourceConsumptionRecorderMBean bean;
    private final int frequency;
    private Set<ResourcePrincipal> principals;

    private AppBehaviorObserver appBehaviorObserver = null;

    boolean stop = false;

    PollingConsumption(int frequency, ResourceConsumptionRecorderMBean beanProxy) {
        this.bean = beanProxy;
        this.frequency = frequency;
        principals = new HashSet<ResourcePrincipal>();
    }

    @Override
    public void run() {

        while (!isInterrupted() && !isStopped()) try {
            Thread.sleep(frequency);
            if (appBehaviorObserver == null) continue;
            ResourcePrincipal[] tmp = bean.getApplications();

            Set<ResourcePrincipal> newSet = new HashSet<ResourcePrincipal>(tmp.length);

            for (int i = 0; i < tmp.length; i++) {
                if (!principals.contains(tmp[i])) appBehaviorObserver.newApp(tmp[i]);
                else appBehaviorObserver.informationChange(tmp[i]);
                newSet.add(tmp[i]);
            }

            for (ResourcePrincipal rp : principals)
                if (!newSet.contains(rp))
                    appBehaviorObserver.removeApp(rp);

            principals = newSet;

            setStop(isStopped() || appBehaviorObserver.isStopped());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void setAppBehaviorObserver(AppBehaviorObserver appBehaviorObserver) {
        this.appBehaviorObserver = appBehaviorObserver;
    }

    public synchronized void setStop(boolean stop) {
        this.stop = stop;
    }

    public synchronized boolean isStopped() {
        return stop;
    }
}
