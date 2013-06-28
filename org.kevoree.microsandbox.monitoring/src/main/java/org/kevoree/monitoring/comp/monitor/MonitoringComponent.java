package org.kevoree.monitoring.comp.monitor;

import org.kevoree.annotation.*;
import org.kevoree.framework.AbstractComponentType;
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
public class MonitoringComponent extends AbstractComponentType
        implements
        ContractVerificationRequired {

    MonitoringTask monitoringTask;

    private ComponentWatcher componentWatcher;
    private ContractWatcher contractWatcher;

    @Start
    public void startComponent() {
//        contractWatcher = new ContractWatcher();
//        componentWatcher = new ComponentWatcher();
//        componentWatcher.addContractVerificationRequieredListener(this);
//        new Thread(componentWatcher).start();



        monitoringTask = new MonitoringTask(getNodeName(), getModelService(), getBootStrapperService());
        new Thread(monitoringTask).start();
    }

    @Stop
    public void stopComponent() {
//        componentWatcher.setTerminated(true);
        monitoringTask.stop();
    }

    @Update
    public void updateComponent() {
        stopComponent();
        startComponent();
    }

    @Override
    public void verifyContract(ResourcePrincipal principal, Object obj) {
        if (obj instanceof DataForCheckingContract) {
            DataForCheckingContract data = (DataForCheckingContract)obj;
            contractWatcher.checkContract(principal, data);
        }
    }

    @Override
    public void onGCVerifyContract(long used, long max) {

    }
}
