package org.kevoree.monitoring.ranking

import org.kevoree.ComponentInstance
import org.kevoree.api.service.core.handler.KevoreeModelHandlerService
import org.kevoree.api.service.core.handler.ModelListener

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 7/9/13
 * Time: 3:14 PM
 * To change this template use File | Settings | File Templates.
 */
// TODO should be a component with one service port. Each implementation of this component may have its specific ranking algorithm
public object ComponentRankerFunctionFactory {
    var modelRanker : ModelRankingAlgorithm? = null
    fun get(name: String): (ComponentInstance, ComponentInstance) -> Int {
        return when (name) {
            "amount_of_time_alive" -> {
                (a, b) ->
                val currentTime = System.currentTimeMillis()
                val x = ComponentsInfoStorage.instance.getExecutionInfo(a.path() as String)
                val y = ComponentsInfoStorage.instance.getExecutionInfo(b.path() as String)
                if ((x?.timeAlive(currentTime) as Long) < y?.timeAlive(currentTime) as Long)
                    1
                else
                    -1
            }
            "number_of_failures" -> {
                (a,b) ->
                val x = ComponentsInfoStorage.instance.getExecutionInfo(a.path() as String)
                val y = ComponentsInfoStorage.instance.getExecutionInfo(b.path() as String)
                if ((x?.getFailures() as Long) < y?.getFailures() as Long)
                    -1
                else
                    1
            }
            "model_history" -> {
                (a, b) ->
                if (modelRanker != null) {
                    modelRanker!!.rank(a, b)
                } else {
                    // TODO get the default value of componentRankFunction in MonitoringComponent
                    1
                }
            }

            else -> {
                (a,b) -> -1
            }
        }
    }
}