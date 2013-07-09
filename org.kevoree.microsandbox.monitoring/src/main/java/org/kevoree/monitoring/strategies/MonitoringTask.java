package org.kevoree.monitoring.strategies;

import org.kevoree.ContainerRoot;
import org.kevoree.api.Bootstraper;
import org.kevoree.api.service.core.handler.KevoreeModelHandlerService;
import org.kevoree.api.service.core.handler.ModelListener;
import org.kevoree.microsandbox.api.communication.MonitoringReporterFactory;
import org.kevoree.microsandbox.api.sla.Metric;
import org.kevoree.monitoring.comp.MyLowLevelResourceConsumptionRecorder;
import org.kevoree.monitoring.comp.monitor.ContractVerificationRequired;
import org.kevoree.monitoring.comp.monitor.GCWatcher;
import org.kevoree.monitoring.models.SimpleIdAssigner;
import org.kevoree.monitoring.ranking.*;
import org.kevoree.monitoring.sla.FaultyComponent;
import org.kevoree.monitoring.sla.GlobalThreshold;
import org.kevoree.monitoring.sla.MeasurePoint;
import org.kevoree.monitoring.strategies.adaptation.KillThemAll;
import org.kevoree.monitoring.strategies.adaptation.SlowDownComponentInteraction;
import org.kevoree.monitoring.strategies.monitoring.*;
import org.resourceaccounting.ResourcePrincipal;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 6/23/13
 * Time: 11:12 AM
 *
 */
public class MonitoringTask implements Runnable, ContractVerificationRequired, ModelListener {

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

    @Override
    public boolean preUpdate(ContainerRoot containerRoot, ContainerRoot containerRoot2) {
        return true;
    }

    @Override
    public boolean initUpdate(ContainerRoot containerRoot, ContainerRoot containerRoot2) {
        return true;
    }

    @Override
    public boolean afterLocalUpdate(ContainerRoot containerRoot, ContainerRoot containerRoot2) {
        return true;
    }

    @Override
    public void modelUpdated() {
        ComponentsInfoStorage.instance$.refresh(nodeName, service);
    }

    @Override
    public void preRollback(ContainerRoot containerRoot, ContainerRoot containerRoot2) { }

    @Override
    public void postRollback(ContainerRoot containerRoot, ContainerRoot containerRoot2) { }

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
        ComponentsInfoStorage.instance$.setIdAssigner(new SimpleIdAssigner(service));

        gcWatcher = new GCWatcher();
        gcWatcher.addContractVerificationRequieredListener(this);
        gcWatcher.register();

        switchToGlobal();

        stopped = false;
        while (!isStopped()) {
            waitMessage();
            if (isStopped()) continue;
            switch (currentStatus) {
                case GLOBAL_MONITORING:
                    if (currentStrategy.isThereContractViolation()) {
                        System.out.println("Switching to local monitoring " + currentStrategy.getViolationOn());
                        currentStrategy.pause();
                        switchToSimpleLocal(currentStrategy.getViolationOn());
                    }
                    break;
                case LOCAL_MONITORING:
                    if (currentStrategy.isThereContractViolation()) {
                        System.out.println("Triggering adaptation to solve the problem");
//                        for (Metric m : currentStrategy.getViolationOn())
//                            System.out.println("\t" + m);
                        currentStrategy.pause();
                        FineGrainedMonitoringStrategy s =(FineGrainedMonitoringStrategy)currentStrategy;
                        List<FaultyComponent> tmpList = s.getFaultyComponents();
                        for (FaultyComponent c : tmpList) {
                            ComponentsInfoStorage.instance$.getExecutionInfo(c.getComponentPath()).increaseFailures();
                            EnumMap<Metric, MeasurePoint> map = c.getMetrics();
                            for (Metric m : map.keySet())
                                MonitoringReporterFactory.reporter().sla(c.getComponentPath(),
                                        m, map.get(m).getObserved(), map.get(m).getMax());
                        }

                        tmpList = new SlowDownComponentInteraction(service).adapt(nodeName, tmpList);
                        tmpList = new KillThemAll(service).adapt(nodeName, tmpList);

                        if (tmpList.isEmpty()) {
                            switchToGlobal();
                        }
                        else {
                            // TODO: the system cannot perform an adaptation. Die
                            System.err.println("Why I am here");
                            System.exit(3);
                        }
                    }
                    else {
                        currentStrategy.pause();
                        switchToGlobal();
                    }

                    break;
            }
        }

        currentStrategy.stop();
        gcWatcher.unregister();
        gcWatcher = null;
    }



    private void switchToSimpleLocal(EnumSet<Metric> reason) {
        MonitoringReporterFactory.reporter().monitoring(false);
        MyLowLevelResourceConsumptionRecorder.getInstance().turnMonitoring(true);
        currentStatus = MonitoringStatus.LOCAL_MONITORING;
        currentStrategy = FineGrainedStrategyFactory.instance$.newMonitor(reason,
                ComponentsRanker.instance$.rank(nodeName, service, bootstraper), msg);
        currentStrategy.init(0);
    }

    private void switchToGlobal() {
        MonitoringReporterFactory.reporter().monitoring(true);
        MyLowLevelResourceConsumptionRecorder.getInstance().turnMonitoring(false);
        currentStatus = MonitoringStatus.GLOBAL_MONITORING;
        currentStrategy = new GlobalMonitoring(msg, globalThreshold);
        currentStrategy.init(1000);
    }

    private void waitMessage() {
        synchronized (msg) {
            try {
                msg.wait();
            } catch (InterruptedException e) {

            }
        }
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
        if (currentStrategy != null)
            currentStrategy.onGCVerifyContract(used, max);
    }
}
