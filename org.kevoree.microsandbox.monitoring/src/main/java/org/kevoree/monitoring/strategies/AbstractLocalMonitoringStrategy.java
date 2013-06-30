package org.kevoree.monitoring.strategies;

import org.kevoree.ComponentInstance;
import org.kevoree.library.defaultNodeTypes.context.KevoreeDeployManager;
import org.kevoree.monitoring.comp.MyResourceConsumptionRecorder;
import org.resourceaccounting.ResourceConsumptionRecorderMBean;
import org.resourceaccounting.ResourcePrincipal;

import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 6/30/13
 * Time: 10:00 PM
 *
 */
public abstract class AbstractLocalMonitoringStrategy extends AbstractMonitoringStrategy {
    protected final Iterator<ComponentInstance> ranking;
    protected ComponentInstance currentComponent;

    public AbstractLocalMonitoringStrategy(Iterator<ComponentInstance> ranking, Object msg) {
        super(msg);
        this.ranking = ranking;

    }

    @Override
    public void init() {
        super.init();
    }

    protected DataForCheckingContract getInfo(ResourcePrincipal principal) {
        ResourceConsumptionRecorderMBean recorder = MyResourceConsumptionRecorder.getInstance();
        long lastCPU = recorder.getExecutedInstruction(principal);
        long lastSent = recorder.getBytesSent(principal);
        long lastReceived = recorder.getBytesReceived(principal);
        DataForCheckingContract r = new DataForCheckingContract(lastCPU, lastSent, lastReceived);
        return r;
    }

    protected ResourcePrincipal getPrincipal() {
        ResourceConsumptionRecorderMBean recorder = MyResourceConsumptionRecorder.getInstance();
        for (String key : KevoreeDeployManager.instance$.getInternalMap().keySet()) {
            if (key.contains("_tg")) {  //TODO far better ....
                ThreadGroup tg = (ThreadGroup) KevoreeDeployManager.instance$.getInternalMap().get(key);
                String threadGroupKevoreeInstancePath = tg.getName().substring(tg.getName().indexOf("/") + 1);
                if (currentComponent.path().equals(threadGroupKevoreeInstancePath)) {
                    // Found
                    ResourcePrincipal p = recorder.getApplication(tg.getName());
                    if (p == null) {
                        System.err.println("No resource principal was found");
                        System.exit(2);
                    }
                    return p;
                }
            }
        }
        System.err.println("No resource principal was found");
        System.exit(2);
        return null;
    }
}
