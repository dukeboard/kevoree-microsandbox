package org.kevoree.microsandbox.core

import org.jacoco.core.analysis.*
import org.jacoco.core.data.ExecutionDataStore
import org.jacoco.core.data.SessionInfoStore
import org.jacoco.core.instr.Instrumenter
import org.jacoco.core.runtime.IRuntime
import org.jacoco.core.runtime.LoggerRuntime
import org.jacoco.core.runtime.RuntimeData
import java.util.Vector
import java.io.InputStream

import org.kevoree.microsandbox.core.KevoreeJarClassLoaderCoverageInjection

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 6/25/13
 * Time: 3:26 PM
 * To change this template use File | Settings | File Templates.
 */
object CoverageRuntime {

    private val runtime : IRuntime? = LoggerRuntime()
    private val instr : Instrumenter? = Instrumenter(runtime)
    private val data : RuntimeData? = RuntimeData()

    private var parent : KevoreeJarClassLoaderCoverageInjection? = null;

    fun init(p: KevoreeJarClassLoaderCoverageInjection): Unit {
        if (parent != null) {
            parent = p
            runtime?.startup(data)
        }
    }

    fun instrument(bytes : ByteArray?) : ByteArray {
        return instr?.instrument(bytes) ?: ByteArray(0)
    }

    fun calculateCoverage(classes : Vector<Class<Any>>) : Double {
        var dataStore : ExecutionDataStore? = ExecutionDataStore()
        var infoStore : SessionInfoStore? = SessionInfoStore()
        data?.collect(dataStore, infoStore, false)
        var coverageBuilder : CoverageBuilder? = CoverageBuilder()
        var analyzer : Analyzer? = Analyzer(dataStore, coverageBuilder)

        for (clazz in classes) {
            val name : String = clazz.getCanonicalName()?.replace('.', '/') + ".class"
            println("Calculating coverage for : " + name + " from a total of : " + classes.size)
            val a : InputStream? = parent?.lala(clazz.getCanonicalName() + ".class")
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