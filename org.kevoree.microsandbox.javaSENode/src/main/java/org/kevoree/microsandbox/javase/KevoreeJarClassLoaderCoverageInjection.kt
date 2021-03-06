package org.kevoree.microsandbox.javase



import java.io.InputStream
import java.lang.reflect.Field
import java.util.Vector
import java.io.IOException
import org.kevoree.kcl.KevoreeJarClassLoader
import org.kevoree.microsandbox.core.CoverageRuntime
import org.kevoree.microsandbox.core.instrumentation.ExtraInstrumentationRules
import org.kevoree.microsandbox.core.instrumentation.InstrumenterCommand
import java.util.concurrent.atomic.AtomicInteger
import org.resourceaccounting.binder.MonitoringStatusList

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 6/24/13
 * Time: 11:38 AM
 * To change this template use File | Settings | File Templates.
 */

open class KevoreeJarClassLoaderCoverageInjection() : KevoreeJarClassLoader() {

    public val loadedClasses : Vector<String> = Vector<String>()

    private var cmd : InstrumenterCommand = InstrumenterCommand()

    private val id : Int;


    KevoreeJarClassLoaderCoverageInjection() {
        CoverageRuntime.init()
        id = IdGenerator.instance()?.next()!!
    }

    override fun internal_defineClass(className: String, bytes: ByteArray): Class<out Any?>? {
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