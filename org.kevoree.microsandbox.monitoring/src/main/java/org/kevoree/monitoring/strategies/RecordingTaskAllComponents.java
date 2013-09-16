package org.kevoree.monitoring.strategies;

import org.kevoree.ComponentInstance;
import org.kevoree.api.Bootstraper;
import org.kevoree.api.service.core.handler.KevoreeModelHandlerService;
import org.kevoree.monitoring.comp.MyLowLevelResourceConsumptionRecorder;
import org.kevoree.monitoring.comp.monitor.GCWatcher;
import org.kevoree.monitoring.comp.monitor.NewMetricReporter;
import org.kevoree.monitoring.models.SimpleIdAssigner;
import org.kevoree.monitoring.ranking.ComponentRankerFunctionFactory;
import org.kevoree.monitoring.ranking.ComponentsInfoStorage;
import org.kevoree.monitoring.ranking.ComponentsRanker;
import org.kevoree.monitoring.strategies.monitoring.FineGrainedStrategyFactory;
import org.kevoree.monitoring.strategies.monitoring.RankChecker;
import org.kevoree.monitoring.strategies.monitoring.RecordingAllComponentsForEver;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 7/9/13
 * Time: 5:03 PM
 *
 */
public class RecordingTaskAllComponents extends AbstractMonitoringTask implements RankChecker {

    private final NewMetricReporter reporter;

    public RecordingTaskAllComponents(String nodeName,
                                      KevoreeModelHandlerService service,
                                      Bootstraper bootstraper, NewMetricReporter reporter) {
        super(bootstraper,service,"",nodeName);
        this.reporter = reporter;
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
        MyLowLevelResourceConsumptionRecorder.getInstance().turnMonitoring(true,
                !FineGrainedStrategyFactory.instance$.isSingleMonitoring());
        currentStrategy = new RecordingAllComponentsForEver(new ArrayList<ComponentInstance>(), msg, this, reporter);
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
