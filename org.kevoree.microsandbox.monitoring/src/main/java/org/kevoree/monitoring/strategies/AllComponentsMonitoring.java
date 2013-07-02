package org.kevoree.monitoring.strategies;

import org.kevoree.ComponentInstance;
import org.kevoree.monitoring.sla.FaultyComponent;
import org.kevoree.monitoring.sla.Metric;
import org.resourceaccounting.ResourcePrincipal;
import org.resourceaccounting.contract.ResourceContract;

import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 6/30/13
 * Time: 10:04 PM
 *
 */
public class AllComponentsMonitoring extends AbstractLocalMonitoringStrategy {

    int count = 0;

    EnumSet<Metric> a;



    public AllComponentsMonitoring(List<ComponentInstance> ranking, Object msg) {
        super(ranking, msg);
    }

    @Override
    public void init(int startTime) {
        super.init(startTime);
        count = 0;
    }

    @Override
    public void verifyContract(ResourcePrincipal principal, Object obj) {
        DataForCheckingContract data = (DataForCheckingContract)obj;
        ResourceContract contract = principal.getContract();
        EnumSet<Metric> tmp = EnumSet.noneOf(Metric.class);
        if (contract.getCPU() < data.lastCPU) {
//            System.out.printf("%s consumes %d CPU vs. %d\n",
//                    currentComponent.getName(),
//                    data.lastCPU,
//                    contract.getCPU()
//            );
            tmp.add(Metric.CPU);
        }

        if (contract.getNetworkOut() < data.lastSent) {
//            System.out.printf("%s consumes %d Sent\n",
//                    currentComponent.getName(),
//                    data.lastSent
//            );
            tmp.add(Metric.NetworkS);
        }

        if (contract.getNetworkIn() < data.lastReceived) {
//            System.out.printf("%s consumes %d Received\n",
//                    currentComponent.getName(),
//                    data.lastReceived
//            );
            tmp.add(Metric.NetworkR);
        }

        if (contract.getMemory() < data.lastMem) {
            tmp.add(Metric.Memory);
        }

        if (count == 2 && !tmp.isEmpty()) {
            a.addAll(tmp);
            faultyComponents.add(new FaultyComponent(currentComponent.path(),tmp));
        }

    }

    @Override
    public void onGCVerifyContract(long used, long max) { }

    @Override
    public void run() {
        count++;
        if (count == 2) {
            a = EnumSet.noneOf(Metric.class);
        }
        Iterator<ComponentInstance> it = ranking.iterator();
        while (it.hasNext()) {
            currentComponent = it.next();
            ResourcePrincipal principal = getPrincipal(currentComponent);
            makeContractAvailable(principal, currentComponent);
            DataForCheckingContract data = getInfo(principal);
            verifyContract(principal, data);
        }
        if (count == 2) {
            // if someone is violating the contract then trigger adaptation
            if (!a.isEmpty())
                actionOnContractViolation(a);
            else {
                // pass to Global Monitoring
                passWithoutViolation();
            }
        }
    }

}
