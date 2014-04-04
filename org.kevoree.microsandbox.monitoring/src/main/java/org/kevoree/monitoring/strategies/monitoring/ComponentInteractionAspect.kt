package org.kevoree.monitoring.strategies.adaptation

import org.kevoree.ComponentInstance
import org.kevoree.ContainerRoot
import org.kevoree.Port
import org.kevoree.monitoring.comp.MyLowLevelResourceConsumptionRecorder
import java.util.HashSet
import java.util.HashMap
import org.kevoree.monitoring.strategies.monitoring.FineGrainedMonitoringStrategy
import org.kevoree.api.ModelService

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 7/7/13
 * Time: 8:57 AM
 *
 */
public object ComponentInteractionAspect {

    /**
     * This method tries to identified if a component is being used in the wrong way.
     * There are two contracts related to the usage of component:
     *  1 - For each provided port, the contract specifies the number of requests per second that the component
     *  is able to answer without breaking the contract regarding resource consumption
     *  2 - For the whole component, there is contract that specifies the number of requests per second for all
     *  the provided ports that the component can handle
     * This component checks that both contracts are respected. Moreover, if contract (1) is not met the method
     * attempts to find if some bind port is sending more than the contract.
     *
     * NOTE: In general it is not possible to identified a guilty component because of the many-to-many relation
     * between ports. In such a case :
     *  1 - The architecture is wrong
     *  2 - The contract is wrong
     *
     *  Return Value: the set of ports that are using <i>componentPath</i> in the wrong way
     */
    fun findMisbehavedComponents(modelService : ModelService,
                       componentPath : String) : PortUsageStatus {

        val result = PortUsageStatus(false, HashMap<String, HashSet<Port>>())
        val root = modelService.getCurrentModel()!!.getModel() as ContainerRoot
        val c = root.findByPath(componentPath, javaClass<ComponentInstance>())
        val totalExpected = getMaxNumberOfRequest(componentPath, modelService)
        var totalObserved = 0
        var errorOnSinglePortUsage = false;

        for (port in c?.provided!!)
        {
            val name = port.portTypeRef?.name!!
            val portObserved : Int = MyLowLevelResourceConsumptionRecorder.
                    getInstance()?.
                    getUsesOfProvidedPort(c?.name!!, name)!! / FineGrainedMonitoringStrategy.ELAPSED_SECONDS

            val portExpected = getMaxNumberOfRequest(componentPath, name, modelService)

            // check if the port is been used in the proper way
            if (portObserved > portExpected) {

                // ok, someone is sending more message than expected, try to identify the faulty
                errorOnSinglePortUsage = true
                if (!result.misUsedProvidedPorts.containsKey(name))
                    result.misUsedProvidedPorts.put(name, HashSet<Port>())
                for (binding in port.bindings)
                {
                    for (b2 in binding.hub?.bindings!!)

                        if (!b2.equals(binding) && (b2.port!!.eContainer() as ComponentInstance).required.contains(b2.port!!))
                        {
                            val nameC = (b2.port?.eContainer() as ComponentInstance).name!!
                            val nameP = b2.port?.portTypeRef?.name!!
                            val d = MyLowLevelResourceConsumptionRecorder.
                                    getInstance()?.getUsesOfRequiredPort(nameC, nameP) as Int / FineGrainedMonitoringStrategy.ELAPSED_SECONDS
                            if (d > portExpected) {
                                result.misUsedProvidedPorts.get(name)?.add(b2?.port!!)
                            }
                        }
                }
            }
            totalObserved += portObserved
        }
        if (!errorOnSinglePortUsage) {
            if ( totalObserved / FineGrainedMonitoringStrategy.ELAPSED_SECONDS > totalExpected) {
                // ok, there is no violation on single port, but there is violation on the global contract
                result.wrongUsage = true
                return result
            }
            else {
                // no violation was identified on interaction
                return result
            }
        }
        else {
            // violation on a ports
            result.wrongUsage = true
            return result
        }
    }

    private fun getMaxNumberOfRequest(componentPath : String, modelS : ModelService): Int {
        val c = modelS.getCurrentModel()!!.getModel()?.findByPath(componentPath, javaClass<ComponentInstance>())
        var result = Integer.MAX_VALUE
        for (dv in c?.dictionary?.values!!) {
            if (dv.name.equals("throughput_msg_per_second")) {
               val value = dv.value!!
               val l : Array<String> = value.split(";")
               val tmp = l.filter { s -> s.startsWith("all=") }.
                            map { s -> Integer.valueOf(s.substring(s.indexOf('=') + 1)) }

               if (tmp != null && tmp.size() > 0)
                   result = tmp.get(0) as Int

            }
        }
        return result;
    }

    public fun getMaxNumberOfRequest(componentPath : String, port : String, modelS : ModelService): Int {
        val c = modelS.getCurrentModel()!!.getModel()?.findByPath(componentPath, javaClass<ComponentInstance>())
        var result = Integer.MAX_VALUE
        for (dv in c?.dictionary?.values!!) {
            if (dv.name.equals("throughput_msg_per_second")) {
                val value = dv.value!!
                val l : Array<String> = value.split(";")
                val tmp = l.filter { s -> s.startsWith(port + "=") }.
                map { s -> Integer.valueOf(s.substring(s.indexOf('=') + 1)) }

                if (tmp != null && tmp.size() > 0)
                    result = tmp.get(0) as Int

            }
        }
        return result;
    }
}