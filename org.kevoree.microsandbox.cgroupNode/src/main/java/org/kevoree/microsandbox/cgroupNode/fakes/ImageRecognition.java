package org.kevoree.microsandbox.cgroupNode.fakes;

import org.kevoree.annotation.*;
import org.kevoree.framework.AbstractComponentType;

/**
 * Created by inti on 2/20/14.
 */
@Provides({
        @ProvidedPort(name = "videoStream", type = PortType.MESSAGE)
})
@ComponentType
public class ImageRecognition extends AbstractComponentType {

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

    @Port(name = "videoStream")
    public void onSnapshot(Object obj) {

    }
}
