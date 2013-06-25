package org.kevoree.monitoring.comp.monitor;

import org.resourceaccounting.ResourcePrincipal;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 6/23/13
 * Time: 11:12 AM
 * To change this template use File | Settings | File Templates.
 */
public class MonitoringTask implements Runnable, ContractVerificationRequired {

    private boolean stopped;
    private GCWatcher gcWatcher;
    private Object msg;

    private enum MonitoringStatus {
        GLOBAL_MONITORING,
        LOCAL_MONITORING;
    }

    private MonitoringStatus currentStatus;
    private MonitoringStrategy currentStrategy;


    @Override
    public void run() {
        System.out.printf("Initiating Monitoring task\n");
        msg = new Object();

        gcWatcher = new GCWatcher();
        gcWatcher.addContractVerificationRequieredListener(this);
        gcWatcher.register();

        currentStatus = MonitoringStatus.GLOBAL_MONITORING;
        currentStrategy = new GlobalMonitoring(msg);
        currentStrategy.init();

        stopped = false;
        while (!isStopped()) {
            synchronized (msg) {
                try {
                    msg.wait();
                    System.out.println("Switching to local monitoring");
                } catch (InterruptedException e) { }
            }
        }

        currentStrategy.stop();
        gcWatcher.unregister();
        gcWatcher = null;
    }


    public synchronized boolean isStopped() {
        return stopped;
    }

    public synchronized void stop() {
        stopped = true;
        synchronized (msg) {
            msg.notify();
        }
    }

    @Override
    public void verifyContract(ResourcePrincipal principal, Object obj) {
        currentStrategy.verifyContract(principal, obj);
    }

    @Override
    public void onGCVerifyContract(long used, long max) {
        currentStrategy.onGCVerifyContract(used, max);
    }
}
