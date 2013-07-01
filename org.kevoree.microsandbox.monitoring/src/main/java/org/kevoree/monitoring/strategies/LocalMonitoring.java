package org.kevoree.monitoring.strategies;

import org.kevoree.ComponentInstance;
import org.resourceaccounting.ResourcePrincipal;
import org.resourceaccounting.contract.ResourceContract;

import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 6/28/13
 * Time: 6:08 PM
 *
 */
public class LocalMonitoring extends AbstractLocalMonitoringStrategy {

    private int counter;

    public LocalMonitoring(List<ComponentInstance> ranking, Object msg) {
        super(ranking,msg);
    }

    @Override
    public void init(int startTime) {
        super.init(startTime);
        counter = 0;
    }

    @Override
    public void verifyContract(ResourcePrincipal principal, Object obj) {
    }

    private void checkContract(ResourcePrincipal principal, DataForCheckingContract data) {
//        long cpu = principal.getExecutedInstructions() - data.lastCPU;
//        long sent = principal.getExecutedInstructions() - data.lastSent;
//        long received = principal.getExecutedInstructions() - data.lastReceived;
//        checkContract(principal, cpu, sent, received);
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

    }

    @Override
    public void run() {
        Iterator<ComponentInstance> it = ranking.iterator();
        if (it.hasNext()) {
            if ((counter & 1) == 0)
                currentComponent = it.next();
            ResourcePrincipal principal = getPrincipal(currentComponent);
            counter++;
            if ((counter & 1) == 0) {
                checkContract(principal, getInfo(principal));
            }
        }
        else {
            pause();
        }
    }



}
