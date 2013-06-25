package org.kevoree.microsandbox.core



import java.io.InputStream
import java.lang.reflect.Field
import java.util.Vector
import java.io.IOException
import org.kevoree.kcl.KevoreeJarClassLoader

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 6/24/13
 * Time: 11:38 AM
 * To change this template use File | Settings | File Templates.
 */

open class KevoreeJarClassLoaderCoverageInjection() : KevoreeJarClassLoader() {

    KevoreeJarClassLoaderCoverageInjection() {
//        CoverageRuntime.init(this)
    }

    override fun internal_defineClass(className: String, bytes: ByteArray): Class<out Any?>? {
        println("Coverage for class : " + className +  " has been solicited :-)")
//        if (className?.contains("jacoco")
//            || className?.contains("kevoree/library/monitoring")
//            || className?.contains("asm")
//        )
        val x: ByteArray = bytes //CoverageRuntime.instrument(bytes)
        return super.internal_defineClass(className, x)
        //return super.internal_defineClass(className, x)
    }

    fun lala(className : String) : InputStream? {
        return getResourceAsStream(className)
    }

    open fun calculateCoverage() : Double {
        val f:Field = this.getClass().getDeclaredField("classes")
        f.setAccessible(true)
        val classes : Vector<Class<Any>> = f.get(this) as Vector<Class<Any>>
        return 0.0//CoverageRuntime.calculateCoverage(classes)
    }

}