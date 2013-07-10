package org.kevoree.microsandbox.api.event;

/**
 * User: Erwan Daubert - erwan.daubert@gmail.com
 * Date: 10/07/13
 * Time: 15:00
 *
 * @author Erwan Daubert
 * @version 1.0
 */
public class AdaptationEvent extends MicrosandboxEvent  {
    private String actionName;
    private String path;

    public AdaptationEvent(String actionName, String path) {
        this.actionName = actionName;
        this.path = path;
    }

    @Override
    public String toString() {
        return "ADP " + actionName  + " " + path;
    }
}
