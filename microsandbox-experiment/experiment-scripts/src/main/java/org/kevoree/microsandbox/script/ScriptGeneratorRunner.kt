package org.kevoree.microsandbox.script

import java.io.File

/**
 * User: Erwan Daubert - erwan.daubert@gmail.com
 * Date: 10/09/13
 * Time: 19:30
 *
 * @author Erwan Daubert
 * @version 1.0
 */

fun main(args: Array<String>) {

    val kevoreeVersion = "2.0.12"
    val kevoreeCoreLibraryVersion = "2.0.4"
    val microsandboxVersion = "1.0-SNAPSHOT"
    val experimentVersion = "1.0.0-SNAPSHOT"

    val folder = File("/home/inti/microsandbox")
    if (!folder.exists() || (folder.isFile() && folder.delete())) {
        folder.mkdirs()
    }

    var internalFolder = File(folder.getAbsolutePath() + File.separator + "overhead")
    if (!internalFolder.exists() || (internalFolder.isFile() && internalFolder.delete())) {
        internalFolder.mkdirs()
    }
    val smallGenerator = ScriptGeneratorSmallFaulty(kevoreeVersion, kevoreeCoreLibraryVersion, microsandboxVersion, experimentVersion)
    smallGenerator.generate(internalFolder.getAbsolutePath(), "defaultScript.kevs", "Our", "FaultyCPU")
    smallGenerator.generate(internalFolder.getAbsolutePath(), "defaultScriptAllForEver.kevs", "O1", "FaultyCPU")
    smallGenerator.generate(internalFolder.getAbsolutePath(), "defaultScriptAdaptiveWithAll.kevs", "O2", "FaultyCPU")

    smallGenerator.generate(internalFolder.getAbsolutePath(), "defaultScript.kevs", "Our", "FaultyMemory")
    smallGenerator.generate(internalFolder.getAbsolutePath(), "defaultScriptAllForEver.kevs", "O1", "FaultyMemory")
    smallGenerator.generate(internalFolder.getAbsolutePath(), "defaultScriptAdaptiveWithAll.kevs", "O2", "FaultyMemory")

    val templateFile = File(folder.getAbsolutePath() + File.separator + "extra" + File.separator + "FMO1FaultyCPU_dacapo1.kevs")
    Experiment3ScriptGenerator.all_files(
            folder.getAbsolutePath())

    /*internalFolder = File(folder.getAbsolutePath() + File.separator + "multipleViolations")
    if (!internalFolder.exists() || (internalFolder.isFile() && internalFolder.delete())) {
        internalFolder.mkdirs()
    }
    val multipleViolationGenerator = ScriptGeneratorSmallFaultyMultipleViolations(kevoreeVersion, kevoreeCoreLibraryVersion, microsandboxVersion, experimentVersion)
    multipleViolationGenerator.generate(internalFolder.getAbsolutePath(), "defaultScript.kevs", "Our", "FaultyCPU")
    multipleViolationGenerator.generate(internalFolder.getAbsolutePath(), "defaultScriptAllForEver.kevs", "O1", "FaultyCPU")
    multipleViolationGenerator.generate(internalFolder.getAbsolutePath(), "defaultScriptAdaptiveWithAll.kevs", "O2", "FaultyCPU")

    multipleViolationGenerator.generate(internalFolder.getAbsolutePath(), "defaultScript.kevs", "Our", "FaultyMemory")
    multipleViolationGenerator.generate(internalFolder.getAbsolutePath(), "defaultScriptAllForEver.kevs", "O1", "FaultyMemory")
    multipleViolationGenerator.generate(internalFolder.getAbsolutePath(), "defaultScriptAdaptiveWithAll.kevs", "O2", "FaultyMemory")*/

    internalFolder = File(folder.getAbsolutePath() + File.separator + "multipleAdaptations")
    if (!internalFolder.exists() || (internalFolder.isFile() && internalFolder.delete())) {
        internalFolder.mkdirs()
    }
    val multipleAdaptationGenerator = ScriptGeneratorSmallFaultyMultipleAdaptations(kevoreeVersion, kevoreeCoreLibraryVersion, microsandboxVersion, experimentVersion)
    multipleAdaptationGenerator.generate(internalFolder.getAbsolutePath(), "defaultScript.kevs", "Our", "FaultyCPU")
    multipleAdaptationGenerator.generate(internalFolder.getAbsolutePath(), "defaultScriptAllForEver.kevs", "O1", "FaultyCPU")
    multipleAdaptationGenerator.generate(internalFolder.getAbsolutePath(), "defaultScriptAdaptiveWithAll.kevs", "O2", "FaultyCPU")

    multipleAdaptationGenerator.generate(internalFolder.getAbsolutePath(), "defaultScript.kevs", "Our", "FaultyMemory")
    multipleAdaptationGenerator.generate(internalFolder.getAbsolutePath(), "defaultScriptAllForEver.kevs", "O1", "FaultyMemory")
    multipleAdaptationGenerator.generate(internalFolder.getAbsolutePath(), "defaultScriptAdaptiveWithAll.kevs", "O2", "FaultyMemory")
}