package org.kevoree.microsandbox.api.communication;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 7/5/13
 * Time: 9:29 AM
 *
 */
public abstract class AbstractMicrosandboxReporter implements MonitoringReporter {
//    protected abstract void dispatchEvent(MicrosandboxEvent event);

    /*@Override
    public void monitoring(boolean global) { }

    @Override
    public void sla(String componentPath, Metric metric, double observed, double max) {
        ContractViolationEvent event = new ContractViolationEvent(componentPath, metric,observed,max);
        dispatchEvent(event);
    }

    @Override
    public void adaptation(String action, String args) { }

    @Override
    public void controlAdmission_accepted(String componentPath) {
        dispatchEvent(new ModelComponentAcceptedEvent(componentPath));
    }

    @Override
    public void controlAdmission_removed(String componentPath) {
        dispatchEvent(new ModelComponentRemovedEvent(componentPath));
    }

    @Override
    public void controlAdmission_updated(String componentPath) {
        dispatchEvent(new ModelComponentUpdatedEvent(componentPath));
    }*/
}
