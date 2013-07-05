package org.kevoree.microsandbox.api.event;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 7/5/13
 * Time: 9:39 AM
 * To change this template use File | Settings | File Templates.
 */
public class ModelComponentUpdatedEvent extends ModelAdmissionEvent {
    public ModelComponentUpdatedEvent(String componentPath) {
        super(componentPath);
    }

    @Override
    protected String action() {
        return "updated";
    }
}
