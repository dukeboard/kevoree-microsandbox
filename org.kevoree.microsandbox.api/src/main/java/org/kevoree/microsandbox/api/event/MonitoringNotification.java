package org.kevoree.microsandbox.api.event;

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

    public MonitoringNotification(boolean global) {
        this.global = global;
    }

    @Override
    public String toString() {
        if (global) {
        return "MON GLOBAL";
        } else {
            return "MON LOCAL";
        }
    }

    public String toRegex() {
        return toString();
    }
}
