package org.kevoree.microsandbox.samples.benchmark.cpuusage;

import org.kevoree.annotation.*;
import org.kevoree.framework.AbstractComponentType;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 9/5/13
 * Time: 2:22 PM
 * To change this template use File | Settings | File Templates.
 */
@ComponentType
public class MeasuringCPUUsage extends AbstractComponentType {

    private final static int nCPUs = Runtime.getRuntime().availableProcessors();
    public static final double ELAPSED_TIME = 1000; // 1 second

    private final ThreadMXBean tmxb = ManagementFactory.getThreadMXBean();
    double previousCPU = 0; // in milliseconds
    double cpuUsageCumulative = 0;
    int time = 0;

    class Measuring extends TimerTask {

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
            double diff = sum - previousCPU; // FIXME : this has a problem because the set of active threads may differs between
                                             // calls. For now I can put the minimum to 0
            if (diff < 0) diff = 0;
            previousCPU = sum;
            double cpuUsage = Math.min(99, diff/(ELAPSED_TIME*nCPUs)*100);

            time ++;
            cpuUsageCumulative += cpuUsage;

            // avoid to check when the previous measurement doesn't exist because its use may imply erroneous estimation
            if (!firstTime) {
                System.out.printf("Last %f , total %f\n", cpuUsage, cpuUsageCumulative/(100*time)*100);
            }
        }
    }


    @Start
    public void start() {
        Timer t = new Timer();
        t.schedule(new Measuring(),(long)ELAPSED_TIME,(long)ELAPSED_TIME);
    }

    @Stop
    public void stop() {

    }

    @Update
    public void update() {
        stop();
        start();
    }
}
