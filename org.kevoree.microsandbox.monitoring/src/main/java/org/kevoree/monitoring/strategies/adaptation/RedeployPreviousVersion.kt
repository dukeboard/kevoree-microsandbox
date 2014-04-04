package org.kevoree.monitoring.strategies.adaptation

import org.kevoree.monitoring.sla.FaultyComponent
import org.kevoree.api.ModelService

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 7/7/13
 * Time: 8:38 AM
 * To change this template use File | Settings | File Templates.
 */
public class RedeployPreviousVersion(modelService: ModelService)
                                        : BasicAdaptation(modelService) {


    public override fun adapt(nodeName: String?, faultyComponents: List<FaultyComponent>?): MutableList<FaultyComponent>? {
        throw UnsupportedOperationException()
    }
}