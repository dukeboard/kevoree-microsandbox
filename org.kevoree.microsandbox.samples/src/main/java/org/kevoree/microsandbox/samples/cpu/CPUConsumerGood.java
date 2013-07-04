package org.kevoree.microsandbox.samples.cpu;

import org.kevoree.annotation.*;
import org.kevoree.framework.AbstractComponentType;
import org.kevoree.microsandbox.api.contract.CPUContracted;
import org.kevoree.microsandbox.api.contract.FullContracted;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 7/1/13
 * Time: 1:27 AM
 */

@DictionaryType({
        @DictionaryAttribute(name = "sleepTime", dataType = Integer.class, optional = true)
})
@ComponentType
public class CPUConsumerGood extends AbstractComponentType implements FullContracted, Runnable {

    @Override
    public void run() {
        //define an acceptable level of consumption
        while (true) {
            //inject
            try {
                Thread.sleep(200);
                int c= 0;
                for (int i = 0 ; i < 10000000 ; i++) {
                    c++;
                }
            } catch (InterruptedException e) {

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
