package org.kevoree.monitoring.comp.monitor;

import org.kevoree.ComponentInstance;
import org.kevoree.ContainerRoot;
import org.kevoree.annotation.*;
import org.kevoree.api.BootstrapService;
import org.kevoree.api.Context;
import org.kevoree.api.ModelService;
import org.kevoree.api.Port;
import org.kevoree.api.handler.ModelListener;
import org.kevoree.api.handler.ModelListenerAdapter;
import org.kevoree.komponents.helpers.SynchronizedChannelCallback;
import org.kevoree.log.Log;
import org.kevoree.microsandbox.api.communication.ComposeMonitoringReport;
import org.kevoree.microsandbox.api.communication.MonitoringReporterFactory;
import org.kevoree.microsandbox.api.contract.PlatformDescription;
import org.kevoree.microsandbox.api.event.MicrosandboxEvent;
import org.kevoree.microsandbox.api.heuristic.MonitoringEvent;
import org.kevoree.microsandbox.api.heuristic.RankingHeuristicComponent;
import org.kevoree.microsandbox.monitoredNode.MonitoringRegistry;
import org.kevoree.monitoring.communication.MicrosandboxEventListener;
import org.kevoree.monitoring.communication.MicrosandboxReporter;
import org.kevoree.monitoring.sla.GlobalThreshold;
import org.kevoree.monitoring.strategies.AbstractMonitoringTask;
import org.kevoree.monitoring.strategies.MonitoringTask;
import org.kevoree.monitoring.strategies.MonitoringTaskAllComponents;
import org.kevoree.monitoring.strategies.monitoring.FineGrainedStrategyFactory;

import java.util.LinkedHashMap;
import java.util.Map;

//import org.kevoree.monitoring.ranking.ModelRankingAlgorithm;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 6/11/13
 * Time: 2:57 PM
 */
@ComponentType
public class MonitoringComponent implements MicrosandboxEventListener, RankingHeuristicComponent {
    AbstractMonitoringTask monitoringTask;

    @Output(optional = true)
    Port output;
    @Output(optional = true)
    Port reasoner;
    @Output(optional = true)
    Port getRankingOrder;
    @Output(optional = true)
    Port triggerMonitoringEvent;

    @Param(defaultValue = "60")
    int memory_threshold;
    @Param(defaultValue = "70")
    int cpu_threshold;
    @Param(defaultValue = "80")
    int net_in_threshold;
    @Param(defaultValue = "80")
    int net_out_threshold;
    @Param(defaultValue = "80")
    int io_in_threshold;
    @Param(defaultValue = "80")
    int io_out_threshold;
    @Param(optional = true, defaultValue = "true")
    boolean adaptiveMonitoring;
    @Param(optional = true, defaultValue = "all-components")
    String fineGrainedStrategy;

    @KevoreeInject
    Context context;
    @KevoreeInject
    ModelService modelService;
    @KevoreeInject
    BootstrapService bootstrapService;

    //    private ModelRankingAlgorithm modelRanker;
    private ModelListener listener;

    private MonitoringRegistry monitoringRegistry;

    @Start
    public void startComponent() {
        monitoringRegistry = MonitoringRegistry.getInstance();

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

//        boolean adaptiveMonitoring = Boolean.valueOf(getDictionary().get("adaptiveMonitoring").toString());

        if (MonitoringReporterFactory.reporter() instanceof ComposeMonitoringReport) {
            ((ComposeMonitoringReport) MonitoringReporterFactory.reporter()).addReporter(
                    new MicrosandboxReporter(this));
        }

        if (adaptiveMonitoring) {
            FineGrainedStrategyFactory.instance$.init(fineGrainedStrategy);
            GlobalThreshold globalThreshold = new GlobalThreshold(cpu_threshold, memory_threshold,
                    net_in_threshold, net_out_threshold,
                    io_in_threshold, io_out_threshold, description);
            monitoringTask = new MonitoringTask(context.getNodeName(),
                    globalThreshold,
                    this,
                    modelService,
                    bootstrapService);

        } else {
            monitoringTask = new MonitoringTaskAllComponents(getNodeName(),
                    this,
                    modelService,
                    bootstrapService);
        }
        listener = new DeployTimeSender();
        modelService.registerModelListener(listener);
        new Thread(monitoringTask).start();
    }

    @Stop
    public void stopComponent() {
        monitoringTask.stop();
        modelService.unregisterModelListener(listener);
//        getModelService().unregisterModelListener(modelRanker);
    }

    @Update
    public void updateComponent() {
        stopComponent();
        startComponent();
    }

    @Override
    public void notifyEvent(MicrosandboxEvent monitoringEvent) {
        if (reasoner.getConnectedBindingsSize() > 0) {
            reasoner.send(monitoringEvent);
        }
    }

    public ComponentInstance[] getRankingOrder(String nodeName) {
        if (getRankingOrder.getConnectedBindingsSize() > 0) {
            SynchronizedChannelCallback<ComponentInstance[]> callback = new SynchronizedChannelCallback<ComponentInstance[]>();
            callback.initialize();
            getRankingOrder.call(nodeName, callback);
            try {
                ComponentInstance[] instances = callback.waitForResult(5000);

                // FIXME remove the loop
                for (ComponentInstance instance : instances) {
                    System.out.println(instance.path());
                }
                return instances;
            } catch (Throwable throwable) {
                throwable.printStackTrace();
                return new ComponentInstance[0];
            }
        } else {
            return new ComponentInstance[0];
        }
    }

    @Override
    public void triggerMonitoringEvent(MonitoringEvent event) {
        if (triggerMonitoringEvent.getConnectedBindingsSize() > 0) {
            Log.info("TRIGGERING MONITORING EVENT {}", event);
            triggerMonitoringEvent.send(event);
        }
    }


    public String getNodeName() {
        return context.getNodeName();
    }

    private class DeployTimeSender extends ModelListenerAdapter {


        private Map<String, Long> deployTimes;
        private Map<String, Long> deployTimesToSend;

        private DeployTimeSender() {
            deployTimes = new LinkedHashMap<String, Long>();
            deployTimesToSend = new LinkedHashMap<String, Long>();

        }

        @Override
        public boolean afterLocalUpdate(ContainerRoot currentModel, ContainerRoot proposedModel) {
            for (ComponentInstance instance : proposedModel.findNodesByID(getNodeName()).getComponents()) {
                if (!deployTimes.containsKey(instance.path())) {
                    deployTimesToSend.put(instance.path(), (Long) monitoringRegistry.lookup(instance.getClass().getName() + "_deployTime"));
                }
            }
            return true;
        }

        @Override
        public void modelUpdated() {
            for (String instancePath : deployTimesToSend.keySet()) {
                triggerMonitoringEvent(new MonitoringEvent("CREATE", "deployTime", instancePath, deployTimesToSend.get(instancePath)));
            }
            deployTimes.putAll(deployTimesToSend);
            deployTimesToSend.clear();
        }

        @Override
        public void preRollback(ContainerRoot containerRoot, ContainerRoot containerRoot2) {
            deployTimesToSend.clear();
        }
    }
}
