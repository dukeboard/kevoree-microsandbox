package org.kevoree.monitoring.comp.monitor;

import org.kevoree.api.Bootstraper;
import org.kevoree.api.service.core.handler.KevoreeModelHandlerService;
import org.kevoree.monitoring.ranking.ComponentsRanker;
import org.resourceaccounting.ResourcePrincipal;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 6/23/13
 * Time: 11:12 AM
 * To change this template use File | Settings | File Templates.
 */
public class MonitoringTask implements Runnable, ContractVerificationRequired {

    private final String nodeName;
    private final Bootstraper bootstrapper;
    private final KevoreeModelHandlerService service;
    private boolean stopped;
    private GCWatcher gcWatcher;
    private Object msg;

    private enum MonitoringStatus {
        GLOBAL_MONITORING,
        LOCAL_MONITORING;
    }

    private MonitoringStatus currentStatus;
    private MonitoringStrategy currentStrategy;

    public MonitoringTask(String nodeName, KevoreeModelHandlerService service, Bootstraper bootstrapper) {
        this.nodeName= nodeName;
        this.service = service;
        this.bootstrapper = bootstrapper;
    }


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
                    if (!isStopped()) {
                        switch (currentStatus) {
                            case GLOBAL_MONITORING:
                                if (currentStrategy.isThereContractViolation()) {
                                    System.out.println("Switching to local monitoring");
                                    currentStrategy.pause();
                                    currentStrategy = new LocalMonitoring(
                                            ComponentsRanker.instance$.rank(nodeName, service, bootstrapper));
                                    currentStatus = MonitoringStatus.LOCAL_MONITORING;
                                }
                                break;
                        }

                    }
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
