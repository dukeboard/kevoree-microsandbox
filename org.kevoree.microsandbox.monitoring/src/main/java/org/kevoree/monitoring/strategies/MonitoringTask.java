package org.kevoree.monitoring.strategies;

import org.kevoree.api.Bootstraper;
import org.kevoree.api.service.core.handler.KevoreeModelHandlerService;
import org.kevoree.monitoring.comp.monitor.ContractVerificationRequired;
import org.kevoree.monitoring.comp.monitor.GCWatcher;
import org.kevoree.monitoring.ranking.*;
import org.kevoree.monitoring.sla.GlobalThreshold;
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
    private final Bootstraper bootstraper;
    private final KevoreeModelHandlerService service;
    private final GlobalThreshold globalThreshold;
    private boolean stopped;
    private GCWatcher gcWatcher;
    private Object msg;

    public MonitoringTask(String nodeName,
                          GlobalThreshold globalThreshold,
                          KevoreeModelHandlerService service,
                          Bootstraper bootstraper) {
        this.nodeName= nodeName;
        this.service = service;
        this.bootstraper = bootstraper;
        this.globalThreshold = globalThreshold;
    }

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
        currentStrategy = new GlobalMonitoring(msg, globalThreshold);
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
                                    currentStatus = MonitoringStatus.LOCAL_MONITORING;
                                    currentStrategy = new LocalMonitoring(
                                            ComponentsRanker.instance$.rank(nodeName, service, bootstraper), msg);
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
