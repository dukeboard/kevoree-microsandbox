package org.kevoree.monitoring.strategies.monitoring;

import org.kevoree.ComponentInstance;
import org.kevoree.microsandbox.api.sla.Metric;
import org.kevoree.monitoring.sla.FaultyComponent;
import org.kevoree.monitoring.sla.MeasurePoint;
import org.resourceaccounting.ResourcePrincipal;
import org.resourceaccounting.contract.ResourceContract;

import java.util.*;

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

    EnumMap<Metric, MeasurePoint> a;

    public AllComponentsMonitoring(EnumSet<Metric> reason, List<ComponentInstance> ranking, Object msg) {
        super(reason, ranking, msg);
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
            if (reason.contains(Metric.CPU) && contract.getCPU() < data.lastCPU)
                a.put(Metric.CPU,  new MeasurePoint(data.lastCPU, contract.getCPU()));

            if (reason.contains(Metric.NetworkS) && contract.getNetworkOut() < data.lastSent)
                a.put(Metric.NetworkS, new MeasurePoint(data.lastSent, contract.getNetworkOut()));

            if (reason.contains(Metric.NetworkR) && contract.getNetworkIn() < data.lastReceived) {
                a.put(Metric.NetworkR, new MeasurePoint(data.lastReceived, contract.getNetworkIn()));
            }

            if (reason.contains(Metric.Memory) && contract.getMemory() < data.lastMem) {
                a.put(Metric.Memory, new MeasurePoint(data.lastMem, contract.getMemory()));
            }

            if (reason.contains(Metric.IOWrite) && contract.getWrite() < data.lastWrite) {
                a.put(Metric.IOWrite, new MeasurePoint(data.lastWrite, contract.getWrite()));
            }

            if (reason.contains(Metric.IORead) && contract.getRead() < data.lastRead) {
                a.put(Metric.IORead, new MeasurePoint(data.lastRead, contract.getRead()));
            }

            if (!a.isEmpty())
                faultyComponents.add(new FaultyComponent(currentComponent.path(),a,
                        new HashSet<String>(), new HashSet<String>()));
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
                a = new EnumMap<Metric, MeasurePoint>(Metric.class);
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
