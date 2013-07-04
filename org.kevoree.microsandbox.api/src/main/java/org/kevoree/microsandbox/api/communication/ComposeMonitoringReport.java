package org.kevoree.microsandbox.api.communication;

import org.kevoree.microsandbox.api.sla.Metric;

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
    public void monitoring(boolean global) {
        for (MonitoringReporter r : reporters) {
            r.monitoring(global);
        }
    }

    @Override
    public void sla(String componentPath, Metric metric, double observed, double max) {
        for (MonitoringReporter r : reporters) {
            r.sla(componentPath, metric, observed, max);
        }
    }

    @Override
    public void adaptation(String action, String args) {
        for (MonitoringReporter r : reporters) {
            r.adaptation(action, args);
        }
    }

    @Override
    public void controlAdmission_accepted(String componentPath) {
        for (MonitoringReporter r : reporters) {
            r.controlAdmission_accepted(componentPath);
        }
    }

    @Override
    public void controlAdmission_removed(String componentPath) {
        for (MonitoringReporter r : reporters) {
            r.controlAdmission_removed(componentPath);
        }
    }

    @Override
    public void controlAdmission_updated(String componentPath) {
        for (MonitoringReporter r : reporters) {
            r.controlAdmission_updated(componentPath);
        }
    }
}
