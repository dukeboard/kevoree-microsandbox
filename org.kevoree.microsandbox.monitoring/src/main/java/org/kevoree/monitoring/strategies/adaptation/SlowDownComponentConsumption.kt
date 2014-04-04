package org.kevoree.monitoring.strategies.adaptation

import org.kevoree.monitoring.sla.FaultyComponent
import org.kevoree.api.ModelService

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 7/7/13
 * Time: 12:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class SlowDownComponentConsumption(modelService: ModelService)
                                : BasicAdaptation(modelService) {


    public override fun adapt(nodeName: String?, faultyComponents: List<FaultyComponent>?): MutableList<FaultyComponent>? {
        throw UnsupportedOperationException()
    }
}