package org.kevoree.monitoring.strategies;

import org.kevoree.api.BootstrapService;
import org.kevoree.api.ModelService;
import org.kevoree.microsandbox.api.communication.MonitoringReporterFactory;
import org.kevoree.microsandbox.api.event.ContractViolationEvent;
import org.kevoree.microsandbox.api.event.MonitoringNotification;
import org.kevoree.microsandbox.api.heuristic.MonitoringEvent;
import org.kevoree.microsandbox.api.sla.Metric;
import org.kevoree.monitoring.comp.MyLowLevelResourceConsumptionRecorder;
import org.kevoree.monitoring.comp.monitor.GCWatcher;
import org.kevoree.monitoring.comp.monitor.MonitoringComponent;
import org.kevoree.monitoring.sla.FaultyComponent;
import org.kevoree.monitoring.sla.GlobalThreshold;
import org.kevoree.monitoring.sla.MeasurePoint;
import org.kevoree.monitoring.strategies.monitoring.FineGrainedMonitoringStrategy;
import org.kevoree.monitoring.strategies.monitoring.GlobalMonitoring;
import org.kevoree.monitoring.strategies.monitoring.MonitoringStrategy;

import java.util.Arrays;
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
    private int countOfLocalMonitoring = 0;
    private long totalTimeInLocalMonitoring = 0;

    public MonitoringTask(String nodeName,
                          GlobalThreshold globalThreshold,
                          /*String nameOfRankerFunction*/
                          MonitoringComponent monitoringComponent,
                          ModelService service,
                          BootstrapService bootstraper) {
        super(bootstraper, service, monitoringComponent, nodeName);
        this.globalThreshold = globalThreshold;

        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run() {
                timeConsumedInLocalMonitoring();
            }
        });
    }

    /*@Override
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
        ComponentsInfoStorage.instance.refresh(nodeName, service);
    }

    @Override
    public void preRollback(ContainerRoot containerRoot, ContainerRoot containerRoot2) { }

    @Override
    public void postRollback(ContainerRoot containerRoot, ContainerRoot containerRoot2) { }*/

    private enum MonitoringStatus {
        GLOBAL_MONITORING,
        LOCAL_MONITORING;
    }

    private MonitoringStatus currentStatus;


    @Override
    public void run() {
//        System.out.printf("Initiating Monitoring task\n");

//        ComponentsInfoStorage.instance.setIdAssigner(new SimpleIdAssigner(service));

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
                    if (getCurrentStrategy().isThereContractViolation()) {
//                        System.out.println("Switching to local monitoring " + currentStrategy.getViolationOn());
                        getCurrentStrategy().pause();
                        timeAtTheBeginning = System.currentTimeMillis();
                        switchToSimpleLocal(getCurrentStrategy().getViolationOn());
                    }
                    break;
                case LOCAL_MONITORING:
                    if (getCurrentStrategy().isThereContractViolation()) {
//                        System.out.println("Triggering adaptation to solve the problem");
//                        for (Metric m : currentStrategy.getViolationOn())
//                            System.out.println("\t" + m);
                        getCurrentStrategy().pause();
                        FineGrainedMonitoringStrategy s =(FineGrainedMonitoringStrategy)getCurrentStrategy();
                        List<FaultyComponent> tmpList = s.getFaultyComponents();
                        for (FaultyComponent c : tmpList) {
                            // FIXME add some information on a specific port (or something to notify interesting component)
                            // TODO add this information inside Context Model
                            /*org.kevoree.context.Metric nbFailureMetric = PutHelper.getMetric(monitoringComponent.getModelService().getContextModel(), "monitoring/deployTime/{nodes[" + nodeName + "]/components[" + c.getComponentPath() + "]}", PutHelper.getParam().setMetricTypeClazzName(CounterHistoryMetric.class.getName()).setNumber(1));

                            nbFailureMetric.
                            PutHelper.addValue(nbFailureMetric, "" + System.nanoTime());*/
//                            ComponentsInfoStorage.object$.getInstance().getExecutionInfo(c.getComponentPath()).increaseFailures();
                            monitoringComponent.triggerMonitoringEvent(new MonitoringEvent("CREATE", "nbFailure", c.getComponentPath(), 1l));
                            EnumMap<Metric, MeasurePoint> map = c.getMetrics();
                            for (Metric m : map.keySet())
                                MonitoringReporterFactory.reporter().trigger(
                                        new ContractViolationEvent(c.getComponentPath(),
                                                m, map.get(m).getObserved(), map.get(m).getMax()));
                        }

//                        // FIXME in Monitoring component, reconfiguration must be avoid.
//                        // Monitoring event must be sent to something else which is able to take decision
//                        tmpList = new SlowDownComponentInteraction(service).adapt(nodeName, tmpList);
//                        tmpList = new KillThemAll(service).adapt(nodeName, tmpList);
//
//                        if (tmpList.isEmpty()) {
                            switchToGlobal();
//                        }
//                        else {
//                            // TODO: the system cannot perform an adaptation. Die
//                            System.err.println("Why I am here");
//                            System.exit(3);
//                        }
                    }
                    else {
                        getCurrentStrategy().pause();
                        switchToGlobal();
                    }

                    break;
            }
        }

        getCurrentStrategy().stop();
        gcWatcher.unregister();
        gcWatcher = null;
    }



    private void switchToSimpleLocal(EnumSet<Metric> reason) {
        // FIXME : SimpleID problem because getPreviousModel cannot be requested during updates
        try {
            MonitoringReporterFactory.reporter().trigger(new MonitoringNotification(false, reason))/*.monitoring(false)*/;
            MyLowLevelResourceConsumptionRecorder.getInstance().turnMonitoring(true,
                    !monitoringComponent.isSingleMonitoring());
            currentStatus = MonitoringStatus.LOCAL_MONITORING;
            MonitoringStrategy strategy = monitoringComponent.getLocalMonitoringStrategy(reason, msg);

            setCurrentStrategy(strategy);
            strategy.init(0);
        }
        catch (Exception e) {
            System.err.println("==================\n nooooooooo \n ===================");
            e.printStackTrace();
            switchToGlobal();
        }
    }

    private void switchToGlobal() {
        long time = timeConsumedInLocalMonitoring();
        MonitoringReporterFactory.reporter().trigger(new MonitoringNotification(true, time));
        MyLowLevelResourceConsumptionRecorder.getInstance().turnMonitoring(false,
                !monitoringComponent.isSingleMonitoring());
        currentStatus = MonitoringStatus.GLOBAL_MONITORING;
        setCurrentStrategy(new GlobalMonitoring(msg, globalThreshold));
        getCurrentStrategy().init(1000);
    }

    private long timeConsumedInLocalMonitoring() {
        if (timeAtTheBeginning == 0)
            timeAtTheBeginning = System.currentTimeMillis();
        long time = System.currentTimeMillis() - timeAtTheBeginning;
        totalTimeInLocalMonitoring += time;
        countOfLocalMonitoring++;
        System.out.printf("Total Time in Local Monitoring %d with %d times inside it\n",
                totalTimeInLocalMonitoring, countOfLocalMonitoring);
        return time;
    }
}
