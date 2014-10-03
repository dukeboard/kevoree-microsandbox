package org.kevoree.monitoring.strategies;

import org.kevoree.ComponentInstance;
import org.kevoree.api.BootstrapService;
import org.kevoree.api.ModelService;
import org.kevoree.monitoring.comp.MyLowLevelResourceConsumptionRecorder;
import org.kevoree.monitoring.comp.monitor.GCWatcher;
import org.kevoree.monitoring.comp.monitor.NewMetricReporter;
import org.kevoree.monitoring.strategies.monitoring.RankChecker;
import org.kevoree.monitoring.strategies.monitoring.RecordingAllComponentsForEver;

import java.util.ArrayList;
import java.util.Arrays;
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
                                      ModelService service,
                                      BootstrapService bootstraper, NewMetricReporter reporter) {
        super(bootstraper,service,null,nodeName);
        this.reporter = reporter;
    }


    @Override
    public void run() {
        System.out.printf("Initiating Monitoring task\n");

//        ComponentsInfoStorage.instance.setIdAssigner(new SimpleIdAssigner(service));

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

        getCurrentStrategy().stop();
        gcWatcher.unregister();
        gcWatcher = null;
    }

    private void switchToSimpleLocal() {
        MyLowLevelResourceConsumptionRecorder.getInstance().turnMonitoring(true,
                !monitoringComponent.isSingleMonitoring());
        setCurrentStrategy(new RecordingAllComponentsForEver(new ArrayList<ComponentInstance>(), msg, this, reporter));
        getCurrentStrategy().init(0);
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
