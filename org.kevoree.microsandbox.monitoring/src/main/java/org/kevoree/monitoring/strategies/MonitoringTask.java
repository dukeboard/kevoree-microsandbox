package org.kevoree.monitoring.strategies;

import org.kevoree.ContainerRoot;
import org.kevoree.api.Bootstraper;
import org.kevoree.api.service.core.handler.KevoreeModelHandlerService;
import org.kevoree.microsandbox.api.communication.MonitoringReporterFactory;
import org.kevoree.microsandbox.api.event.ContractViolationEvent;
import org.kevoree.microsandbox.api.event.MonitoringNotification;
import org.kevoree.microsandbox.api.sla.Metric;
import org.kevoree.monitoring.comp.MyLowLevelResourceConsumptionRecorder;
import org.kevoree.monitoring.comp.monitor.GCWatcher;
import org.kevoree.monitoring.models.SimpleIdAssigner;
import org.kevoree.monitoring.ranking.ComponentRankerFunctionFactory;
import org.kevoree.monitoring.ranking.ComponentsInfoStorage;
import org.kevoree.monitoring.ranking.ComponentsRanker;
import org.kevoree.monitoring.sla.FaultyComponent;
import org.kevoree.monitoring.sla.GlobalThreshold;
import org.kevoree.monitoring.sla.MeasurePoint;
import org.kevoree.monitoring.strategies.adaptation.KillThemAll;
import org.kevoree.monitoring.strategies.adaptation.SlowDownComponentInteraction;
import org.kevoree.monitoring.strategies.monitoring.FineGrainedMonitoringStrategy;
import org.kevoree.monitoring.strategies.monitoring.FineGrainedStrategyFactory;
import org.kevoree.monitoring.strategies.monitoring.GlobalMonitoring;

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
public class MonitoringTask extends AbstractMonitoringTask {

    private final GlobalThreshold globalThreshold;
    private long timeAtTheBeginning;

    public MonitoringTask(String nodeName,
                          GlobalThreshold globalThreshold,
                          String nameOfRankerFunction,
                          KevoreeModelHandlerService service,
                          Bootstraper bootstraper) {
        super(bootstraper, service, nameOfRankerFunction, nodeName);
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
        ComponentsInfoStorage.object$.getInstance().refresh(nodeName, service);
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


    @Override
    public void run() {
        System.out.printf("Initiating Monitoring task\n");

        ComponentsInfoStorage.object$.getInstance().setIdAssigner(new SimpleIdAssigner(service));

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
                        timeAtTheBeginning = System.currentTimeMillis();
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
                            ComponentsInfoStorage.object$.getInstance().getExecutionInfo(c.getComponentPath()).increaseFailures();
                            EnumMap<Metric, MeasurePoint> map = c.getMetrics();
                            for (Metric m : map.keySet())
                                MonitoringReporterFactory.reporter().trigger(new ContractViolationEvent(c.getComponentPath(), m, map.get(m).getObserved(), map.get(m).getMax()));
                        }

                        // FIXME in Monitoring component, reconfiguration must be avoid.
                        // Monitoring event must be sent to something else which is able to take decision
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
        MonitoringReporterFactory.reporter().trigger(new MonitoringNotification(false, reason))/*.monitoring(false)*/;
        MyLowLevelResourceConsumptionRecorder.getInstance().turnMonitoring(true);
        currentStatus = MonitoringStatus.LOCAL_MONITORING;
        currentStrategy = FineGrainedStrategyFactory.instance$.newMonitor(reason,
                ComponentsRanker.instance$.rank(nodeName, service, bootstraper,
                        ComponentRankerFunctionFactory.instance$.get(nameOfRankerFunction)), msg);
        currentStrategy.init(0);
    }

    private void switchToGlobal() {
        MonitoringReporterFactory.reporter().trigger(new MonitoringNotification(true,
                System.currentTimeMillis() - timeAtTheBeginning))/*.monitoring(true)*/;
        MyLowLevelResourceConsumptionRecorder.getInstance().turnMonitoring(false);
        currentStatus = MonitoringStatus.GLOBAL_MONITORING;
        currentStrategy = new GlobalMonitoring(msg, globalThreshold);
        currentStrategy.init(1000);
    }
}
