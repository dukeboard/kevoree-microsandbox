package org.kevoree.monitoring.strategies;

import org.kevoree.monitoring.comp.MyResourceConsumptionRecorder;
import org.resourceaccounting.ResourceConsumptionRecorderMBean;
import org.resourceaccounting.ResourcePrincipal;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 6/23/13
 * Time: 11:24 AM
 *
 */
public class GlobalMonitoring extends AbstractMonitoringStrategy {

    private final ThreadMXBean tmxb = ManagementFactory.getThreadMXBean();

    private final int nCPUs = Runtime.getRuntime().availableProcessors();

    public GlobalMonitoring(Object msg) {
        super(msg);
    }

    @Override
    public void verifyContract(ResourcePrincipal principal, Object obj) {
        // null implementation because in global monitoring
        // the resource principals are not checked
    }

    @Override
    public void onGCVerifyContract(long used, long max) {
        double usage = (double)used/max*100F;
        System.out.printf("GC, current consumption %f\n", usage);
        if (usage > 60) {
            // threshold has been surpassed, try to identify why
            actionOnContractViolation();
        }
    }

    @Override
    public void run() {
        long[] threadIDs = tmxb.getAllThreadIds();
        double sum = 0;
        for (int i = 0; i < threadIDs.length; i++) {
            long threadId = threadIDs[i];
            if (threadId != -1) {
                sum += tmxb.getThreadCpuTime(threadId) / 1000000F;
            }
        }

        double diff = sum - previousCPU;
        previousCPU = sum;
        double cpuUsage = Math.min(99, diff/(elapsedTime*nCPUs)*100);

        ResourceConsumptionRecorderMBean ins = MyResourceConsumptionRecorder.getInstance();
        long sent = ins.getTotalSent() - previousSent;
        long received = ins.getTotalReceived() - previousReceived;
        previousSent = ins.getTotalSent();
        previousReceived = ins.getTotalReceived();

        System.out.printf("%%CPU : %f , Sent : %f KiB/S, Received %f KiB/S\n",
                cpuUsage,
                sent / 1024F,
                received / 1024F);


        if (cpuUsage > 70 && cpuUsage < 99) {
            actionOnContractViolation();
        }
    }
}
