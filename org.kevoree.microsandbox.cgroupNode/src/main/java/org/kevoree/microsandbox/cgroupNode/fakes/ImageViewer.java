package org.kevoree.microsandbox.cgroupNode.fakes;

import org.kevoree.annotation.*;
import org.kevoree.api.Port;

/**
 * Created by inti on 2/20/14.
 */
@ComponentType
public class ImageViewer {

    @Output
    Port imageAnalysisRequest;

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
    public void image(Object obj) {

    }
}
