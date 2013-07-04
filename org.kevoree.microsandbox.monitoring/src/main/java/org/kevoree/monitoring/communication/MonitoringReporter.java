package org.kevoree.monitoring.communication;


import org.kevoree.monitoring.sla.Metric;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 7/4/13
 * Time: 9:43 AM
 * To change this template use File | Settings | File Templates.
 */
public interface MonitoringReporter {
    public void monitoring(boolean global);
    public void sla(String componentPath, Metric metric, double observed, double max);
    public void adaptation(String action, String args);
    public void controlAdmission_accepted(String componentPath);
    public void controlAdmission_removed(String componentPath);
    public void controlAdmission_updated(String componentPath);
}
