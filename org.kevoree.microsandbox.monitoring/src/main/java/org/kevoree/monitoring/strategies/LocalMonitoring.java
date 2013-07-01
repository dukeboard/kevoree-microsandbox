package org.kevoree.monitoring.strategies;

import org.kevoree.ComponentInstance;
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
public class LocalMonitoring extends AbstractLocalMonitoringStrategy {

    private int counter;

    public LocalMonitoring(Iterator<ComponentInstance> ranking, Object msg) {
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
        if (ranking.hasNext()) {
            if ((counter & 1) == 0)
                currentComponent = ranking.next();
            ResourcePrincipal principal = getPrincipal();
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
