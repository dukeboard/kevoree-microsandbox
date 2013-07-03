package org.kevoree.microsandbox.samples.cpu;

import org.kevoree.annotation.*;
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

@DictionaryType({
        @DictionaryAttribute(name = "sleepTime", dataType = Integer.class, optional = true)
})
@ComponentType
public class CPUConsumerGood extends AbstractComponentType implements CPUContracted, Runnable {

    @Override
    public void run() {
        //define an acceptable level of consumption

        //inject

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
