package org.kevoree.microsandbox.samples.benchmark;

import org.kevoree.annotation.ComponentType;
import org.kevoree.annotation.Start;
import org.kevoree.annotation.Stop;
import org.kevoree.annotation.Update;
import org.kevoree.framework.AbstractComponentType;
import org.kevoree.microsandbox.api.contract.CPUContracted;
import org.kevoree.microsandbox.api.contract.MemoryContracted;

/**
 * Created by inti on 3/4/14.
 */
@ComponentType
public class NaiveCPUConsumer extends AbstractComponentType
        implements MemoryContracted, CPUContracted {

    @Start
    public void start() {
        new Thread() {
            @Override
            public void run() {
                int c = 0;
                int counter = 0;
                while (true) {
                    for (int i = 0 ; i < 1000000000 ; ++i)
                        c += i;
                    counter++;
                    System.out.println("Again : " + c + " " + counter);
                }
            }
        }.start();
    }

    @Stop
    public void stop() {

    }

    @Update
    public void update() {

    }
}
