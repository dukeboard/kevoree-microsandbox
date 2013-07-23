package org.kevoree.monitoring.strategies;

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
import org.kevoree.monitoring.sla.MeasurePoint;
import org.kevoree.monitoring.strategies.adaptation.KillThemAll;
import org.kevoree.monitoring.strategies.adaptation.SlowDownComponentInteraction;
import org.kevoree.monitoring.strategies.monitoring.AllComponentsForEver;
import org.kevoree.monitoring.strategies.monitoring.FineGrainedMonitoringStrategy;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 7/9/13
 * Time: 5:03 PM
 *
 */
public class MonitoringTaskAllComponents extends AbstractMonitoringTask {

    public MonitoringTaskAllComponents(String nodeName,
                          String nameOfRankerFunction,
                          KevoreeModelHandlerService service,
                          Bootstraper bootstraper) {
        super(bootstraper,service,nameOfRankerFunction,nodeName);
    }


    @Override
    public void run() {
        System.out.printf("Initiating Monitoring task\n");

        ComponentsInfoStorage.instance$.setIdAssigner(new SimpleIdAssigner(service));

        gcWatcher = new GCWatcher();
        gcWatcher.addContractVerificationRequieredListener(this);
        gcWatcher.register();

        switchToSimpleLocal(EnumSet.allOf(Metric.class));

        stopped = false;
        while (!isStopped()) {
            waitMessage();
            if (isStopped()) continue;
            if (currentStrategy.isThereContractViolation()) {
                currentStrategy.pause();
                FineGrainedMonitoringStrategy s =(FineGrainedMonitoringStrategy)currentStrategy;
                List<FaultyComponent> tmpList = s.getFaultyComponents();
                for (FaultyComponent c : tmpList) {
                    ComponentsInfoStorage.instance$.getExecutionInfo(c.getComponentPath()).increaseFailures();
                    EnumMap<Metric, MeasurePoint> map = c.getMetrics();
                    for (Metric m : map.keySet())
                        MonitoringReporterFactory.reporter().trigger(new ContractViolationEvent(c.getComponentPath(), m, map.get(m).getObserved(), map.get(m).getMax()));
                }

                tmpList = new SlowDownComponentInteraction(service).adapt(nodeName, tmpList);
                tmpList = new KillThemAll(service).adapt(nodeName, tmpList);

                if (tmpList.isEmpty()) {
                    currentStrategy.init(0);
                }
                else {
                    // TODO: the system cannot perform an adaptation. Die
                    System.err.println("Why I am here");
                    System.exit(3);
                }
            }
        }

        currentStrategy.stop();
        gcWatcher.unregister();
        gcWatcher = null;
    }

    private void switchToSimpleLocal(EnumSet<Metric> reason) {
        MonitoringReporterFactory.reporter().trigger(new MonitoringNotification(false, reason))/*.monitoring(false)*/;
        MyLowLevelResourceConsumptionRecorder.getInstance().turnMonitoring(true);

        currentStrategy = new AllComponentsForEver(
                ComponentsRanker.instance$.rank(nodeName, service, bootstraper,
                        ComponentRankerFunctionFactory.instance$.get(nameOfRankerFunction)), msg);
        currentStrategy.init(0);
    }


}
