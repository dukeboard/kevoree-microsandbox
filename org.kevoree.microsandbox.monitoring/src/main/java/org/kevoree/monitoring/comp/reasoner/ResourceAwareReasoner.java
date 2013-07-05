package org.kevoree.monitoring.comp.reasoner;

import org.kevoree.annotation.*;
import org.kevoree.framework.AbstractComponentType;
import org.kevoree.microsandbox.api.event.MicrosandboxEvent;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 7/5/13
 * Time: 10:45 AM
 *
 */
@Provides({
        @ProvidedPort(name = "eventHandler", className = MicrosandboxEvent.class, type = PortType.MESSAGE)
})

@ComponentType
public class ResourceAwareReasoner extends AbstractComponentType {

    @Start
    public void startComponent() {

    }

    @Stop
    public void stopComponent() {

    }

    @Update
    public void updateComponent() {

    }

    @Port(name = "eventHandler")
    public void handlingEvent(Object event) {
        if (event instanceof MicrosandboxEvent) {
            MicrosandboxEvent e = (MicrosandboxEvent)event;
            System.out.println(e);
        }
    }
}
