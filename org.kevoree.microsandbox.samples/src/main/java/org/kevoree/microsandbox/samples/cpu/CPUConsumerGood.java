package org.kevoree.microsandbox.samples.cpu;

import org.kevoree.annotation.ComponentType;
import org.kevoree.annotation.Start;
import org.kevoree.annotation.Stop;
import org.kevoree.framework.AbstractComponentType;
import org.kevoree.microsandbox.api.CPUContracted;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 7/1/13
 * Time: 1:27 AM
 */
@ComponentType
public class CPUConsumerGood extends AbstractComponentType implements CPUContracted, Runnable {

    @Override
    public void run() {
        int sum = 0;
        while (true) {
            for (int i = 0; i < 1000000; i++) {
                sum += i;
            }
        }
    }

    ExecutorService pool;

    @Start
    public void startComponent() {
        pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        for (int i = 0; i < Runtime.getRuntime().availableProcessors(); i++) {
            pool.submit(new CPUConsumerGood());
        }
    }

    @Stop
    public void stopComponent() {
        pool.shutdownNow();
    }

}
