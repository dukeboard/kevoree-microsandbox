package org.kevoree.microsandbox.api.event;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 7/5/13
 * Time: 9:37 AM
 * To change this template use File | Settings | File Templates.
 */
public class ModelComponentRemovedEvent extends ModelAdmissionEvent {
    public ModelComponentRemovedEvent(String componentPath) {
        super(componentPath);
    }

    @Override
    protected String action() {
        return "removed";
    }
}
