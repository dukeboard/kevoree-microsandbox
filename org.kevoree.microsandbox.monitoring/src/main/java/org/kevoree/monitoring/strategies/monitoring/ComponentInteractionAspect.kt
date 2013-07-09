package org.kevoree.monitoring.strategies.adaptation

import org.kevoree.api.service.core.handler.KevoreeModelHandlerService
import org.kevoree.framework.kaspects.PortAspect
import org.kevoree.ComponentInstance
import org.kevoree.ContainerRoot
import org.kevoree.Port
import org.kevoree.monitoring.comp.MyResourceConsumptionRecorder
import org.kevoree.MBinding
import java.util.ArrayList
import java.util.HashSet
import java.util.HashMap
import org.kevoree.monitoring.strategies.monitoring.AllComponentsMonitoring

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 7/7/13
 * Time: 8:57 AM
 *
 */
public object ComponentInteractionAspect {
    val portAspect : PortAspect = PortAspect()

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
    fun findMisbehavedComponents(modelService : KevoreeModelHandlerService,
                       componentPath : String) : PortUsageStatus {

        val result = PortUsageStatus(false, HashMap<String, HashSet<Port>>())
        val root = modelService.getLastModel() as ContainerRoot
        val c = root.findByPath(componentPath, javaClass<ComponentInstance>())
        val totalExpected = getMaxNumberOfRequest(componentPath, modelService)
        var totalObserved = 0
        var errorOnSinglePortUsage = false;

        for (port in c?.getProvided()!!)
        {
            val name = port?.getPortTypeRef()?.getName() as String
            val portObserved : Int = MyResourceConsumptionRecorder.
                    getInstance()?.
                    getUsesOfProvidedPort(c?.getName(), name)!! / AllComponentsMonitoring.ELLAPSED_SECONDS

            val portExpected = getMaxNumberOfRequest(componentPath, name, modelService)

            // check if the port is been used in the proper way
            if (portObserved > portExpected) {

                // ok, someone is sending more message than expected, try to identify the faulty
                errorOnSinglePortUsage = true
                if (!result.misUsedProvidedPorts.containsKey(name))
                    result.misUsedProvidedPorts.put(name, HashSet<Port>())
                for (binding in port?.getBindings()!!)
                {
                    for (b2 in binding?.getHub()?.getBindings()!!)
                        if (!b2.equals(binding) && (portAspect.isRequiredPort(b2.getPort() as Port)))
                        {
                            val other = ((b2.getPort()?.eContainer() as ComponentInstance))
                            val nameC = other.getName()
                            val nameP = b2.getPort()?.getPortTypeRef()?.getName()
                            val d = MyResourceConsumptionRecorder.
                                    getInstance()?.getUsesOfRequiredPort(nameC, nameP) as Int / AllComponentsMonitoring.ELLAPSED_SECONDS
                            if (d > portExpected) {
                                result.misUsedProvidedPorts.get(name)?.add(b2?.getPort()!!)
                            }
                        }
                }
            }
            totalObserved += portObserved
        }
        if (!errorOnSinglePortUsage) {
            if ( totalObserved / AllComponentsMonitoring.ELLAPSED_SECONDS > totalExpected) {
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

    private fun getMaxNumberOfRequest(componentPath : String, modelS : KevoreeModelHandlerService): Int {
        val c = modelS.getLastModel()?.findByPath(componentPath, javaClass<ComponentInstance>())
        var result = Integer.MAX_VALUE
        for (dv in c?.getDictionary()?.getValues()!!) {
            if (dv.getAttribute()?.getName() == "throughput_msg_per_second") {
               val value = dv.getValue()
               val l : Array<String> = value.split(";")
               val tmp = l.filter { s -> s.startsWith("all=") }.
                            map { s -> Integer.valueOf(s.substring(s.indexOf('=') + 1)) }

               if (tmp != null && tmp.size() > 0)
                   result = tmp.get(0) as Int

            }
        }
        return result;
    }

    public fun getMaxNumberOfRequest(componentPath : String, port : String, modelS : KevoreeModelHandlerService): Int {
        val c = modelS.getLastModel()?.findByPath(componentPath, javaClass<ComponentInstance>())
        var result = Integer.MAX_VALUE
        for (dv in c?.getDictionary()?.getValues()!!) {
            if (dv.getAttribute()?.getName() == "throughput_msg_per_second") {
                val value = dv.getValue()
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