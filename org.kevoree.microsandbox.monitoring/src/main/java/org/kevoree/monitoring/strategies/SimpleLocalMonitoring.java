package org.kevoree.monitoring.strategies;

import org.kevoree.ComponentInstance;
import org.kevoree.DictionaryValue;
import org.kevoree.library.defaultNodeTypes.context.KevoreeDeployManager;
import org.kevoree.monitoring.comp.MyResourceConsumptionRecorder;
import org.resourceaccounting.ResourcePrincipal;
import org.resourceaccounting.contract.ComponentResourceContract;
import org.resourceaccounting.contract.ResourceContract;

import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 6/30/13
 * Time: 10:04 PM
 *
 */
public class SimpleLocalMonitoring extends AbstractLocalMonitoringStrategy {

    public SimpleLocalMonitoring(Iterator<ComponentInstance> ranking, Object msg) {
        super(ranking, msg);
    }

    @Override
    public void verifyContract(ResourcePrincipal principal, Object obj) {
        DataForCheckingContract data = (DataForCheckingContract)obj;
        ResourceContract contract = principal.getContract();
        if (contract.getCPU() < data.lastCPU) {
            System.out.printf("%s consumes %d CPU vs. %d\n",
                    currentComponent.getName(),
                    data.lastCPU,
                    contract.getCPU()
            );
        }

        if (contract.getNetworkOut() < data.lastSent) {
            System.out.printf("%s consumes %d Sent\n",
                    currentComponent.getName(),
                    data.lastSent
            );
        }

        if (contract.getNetworkIn() < data.lastReceived) {
            System.out.printf("%s consumes %d Received\n",
                    currentComponent.getName(),
                    data.lastReceived
            );
        }

    }

    @Override
    public void onGCVerifyContract(long used, long max) {
    }

    @Override
    public void run() {
        while (ranking.hasNext()) {
            currentComponent = ranking.next();
            ResourcePrincipal principal = getPrincipal();
            makeContractAvailable(principal, currentComponent);
            DataForCheckingContract data = getInfo(principal);
            verifyContract(principal, data);
        }
        System.out.println("Done with the simple local monitoring");
    }

}
