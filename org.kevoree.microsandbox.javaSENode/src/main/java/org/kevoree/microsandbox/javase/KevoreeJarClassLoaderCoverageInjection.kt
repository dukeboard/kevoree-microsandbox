package org.kevoree.microsandbox.javase


import org.jacoco.core.analysis.*
import org.jacoco.core.data.ExecutionDataStore
import org.jacoco.core.data.SessionInfoStore
import org.jacoco.core.instr.Instrumenter
import org.jacoco.core.runtime.IRuntime
import org.jacoco.core.runtime.LoggerRuntime
import org.jacoco.core.runtime.RuntimeData
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

    private val runtime : IRuntime? = LoggerRuntime()

    private val instr : Instrumenter? = Instrumenter(runtime)

    private val data : RuntimeData? = RuntimeData()


    KevoreeJarClassLoaderCoverageInjection() {
        runtime?.startup(data)
    }

    override fun internal_defineClass(className: String, bytes: ByteArray): Class<out Any?>? {
        println("Coverage for class : " + className +  " has been solicited :-)")
        val x: ByteArray = instr?.instrument(bytes) ?: ByteArray(0) ;
        return super.internal_defineClass(className, x)
    }

    open fun calculateCoverage() : Double {
        var dataStore : ExecutionDataStore? = ExecutionDataStore()
        var infoStore : SessionInfoStore? = SessionInfoStore()
        data?.collect(dataStore, infoStore, false)
        var coverageBuilder : CoverageBuilder? = CoverageBuilder()
        var analyzer : Analyzer? = Analyzer(dataStore, coverageBuilder)

        val f:Field = this.getClass().getDeclaredField("classes")
        f.setAccessible(true)

        val classes : Vector<Class<Any>> = f.get(this) as Vector<Class<Any>>
        for (clazz in classes) {
            val name : String = clazz.getCanonicalName()?.replace('.', '/') + ".class"
            println("Calculating coverage for : " + name + " from a total of : " + classes.size)
            val a : InputStream? = getResourceAsStream(clazz.getCanonicalName() + ".class")
            analyzer?.analyzeClass(a)
            a?.close()
        }

        var ratioBranch : Double = 0.0
        var ratioInstr : Double = 0.0
        var count : Int = 0
        for (cc : IClassCoverage? in coverageBuilder?.getClasses()!!)
        {
            ratioBranch += (cc?.getBranchCounter()?.getCoveredRatio() as Double)
            ratioInstr += (cc?.getInstructionCounter()?.getCoveredRatio() as Double)
            count ++
        }

        ratioBranch /= count
        ratioInstr /= count

        return (ratioBranch + ratioInstr) / 2

    }

}