package org.kevoree.monitoring.strategies.monitoring;

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
 * Date: 7/9/13
 * Time: 5:12 PM
 *
 */
public class AllComponentsForEver extends FineGrainedMonitoringStrategy {
    private int count = 0;
    private Object lock = new Object();
    private RankChecker rankChecker;

    public AllComponentsForEver(List<ComponentInstance> ranking, Object msg, RankChecker rankChecker) {
        super(null, ranking, msg);
        this.rankChecker =rankChecker;
    }

    @Override
    public void verifyContract(ResourcePrincipal principal, Object obj) {
        DataForCheckingContract data = (DataForCheckingContract)obj;
        ResourceContract contract = principal.getContract();

        data.lastCPU /= ELAPSED_SECONDS;
        data.lastRead /= ELAPSED_SECONDS;
        data.lastWrite /= ELAPSED_SECONDS;
        data.lastReceived /= ELAPSED_SECONDS;
        data.lastSent /= ELAPSED_SECONDS;

        EnumMap<Metric, MeasurePoint> a = new EnumMap<Metric, MeasurePoint>(Metric.class);

        if (contract.getCPU() > 0 && contract.getCPU() < data.lastCPU) {
            a.put(Metric.CPU,  new MeasurePoint(data.lastCPU, contract.getCPU()));
        }

        if (contract.getNetworkOut() > 0 &&  contract.getNetworkOut() < data.lastSent) {
            a.put(Metric.NetworkS, new MeasurePoint(data.lastSent, contract.getNetworkOut()));
        }

        if (contract.getNetworkIn() > 0 && contract.getNetworkIn() < data.lastReceived) {
            a.put(Metric.NetworkR, new MeasurePoint(data.lastReceived, contract.getNetworkIn()));
        }

        if (contract.getWrite() < data.lastWrite) {
            a.put(Metric.IOWrite, new MeasurePoint(data.lastWrite, contract.getWrite()));
        }

        if (contract.getRead() < data.lastRead) {
            a.put(Metric.IORead, new MeasurePoint(data.lastRead, contract.getRead()));
        }

        if (!a.isEmpty())
            faultyComponents.add(new FaultyComponent(currentComponent.path(),a,
                    new HashSet<String>(), new HashSet<String>()));

    }

    @Override
    public void onGCVerifyContract(long used, long max) {
        Log.debug("Executing memory consumption verification after GC Used:{}, Max:{}", used, max);
        ArrayList<FaultyComponent> faultyComponents = new ArrayList<FaultyComponent>();
        for (ComponentInstance component : ranking) {
            EnumMap<Metric, MeasurePoint> b = new EnumMap<Metric, MeasurePoint>(Metric.class);
            ResourcePrincipal principal = getPrincipal(component);
            if (principal == null)
                continue;
            DataForCheckingContract data = getInfo(principal);
            ResourceContract contract = principal.getContract();
            Log.debug("Comparing memory consumption for {}. Contract = {}, Used = {}",
                    component.getName(), contract.getMemory(), data.lastMem);

            if (contract.getMemory() > 0 && contract.getMemory() < data.lastMem) {
                b.put(Metric.Memory, new MeasurePoint(data.lastMem, contract.getMemory()));
                faultyComponents.add(new FaultyComponent(component.path(),b,
                        new HashSet<String>(), new HashSet<String>()));
            }
        }
        if (faultyComponents.size() > 0) {
//            EnumSet<Metric> tmp = EnumSet.noneOf(Metric.class);
            cancel();
            synchronized (lock) {
                this.faultyComponents = faultyComponents;
                for (FaultyComponent c :faultyComponents) {
                    System.out.println(c.getComponentPath());
                }
                actionOnContractViolation(new Metric[0]);
            }
        }
    }

    @Override
    public void run() {
        count++;
        if (count >= 2) {
            synchronized (lock) {
                faultyComponents.clear();
                checkRanking();
                Iterator<ComponentInstance> it = ranking.iterator();
                while (it.hasNext()) {
                    currentComponent = it.next();
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
            }
        }

    }

    private void checkRanking() {
        if (ranking.size() == 0) {
            ranking = rankChecker.getRanking();
        }
    }
}
