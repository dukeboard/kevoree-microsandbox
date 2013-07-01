package org.kevoree.microsandbox.javase

import org.kevoree.ComponentInstance
import org.kevoree.Dictionary
import org.kevoree.DictionaryValue
import java.lang.ref.WeakReference
import java.util.ArrayList
import org.resourceaccounting.contract.ComponentResourceContract
import org.resourceaccounting.contract.ResourceContract

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 6/27/13
 * Time: 11:20 AM
 * To change this template use File | Settings | File Templates.
 */
public object ControlAdmissionSystem {

    class Info(val c : WeakReference<ComponentInstance>,
               val mem: Long,
               val netIn : Long,
               val netOut : Long) {

    }

    private var freeMemory : Long = 0
    private var freeNetworkIn : Long = 0
    private var freeNetworkOut : Long = 0

    private val components : MutableList<Info> = ArrayList<Info>()

    /**
     * Calculate the initial amount of resource in the platform and
     * establish this amount as the initial amount of free resources
     */
    fun init() : Unit {
        freeMemory = Runtime.getRuntime().freeMemory()
        freeNetworkIn = java.lang.Long.MAX_VALUE
        freeNetworkOut = java.lang.Long.MAX_VALUE
    }

    public data class ComponentRegistration(val valid: Boolean, val contract: ResourceContract?)

    fun registerComponent(component: ComponentInstance): ComponentRegistration {
        val v : Dictionary? = component.getDictionary()
        if (v !=null){
            val tmp = v as Dictionary
            var mem : Long = 0
            var netIn : Long = 0
            var netOut : Long = 0
            var instr  : Long = 0;
            var i = 0
            val d = tmp.getValues()
            val n : Int = d.size()
            while (i < n) {
                val dv = d.get(i)
                when (dv.getAttribute()?.getName()) {
                    "memory_max_size" -> {
                        mem = java.lang.Long.parseLong(dv.getValue())
                    }
                    "cpu_wall_time" -> {
                        instr = java.lang.Long.parseLong(dv.getValue())
                    }
                    "network_input_seconds" -> {
                        netIn = java.lang.Long.parseLong(dv.getValue())
                    }
                    "network_output_seconds" -> {
                        netOut = java.lang.Long.parseLong(dv.getValue())
                    }
                    else -> { }
                }
                i++
            }
            if (mem < freeMemory
                    && netIn < freeNetworkIn
                    && netOut < freeNetworkOut) {
                freeMemory -= mem
                freeNetworkIn -= netIn
                freeNetworkOut -= netOut
                components.add(
                        Info(WeakReference<ComponentInstance>(component),
                        mem as Long, netIn as Long, netOut as Long))

                val contract : KevoreeComponentResourceContract? = if (mem.toInt() == 0 && instr.toInt() == 0)
                                                                        null
                                                                    else
                                                                        KevoreeComponentResourceContract(instr, mem, netOut, netIn)

                return ComponentRegistration(true, contract)
            }
            return ComponentRegistration(false, null)
        }
        else return ComponentRegistration(true, null)
    }

    fun unregisterComponent(c : ComponentInstance) : Boolean {
        val n = components.filter { info -> info.c.get() != null && info.c.get().equals(c) }.first
        if (n != null) {
            components.remove(n)
            freeMemory += n.mem
            freeNetworkIn += n.netIn
            freeNetworkOut += n.netOut
            return true
        }
        return false
    }
}