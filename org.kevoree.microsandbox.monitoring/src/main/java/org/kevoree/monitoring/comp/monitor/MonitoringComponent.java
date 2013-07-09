package org.kevoree.monitoring.comp.monitor;

import org.kevoree.ComponentInstance;
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
import org.kevoree.monitoring.sla.GlobalThreshold;
import org.kevoree.monitoring.strategies.MonitoringTask;
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
 @RequiredPort(name = "reasoner", type = PortType.MESSAGE,
         className = MicrosandboxEvent.class, optional = true)
})
@DictionaryType( {
        @DictionaryAttribute(name = "memory_threshold", defaultValue = "60"),
        @DictionaryAttribute(name = "cpu_threshold", defaultValue = "70"),
        @DictionaryAttribute(name = "net_in_threshold", defaultValue = "80"),
        @DictionaryAttribute(name = "net_out_threshold", defaultValue = "80"),
        @DictionaryAttribute(name = "io_in_threshold", defaultValue = "80"),
        @DictionaryAttribute(name = "io_out_threshold", defaultValue = "80"),

        @DictionaryAttribute(name = "fineGrainedStrategy", defaultValue = "all-components") // the other is single-monitoring
}
)
@ComponentType
public class MonitoringComponent extends AbstractComponentType implements MicrosandboxEventListener {
    MonitoringTask monitoringTask;

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
            System.out.println("panic: Why the platform description isn't here");
            System.exit(0);
        }

        FineGrainedStrategyFactory.instance$.init(getDictionary().get("fineGrainedStrategy").toString());

        GlobalThreshold globalThreshold = new GlobalThreshold(cpu,memory,
                                                                net_received, net_sent,
                                                                io_read, io_write,description);

        if (MonitoringReporterFactory.reporter() instanceof ComposeMonitoringReport) {
            ((ComposeMonitoringReport)MonitoringReporterFactory.reporter()).addReporter(
                    new MicrosandboxReporter(this));
        }

        monitoringTask = new MonitoringTask(getNodeName(),
                globalThreshold,
                getModelService(),
                getBootStrapperService());

        getModelService().registerModelListener(monitoringTask);

        new Thread(monitoringTask).start();
    }

    @Stop
    public void stopComponent() {
        monitoringTask.stop();
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
}
