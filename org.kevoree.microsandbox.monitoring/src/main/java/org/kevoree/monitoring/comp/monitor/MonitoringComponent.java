package org.kevoree.monitoring.comp.monitor;

import org.kevoree.ComponentInstance;
import org.kevoree.ContainerRoot;
import org.kevoree.annotation.*;
import org.kevoree.api.*;
import org.kevoree.api.handler.ModelListener;
import org.kevoree.api.handler.ModelListenerAdapter;
import org.kevoree.api.handler.UpdateContext;
import org.kevoree.library.defaultNodeTypes.ModelRegistry;
import org.kevoree.log.Log;
import org.kevoree.microsandbox.api.communication.ComposeMonitoringReport;
import org.kevoree.microsandbox.api.communication.MonitoringReporterFactory;
import org.kevoree.microsandbox.api.contract.PlatformDescription;
import org.kevoree.microsandbox.api.event.MicrosandboxEvent;
import org.kevoree.microsandbox.api.heuristic.MonitoringEvent;
import org.kevoree.microsandbox.api.heuristic.RankingHeuristicComponent;
import org.kevoree.microsandbox.api.sla.Metric;
import org.kevoree.microsandbox.monitoredNode.MonitoringRegistry;
import org.kevoree.monitoring.communication.MicrosandboxEventListener;
import org.kevoree.monitoring.communication.MicrosandboxReporter;
import org.kevoree.monitoring.comp.MyLowLevelResourceConsumptionRecorder;
import org.kevoree.monitoring.sla.GlobalThreshold;
import org.kevoree.monitoring.strategies.AbstractMonitoringTask;
import org.kevoree.monitoring.strategies.MonitoringTask;
import org.kevoree.monitoring.strategies.MonitoringTaskAllComponents;
import org.kevoree.monitoring.strategies.monitoring.*;
import org.kevoree.monitoring.helper.SynchronizedChannelCallback;
import org.resourceaccounting.LowLevelResourceMonitorProxy;

import java.util.*;

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
    double memory_threshold;
    @Param(defaultValue = "70")
    double cpu_threshold;
    @Param(defaultValue = "80")
    double net_in_threshold;
    @Param(defaultValue = "80")
    double net_out_threshold;
    @Param(defaultValue = "80")
    double io_in_threshold;
    @Param(defaultValue = "80")
    double io_out_threshold;
    @Param(optional = true, defaultValue = "true")
    boolean adaptiveMonitoring;
    @Param(optional = true, defaultValue = "all-components")
    String fineGrainedStrategy;

    @Param(optional = true, defaultValue = "false") // or "heap-explorer"
    boolean use_HeapExplorer;

    @KevoreeInject
    Context context;
    @KevoreeInject
    ModelService modelService;
    @KevoreeInject
    BootstrapService bootstrapService;

    // used with the native agent
    public ModelRegistry register;

    //    private ModelRankingAlgorithm modelRanker;
    private ModelListener listener;

    private MonitoringRegistry monitoringRegistry;
    private MemorySubstrategy memorySubstrategy = new DefaultMemorySubstrategy();

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
            Log.error("Why the platform description isn't here?");
            System.exit(0);
        }

//        boolean adaptiveMonitoring = Boolean.valueOf(getDictionary().get("adaptiveMonitoring").toString());

        if (MonitoringReporterFactory.reporter() instanceof ComposeMonitoringReport) {
            ((ComposeMonitoringReport) MonitoringReporterFactory.reporter()).addReporter(
                    new MicrosandboxReporter(this));
        }

        if (use_HeapExplorer) {
            if (MyLowLevelResourceConsumptionRecorder.getInstance().isScapegoat2())
                memorySubstrategy = new HeapExplorerMemorySubstrategy(modelService, register);
            else {
                while (true) {
                    Log.error("Using heapExplorer without providing the proper strategy to the Java Agent. Should be scapegoat2");
                }
            }
        }

        if (adaptiveMonitoring) {
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
        if (monitoringTask != null) {
            monitoringTask.stop();
        }
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
        if (getRankingOrder != null && getRankingOrder.getConnectedBindingsSize() > 0) {
            SynchronizedChannelCallback<ComponentInstance[]> callback = new SynchronizedChannelCallback<ComponentInstance[]>();
            getRankingOrder.call(nodeName, callback);
            try {
                ComponentInstance[] instances = callback.waitForResult(5000);

                if (instances != null) {
                    return instances;
                }
                return new ComponentInstance[0];
            } catch (Throwable throwable) {
                throwable.printStackTrace();
                return new ComponentInstance[0];
            }
        } else {
            return new ComponentInstance[0];
        }
    }

    public MemorySubstrategy getMemorySubstrategy() {
        return memorySubstrategy;
    }

    public boolean isSingleMonitoring() {
        return fineGrainedStrategy.equals("single-monitoring");
    }

    public MonitoringStrategy getLocalMonitoringStrategy(EnumSet<Metric> reason, Object msg) {
        ComponentInstance[] ll = getRankingOrder(getNodeName());
        List<ComponentInstance> l = new ArrayList<ComponentInstance>();

        for (ComponentInstance ci : ll) l.add(ci);

        if (fineGrainedStrategy.equals("single-monitoring"))
            return new SingleComponentMonitoring(reason, l, getMemorySubstrategy(), msg);
        if (fineGrainedStrategy.equals("all-components"))
            return new AllComponentsMonitoring(reason, l, getMemorySubstrategy(), msg);
        return new AllComponentsMonitoring(reason, l, getMemorySubstrategy(), msg);
    }


    @Override
    public void triggerMonitoringEvent(MonitoringEvent event) {
        if (triggerMonitoringEvent.getConnectedBindingsSize() > 0) {
            Log.debug("TRIGGERING MONITORING EVENT {}", event);
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
        public boolean afterLocalUpdate(UpdateContext updateContext) {
            for (ComponentInstance instance : updateContext.getProposedModel().findNodesByID(getNodeName()).getComponents()) {
                if (!deployTimes.containsKey(instance.path())) {
                    deployTimesToSend.put(instance.path(), (Long) monitoringRegistry.lookup(instance.path() + "_deployTime"));
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
        public void preRollback(UpdateContext updateContext) {
            deployTimesToSend.clear();
        }
    }
}

