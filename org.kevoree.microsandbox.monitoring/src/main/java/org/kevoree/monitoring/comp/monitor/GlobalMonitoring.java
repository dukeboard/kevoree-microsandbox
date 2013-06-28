package org.kevoree.monitoring.comp.monitor;

import org.kevoree.monitoring.comp.MyResourceConsumptionRecorder;
import org.resourceaccounting.ResourceConsumptionRecorderMBean;
import org.resourceaccounting.ResourcePrincipal;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 6/23/13
 * Time: 11:24 AM
 *
 */
public class GlobalMonitoring extends TimerTask implements MonitoringStrategy {
    private final Object msg;
    private Timer timerForCPU;
    double previousCPU = 0; // in milliseconds
    long previousSent = 0;
    long previousReceived = 0;

    private boolean contractViolation;

    private final ThreadMXBean tmxb = ManagementFactory.getThreadMXBean();
    private final int nCPUs = Runtime.getRuntime().availableProcessors();

    private static final double elapsedTime = 1000; // 1 second

    public GlobalMonitoring(Object msg) {
        this.msg = msg;
        contractViolation = false;
    }

    @Override
    public void init() {
        // init monitoring of thread execution
        timerForCPU = new Timer();
        timerForCPU.schedule(this, 1000, 1000);
        contractViolation = false;
        // init monitoring of network communication
    }

    @Override
    public void stop() {
        // stop the monitoring
        timerForCPU.cancel();
    }

    @Override
    public synchronized void actionOnContractViolation() {
        // notify about action
        msg.notify();
        contractViolation = true;
    }

    @Override
    public synchronized boolean isThereContractViolation() {
        return contractViolation;
    }

    @Override
    public synchronized void pause() {
        timerForCPU.cancel();
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
