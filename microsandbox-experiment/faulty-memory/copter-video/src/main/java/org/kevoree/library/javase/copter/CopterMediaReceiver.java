package org.kevoree.library.javase.copter;

import org.kevoree.annotation.*;
import org.kevoree.framework.AbstractComponentType;
import org.kevoree.framework.MessagePort;

/**
 * User: Erwan Daubert - erwan.daubert@gmail.com
 * Date: 28/08/13
 * Time: 17:25
 *
 * @author Erwan Daubert
 * @version 1.0
 */
@Library(name = "copterManager")
@Requires({
        @RequiredPort(name = "media", type = PortType.MESSAGE, optional = true)
})
@Provides({
        @ProvidedPort(name = "stream", type = PortType.MESSAGE)
})
@ComponentType(description = "This component is able to receive an url to acces to a stream")
public class CopterMediaReceiver extends AbstractComponentType {

    @Start
    public void start() {

    }

    @Stop
    public void stop() {

    }

    @Port(name = "stream")
    public void strean(Object msg) {
        if (msg instanceof String) {
            // TODO record the stream
            if (isPortBinded("media")) {
                getPortByName("media", MessagePort.class).process(msg);
            }
        }
    }

}
