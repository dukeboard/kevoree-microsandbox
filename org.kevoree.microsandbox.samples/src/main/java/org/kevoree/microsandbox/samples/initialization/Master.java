package org.kevoree.microsandbox.samples.initialization;

import org.kevoree.annotation.*;
import org.kevoree.framework.AbstractComponentType;
import org.kevoree.log.Log;

/**
 * Created by inti on 3/11/14.
 */


@Provides({
        @ProvidedPort(name = "startNotification", type = PortType.MESSAGE),
        @ProvidedPort(name = "beforeModelDeployment", type = PortType.MESSAGE)
})
@ComponentType
public class Master extends AbstractComponentType {
    private long time;
    private long totalTime = 0;
    private int count = 0;

    @Start
    public void start() {

    }

    @Stop
    public void stop() {

    }

    @Update
    public void update() {
        stop();
        start();
    }

    @Port(name = "startNotification")
    public void onStartNotification(Object obj) {
        Log.info("New message 0");
        if (obj instanceof DataAboutInitialization) {
            DataAboutInitialization d = (DataAboutInitialization)obj;
            long tmp = d.time - time;
            totalTime += tmp;
            count++;
            Log.info("Node {} started in {} milliseconds. (Average = {}, Total = {})",
                    d.nodeName, tmp/1000000, totalTime/1000000/count, totalTime/1000000);
        }
    }

    @Port(name = "beforeModelDeployment")
    public void beforeModelDeployment(Object obj) {
        Log.info("New message 1");
        if (obj instanceof Long) {
            time = (Long) obj;
            Log.info("Starting deployment at {}", time);
        }
    }
}
