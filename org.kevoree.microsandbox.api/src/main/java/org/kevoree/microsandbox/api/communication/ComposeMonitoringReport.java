package org.kevoree.microsandbox.api.communication;

import org.kevoree.microsandbox.api.event.MicrosandboxEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 7/4/13
 * Time: 3:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class ComposeMonitoringReport implements MonitoringReporter {

    private List<MonitoringReporter> reporters = new ArrayList<MonitoringReporter>();

    public void addReporter(MonitoringReporter r) {
        reporters.add(r);
    }

    @Override
    public void trigger(MicrosandboxEvent event) {
        for (MonitoringReporter r : reporters) {
            r.trigger(event);
        }
    }
}
