package org.kevoree.microsandbox.api.communication;


import org.kevoree.microsandbox.api.event.MicrosandboxEvent;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 7/4/13
 * Time: 9:47 AM
 * To change this template use File | Settings | File Templates.
 */
public class ConsoleMonitoringReporter implements MonitoringReporter {

    @Override
    public void trigger(MicrosandboxEvent event) {
        System.out.printf("Event=%s\n", event.toString());
    }
}
