package org.kevoree.monitoring.strategies;

import org.kevoree.ComponentInstance;
import org.kevoree.api.Bootstraper;
import org.kevoree.api.service.core.handler.KevoreeModelHandlerService;
import org.kevoree.microsandbox.api.communication.MonitoringReporterFactory;
import org.kevoree.microsandbox.api.event.ContractViolationEvent;
import org.kevoree.microsandbox.api.event.MonitoringNotification;
import org.kevoree.microsandbox.api.sla.Metric;
import org.kevoree.monitoring.comp.MyLowLevelResourceConsumptionRecorder;
import org.kevoree.monitoring.comp.monitor.GCWatcher;
import org.kevoree.monitoring.comp.monitor.MonitoringComponent;
import org.kevoree.monitoring.sla.FaultyComponent;
import org.kevoree.monitoring.sla.MeasurePoint;
import org.kevoree.monitoring.strategies.monitoring.AllComponentsForEver;
import org.kevoree.monitoring.strategies.monitoring.FineGrainedMonitoringStrategy;
import org.kevoree.monitoring.strategies.monitoring.FineGrainedStrategyFactory;
import org.kevoree.monitoring.strategies.monitoring.RankChecker;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 7/9/13
 * Time: 5:03 PM
 *
 */
public class MonitoringTaskAllComponents extends AbstractMonitoringTask implements RankChecker {

    public MonitoringTaskAllComponents(String nodeName,/*String nameOfRankerFunction*/
                                       MonitoringComponent monitoringComponent,
                          KevoreeModelHandlerService service,
                          Bootstraper bootstraper) {
        super(bootstraper,service,monitoringComponent,nodeName);
    }


    @Override
    public void run() {
        System.out.printf("Initiating Monitoring task\n");

//        ComponentsInfoStorage.instance.setIdAssigner(new SimpleIdAssigner(service));

        gcWatcher = new GCWatcher();
        gcWatcher.addContractVerificationRequieredListener(this);
        gcWatcher.register();

        switchToSimpleLocal(EnumSet.allOf(Metric.class), true);
        int errors = 0;

        stopped = false;
        while (!isStopped()) {
            waitMessage();
            if (isStopped()) continue;
            if (currentStrategy.isThereContractViolation()) {
                currentStrategy.pause();
                FineGrainedMonitoringStrategy s =(FineGrainedMonitoringStrategy)currentStrategy;
                List<FaultyComponent> tmpList = s.getFaultyComponents();
                for (FaultyComponent c : tmpList) {
                    // FIXME add some information on a specific port (or somthing to notify interesting component)
                    // TODO add this information inside Context Model
//                    ComponentsInfoStorage.instance.getExecutionInfo(c.getComponentPath()).increaseFailures();
                    EnumMap<Metric, MeasurePoint> map = c.getMetrics();
                    for (Metric m : map.keySet())
                        MonitoringReporterFactory.reporter().trigger(
                                new ContractViolationEvent(c.getComponentPath(),
                                        m, map.get(m).getObserved(), map.get(m).getMax()));
                }

                System.out.println("Number of errors found " + ++errors);

                // FIXME in Monitoring component, reconfiguration must be avoid. Monitoring event must be sent to something else which is able to take decisions
//                tmpList = new SlowDownComponentInteraction(service).adapt(nodeName, tmpList);
//                tmpList = new KillThemAll(service).adapt(nodeName, tmpList);

//                if (tmpList.isEmpty()) {
                    switchToSimpleLocal(EnumSet.allOf(Metric.class),false);
//                }
//                else {
//                    // TODO: the system cannot perform an adaptation. Die
//                    System.err.println("Why am I here?");
//                    System.exit(3);
//                }
            }
        }

        currentStrategy.stop();
        gcWatcher.unregister();
        gcWatcher = null;
    }

    private void switchToSimpleLocal(EnumSet<Metric> reason, boolean b) {
        MonitoringReporterFactory.reporter().trigger(new MonitoringNotification(false, reason))/*.monitoring(false)*/;
        if (b)
            MyLowLevelResourceConsumptionRecorder.getInstance().turnMonitoring(true,
                    !FineGrainedStrategyFactory.instance$.isSingleMonitoring());

        currentStrategy = new AllComponentsForEver( new ArrayList<ComponentInstance>(), msg, this);
        currentStrategy.init(0);
    }


    @Override
    public List<ComponentInstance> getRanking() {
        try {
//            return ComponentsRanker.instance$.rank(nodeName, service, bootstraper,nameOfRankerFunction);
            return Arrays.asList(getRankingOrder(monitoringComponent.getNodeName()));
        }
        catch (Exception e) {
            return new ArrayList<ComponentInstance>();
        }
    }
}
