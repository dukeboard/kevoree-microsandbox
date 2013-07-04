package org.kevoree.microsandbox.api.communication;


import org.kevoree.microsandbox.api.sla.Metric;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 7/4/13
 * Time: 9:47 AM
 * To change this template use File | Settings | File Templates.
 */
public class ConsoleMonitoringReporter implements MonitoringReporter {
    @Override
    public void monitoring(boolean global) {
        System.out.printf("MON %s\n", global ? "GLOBAL" : "LOCAL");
    }

    @Override
    public void sla(String componentPath, Metric metric, double observed, double max) {
        System.out.printf("SLA %s %s %f %f\n", componentPath, metric, observed, max);
    }

    @Override
    public void adaptation(String action, String args) {
        System.out.printf("ADP %s %s\n", action, args);
    }

    @Override
    public void controlAdmission_accepted(String componentPath) {
        System.out.printf("CA accepted %s\n", componentPath);
    }

    @Override
    public void controlAdmission_removed(String componentPath) {
        System.out.printf("CA removed %s\n", componentPath);
    }

    @Override
    public void controlAdmission_updated(String componentPath) {
        System.out.printf("CA updated %s\n", componentPath);
    }
}
