package org.kevoree.microsandbox.api.event;

import org.kevoree.microsandbox.api.sla.Metric;

import java.util.EnumSet;

/**
 * User: Erwan Daubert - erwan.daubert@gmail.com
 * Date: 11/07/13
 * Time: 16:41
 *
 * @author Erwan Daubert
 * @version 1.0
 */
public class MonitoringNotification extends MicrosandboxEvent {
    private boolean global;
    private EnumSet<Metric> reason;

    public MonitoringNotification(boolean global) {
        this.global = global;
    }

    public MonitoringNotification(boolean global, EnumSet<Metric> reason) {
        this.global = global;
        this.reason = reason;
    }

    @Override
    public String toString() {
        if (global) {
        return "MON GLOBAL";
        } else {
            return "MON LOCAL " + reason;
        }
    }

    public String toRegex() {
        return toString().replace("[", "\\[").replace("]", "\\]");
    }
}
