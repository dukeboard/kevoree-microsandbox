package org.kevoree.microsandbox.cgroupNode.fakes;

import org.kevoree.annotation.*;
import org.kevoree.framework.AbstractComponentType;

/**
 * Created by inti on 2/20/14.
 */
@Provides({
        @ProvidedPort(name = "sensedData", type = PortType.MESSAGE)
})
@Requires({
        @RequiredPort(name = "snapshot", type = PortType.MESSAGE, optional = true)
})
@ComponentType
public class MapView extends AbstractComponentType {

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

    @Port(name = "sensedData")
    public void onSnapshot(Object obj) {

    }
}
