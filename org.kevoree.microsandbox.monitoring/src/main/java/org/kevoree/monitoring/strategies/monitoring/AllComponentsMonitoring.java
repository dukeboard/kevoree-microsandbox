package org.kevoree.monitoring.strategies.monitoring;

import kotlin.Pair;
import org.kevoree.ComponentInstance;
import org.kevoree.log.Log;
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
public class AllComponentsMonitoring<T extends MemorySubstrategy>
        extends FineGrainedMonitoringStrategy<T> {

    int count = 0;

    EnumMap<Metric, MeasurePoint> a;

    public AllComponentsMonitoring(EnumSet<Metric> reason,
                                   List<ComponentInstance> ranking,
                                   T memorySubstrategy,
                                   Object msg) {
        super(reason, ranking, msg);
        this.memorySubstrategy = memorySubstrategy;
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
            data.lastCPU /= ELAPSED_SECONDS;
            data.lastRead /= ELAPSED_SECONDS;
            data.lastWrite /= ELAPSED_SECONDS;
            data.lastReceived /= ELAPSED_SECONDS;
            data.lastSent /= ELAPSED_SECONDS;
            Pair<ResourcePrincipal, DataForCheckingContract> pair = new Pair(principal, data);

            ResourceContract contract = principal.getContract();
            if (reason.contains(Metric.CPU) && contract.getCPU() > 0 && contract.getCPU() < data.lastCPU) {
                a.put(Metric.CPU,  new MeasurePoint(data.lastCPU, contract.getCPU()));
            }

            if (reason.contains(Metric.NetworkS) && contract.getNetworkOut() > 0
                    && contract.getNetworkOut() < data.lastSent) {
                a.put(Metric.NetworkS, new MeasurePoint(data.lastSent, contract.getNetworkOut()));
            }

            if (reason.contains(Metric.NetworkR) &&
                    contract.getNetworkIn() > 0 && contract.getNetworkIn() < data.lastReceived) {
                a.put(Metric.NetworkR, new MeasurePoint(data.lastReceived, contract.getNetworkIn()));
            }

            // TODO : I am wondering if this is OK? Shouldn't I do this inside onGCVerifyContract?
            if (reason.contains(Metric.Memory) && isWorthyContractForMemory(contract)) {
                long tmp = memorySubstrategy.getMemoryConsumption(pair);
                if (contract.getMemory() < tmp) {
                    a.put(Metric.Memory, new MeasurePoint(tmp, contract.getMemory()));
                }
            }

            if (reason.contains(Metric.IOWrite) && contract.getWrite() < data.lastWrite) {
                a.put(Metric.IOWrite, new MeasurePoint(data.lastWrite, contract.getWrite()));
            }

            if (reason.contains(Metric.IORead) && contract.getRead() < data.lastRead) {
                a.put(Metric.IORead, new MeasurePoint(data.lastRead, contract.getRead()));
            }

            if (!a.isEmpty()) {
                faultyComponents.add(new FaultyComponent(currentComponent.path(),a,
                        new HashSet<String>(), new HashSet<String>()));
            }
        }

    }

    @Override
    public void onGCVerifyContract(long used, long max) {
    }

    @Override
    public void run() {
        count++;
//        checkRanking();
        if (count == NUMBER_OF_STEPS) {
            Iterator<ComponentInstance> it = ranking.iterator();
            while (it.hasNext()) {
                currentComponent = it.next();
                a = new EnumMap<Metric, MeasurePoint>(Metric.class);
                ResourcePrincipal principal = getPrincipal(currentComponent);
                if (principal == null)
                    continue;
                makeContractAvailable(principal, currentComponent);
                DataForCheckingContract data = getInfo(principal);
                verifyContract(principal, data);
            }
            // if someone is violating the contract then trigger adaptation
            if (faultyComponents.size() > 0) {
//                EnumSet<Metric> tmp = EnumSet.noneOf(Metric.class);
                actionOnContractViolation(new Metric[0]);
            }
            else {
                // pass to Global Monitoring
                passWithoutViolation();
            }
        }
        
    }

//    private synchronized void checkRanking() {
//        if (ranking.size() == 0) {
//            ranking = rankChecker.getRanking();
//        }
//    }

}
