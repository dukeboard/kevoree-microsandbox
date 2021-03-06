package org.kevoree.monitoring.strategies.monitoring;

import org.kevoree.microsandbox.api.sla.Metric;
import org.kevoree.monitoring.comp.MyLowLevelResourceConsumptionRecorder;
import org.kevoree.monitoring.sla.GlobalThreshold;
import org.resourceaccounting.LowLevelResourceMonitorProxy;
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

    private final static int nCPUs = Runtime.getRuntime().availableProcessors();
    private final GlobalThreshold threshold;

    public GlobalMonitoring(Object msg, GlobalThreshold threshold) {
        super(msg);
        this.threshold = threshold;
//        System.out.println("Well, the global monitoring is created");
    }

    @Override
    public void verifyContract(ResourcePrincipal principal, Object obj) {
        // null implementation because in global monitoring
        // the resource principals are not checked
    }

    @Override
    public void onGCVerifyContract(long used, long max) {
        double usage = (double)used/max*100F;
        System.out.printf("Ratio %f and threshold %f\n",usage, threshold.getMemory_threshold());
        if (usage > threshold.getMemory_threshold()) {
            // threshold has been surpassed, try to identify why
            actionOnContractViolation(Metric.Memory);
        }
    }

    @Override
    public void run() {
//        System.out.println("Well, the global monitoring is running");
//        System.exit(434);
        long[] threadIDs = tmxb.getAllThreadIds();
        double sum = 0;
        for (int i = 0; i < threadIDs.length; i++) {
            long threadId = threadIDs[i];
            if (threadId != -1) {
                sum += tmxb.getThreadCpuTime(threadId) / 1000000F;
            }
        }

        boolean firstTime = previousCPU == 0;
        double diff = sum - previousCPU;
        if (diff < 0) diff = 0;
        previousCPU = sum;
        double cpuUsage = Math.min(99, diff/(elapsedTime*nCPUs)*100);

        LowLevelResourceMonitorProxy ins = MyLowLevelResourceConsumptionRecorder.getInstance();
        double sent = ins.getTotalSent();
        double received = ins.getTotalReceived();
        double written = ins.getTotalWritten();
        double read = ins.getTotalRead();

        double perSent = (sent / threshold.getpDescription().availability_sent)*100;
        double perReceived = (received /  threshold.getpDescription().availability_received) * 100;

        double perWritten = (written /  threshold.getpDescription().availability_write_disc)*100;
        double perRead = (read /  threshold.getpDescription().availability_read_disc) * 100;

        // avoid to check when the previous measurement doesn't exist because its use may imply erroneous estimation
        if (!firstTime) {
            if (cpuUsage > threshold.getCpu_threshold() && cpuUsage < 99) {
                actionOnContractViolation(Metric.CPU);
            }
            else if (perSent > threshold.getNet_sent()) {
                actionOnContractViolation(Metric.NetworkS);
            }
            else if (perReceived > threshold.getNet_received_threshold()) {
                actionOnContractViolation(Metric.NetworkR);
            }
            else if (perWritten > threshold.getIo_write()) {
                actionOnContractViolation(Metric.IOWrite);
            }
            else if (perRead > threshold.getIo_read()) {
                actionOnContractViolation(Metric.IORead);
            }

        }

    }
}
