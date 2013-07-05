package org.kevoree.monitoring.communication;

import org.kevoree.microsandbox.api.event.MicrosandboxEvent;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 7/5/13
 * Time: 10:19 AM
 *
 */
public interface MicrosandboxEventListener {
    void notifyEvent(MicrosandboxEvent monitoringEvent);
}
