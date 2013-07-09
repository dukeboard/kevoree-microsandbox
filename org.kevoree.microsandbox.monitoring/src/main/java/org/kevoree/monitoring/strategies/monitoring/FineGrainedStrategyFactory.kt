package org.kevoree.monitoring.strategies.monitoring

import org.kevoree.microsandbox.api.sla.Metric
import java.util.EnumSet
import org.kevoree.ComponentInstance

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 7/9/13
 * Time: 4:06 AM
 *
 */
public object FineGrainedStrategyFactory {
    private var kind: String = "all-components"
    fun init(kind : String): Unit {
        this.kind = kind
    }

    fun newMonitor(reasons: EnumSet<Metric>,
            ranking: List<ComponentInstance>,
            msg: Object): FineGrainedMonitoringStrategy {
        return when (kind) {
            "single-monitoring" -> SingleComponentMonitoring(reasons, ranking, msg);
            "all-components" -> AllComponentsMonitoring(reasons, ranking, msg)
            else -> AllComponentsMonitoring(reasons, ranking, msg)
        }
    }
}