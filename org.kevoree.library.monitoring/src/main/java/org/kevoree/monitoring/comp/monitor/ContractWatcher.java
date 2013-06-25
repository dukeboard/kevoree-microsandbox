package org.kevoree.monitoring.comp.monitor;

import org.resourceaccounting.ResourcePrincipal;
import org.resourceaccounting.contract.ResourceContract;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 6/11/13
 * Time: 5:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class ContractWatcher {
    public void checkContract(ResourcePrincipal principal, long cpu, long sent, long received) {
        ResourceContract contract = principal.getContract();
        if (contract == null) return;
        if (contract.getCPU() < cpu) {

        }

        if (contract.getNetworkOut() < sent) {

        }

        if (contract.getNetworkIn() < received) {

        }
    }

    public void checkContract(ResourcePrincipal principal, DataForCheckingContract data) {
        long cpu = principal.getExecutedInstructions() - data.lastCPU;
        long sent = principal.getExecutedInstructions() - data.lastSent;
        long received = principal.getExecutedInstructions() - data.lastReceived;
        checkContract(principal, cpu, sent, received);
    }
}
