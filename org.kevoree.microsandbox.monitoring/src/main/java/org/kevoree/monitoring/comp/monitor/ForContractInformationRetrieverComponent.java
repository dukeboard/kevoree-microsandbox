package org.kevoree.monitoring.comp.monitor;

import org.kevoree.annotation.*;
import org.kevoree.framework.AbstractComponentType;
import org.kevoree.framework.MessagePort;
import org.kevoree.library.defaultNodeTypes.context.KevoreeDeployManager;
import org.kevoree.microsandbox.api.communication.ComposeMonitoringReport;
import org.kevoree.microsandbox.api.communication.MonitoringReporterFactory;
import org.kevoree.microsandbox.api.contract.PlatformDescription;
import org.kevoree.microsandbox.api.event.MicrosandboxEvent;
import org.kevoree.monitoring.communication.MicrosandboxEventListener;
import org.kevoree.monitoring.communication.MicrosandboxReporter;
import org.kevoree.monitoring.ranking.ComponentRankerFunctionFactory;
import org.kevoree.monitoring.ranking.ComponentsInfoStorage;
import org.kevoree.monitoring.ranking.ModelRankingAlgorithm;
import org.kevoree.monitoring.sla.GlobalThreshold;
import org.kevoree.monitoring.strategies.AbstractMonitoringTask;
import org.kevoree.monitoring.strategies.MonitoringTask;
import org.kevoree.monitoring.strategies.MonitoringTaskAllComponents;
import org.kevoree.monitoring.strategies.RecordingTaskAllComponents;
import org.kevoree.monitoring.strategies.monitoring.FineGrainedStrategyFactory;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 6/11/13
 * Time: 2:57 PM
 *
 */
@Requires( {
 @RequiredPort(name = "output" , type = PortType.MESSAGE, optional = true),
})
@ComponentType
public class ForContractInformationRetrieverComponent extends AbstractComponentType
            implements NewMetricReporter{
    AbstractMonitoringTask monitoringTask;

    private ModelRankingAlgorithm modelRanker;

    @Start
    public void startComponent() {

        PlatformDescription description = null;
        for (String key : KevoreeDeployManager.instance$.getInternalMap().keySet())
            if (key.contains("_platformDescription")) {
                description = (PlatformDescription) KevoreeDeployManager.instance$.getInternalMap().get(key);
                break;
            }
        if (description == null) {
            System.out.println("panic: Why the platform description isn't here?");
            System.exit(0);
        }

        monitoringTask = new RecordingTaskAllComponents(getNodeName(),
                            getModelService(),
                            getBootStrapperService(), this);
        getModelService().registerModelListener(monitoringTask);

        new Thread(monitoringTask).start();
    }

    @Stop
    public void stopComponent() {
        monitoringTask.stop();
        getModelService().unregisterModelListener(modelRanker);
    }

    @Update
    public void updateComponent() {
        stopComponent();
        startComponent();
    }

    @Override
    public void report(String component, InfoForContractCreation info) {
        MessagePort p = getPortByName("output", MessagePort.class);
        p.process(info);
    }
}
