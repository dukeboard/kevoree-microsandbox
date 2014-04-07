package org.kevoree.microsandbox.cgroupNode.fakes;

import org.kevoree.annotation.*;

/**
 * Created by inti on 2/20/14.
 */
@ComponentType
public class ImageRecognition {

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

    @Input
    public void videoStream(Object obj) {

    }
}
