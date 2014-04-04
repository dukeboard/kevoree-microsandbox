package org.kevoree.library.javase.copter;

import org.kevoree.annotation.*;
import org.kevoree.api.Port;

/**
 * User: Erwan Daubert - erwan.daubert@gmail.com
 * Date: 28/08/13
 * Time: 17:25
 *
 * @author Erwan Daubert
 * @version 1.0
 */
@ComponentType(description = "This component is able to receive an url to acces to a stream")
public class CopterMediaReceiver {

    @Output
    Port media;


    @Start
    public void start() {

    }

    @Stop
    public void stop() {

    }

    @Input
    public void strean(Object msg) {
        if (msg instanceof String) {
            // TODO record the stream
            if (media.getConnectedBindingsSize() > 0) {
                media.send(msg);
            }
        }
    }

}
