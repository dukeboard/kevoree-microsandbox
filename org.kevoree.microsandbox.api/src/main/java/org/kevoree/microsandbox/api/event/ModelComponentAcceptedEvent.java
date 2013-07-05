package org.kevoree.microsandbox.api.event;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 7/5/13
 * Time: 9:35 AM
 * To change this template use File | Settings | File Templates.
 */
public class ModelComponentAcceptedEvent extends ModelAdmissionEvent {
    public ModelComponentAcceptedEvent(String componentPath) {
        super(componentPath);
    }

    @Override
    protected String action() {
        return "accepted";
    }
}
