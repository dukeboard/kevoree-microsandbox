package org.kevoree.monitoring.strategies.adaptation

import org.kevoree.api.service.core.handler.KevoreeModelHandlerService
import org.kevoree.monitoring.sla.FaultyComponent

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 7/7/13
 * Time: 12:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class SlowDownComponentConsumption(modelService: KevoreeModelHandlerService)
                                : BasicAdaptation(modelService) {


    public override fun adapt(nodeName: String?, faultyComponents: List<FaultyComponent>?): Boolean {
        throw UnsupportedOperationException()
    }
}