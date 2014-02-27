package org.kevoree.microsandbox.cgroupNode.fakes;

import org.kevoree.annotation.*;
import org.kevoree.framework.AbstractComponentType;
import org.kevoree.log.Log;
import org.kevoree.microsandbox.api.event.MicrosandboxEvent;
import org.kevoree.microsandbox.api.heuristic.RankingHeuristicComponent;

import java.io.IOException;
import java.nio.file.*;

/**
 * Created by inti on 2/20/14.
 */
@Requires({
        @RequiredPort(name = "temperature", type = PortType.MESSAGE, optional = true)
})
@ComponentType
public class TemperatureSensor extends AbstractComponentType {

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
}
