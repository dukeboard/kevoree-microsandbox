package org.kevoree.monitoring.comp.reasoner;

import org.kevoree.annotation.*;
import org.kevoree.log.Log;
import org.kevoree.microsandbox.api.event.MicrosandboxEvent;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 7/5/13
 * Time: 10:45 AM
 *
 */
@ComponentType
public class ResourceAwareReasoner {

    @Start
    public void startComponent() {

    }

    @Stop
    public void stopComponent() {

    }

    @Update
    public void updateComponent() {

    }

    @Input
    public void eventHandler(Object event) {
        if (event instanceof MicrosandboxEvent) {
            MicrosandboxEvent e = (MicrosandboxEvent)event;
//            Log.info("The reasoner catch an event={}, do something", e);
//            System.out.println(e);
        }
    }
}
