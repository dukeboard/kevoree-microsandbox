package org.kevoree.monitoring.comp.monitor;

import org.kevoree.annotation.*;
import org.kevoree.api.BootstrapService;
import org.kevoree.api.Context;
import org.kevoree.api.ModelService;
import org.kevoree.api.Port;
import org.kevoree.microsandbox.api.contract.PlatformDescription;
import org.kevoree.microsandbox.monitoredNode.MonitoringRegistry;
import org.kevoree.monitoring.strategies.AbstractMonitoringTask;
import org.kevoree.monitoring.strategies.RecordingTaskAllComponents;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 6/11/13
 * Time: 2:57 PM
 */
@ComponentType
public class ForContractInformationRetrieverComponent implements NewMetricReporter {
    AbstractMonitoringTask monitoringTask;

    @Output(optional = false)
    Port output;

    @KevoreeInject
    Context context;
    @KevoreeInject
    ModelService modelService;
    @KevoreeInject
    BootstrapService bootstrapService;

    MonitoringRegistry monitoringRegistry;
//    private ModelRankingAlgorithm modelRanker;

    @Start
    public void startComponent() {

        PlatformDescription description = null;
        for (String key : monitoringRegistry.getRegistry().keySet())
            if (key.contains("_platformDescription")) {
                description = (PlatformDescription) monitoringRegistry.getRegistry().get(key);
                break;
            }
        if (description == null) {
            System.out.println("panic: Why the platform description isn't here?");
            System.exit(0);
        }

        monitoringTask = new RecordingTaskAllComponents(context.getNodeName(),
                modelService,
                bootstrapService, this);
//        getModelService().registerModelListener(monitoringTask);

        new Thread(monitoringTask).start();
    }

    @Stop
    public void stopComponent() {
        monitoringTask.stop();
//        getModelService().unregisterModelListener(modelRanker);
    }

    @Update
    public void updateComponent() {
        stopComponent();
        startComponent();
    }

    @Override
    public void report(String component, InfoForContractCreation info) {
        if (output.getConnectedBindingsSize() > 0) {
            output.send(info);
        }
    }
}
