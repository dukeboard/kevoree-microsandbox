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
import java.lang.reflect.Field
import java.lang.reflect.Method

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 6/25/13
 * Time: 3:26 PM
 *
 */
object CoverageRuntime {

    private val runtime : IRuntime? = LoggerRuntime()
    private val instr : Instrumenter? = Instrumenter(runtime)
    private val data : RuntimeData? = RuntimeData()

    private var b : Boolean = false;

    fun init(): Unit {
        if (!b) {
            b = true
            runtime?.startup(data)
        }
    }

    fun instrument(bytes : ByteArray?) : ByteArray {
        return instr?.instrument(bytes) ?: ByteArray(0)
    }

    private fun calculateCoverage(classes : Vector<String>?,
                                  loader : ClassLoader) : Double {

        var dataStore : ExecutionDataStore? = ExecutionDataStore()
        var infoStore : SessionInfoStore? = SessionInfoStore()
        data?.collect(dataStore, infoStore, false)
        var coverageBuilder : CoverageBuilder? = CoverageBuilder()
        var analyzer : Analyzer? = Analyzer(dataStore, coverageBuilder)

        for (clazz in classes!!) {
            val name : String = clazz.replace('.', '/') + ".class"
            val a : InputStream? = lala(loader, name)
            analyzer?.analyzeClass(a)
            a?.close()
        }

        var ratioBranch : Double = 0.0
        var ratioInstr : Double = 0.0
        var branchCount : Int = 0
        var instrCount : Int = 0
        for (cc : IClassCoverage? in coverageBuilder?.getClasses()!!)
        {
            ratioBranch += (cc?.getBranchCounter()?.getCoveredCount() as Int)
            ratioInstr += (cc?.getInstructionCounter()?.getCoveredCount() as Int)
            branchCount += (cc?.getBranchCounter()?.getTotalCount() as Int)
            instrCount += (cc?.getInstructionCounter()?.getTotalCount() as Int)
        }

        ratioBranch /= branchCount
        ratioInstr /= instrCount

        return (ratioBranch + ratioInstr) / 2
    }

    private fun lala(loader : ClassLoader, className : String) : InputStream? {
        return loader.getResourceAsStream(className)
    }

    open fun calculateCoverage(loader : ClassLoader) : Double {
        if (loader == null)
            return 2.0

        var f : Method?
        try {
            f = loader.getClass().getDeclaredMethod("getLoadedClasses")
        }
        catch (ex : NoSuchMethodException) { return 3.0 }

        val classes : Vector<String>? = f?.invoke(loader) as? Vector<String>
        return CoverageRuntime.calculateCoverage(classes, loader)
    }
}