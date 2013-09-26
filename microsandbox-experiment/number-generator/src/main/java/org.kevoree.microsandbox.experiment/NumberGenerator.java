package org.kevoree.microsandbox.experiment;

import org.kevoree.annotation.*;
import org.kevoree.framework.AbstractComponentType;
import org.kevoree.framework.MessagePort;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

@Requires({
        @RequiredPort(name = "output", type = PortType.MESSAGE)
})
@ComponentType
public class NumberGenerator extends AbstractComponentType {
    final Random random = new Random();
    @Start
    public void start() {

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                int n = random.nextInt(20000) + 2;
                getPortByName("output", MessagePort.class).process(n + "");
            }
        }, 300, 300);
    }

    @Stop
    public void stop() {

    }
}