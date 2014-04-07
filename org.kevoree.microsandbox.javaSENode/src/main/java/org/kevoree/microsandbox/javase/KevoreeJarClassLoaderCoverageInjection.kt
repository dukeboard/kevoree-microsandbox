package org.kevoree.microsandbox.javase

import java.util.Vector
import org.kevoree.microsandbox.core.CoverageRuntime
import org.kevoree.kcl.impl.FlexyClassLoaderImpl
import org.kevoree.microsandbox.core.instrumentation.InstrumenterCommand
import org.kevoree.microsandbox.core.instrumentation.ExtraInstrumentationRules

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 6/24/13
 * Time: 11:38 AM
 */

open class KevoreeJarClassLoaderCoverageInjection() : FlexyClassLoaderImpl() {

    public val loadedClasses : Vector<String> = Vector<String>()

    private var cmd : InstrumenterCommand = InstrumenterCommand()

    private val id : Int = IdGenerator.instance()?.next()!!

    {
        CoverageRuntime.init()
    }

    /*override*/ fun internal_defineClass(className: String, bytes: ByteArray): Class<out Any?>? {
//        println(className + " MIERDA PRIETA " + Thread.currentThread().getThreadGroup()?.getName())\
//        MonitoringStatusList.instance()?.saveClassName(Thread.currentThread().getThreadGroup()?.getName(), className, this)
        val x: ByteArray =  if (!ExtraInstrumentationRules.isInstrumentable(className.replace('.','/'))) {
                                bytes
                            }
                            else {
                                loadedClasses.add(className)
                                CoverageRuntime.instrument(bytes)
                            }

        if (className.contains(".")) {
            val packageName = className.substring(0, className.lastIndexOf('.'))
            if (getPackage(packageName) == null) {
                definePackage(packageName, null, null, null, null, null, null, null)
            }
        }
        val clazz : Class<out Any?>? = defineClass(className, x, 0, x.size)
        return clazz
    }


    public override fun hashCode(): Int {
        return id;
    }
}