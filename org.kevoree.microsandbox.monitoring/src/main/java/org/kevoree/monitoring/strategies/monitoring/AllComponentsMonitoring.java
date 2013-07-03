package org.kevoree.monitoring.strategies.monitoring;

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

    public static final int NUMBER_OF_STEPS = 3;
    int count = 0;

    EnumSet<Metric> a;



    public AllComponentsMonitoring(List<ComponentInstance> ranking, Object msg) {
        super(ranking, msg);
        System.out.println("Local monitor constructor called");
    }

    @Override
    public void init(int startTime) {
        super.init(startTime);
        count = 0;
        System.out.println("Local monitor init called");
    }

    @Override
    public void verifyContract(ResourcePrincipal principal, Object obj) {
        DataForCheckingContract data = (DataForCheckingContract)obj;
        ResourceContract contract = principal.getContract();
        EnumSet<Metric> tmp = EnumSet.noneOf(Metric.class);
        if (contract.getCPU() < data.lastCPU) {
            tmp.add(Metric.CPU);
        }

        if (contract.getNetworkOut() < data.lastSent) {
            tmp.add(Metric.NetworkS);
        }

        if (contract.getNetworkIn() < data.lastReceived) {
            tmp.add(Metric.NetworkR);
        }

        if (contract.getMemory() < data.lastMem) {
            tmp.add(Metric.Memory);
        }

        if (count == NUMBER_OF_STEPS && !tmp.isEmpty()) {
            a.addAll(tmp);
            faultyComponents.add(new FaultyComponent(currentComponent.path(),tmp));
        }

    }

    @Override
    public void onGCVerifyContract(long used, long max) { }

    @Override
    public void run() {
        System.out.println("Local monitor run called");
        count++;
        if (count == NUMBER_OF_STEPS) {
            a = EnumSet.noneOf(Metric.class);
            Iterator<ComponentInstance> it = ranking.iterator();
            while (it.hasNext()) {
                currentComponent = it.next();
                ResourcePrincipal principal = getPrincipal(currentComponent);
                makeContractAvailable(principal, currentComponent);
                DataForCheckingContract data = getInfo(principal);
                verifyContract(principal, data);
                System.out.printf("\t\tThe consumption for %s is %d\n",
                        currentComponent.getName(),
                        data.lastMem);
            }
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
