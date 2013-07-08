package org.kevoree.microsandbox.javase

import org.kevoree.ComponentInstance
import org.kevoree.Dictionary
import org.kevoree.DictionaryValue
import java.lang.ref.WeakReference
import java.util.ArrayList
import org.resourceaccounting.contract.ComponentResourceContract
import org.resourceaccounting.contract.ResourceContract
import java.util.concurrent.locks.ReentrantLock
import org.kevoree.microsandbox.api.communication.MonitoringReporterFactory
import org.kevoree.microsandbox.api.contract.PlatformDescription

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
        freeMemory = Math.min(Runtime.getRuntime().freeMemory(), description?.availability_memory as Long)
        freeNetworkIn = description?.availability_received as Long
        freeNetworkOut = description?.availability_sent as Long
        freeRead = description?.availability_read_disc as Long
        freeWrite = description?.availability_write_disc as Long
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
                    "network_input_peak_seconds" -> {
                        netIn = java.lang.Long.parseLong(dv.getValue())
                    }
                    "network_output_peak_seconds" -> {
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

                MonitoringReporterFactory.reporter()?.controlAdmission_accepted(component.path() + " " +
                                component.getMetaData() + " " + component.getTypeDefinition()?.getName() )
                return ComponentRegistration(true, contract)
            }
            return ComponentRegistration(false, null)
        }
        else {
            MonitoringReporterFactory.reporter()?.controlAdmission_accepted(component.path())
            return ComponentRegistration(true, null)
        }
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
            MonitoringReporterFactory.reporter()?.controlAdmission_removed(c.path())
            return true
        }
        return false
    }

    fun getPlatformDescription() : PlatformDescription? = description
}