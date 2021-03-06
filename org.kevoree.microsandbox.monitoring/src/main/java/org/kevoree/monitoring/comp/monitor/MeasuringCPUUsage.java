package org.kevoree.monitoring.comp.monitor;

import org.kevoree.annotation.*;
import org.kevoree.framework.AbstractComponentType;
import org.kevoree.framework.MessagePort;
import org.resourceaccounting.ResourcePrincipal;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 9/5/13
 * Time: 2:22 PM
 * To change this template use File | Settings | File Templates.
 */
@Requires({
        @RequiredPort(name = "maximumCPU", optional = true, type = PortType.MESSAGE, needCheckDependency = true),
        @RequiredPort(name = "maximumMem", optional = true, type = PortType.MESSAGE, needCheckDependency = true)
})
@DictionaryType({
        @DictionaryAttribute(name = "accountGlobalConsumption", defaultValue = "0", dataType = Long.class)
})
@ComponentType
public class MeasuringCPUUsage extends AbstractComponentType {

    private final static int nCPUs = Runtime.getRuntime().availableProcessors();
    public static final double ELAPSED_TIME = 1000; // 1 second

    private final ThreadMXBean tmxb = ManagementFactory.getThreadMXBean();
    double cpuUsageCumulative = 0;
    int time = 0;

    double maximumCPUUsage = 0;

    int count = 0;

    GCWatcher gcWatcher = new GCWatcher();
    Timer t = new Timer();
    private double maximumMem;

    private Map<Long, Long> cpuTimes = new HashMap<Long, Long>(50);

    class Measuring extends TimerTask implements ContractVerificationRequired {

        @Override
        public void run() {
            long[] threadIDs = tmxb.getAllThreadIds();
            double diff = 0;
            for (int i = 0; i < threadIDs.length; i++) {
                long threadId = threadIDs[i];
                if (threadId != -1) {
                    long tmp = tmxb.getThreadCpuTime(threadId);
                    long l = tmp;
                    if (cpuTimes.containsKey(threadId)) {
                        l = l - cpuTimes.get(threadId);
                    }
                    cpuTimes.put(threadId, tmp);
                    diff += l / 1000000F;
                }
            }

//            System.out.println(diff);
            boolean firstTime = count == 0;
//            double diff = sum - previousCPU; // FIXME : this has a problem because the set of active threads may differs between
            // calls. For now I can put the minimum to 0
            if (diff < 0) diff = 0;
            double cpuUsage = Math.min(99, diff/(ELAPSED_TIME*nCPUs)*100);

            time ++;
            cpuUsageCumulative += diff;

            // avoid to check when the previous measurement doesn't exist because its use may imply erroneous estimation
            if (!firstTime) {
//                System.out.printf("Last %f , total %f\n", cpuUsage, cpuUsageCumulative/(100*time)*100);
            }

            // skip initial values because the overhead is due deployment
            if (count > 5) {
                if (cpuUsage > maximumCPUUsage)  {
                    maximumCPUUsage = cpuUsage;
                    MessagePort p = getPortByName("maximumCPU",MessagePort.class);
                    p.process(maximumCPUUsage);
                }
            }
            count++;
        }

        @Override
        public void verifyContract(ResourcePrincipal principal, Object obj) {
        }

        @Override
        public void onGCVerifyContract(long used, long max) {
            double u = used;
            u /= max;
            u *= 100;
            if (u > maximumMem) {
                maximumMem = u;
                MessagePort p = getPortByName("maximumMem",MessagePort.class);
                p.process(maximumMem);
            }
        }
    }


    @Start
    public void start() {
        long timetoWait = Long.parseLong(getDictionary().get("accountGlobalConsumption").toString());
        if (timetoWait != 0) {
            final Timer tt = new Timer();
            tt.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.printf("Total CPU usage : %f %f %f %f\n",
                            cpuUsageCumulative, ELAPSED_TIME*time, ELAPSED_TIME*time*nCPUs,
                            cpuUsageCumulative/(ELAPSED_TIME*time*nCPUs)*100);
                    tt.cancel();
                    tt.purge();
                    t.cancel();
                    t.purge();
                    System.exit(0);
                }
            }, timetoWait);
        }
        gcWatcher.register();
        Measuring m = new Measuring();
        gcWatcher.addContractVerificationRequieredListener(m);
        t.schedule(m,(long)ELAPSED_TIME,(long)ELAPSED_TIME);
    }

    @Stop
    public void stop() {
        t.cancel();
        t.purge();
        gcWatcher.unregister();
    }

    @Update
    public void update() {
        stop();
        start();
    }
}
