package org.kevoree.monitoring.strategies;

import org.kevoree.ComponentInstance;
import org.kevoree.library.defaultNodeTypes.context.KevoreeDeployManager;
import org.kevoree.monitoring.comp.MyResourceConsumptionRecorder;
import org.resourceaccounting.ResourceConsumptionRecorderMBean;
import org.resourceaccounting.ResourcePrincipal;
import org.resourceaccounting.contract.ResourceContract;

import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 6/28/13
 * Time: 6:08 PM
 *
 */
public class LocalMonitoring extends AbstractMonitoringStrategy {

    private final Iterator<ComponentInstance> ranking;
    private ComponentInstance currentComponent;

    private int counter;

    public LocalMonitoring(Iterator<ComponentInstance> ranking, Object msg) {
        super(msg);
        this.ranking = ranking;
    }

    @Override
    public void init() {
        super.init();
        currentComponent = ranking.next();
        counter = 0;
    }

    @Override
    public void verifyContract(ResourcePrincipal principal, Object obj) {
    }

    private void checkContract(ResourcePrincipal principal, DataForCheckingContract data) {
        long cpu = principal.getExecutedInstructions() - data.lastCPU;
        long sent = principal.getExecutedInstructions() - data.lastSent;
        long received = principal.getExecutedInstructions() - data.lastReceived;
        checkContract(principal, cpu, sent, received);
    }

    private void checkContract(ResourcePrincipal principal, long cpu, long sent, long received) {
        ResourceContract contract = principal.getContract();
        if (contract == null) return;
        if (contract.getCPU() < cpu) {

        }

        if (contract.getNetworkOut() < sent) {

        }

        if (contract.getNetworkIn() < received) {

        }
    }

    @Override
    public void onGCVerifyContract(long used, long max) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void run() {
        if (ranking.hasNext()) {
            ResourcePrincipal principal = getPrincipal();
            counter++;
            if ((counter & 1) == 0) {
                checkContract(principal, getInfo(principal));
                currentComponent = ranking.next();
            }
        }
        else {
            pause();
        }
    }


    private DataForCheckingContract getInfo(ResourcePrincipal principal) {
        ResourceConsumptionRecorderMBean recorder = MyResourceConsumptionRecorder.getInstance();
        long lastCPU = recorder.getExecutedInstruction(principal);
        long lastSent = recorder.getBytesSent(principal);
        long lastReceived = recorder.getBytesReceived(principal);
        DataForCheckingContract r = new DataForCheckingContract(lastCPU, lastSent, lastReceived);
        return r;
    }

    private ResourcePrincipal getPrincipal() {
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
                    return recorder.getApplication(tg.getName());
                }
            }
        }
        return null;
    }
}
