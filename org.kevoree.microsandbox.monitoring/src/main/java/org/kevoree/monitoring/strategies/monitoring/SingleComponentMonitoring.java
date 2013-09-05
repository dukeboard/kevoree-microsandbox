package org.kevoree.monitoring.strategies.monitoring;

import org.kevoree.ComponentInstance;
import org.kevoree.microsandbox.api.sla.Metric;
import org.kevoree.monitoring.comp.MyLowLevelResourceConsumptionRecorder;
import org.kevoree.monitoring.sla.FaultyComponent;
import org.kevoree.monitoring.sla.MeasurePoint;
import org.resourceaccounting.ResourcePrincipal;
import org.resourceaccounting.contract.ResourceContract;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 6/28/13
 * Time: 6:08 PM
 *
 */
public class SingleComponentMonitoring extends FineGrainedMonitoringStrategy {

    private int index = 0;
    EnumMap<Metric, MeasurePoint> a;
    private int counter;

    public SingleComponentMonitoring(EnumSet<Metric> reason, List<ComponentInstance> ranking, Object msg) {
        super(reason, ranking,msg);
    }

    @Override
    public void init(int startTime) {
        super.init(startTime);
        counter = 0;
    }

    @Override
    public void verifyContract(ResourcePrincipal principal, Object obj) {
        if (counter == NUMBER_OF_STEPS) {
            DataForCheckingContract data = (DataForCheckingContract)obj;
            data.lastCPU /= ELAPSED_SECONDS;
            data.lastRead /= ELAPSED_SECONDS;
            data.lastWrite /= ELAPSED_SECONDS;
            data.lastReceived /= ELAPSED_SECONDS;
            data.lastSent /= ELAPSED_SECONDS;

            ResourceContract contract = principal.getContract();
            if (reason.contains(Metric.CPU) && contract.getCPU() > 0 && contract.getCPU() < data.lastCPU)
                a.put(Metric.CPU,  new MeasurePoint(data.lastCPU, contract.getCPU()));

            if (reason.contains(Metric.NetworkS) && contract.getNetworkOut() < data.lastSent)
                a.put(Metric.NetworkS, new MeasurePoint(data.lastSent, contract.getNetworkOut()));

            if (reason.contains(Metric.NetworkR) && contract.getNetworkIn() < data.lastReceived) {
                a.put(Metric.NetworkR, new MeasurePoint(data.lastReceived, contract.getNetworkIn()));
            }

            // TODO : I am wondering if this is OK? Shouldn't I do this inside onGCVerifyContract?
            if (reason.contains(Metric.Memory) && contract.getMemory() > 0 && contract.getMemory() < data.lastMem) {
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
    public void onGCVerifyContract(long used, long max) {

    }

    @Override
    public void run() {
        counter++;
        if (counter == NUMBER_OF_STEPS) {
            currentComponent = ranking.get(index);
            String appId = getAppId(currentComponent);
            // stop monitoring the previous one
            MyLowLevelResourceConsumptionRecorder.getInstance().turnFilteredPrincipalMonitoring(false, null);
            // start monitoring the new one
            MyLowLevelResourceConsumptionRecorder.getInstance().turnFilteredPrincipalMonitoring(true, appId);

            a = new EnumMap<Metric, MeasurePoint>(Metric.class);
            ResourcePrincipal principal = getPrincipal(currentComponent);
            makeContractAvailable(principal, currentComponent);
            DataForCheckingContract data = getInfo(principal);
            verifyContract(principal, data);
            // go to the next component
            counter = 1;
            index++;
            currentComponent = null;
            if (index == ranking.size() || faultyComponents.size() > 0) {
                // leave as soon as we find a faulty components
                // cleanup
                // stop monitoring the components
                MyLowLevelResourceConsumptionRecorder.getInstance().turnFilteredPrincipalMonitoring(false, null);
                // if someone is violating the contract then trigger adaptation
                if (faultyComponents.size() > 0) {
                    EnumSet<Metric> tmp = EnumSet.noneOf(Metric.class);
                    actionOnContractViolation(new Metric[0]);
                }
                else {
                    // pass to Global Monitoring
                    passWithoutViolation();
                }
            }
        }
    }



}
