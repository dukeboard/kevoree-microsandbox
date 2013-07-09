package org.kevoree.monitoring.strategies.adaptation

import org.kevoree.api.service.core.handler.KevoreeModelHandlerService
import org.kevoree.monitoring.sla.FaultyComponent
import org.kevoree.monitoring.ranking.ComponentsInfoStorage
import org.kevoree.ComponentInstance
import org.kevoree.Port
import org.kevoree.monitoring.comp.MyLowLevelResourceConsumptionRecorder
import java.util.ArrayList
import org.kevoree.microsandbox.api.communication.MonitoringReporterFactory
import org.kevoree.microsandbox.api.sla.Metric
import org.kevoree.monitoring.strategies.monitoring.AllComponentsMonitoring

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 7/7/13
 * Time: 12:12 PM
 *
 */
public class SlowDownComponentInteraction(service : KevoreeModelHandlerService)
                        : BasicAdaptation(service) {
    public override fun adapt(nodeName: String?, faultyComponents: List<FaultyComponent>?): MutableList<FaultyComponent>? {
        var result = ArrayList<FaultyComponent>()
        for (c in faultyComponents!!) {
            if (!fixSingleComponent(c.componentPath,
                    ComponentInteractionAspect.findMisbehavedComponents(modelService!!, c.componentPath)))
                result.add(c)
        }
        return result
    }

    private fun fixSingleComponent(path : String, result : PortUsageStatus) : Boolean {
        if (result.wrongUsage)
        {
            for (s : String in result.misUsedProvidedPorts.keySet())
            {
                var nameOfOrigin : String? = ComponentsInfoStorage.getExecutionInfo(path)?.getName()
                val maxAllowed = ComponentInteractionAspect.getMaxNumberOfRequest(path, s, modelService!!)
                val usage = MyLowLevelResourceConsumptionRecorder.getInstance()?.getUsesOfProvidedPort(nameOfOrigin, s) as Int /
                    AllComponentsMonitoring.ELLAPSED_SECONDS
                MonitoringReporterFactory.reporter()?.sla(path, Metric.PortUsage, usage.toDouble(), maxAllowed.toDouble())

                if (result.misUsedProvidedPorts.get(s)?.isEmpty()!!)
                {
                    MyLowLevelResourceConsumptionRecorder.getInstance()?.turnOnPortControllingOn(nameOfOrigin, s, false,
                            maxAllowed)
                }
                else
                    for (p : Port? in result.misUsedProvidedPorts.get(s)!!)
                    {
                        var c : ComponentInstance? = (p?.eContainer() as ComponentInstance?)
                        var portName : String? = p?.getPortTypeRef()?.getName()
                        MonitoringReporterFactory.reporter()?.adaptation("SlowDownInteraction", "${c?.getName()}${portName}" )
                        MyLowLevelResourceConsumptionRecorder.getInstance()?.turnOnPortControllingOn(c?.getName(), portName, true,
                                maxAllowed)
                    }
            }
        }

        return result.wrongUsage
    }

}