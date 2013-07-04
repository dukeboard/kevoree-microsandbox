package org.kevoree.monitoring.strategies.monitoring;

import org.kevoree.microsandbox.api.sla.Metric;
import org.kevoree.monitoring.comp.MyResourceConsumptionRecorder;
import org.kevoree.monitoring.sla.GlobalThreshold;
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

        boolean firstTime = previousCPU == 0;
        double diff = sum - previousCPU;
        previousCPU = sum;
        double cpuUsage = Math.min(99, diff/(elapsedTime*nCPUs)*100);

        ResourceConsumptionRecorderMBean ins = MyResourceConsumptionRecorder.getInstance();
        long sent = ins.getTotalSent();
        long received = ins.getTotalReceived();
        long written = ins.getTotalWritten();
        long read = ins.getTotalRead();

        double perSent = (sent / 100000.0F)*100; // let say that we can send 100000.0F per second at most
        double perReceived = (received / 100000.0F) * 100;

        double perWritten = (written / 100000.0F)*100; // let say that we can send 100000.0F per second at most
        double perRead = (read / 100000.0F) * 100;

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
