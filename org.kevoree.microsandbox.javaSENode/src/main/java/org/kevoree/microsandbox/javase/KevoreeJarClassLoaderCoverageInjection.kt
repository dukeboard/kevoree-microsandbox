package org.kevoree.microsandbox.javase



import java.io.InputStream
import java.lang.reflect.Field
import java.util.Vector
import java.io.IOException
import org.kevoree.kcl.KevoreeJarClassLoader
import org.kevoree.microsandbox.core.CoverageRuntime
import org.kevoree.microsandbox.core.instrumentation.ExtraInstrumentationRules
import org.kevoree.microsandbox.core.instrumentation.InstrumenterCommand

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


    KevoreeJarClassLoaderCoverageInjection() {
        CoverageRuntime.init()
    }

    override fun internal_defineClass(className: String, bytes: ByteArray): Class<out Any?>? {
//        println("Coverage for class : " + className +  " has been solicited :-)")
        val x: ByteArray =  if (!ExtraInstrumentationRules.isInstrumentable(className.replace('.','/'))) {
                                bytes
                            }
                            else {
                                loadedClasses.add(className)
                                val arr : ByteArray? = cmd.instrument(bytes, className.replace('.','/'))
                                CoverageRuntime.instrument(arr)
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

}