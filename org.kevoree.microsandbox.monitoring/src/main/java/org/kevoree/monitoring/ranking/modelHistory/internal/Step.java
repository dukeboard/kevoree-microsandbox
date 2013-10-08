package org.kevoree.monitoring.ranking.modelHistory.internal;

import org.kevoree.ComponentInstance;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * User: Erwan Daubert - erwan.daubert@gmail.com
 * Date: 04/10/13
 * Time: 16:19
 *
 * @author Erwan Daubert
 * @version 1.0
 */
public class Step {
    private List<ComponentInstance> instances;
    private Step nextStep;

    public List<ComponentInstance> getInstances() {
        return instances;
    }

    public void setInstances(List<ComponentInstance> instances) {
        this.instances = instances;
    }

    public Step getNextStep() {
        return nextStep;
    }

    public void setNextStep(Step nextStep) {
        this.nextStep = nextStep;
    }

    public void reduce(ComponentInstance instance) {
        if (instances.contains(instance)) {
            List<ComponentInstance> newInstances = instances;
            newInstances.remove(instance);
            instances = new ArrayList<ComponentInstance>(1);
            instances.add(instance);

            Step newStep = new Step();
            newStep.setInstances(newInstances);
            newStep.setNextStep(this.nextStep);

            setNextStep(newStep);
            nextStep.reduce(instance);
        }
    }

    public List<ComponentInstance> sort() {
        List<ComponentInstance> orderedInstances = new LinkedList<ComponentInstance>();
        orderedInstances.addAll(instances);
        nextStep.sort(orderedInstances);
        return orderedInstances;
    }

    protected void sort(List<ComponentInstance> resultList) {
        if (resultList != null) {
            if (instances != null) {
                resultList.addAll(instances);
            }

            if (nextStep != null) {
                nextStep.sort(resultList);
            }
        }
    }
}
