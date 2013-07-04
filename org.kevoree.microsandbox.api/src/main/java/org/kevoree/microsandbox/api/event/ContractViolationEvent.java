package org.kevoree.microsandbox.api.event;

/**
 * Created with IntelliJ IDEA.
 * User: duke
 * Date: 04/07/13
 * Time: 09:35
 */
public class ContractViolationEvent {

    private String instancePath;

    private Metrics metric;

    private Double observedValue;

    private Double maxValue;

    public String getInstancePath() {
        return instancePath;
    }

    public void setInstancePath(String instancePath) {
        this.instancePath = instancePath;
    }

    public Metrics getMetric() {
        return metric;
    }

    public void setMetric(Metrics metric) {
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

}
