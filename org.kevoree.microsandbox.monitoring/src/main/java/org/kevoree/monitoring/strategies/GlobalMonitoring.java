package org.kevoree.monitoring.strategies;

import org.kevoree.monitoring.comp.MyResourceConsumptionRecorder;
import org.kevoree.monitoring.sla.GlobalThreshold;
import org.kevoree.monitoring.sla.Metric;
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
    private final GlobalThreshold threshold;

    public GlobalMonitoring(Object msg, GlobalThreshold threshold) {
        super(msg);
        this.threshold = threshold;
    }

    @Override
    public void verifyContract(ResourcePrincipal principal, Object obj) {
        // null implementation because in global monitoring
        // the resource principals are not checked
    }

    @Override
    public void onGCVerifyContract(long used, long max) {
        double usage = (double)used/max*100F;
        System.out.printf("GC, current consumption %f vs. %f\n", usage, threshold.getMemory_threshold());
        if (usage > threshold.getMemory_threshold()) {
            // threshold has been surpassed, try to identify why
            actionOnContractViolation(Metric.Memory);
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

        if (cpuUsage > threshold.getCpu_threshold() && cpuUsage < 99) {
            System.out.printf("%%CPU : %f , Sent : %f KiB/S, Received %f KiB/S\n",
                    cpuUsage,
                    sent / 1024F,
                    received / 1024F);
            actionOnContractViolation(Metric.CPU);
        }
    }
}
