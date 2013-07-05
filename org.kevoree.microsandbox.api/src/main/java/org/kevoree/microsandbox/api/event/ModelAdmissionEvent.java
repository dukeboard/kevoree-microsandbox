package org.kevoree.microsandbox.api.event;

/**
 * Created with IntelliJ IDEA.
 * User: duke
 * Date: 04/07/13
 * Time: 09:39
 */
public abstract class ModelAdmissionEvent extends MicrosandboxEvent {
    protected final String componentPath;

    public ModelAdmissionEvent(String componentPath) {
        this.componentPath = componentPath;
    }

    public String getComponentPath() {
        return componentPath;
    }

    @Override
    public String toString() {
        return "ControlAdmission : {" +
                "path : \"" + componentPath + "\", " +
                "action : \"" + action() + "\"" +
                '}';
    }

    protected abstract String action();
}
