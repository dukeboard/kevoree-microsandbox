package org.kevoree.monitoring.comp.monitor;

import org.kevoree.ComponentInstance;
import org.kevoree.ContainerRoot;
import org.kevoree.annotation.*;
import org.kevoree.api.service.core.handler.ModelListener;
import org.kevoree.framework.AbstractComponentType;
import org.kevoree.framework.MessagePort;
import org.kevoree.framework.service.handler.ModelListenerAdapter;
import org.kevoree.library.defaultNodeTypes.context.KevoreeDeployManager;
import org.kevoree.microsandbox.api.communication.ComposeMonitoringReport;
import org.kevoree.microsandbox.api.communication.MonitoringReporterFactory;
import org.kevoree.microsandbox.api.contract.PlatformDescription;
import org.kevoree.microsandbox.api.event.MicrosandboxEvent;
import org.kevoree.microsandbox.api.heuristic.RankingHeuristicComponent;
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
@Requires({
        @RequiredPort(name = "output", type = PortType.MESSAGE, optional = true),
        @RequiredPort(name = "reasoner", type = PortType.MESSAGE, className = MicrosandboxEvent.class, optional = true),
        @RequiredPort(name = "ranking", type = PortType.SERVICE, optional = false, className = RankingHeuristicComponent.class, needCheckDependency = true)
})
@DictionaryType({
        @DictionaryAttribute(name = "memory_threshold", defaultValue = "60"),
        @DictionaryAttribute(name = "cpu_threshold", defaultValue = "70"),
        @DictionaryAttribute(name = "net_in_threshold", defaultValue = "80"),
        @DictionaryAttribute(name = "net_out_threshold", defaultValue = "80"),
        @DictionaryAttribute(name = "io_in_threshold", defaultValue = "80"),
        @DictionaryAttribute(name = "io_out_threshold", defaultValue = "80"),

        // indicates that we want adaptive monitoring
        @DictionaryAttribute(name = "adaptiveMonitoring", defaultValue = "true", vals = {"false", "true"}, optional = true),

        // indicates the kind of fine-grained monitoring
        @DictionaryAttribute(name = "fineGrainedStrategy", defaultValue = "all-components", vals = {"all-components", "single-monitoring"}, optional = true) // the other is single-monitoring

        // indicate the function used to rank components
//        @DictionaryAttribute(name ="componentRankFunction", defaultValue = "amount_of_time_alive")
}
)
@ComponentType
public class MonitoringComponent extends AbstractComponentType implements MicrosandboxEventListener, RankingHeuristicComponent {
    AbstractMonitoringTask monitoringTask;

//    private ModelRankingAlgorithm modelRanker;
    private ModelListener listener;

    @Start
    public void startComponent() {
        double cpu = Double.valueOf(getDictionary().get("cpu_threshold").toString());
        double memory = Double.valueOf(getDictionary().get("memory_threshold").toString());
        double net_received = Double.valueOf(getDictionary().get("net_in_threshold").toString());
        double net_sent = Double.valueOf(getDictionary().get("net_out_threshold").toString());
        double io_read = Long.valueOf(getDictionary().get("io_in_threshold").toString());
        double io_write = Long.valueOf(getDictionary().get("io_out_threshold").toString());

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

        boolean adaptiveMonitoring = Boolean.valueOf(getDictionary().get("adaptiveMonitoring").toString());

        if (MonitoringReporterFactory.reporter() instanceof ComposeMonitoringReport) {
            ((ComposeMonitoringReport) MonitoringReporterFactory.reporter()).addReporter(
                    new MicrosandboxReporter(this));
        }

        if (adaptiveMonitoring) {
            FineGrainedStrategyFactory.instance$.init(getDictionary().get("fineGrainedStrategy").toString());

            GlobalThreshold globalThreshold = new GlobalThreshold(cpu, memory,
                    net_received, net_sent,
                    io_read, io_write, description);
            monitoringTask = new MonitoringTask(getNodeName(),
                    globalThreshold,
                    this,
                    getModelService(),
                    getBootStrapperService());

        } else {
            monitoringTask = new MonitoringTaskAllComponents(getNodeName(),
                    this,
                    getModelService(),
                    getBootStrapperService());
        }
            listener = new DeployTimeSender();
            getModelService().registerModelListener(listener);
        new Thread(monitoringTask).start();
    }

    @Stop
    public void stopComponent() {
        monitoringTask.stop();
        getModelService().unregisterModelListener(listener);
//        getModelService().unregisterModelListener(modelRanker);
    }

    @Update
    public void updateComponent() {
        stopComponent();
        startComponent();
    }

    @Override
    public void notifyEvent(MicrosandboxEvent monitoringEvent) {
        if (isPortBinded("reasoner")) {
            MessagePort port = getPortByName("reasoner", MessagePort.class);
            port.process(monitoringEvent);
        }
    }

    public ComponentInstance[] getRankingOrder(String nodeName) {
        if (isPortBinded("ranking")) {
            // FIXME remove the loop
            ComponentInstance[] instances = getPortByName("ranking", RankingHeuristicComponent.class).getRankingOrder(nodeName);
            for (ComponentInstance instance : instances) {
                System.out.println(instance.path());
            }
            return instances;
        } else {
            return new ComponentInstance[0];
        }
    }

    @Override
    public void triggerMonitoringEvent(String operation, String name, String instancePath, Long value) {
        if (isPortBinded("ranking")) {
            getPortByName("ranking", RankingHeuristicComponent.class).triggerMonitoringEvent(operation, name, instancePath, value);
        }
    }

    private class DeployTimeSender extends ModelListenerAdapter {


        private Map<String, Long> deployTimes;
        private Map<String, Long> deployTimesToSend;

        private DeployTimeSender() {
            deployTimes = new LinkedHashMap<String, Long>();
            deployTimesToSend = new LinkedHashMap<String, Long>();

        }

        @Override
        public boolean preUpdate(ContainerRoot currentModel, ContainerRoot proposedModel) {
            return true;
        }

        @Override
        public boolean initUpdate(ContainerRoot currentModel, ContainerRoot proposedModel) {
            return true;
        }

        @Override
        public boolean afterLocalUpdate(ContainerRoot currentModel, ContainerRoot proposedModel) {
            for (ComponentInstance instance : proposedModel.findNodesByID(getNodeName()).getComponents()) {
                if (!deployTimes.containsKey(instance.path())) {
                    deployTimesToSend.put(instance.path(), (Long) KevoreeDeployManager.instance$.getRef(instance.getClass().getName() + "_deployTime", instance.getName()));
                }
            }
            return true;
        }

        @Override
        public void modelUpdated() {
            for (String instancePath : deployTimesToSend.keySet()) {
                triggerMonitoringEvent("CREATE", "deployTime", instancePath, deployTimesToSend.get(instancePath));
            }
            deployTimes.putAll(deployTimesToSend);
            deployTimesToSend.clear();
        }

        @Override
        public void preRollback(ContainerRoot containerRoot, ContainerRoot containerRoot2) {
            deployTimesToSend.clear();
        }

        @Override
        public void postRollback(ContainerRoot containerRoot, ContainerRoot containerRoot2) {
        }
    }
}
