package org.kevoree.monitoring.strategies.monitoring;

import org.kevoree.ComponentInstance;
import org.kevoree.microsandbox.api.sla.Metric;
import org.kevoree.monitoring.sla.FaultyComponent;
import org.resourceaccounting.ResourcePrincipal;
import org.resourceaccounting.contract.ResourceContract;

import java.util.EnumMap;
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

    EnumMap<Metric, Double> a;

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
        if (count == NUMBER_OF_STEPS) {
            DataForCheckingContract data = (DataForCheckingContract)obj;
            ResourceContract contract = principal.getContract();
            if (contract.getCPU() < data.lastCPU)
                a.put(Metric.CPU, (double) data.lastCPU);

            if (contract.getNetworkOut() < data.lastSent)
                a.put(Metric.NetworkS, (double) data.lastSent);

            if (contract.getNetworkIn() < data.lastReceived) {
                a.put(Metric.NetworkR, (double) data.lastReceived);
            }

            if (contract.getMemory() < data.lastMem) {
                a.put(Metric.Memory, (double)data.lastMem);
            }

            if (contract.getWrite() < data.lastWrite) {
                a.put(Metric.IOWrite, (double)data.lastWrite);
            }

            if (contract.getRead() < data.lastRead) {
                a.put(Metric.IORead, (double)data.lastRead);
            }

            if (!a.isEmpty())
                faultyComponents.add(new FaultyComponent(currentComponent.path(),a));
        }

    }

    @Override
    public void onGCVerifyContract(long used, long max) { }

    @Override
    public void run() {
        count++;
        if (count == NUMBER_OF_STEPS) {

            Iterator<ComponentInstance> it = ranking.iterator();
            while (it.hasNext()) {
                a = new EnumMap<Metric, Double>(Metric.class);
                currentComponent = it.next();
                ResourcePrincipal principal = getPrincipal(currentComponent);
                makeContractAvailable(principal, currentComponent);
                DataForCheckingContract data = getInfo(principal);
                verifyContract(principal, data);
            }
            // if someone is violating the contract then trigger adaptation
            if (faultyComponents.size() > 0) {
                EnumSet<Metric> tmp = EnumSet.allOf(Metric.class);
                actionOnContractViolation(tmp);
            }
            else {
                // pass to Global Monitoring
                passWithoutViolation();
            }
        }
    }

}
