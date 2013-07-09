package org.kevoree.monitoring.ranking

import org.kevoree.ComponentInstance

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 7/9/13
 * Time: 3:14 PM
 * To change this template use File | Settings | File Templates.
 */
public object ComponentRankerFunctionFactory {
    fun get(name: String): (ComponentInstance, ComponentInstance) -> Int {
        return when (name) {
            "amount_of_time_alive" -> {
                (a, b) ->
                val currentTime = System.currentTimeMillis()
                val x = ComponentsInfoStorage.getExecutionInfo(a.path() as String)
                val y = ComponentsInfoStorage.getExecutionInfo(b.path() as String)
                if ((x?.timeAlive(currentTime) as Long) < y?.timeAlive(currentTime) as Long)
                    1
                else
                    -1
            }
            "number_of_failures" -> {
                (a,b) ->
                val x = ComponentsInfoStorage.getExecutionInfo(a.path() as String)
                val y = ComponentsInfoStorage.getExecutionInfo(b.path() as String)
                if ((x?.getFailures() as Long) < y?.getFailures() as Long)
                    -1
                else
                    1
            }

            else -> {
                (a,b) -> -1
            }
        }
    }
}