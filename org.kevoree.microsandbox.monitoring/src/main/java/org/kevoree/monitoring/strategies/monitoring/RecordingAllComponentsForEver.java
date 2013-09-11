package org.kevoree.monitoring.strategies.monitoring;

import org.kevoree.ComponentInstance;
import org.kevoree.Port;
import org.kevoree.microsandbox.api.sla.Metric;
import org.kevoree.monitoring.comp.MyLowLevelResourceConsumptionRecorder;
import org.kevoree.monitoring.comp.monitor.InfoForContractCreation;
import org.kevoree.monitoring.comp.monitor.NewMetricReporter;
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
public class RecordingAllComponentsForEver extends FineGrainedMonitoringStrategy {
    private final NewMetricReporter reporter;
    private int count = 0;
    private Object lock = new Object();
    private RankChecker rankChecker;


    private HashMap<String, InfoForContractCreation> infos = new HashMap<String, InfoForContractCreation>();


    public RecordingAllComponentsForEver(List<ComponentInstance> ranking, Object msg, RankChecker rankChecker,
                                         NewMetricReporter reporter) {
        super(null, ranking, msg);
        this.rankChecker =rankChecker;
        this.reporter = reporter;
    }

    @Override
    public void verifyContract(ResourcePrincipal principal, Object obj) {
        DataForCheckingContract data = (DataForCheckingContract)obj;

        data.lastCPU /= ELAPSED_SECONDS;
        data.lastRead /= ELAPSED_SECONDS;
        data.lastWrite /= ELAPSED_SECONDS;
        data.lastReceived /= ELAPSED_SECONDS;
        data.lastSent /= ELAPSED_SECONDS;

        boolean flag = false;
        synchronized (lock) {
            String key = principal.toString();
            InfoForContractCreation info = infos.containsKey(key)?
                    infos.get(key) :
                    infos.put(key, new InfoForContractCreation()); // what a crazy behavior the one of this method (side effects and return value)

            info = infos.get(key);
            info.path = key;

            if (info.maxCPU < data.lastCPU) {
                info.maxCPU = data.lastCPU;
                flag = true;
            }

            if (info.maxSent < data.lastSent) {
                info.maxSent = data.lastSent;
                flag = true;
            }

            if (info.maxReceived < data.lastReceived) {
                info.maxReceived = data.lastReceived;
                flag = true;
            }

            if (info.maxWritten < data.lastWrite) {
                info.maxWritten = data.lastWrite;
                flag = true;
            }

            if (info.maxRead < data.lastRead) {
                info.maxRead = data.lastRead;
                flag = true;
            }

            int total = 0;
            String nameComponent = currentComponent.getName();
            for (Port port : currentComponent.getProvided()) {
                String name = port.getPortTypeRef().getName();
                int usage = MyLowLevelResourceConsumptionRecorder.getInstance().getUsesOfProvidedPort(nameComponent, name)
                        / count;

//                System.out.println("++++++++++++++++++++++++++++++++++" + usage + "+++++++++++++++++++++++++++++");

                boolean b = info.updatePortUsage(name, usage);
                flag = flag || b;
//                System.out.printf("\tPort usage for %s is %d\n", name, usage);
                total += usage;
            }
            if (total > info.allPortCalls) {
                info.allPortCalls = total;
                flag = true;
            }

            if (flag) {
                reporter.report(key, info);
//                System.out.printf("Component %s is consuming CPU: %d, MEM: %d, S: %d, R: %d, W: %d, Re: %d\n",
//                        principal.toString(), info.maxCPU, info.maxReserved,
//                        info.maxSent, info.maxReceived, info.maxWritten, info.maxRead);

            }
        }



    }

    @Override
    public void onGCVerifyContract(long used, long max) {
        for (ComponentInstance component : ranking) {
            ResourcePrincipal principal = getPrincipal(component);
            if (principal == null)
                continue;
            DataForCheckingContract data = getInfo(principal);
            boolean flag = false;
            synchronized (lock) {
                String key = principal.toString();
                InfoForContractCreation info = (infos.containsKey(key))?
                        infos.get(key) :
                        infos.put(key, new InfoForContractCreation());
                info = infos.get(key);
                info.path = key;

                if (info.maxReserved < data.lastMem) {
                    info.maxReserved = data.lastMem;
                    reporter.report(key, info);
                    flag = true;
                }
                if (flag) {
//                    System.out.printf("Component %s is consuming CPU: %d, MEM: %d, S: %d, R: %d, W: %d, Re: %d\n",
//                            principal.toString(), info.maxCPU, info.maxReserved,
//                            info.maxSent, info.maxReceived, info.maxWritten, info.maxRead);
                }
            }
        }
    }

    @Override
    public void run() {
        count++;
        if (count >= 2) {
            checkRanking();
            Iterator<ComponentInstance> it = ranking.iterator();
            while (it.hasNext()) {
                currentComponent = it.next();
//                System.out.println(currentComponent.path());
                ResourcePrincipal principal = getPrincipal(currentComponent);
                if (principal == null)
                    continue;
                DataForCheckingContract data = getInfo(principal);
                verifyContract(principal, data);
            }
        }
    }

    private void checkRanking() {
        if (ranking.size() == 0) {
            ranking = rankChecker.getRanking();
        }
    }
}
