package org.kevoree.microsandbox.monitoredNode

import org.kevoree.Dictionary
import java.util.ArrayList
import org.resourceaccounting.contract.ResourceContract
import java.util.concurrent.locks.ReentrantLock
import org.kevoree.microsandbox.api.contract.PlatformDescription
import org.kevoree.microsandbox.api.communication.MonitoringReporterFactory
import org.kevoree.microsandbox.api.event.ModelComponentAcceptedEvent
import org.kevoree.microsandbox.api.event.ModelComponentRemovedEvent
import org.kevoree.log.Log
import org.kevoree.Instance

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 6/27/13
 * Time: 11:20 AM
 * To change this template use File | Settings | File Templates.
 */
public object ControlAdmissionSystem {

    class Info(val c : String,
               val inst: Long,
               val mem: Long,
               val netIn : Long,
               val netOut : Long) {

    }

    private var description : PlatformDescription? = null
    private var freeMemory : Long = 0
    private var freeNetworkIn : Long = 0
    private var freeNetworkOut : Long = 0
    private var freeWrite : Long = 0
    private var freeRead : Long = 0

    private val components : MutableList<Info> = ArrayList<Info>()

    private val lock = ReentrantLock()

    /**
     * Calculate the initial amount of resource in the platform and
     * establish this amount as the initial amount of free resources
     */
    fun init(platformDescription : PlatformDescription) : Unit {
        description = platformDescription
        // TODO : no parece estar bien
        freeMemory = Math.min(Runtime.getRuntime().totalMemory(), description?.availability_memory!!)
        freeNetworkIn = description?.availability_received as Long
        freeNetworkOut = description?.availability_sent as Long
        freeRead = description?.availability_read_disc as Long
        freeWrite = description?.availability_write_disc as Long
    }

    public data class ComponentRegistration(val valid: Boolean, val contract: ResourceContract?)

    fun registerComponent(component: Instance): ComponentRegistration {
        val dictionary : Dictionary? = component.dictionary
        if (dictionary !=null){
            var mem : Long = 0
            var netIn : Long = 0
            var netOut : Long = 0
            var instr  : Long = 0;
//            var i = 0
            val values = dictionary.values
//            val n : Int = values.size()
            values.forEach {
                dv ->
            /*}
            while (i < n) {*/
//                val dv = d.get(i)
                when (dv/*.attribute?*/.name) {
                    "memory_max_size" -> {
                        mem = java.lang.Long.parseLong(dv.value!!)
                    }
                    "cpu_wall_time" -> {
                        instr = java.lang.Long.parseLong(dv.value!!)
                    }
                    "network_input_peak_seconds" -> {
                        netIn = java.lang.Long.parseLong(dv.value!!)
                    }
                    "network_output_peak_seconds" -> {
                        netOut = java.lang.Long.parseLong(dv.value!!)
                    }
                    else -> { }
                }
            }
            // FIXME why instr doesn't appear on the condition ?
            if (mem < freeMemory
                    && netIn < freeNetworkIn
                    && netOut < freeNetworkOut) {
                freeMemory -= mem
                freeNetworkIn -= netIn
                freeNetworkOut -= netOut

                lock.lock()
                    components.add(
                            Info(component.path() as String, instr,
                            mem, netIn, netOut))
                lock.unlock()

                val contract : ResourceContract =
                        KevoreeComponentResourceContract(instr, mem, netOut, netIn)

                MonitoringReporterFactory.reporter()?.trigger(ModelComponentAcceptedEvent(component.path()))
                return ComponentRegistration(true, contract)
            } else if (freeMemory < mem) {
                Log.error("Contract is not valid because the memory needed"+
                            "({}) is higher than the memory allowed ({})", mem, freeMemory)
            } else if (freeNetworkIn < netIn) {
                Log.error("Contract is not valid because the Network"+
                " received data needed ({}) is higher than the Network"+
                " received allowed ({})", netIn, freeNetworkIn)
            } else if (freeNetworkOut < netOut) {
                Log.error("Contract is not valid because the Network "+
                "sent data needed ({}) is higher than the Network sent "+
                "data allowed ({})", netOut, freeNetworkOut)
            }
            return ComponentRegistration(false, null)
        }
        else {
            MonitoringReporterFactory.reporter()?.trigger(ModelComponentAcceptedEvent(component.path()))
            return ComponentRegistration(true, null)
        }
    }

    fun unregisterComponent(c : Instance) : Boolean {
        lock.lock()
        val l = components.filter { info -> info.c.equals(c.path()) }
        lock.unlock()
        if (l.size > 0) {
            val n = l.first as Info
            lock.lock()
            components.remove(n)
            lock.unlock()
            freeMemory += n.mem
            freeNetworkIn += n.netIn
            freeNetworkOut += n.netOut
            MonitoringReporterFactory.reporter()?.trigger(ModelComponentRemovedEvent(c.path()))/*controlAdmission_removed(c.path())*/
            return true
        }
        return false
    }

    fun getContract(path: String) : ResourceContract? {
        lock.lock()
        val l = components.filter { info -> info.c.equals(path) }
        lock.unlock()
        return if (l.size > 0) {
            val info = l.first as Info
            KevoreeComponentResourceContract(info.inst, info.mem, info.netOut, info.netIn)
        }
        else null
    }

    fun getPlatformDescription() : PlatformDescription? = description
}