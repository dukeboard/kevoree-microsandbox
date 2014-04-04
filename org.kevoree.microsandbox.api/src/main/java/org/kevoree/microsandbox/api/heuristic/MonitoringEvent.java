package org.kevoree.microsandbox.api.heuristic;

/**
 * User: Erwan Daubert - erwan.daubert@gmail.com
 * Date: 04/04/14
 * Time: 11:15
 *
 * @author Erwan Daubert
 * @version 1.0
 */
public class MonitoringEvent {
    String operation;
    String name;
    String instancePath;
    Long value;

    public MonitoringEvent(String operation, String name, String instancePath, Long value) {
        this.operation = operation;
        this.name = name;
        this.instancePath = instancePath;
        this.value = value;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstancePath() {
        return instancePath;
    }

    public void setInstancePath(String instancePath) {
        this.instancePath = instancePath;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return operation + ":" + name + ":" + instancePath + ":" + value;
    }
}
