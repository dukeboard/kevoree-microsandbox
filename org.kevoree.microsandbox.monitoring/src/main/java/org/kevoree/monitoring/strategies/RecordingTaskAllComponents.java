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
import org.kevoree.monitoring.strategies.monitoring.RankChecker;
import org.kevoree.monitoring.strategies.monitoring.RecordingAllComponentsForEver;

import java.util.ArrayList;
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
public class RecordingTaskAllComponents extends AbstractMonitoringTask implements RankChecker {

    public RecordingTaskAllComponents(String nodeName,
                                      KevoreeModelHandlerService service,
                                      Bootstraper bootstraper) {
        super(bootstraper,service,"",nodeName);
    }


    @Override
    public void run() {
        System.out.printf("Initiating Monitoring task\n");

        ComponentsInfoStorage.object$.getInstance().setIdAssigner(new SimpleIdAssigner(service));

        gcWatcher = new GCWatcher();
        gcWatcher.addContractVerificationRequieredListener(this);
        gcWatcher.register();

        switchToSimpleLocal();

        stopped = false;
        while (!isStopped()) {
            waitMessage();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) { }
        }

        currentStrategy.stop();
        gcWatcher.unregister();
        gcWatcher = null;
    }

    private void switchToSimpleLocal() {
        MyLowLevelResourceConsumptionRecorder.getInstance().turnMonitoring(true);

        currentStrategy = new RecordingAllComponentsForEver(new ArrayList<ComponentInstance>(), msg, this);
        currentStrategy.init(0);
    }


    @Override
    public List<ComponentInstance> getRanking() {
        try {

            return ComponentsRanker.instance$.rank(nodeName, service, bootstraper,
                    ComponentRankerFunctionFactory.instance$.get(nameOfRankerFunction));
        }
        catch (Exception e) {
            return new ArrayList<ComponentInstance>();
        }
    }
}
