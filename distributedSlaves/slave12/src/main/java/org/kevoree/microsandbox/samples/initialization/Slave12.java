package org.kevoree.microsandbox.samples.initialization;

import org.kevoree.annotation.*;
import org.kevoree.framework.AbstractComponentType;
import org.kevoree.framework.MessagePort;
import org.kevoree.log.Log;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by inti on 3/11/14.
 */
@Requires({
        @RequiredPort(name = "notifyStarted", optional = false, type = PortType.MESSAGE)
})
@ComponentType
public class Slave12 extends AbstractComponentType {

    @Start
    public void start() {
        final long l = System.nanoTime();
        new Timer().schedule(new TimerTask() {

            @Override
            public void run() {
                Log.info("Sending notification ******************** {}", l);
                getPortByName("notifyStarted", MessagePort.class).process(
                        String.format("%s,%d", getNodeName(),l));
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
