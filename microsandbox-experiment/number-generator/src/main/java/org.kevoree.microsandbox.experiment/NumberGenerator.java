package org.kevoree.microsandbox.experiment;

import org.kevoree.annotation.ComponentType;
import org.kevoree.annotation.Output;
import org.kevoree.annotation.Start;
import org.kevoree.annotation.Stop;
import org.kevoree.api.Port;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

@ComponentType
public class NumberGenerator {

    @Output
    Port output;

    final Random random = new Random();
    @Start
    public void start() {

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                int n = random.nextInt(20000) + 2;
                output.send(n);
            }
        }, 300, 300);
    }

    @Stop
    public void stop() {

    }
}