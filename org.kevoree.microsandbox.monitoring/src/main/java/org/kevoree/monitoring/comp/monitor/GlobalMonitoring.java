package org.kevoree.monitoring.comp.monitor;

import org.kevoree.monitoring.comp.MyResourceConsumptionRecorder;
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
public class GlobalMonitoring implements MonitoringStrategy {
    private final Object msg;
    private Timer timerForCPU;
    double previousCPU = 0; // in milliseconds
    long previousSent = 0;
    long previousReceived = 0;

    public GlobalMonitoring(Object msg) {
        this.msg = msg;
    }

    @Override
    public void init() {
        // init monitoring of thread execution
        TimerTask task = new TimerTask() {

            ThreadMXBean tmxb = ManagementFactory.getThreadMXBean();
            int nCPUs = Runtime.getRuntime().availableProcessors();

            static final double elapsedTime = 1000; // 1 second

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

                long sent = MyResourceConsumptionRecorder.getInstance().getTotalSent() - previousSent;
                long received = MyResourceConsumptionRecorder.getInstance().getTotalReceived() - previousReceived;
                previousSent = MyResourceConsumptionRecorder.getInstance().getTotalSent();
                previousReceived = MyResourceConsumptionRecorder.getInstance().getTotalReceived();

                System.out.printf("%%CPU : %f , Sent : %f KiB/S, Received %f KiB/S\n",
                        cpuUsage,
                        sent / 1024F,
                        received / 1024F);


                if (cpuUsage > 70 && cpuUsage < 99) {
                    actionOnContractViolation();
                }

            }
        };
        timerForCPU = new Timer();
        timerForCPU.schedule(task, 1000, 1000);
        // init monitoring of network communication
    }

    @Override
    public void stop() {
        // stop the monitoring
        timerForCPU.cancel();
    }

    @Override
    public void actionOnContractViolation() {
        // notify about action
        msg.notify();
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
}
