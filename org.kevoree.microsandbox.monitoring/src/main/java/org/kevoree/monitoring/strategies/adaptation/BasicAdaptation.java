package org.kevoree.monitoring.strategies.adaptation;

import org.kevoree.api.service.core.handler.KevoreeModelHandlerService;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 7/3/13
 * Time: 9:20 AM
 * To change this template use File | Settings | File Templates.
 */
public abstract class BasicAdaptation implements AdaptationStrategy {
    protected BasicAdaptation(KevoreeModelHandlerService service) {
        this.modelService = service;
    }

    protected final KevoreeModelHandlerService modelService;
}
