package org.kevoree.microsandbox.api.event;

import org.kevoree.microsandbox.api.sla.Metric;

/**
 * Created with IntelliJ IDEA.
 * User: duke
 * Date: 04/07/13
 * Time: 09:35
 */
public class ContractViolationEvent extends MicrosandboxEvent {

    public ContractViolationEvent(String instancePath,
                                  Metric metric,
                                  Double observedValue, Double maxValue) {
        this.instancePath = instancePath;
        this.metric = metric;
        this.observedValue = observedValue;
        this.maxValue = maxValue;
    }

    private String instancePath;

    private Metric metric;

    private Double observedValue;

    private Double maxValue;

    public String getInstancePath() {
        return instancePath;
    }

    public void setInstancePath(String instancePath) {
        this.instancePath = instancePath;
    }

    public Metric getMetric() {
        return metric;
    }

    public void setMetric(Metric metric) {
        this.metric = metric;
    }

    public Double getObservedValue() {
        return observedValue;
    }

    public void setObservedValue(Double observedValue) {
        this.observedValue = observedValue;
    }

    public Double getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Double maxValue) {
        this.maxValue = maxValue;
    }

    @Override
    public String toString() {
        return "ContractViolation : { path : \"" + instancePath + "\" , metric : \"" + metric.name() + "\" , observedValue : \"" + observedValue + "\" , maxValue : \"" + maxValue + "\" }";
    }

    public String toRegex() {
        return toString().replace("-1.0", "(\\d*\\.\\d*E?\\d*)").replace("{", "\\{").replace("}", "\\}").replace("[", "\\[").replace("]", "\\]");
    }

}
