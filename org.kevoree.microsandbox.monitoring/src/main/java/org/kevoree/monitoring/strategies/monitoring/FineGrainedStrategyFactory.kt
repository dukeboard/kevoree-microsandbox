package org.kevoree.monitoring.strategies.monitoring

import org.kevoree.microsandbox.api.sla.Metric
import java.util.EnumSet
import org.kevoree.ComponentInstance
import org.kevoree.api.ModelService
import org.kevoree.library.defaultNodeTypes.ModelRegistry

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 7/9/13
 * Time: 4:06 AM
 *
 */
public object FineGrainedStrategyFactory {
    private var kind: String = "all-components"
    private var modelService : ModelService? = null
    private var modelRegistry : ModelRegistry? = null
    fun init(kind : String, modelService : ModelService, modelRegistry: ModelRegistry): Unit {
        this.kind = kind
        this.modelService = modelService
        this.modelRegistry = modelRegistry
    }

    fun newMonitor(reasons: EnumSet<Metric>,
            ranking: List<ComponentInstance>,
            msg: Object): FineGrainedMonitoringStrategy<MemorySubstrategy> {
        return when (kind) {
            "single-monitoring-with-heapexplorer" -> SingleComponentMonitoring(reasons, ranking, HeapExplorerMemorySubstrategy(modelService, modelRegistry), msg)
            "all-components-with-heapexplorer" -> AllComponentsMonitoring(reasons, ranking, HeapExplorerMemorySubstrategy(modelService, modelRegistry), msg)
            "single-monitoring" -> SingleComponentMonitoring(reasons, ranking, DefaultMemorySubstrategy(), msg)
            "all-components" -> AllComponentsMonitoring(reasons, ranking, DefaultMemorySubstrategy(), msg)
            else -> AllComponentsMonitoring(reasons, ranking, DefaultMemorySubstrategy(), msg)
        }
    }

    fun isSingleMonitoring(): Boolean = kind.equals("single-monitoring")
}