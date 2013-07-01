package org.kevoree.monitoring.strategies;

import org.kevoree.ComponentInstance;
import org.kevoree.library.defaultNodeTypes.context.KevoreeDeployManager;
import org.kevoree.monitoring.comp.MyResourceConsumptionRecorder;
import org.resourceaccounting.ResourceConsumptionRecorderMBean;
import org.resourceaccounting.ResourcePrincipal;
import org.resourceaccounting.contract.ComponentResourceContract;
import org.resourceaccounting.contract.ResourceContract;

import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 6/30/13
 * Time: 10:00 PM
 *
 */
public abstract class AbstractLocalMonitoringStrategy extends AbstractMonitoringStrategy {
    protected final List<ComponentInstance> ranking;
    protected ComponentInstance currentComponent;

    public AbstractLocalMonitoringStrategy(List<ComponentInstance> ranking, Object msg) {
        super(msg);
        this.ranking = ranking;

    }

    protected DataForCheckingContract getInfo(ResourcePrincipal principal) {
        ResourceConsumptionRecorderMBean recorder = MyResourceConsumptionRecorder.getInstance();
        long lastCPU = recorder.getExecutedInstruction(principal);
        long lastSent = recorder.getBytesSent(principal);
        long lastReceived = recorder.getBytesReceived(principal);
        DataForCheckingContract r = new DataForCheckingContract(lastCPU, lastSent, lastReceived);
        return r;
    }

    protected ResourcePrincipal getPrincipal(ComponentInstance instance) {
        ResourceConsumptionRecorderMBean recorder = MyResourceConsumptionRecorder.getInstance();
        Object obj =KevoreeDeployManager.instance$.getRef(instance.getClass().getName() + "_tg", instance.getName());
        ThreadGroup tg = (ThreadGroup) obj;
        ResourcePrincipal p = recorder.getApplication(tg.getName());
        if (p == null) {
            System.err.println("No resource principal was found");
            System.exit(2);
        }
        return p;
//        for (String key : KevoreeDeployManager.instance$.getInternalMap().keySet()) {
//            if (key.contains("_tg")) {  //TODO far better ....
//
//                String threadGroupKevoreeInstancePath = tg.getName().substring(tg.getName().indexOf("/") + 1);
//                if (currentComponent.path().equals(threadGroupKevoreeInstancePath)) {
//                    // Found
//
//
//                }
//            }
//        }
//        System.err.println("No resource principal was found");
//        System.exit(2);
//        return null;
    }

    protected void makeContractAvailable(ResourcePrincipal principal, ComponentInstance instance) {
        if (principal.getContract() == null) {
            Object obj =KevoreeDeployManager.instance$.getRef(instance.getClass().getName() + "_contract", instance.getName());
            if (obj != null && obj instanceof ResourceContract) {
                ResourceContract contract = (ResourceContract)obj;
                principal.setContract(contract);
            }
            else principal.setContract(new ComponentResourceContract(){});
        }
    }
}
