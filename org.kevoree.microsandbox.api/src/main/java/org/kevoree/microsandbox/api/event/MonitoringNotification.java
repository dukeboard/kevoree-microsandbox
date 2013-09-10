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
    private final long timeUsedInPreviousMode;
    private boolean global;
    private EnumSet<Metric> reason;

    public MonitoringNotification(boolean global, long timeUsedInPreviousMode) {
        this.global = global;
        this.timeUsedInPreviousMode = timeUsedInPreviousMode;
    }

    public MonitoringNotification(boolean global, EnumSet<Metric> reason) {
        this.global = global;
        this.reason = reason;
        timeUsedInPreviousMode = 0; // Who care in this case?
    }

    @Override
    public String toString() {
        if (global) {
        return String.format("MON GLOBAL (It spent %d milliseconds in the last local monitoring round)\n", timeUsedInPreviousMode);
        } else {
            return "MON LOCAL " + reason;
        }
    }

    public String toRegex() {
        return toString().replace("[", "\\[").replace("]", "\\]");
    }
}
