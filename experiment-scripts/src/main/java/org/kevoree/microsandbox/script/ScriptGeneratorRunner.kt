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

fun main(args : Array<String>) {
    val folder = File("/home/inti/microsandbox")
    if (!folder.exists() || (folder.isFile() && folder.delete())) {
        folder.mkdirs()
    }

    ScriptGeneratorSmallFaulty().generate(folder.getAbsolutePath(),
            "defaultScript.kevs","Our", "FaultyCPU")
    ScriptGeneratorSmallFaulty().generate(folder.getAbsolutePath(),
            "defaultScriptAllForEver.kevs","O1", "FaultyCPU")
    ScriptGeneratorSmallFaulty().generate(folder.getAbsolutePath(),
            "defaultScriptAdaptiveWithAll.kevs", "O2", "FaultyCPU")

    ScriptGeneratorSmallFaulty().generate(folder.getAbsolutePath(),"defaultScript.kevs","Our", "FaultyMemory")
    ScriptGeneratorSmallFaulty().generate(folder.getAbsolutePath(),"defaultScriptAllForEver.kevs","O1", "FaultyMemory")
    ScriptGeneratorSmallFaulty().generate(folder.getAbsolutePath(),"defaultScriptAdaptiveWithAll.kevs","O2", "FaultyMemory")
}