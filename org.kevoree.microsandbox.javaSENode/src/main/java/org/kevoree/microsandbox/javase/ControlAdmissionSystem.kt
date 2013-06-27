package org.kevoree.microsandbox.javase

import org.kevoree.ComponentInstance
import org.kevoree.Dictionary
import org.kevoree.DictionaryValue
import java.lang.ref.WeakReference
import java.util.ArrayList

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 6/27/13
 * Time: 11:20 AM
 * To change this template use File | Settings | File Templates.
 */
public object ControlAdmissionSystem {

    private var freeMemory : Long = 0
    private var freeNetworkIn : Long = 0
    private var freeNetworkOut : Long = 0

    private val components : MutableList<WeakReference<ComponentInstance>> = ArrayList<WeakReference<ComponentInstance>>()

    /**
     * Calculate the initial amount of resource in the platform and
     * establish this amount as the initial amount of free resources
     */
    fun init() : Unit {
        freeMemory = Runtime.getRuntime().freeMemory()
        freeNetworkIn = java.lang.Long.MAX_VALUE
        freeNetworkOut = java.lang.Long.MAX_VALUE
    }

    fun registerComponent(component: ComponentInstance): Boolean {
        val v : Dictionary? = component.getDictionary()
        if (v !=null){
            val tmp = v as Dictionary
            var mem : Long = 0
            var netIn : Long = 0
            var netOut : Long = 0
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

                    }
                    "network_input_seconds" -> {
                        netIn = java.lang.Long.parseLong(dv.getValue())
                    }
                    "network_output_seconds" -> {
                        netOut = java.lang.Long.parseLong(dv.getValue())
                    }
                    else -> {
                        // do nothing
                    }
                }
                i++
            }
            if (mem < freeMemory
                    && netIn < freeNetworkIn
                    && netOut < freeNetworkOut) {
                freeMemory -= mem
                freeNetworkIn -= netIn
                freeNetworkOut -= netOut
                components.add(WeakReference<ComponentInstance>(component))
                return true
            }
            return false
        }
        else return true
    }
}