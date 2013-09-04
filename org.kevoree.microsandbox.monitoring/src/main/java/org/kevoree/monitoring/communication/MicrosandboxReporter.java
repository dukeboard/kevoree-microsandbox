package org.kevoree.monitoring.communication;

import org.kevoree.microsandbox.api.communication.AbstractMicrosandboxReporter;
import org.kevoree.microsandbox.api.event.MicrosandboxEvent;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 7/5/13
 * Time: 10:00 AM
 */
public class MicrosandboxReporter extends AbstractMicrosandboxReporter {


    private final MicrosandboxEventListener microsandboxEventListener;

    public MicrosandboxReporter(MicrosandboxEventListener listener) {
        this.microsandboxEventListener = listener;
    }

    @Override
    public void trigger(MicrosandboxEvent event) {
        if (microsandboxEventListener != null)
            microsandboxEventListener.notifyEvent(event);
    }
}
