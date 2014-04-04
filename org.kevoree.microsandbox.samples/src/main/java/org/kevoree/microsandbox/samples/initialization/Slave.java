package org.kevoree.microsandbox.samples.initialization;

import org.kevoree.annotation.*;
import org.kevoree.api.Context;
import org.kevoree.api.Port;
import org.kevoree.log.Log;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by inti on 3/11/14.
 */
@ComponentType
public class Slave {

    @Output(optional = false)
    Port notifyStarted;

    @KevoreeInject
    protected Context context;

    @Start
    public void start() {
        final long l = System.nanoTime();
        new Timer().schedule(new TimerTask() {

            @Override
            public void run() {
                Log.info("Sending notification ******************** {}", l);
                notifyStarted.send(String.format("%s,%d", context.getNodeName(),l));

            }
        }, 100);
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
