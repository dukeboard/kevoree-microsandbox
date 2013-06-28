package org.kevoree.monitoring.comp.monitor;

import org.kevoree.annotation.*;
import org.kevoree.framework.AbstractComponentType;
import org.kevoree.monitoring.strategies.DataForCheckingContract;
import org.kevoree.monitoring.strategies.MonitoringTask;
import org.resourceaccounting.ResourcePrincipal;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 6/11/13
 * Time: 2:57 PM
 * To change this template use File | Settings | File Templates.
 */
@Requires( {
 @RequiredPort(name = "output" , type = PortType.MESSAGE, optional = true)
})
@ComponentType
public class MonitoringComponent extends AbstractComponentType {

    MonitoringTask monitoringTask;

    @Start
    public void startComponent() {
        monitoringTask = new MonitoringTask(getNodeName(), getModelService(), getBootStrapperService());
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
}
