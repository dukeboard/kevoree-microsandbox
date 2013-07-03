package org.kevoree.microsandbox.javase

import org.kevoree.ComponentInstance
import org.kevoree.Dictionary
import org.kevoree.DictionaryValue
import java.lang.ref.WeakReference
import java.util.ArrayList
import org.resourceaccounting.contract.ComponentResourceContract
import org.resourceaccounting.contract.ResourceContract
import java.util.concurrent.locks.ReentrantLock

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 6/27/13
 * Time: 11:20 AM
 * To change this template use File | Settings | File Templates.
 */
public object ControlAdmissionSystem {

    class Info(val c : String,
               val mem: Long,
               val netIn : Long,
               val netOut : Long) {

    }

    private var freeMemory : Long = 0
    private var freeNetworkIn : Long = 0
    private var freeNetworkOut : Long = 0

    private val components : MutableList<Info> = ArrayList<Info>()

    private val lock = ReentrantLock()

    /**
     * Calculate the initial amount of resource in the platform and
     * establish this amount as the initial amount of free resources
     */
    fun init(max_mem : Long, max_sent : Long , max_received : Long) : Unit {
        freeMemory = Math.min(Runtime.getRuntime().freeMemory(), max_mem)
        freeNetworkIn = max_received
        freeNetworkOut = max_sent
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

                lock.lock()
                    components.add(
                            Info(component.path() as String,
                            mem as Long, netIn as Long, netOut as Long))
                lock.unlock()

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
        lock.lock()
        val l = components.filter { info -> info.c.equals(c.path()) }
        lock.unlock()
        if (l != null && l.size > 0) {
            val n = l.first as Info
            lock.lock()
            components.remove(n)
            lock.unlock()
            freeMemory += n.mem
            freeNetworkIn += n.netIn
            freeNetworkOut += n.netOut
            return true
        }
        return false
    }
}