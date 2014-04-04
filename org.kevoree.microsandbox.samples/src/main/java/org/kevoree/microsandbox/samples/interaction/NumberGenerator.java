package org.kevoree.microsandbox.samples.interaction;

import org.kevoree.annotation.*;
import org.kevoree.api.Port;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 7/6/13
 * Time: 3:39 PM
 */
@ComponentType
public class NumberGenerator {

    @Param(defaultValue = "300")
    int frequency;

    @Output
    Port numbers;

    Timer t;
    Random random;

    @Start
    public void startComponent() {
        random = new Random();
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                numbers.send(random.nextInt(200000) + 50000);
            }
        };
        t = new Timer();
        t.schedule(tt, frequency, frequency);
    }

    @Stop
    public void stopComponent() {
        t.cancel();
        t = null;
    }

    @Update
    public void updateComponent() {
        stopComponent();
        startComponent();
    }
}
