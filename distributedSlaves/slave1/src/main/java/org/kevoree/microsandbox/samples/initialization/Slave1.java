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
public class Slave1 {

    @Output(optional = false)
    Port notifyStarted;

    @KevoreeInject
    Context context;

    @Start
    public void start() {
        final long l = System.nanoTime();
        new Timer().schedule(new TimerTask() {

            @Override
            public void run() {
                if (notifyStarted.getConnectedBindingsSize() > 0) {
                    notifyStarted.send(String.format("%s,%d", context.getNodeName(), l));
                    Log.info("Sending notification ******************** {} from {}", l, context.getNodeName());
                }
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
