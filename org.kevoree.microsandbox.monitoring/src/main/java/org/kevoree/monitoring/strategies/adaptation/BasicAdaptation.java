package org.kevoree.monitoring.strategies.adaptation;

import org.kevoree.api.ModelService;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 7/3/13
 * Time: 9:20 AM
 * To change this template use File | Settings | File Templates.
 */
public abstract class BasicAdaptation implements AdaptationStrategy {
    protected BasicAdaptation(ModelService service) {
        this.modelService = service;
    }

    protected final ModelService modelService;
}
