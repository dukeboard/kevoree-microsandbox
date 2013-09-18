package org.kevoree.microsandbox.script

import java.io.File
import java.util.Random

/**
 * User: Erwan Daubert - erwan.daubert@gmail.com
 * Date: 10/09/13
 * Time: 19:07
 *
 * @author Erwan Daubert
 * @version 1.0
 */

class ScriptGeneratorSmallFaultyMultipleAdaptations(val kevoreeVersion: String, val kevoreeCoreLibraryVersion: String, val microsandboxVersion: String, val experiementVersion: String) : ScriptGenerator, FileManipulation {

    fun generate(folder: String, headerFile: String, approach: String, suffix: String) {

        val faultyComponents = array(/*"WsServer", "WebbitHTTPServer", "ResourcesPage", "FollowManager", "JavaFXWebBrowser", "WebSocketClientHandler", */"JavaFXVideoDisplay")

        val defaultScript = generateSmall(kevoreeVersion, kevoreeCoreLibraryVersion, microsandboxVersion, experiementVersion, null, headerFile, null)

        faultyComponents.forEach{
            faultyComponent ->

            val folderStorage = File(folder + File.separator + faultyComponent + suffix)
            if ((folderStorage.exists() && folderStorage.isDirectory()) || (!folderStorage.exists() && folderStorage.mkdirs())) {
                appendAdaptationSubmitter("adaptationSubmitter.kevs", "{microsandbox.modelName}", folderStorage.getAbsolutePath() + File.separator + "1.kevs", defaultScript)
                save(defaultScript.toString(), folderStorage.getAbsolutePath() + File.separator + "0.kevs")

                var script = generateSmall(kevoreeVersion, kevoreeCoreLibraryVersion, microsandboxVersion, experiementVersion, faultyComponent, headerFile, suffix)
                appendAdaptationSubmitter("adaptationSubmitter.kevs", "{microsandbox.modelName}", folderStorage.getAbsolutePath() + File.separator + "2.kevs", defaultScript)
                save(script.toString(), folderStorage.getAbsolutePath() + File.separator + "1.kevs")

//                script = generateSmall(kevoreeVersion, kevoreeCoreLibraryVersion, microsandboxVersion, experiementVersion, faultyComponent, headerFile, suffix)
                appendAdaptationSubmitter("adaptationSubmitter.kevs", "{microsandbox.modelName}", folderStorage.getAbsolutePath() + File.separator + "3.kevs", defaultScript)
                updateParameter(script, faultyComponent + suffix)
                save(script.toString(), folderStorage.getAbsolutePath() + File.separator + "2.kevs")

//                script = generateSmall(kevoreeVersion, kevoreeCoreLibraryVersion, microsandboxVersion, experiementVersion, faultyComponent, headerFile, suffix)
                appendAdaptationSubmitter("adaptationSubmitter.kevs", "{microsandbox.modelName}", folderStorage.getAbsolutePath() + File.separator + "4.kevs", defaultScript)
                updateParameter(script, faultyComponent + suffix)
                save(script.toString(), folderStorage.getAbsolutePath() + File.separator + "3.kevs")

//                script = generateSmall(kevoreeVersion, kevoreeCoreLibraryVersion, microsandboxVersion, experiementVersion, faultyComponent, headerFile, suffix)
                appendAdaptationSubmitter("adaptationSubmitter.kevs", "{microsandbox.modelName}", folderStorage.getAbsolutePath() + File.separator + "5.kevs", defaultScript)
                updateParameter(script, faultyComponent + suffix)
                save(script.toString(), folderStorage.getAbsolutePath() + File.separator + "4.kevs")

//                script = generateSmall(kevoreeVersion, kevoreeCoreLibraryVersion, microsandboxVersion, experiementVersion, faultyComponent, headerFile, suffix)
                appendAdaptationSubmitter("adaptationSubmitter.kevs", "{microsandbox.modelName}", folderStorage.getAbsolutePath() + File.separator + "6.kevs", defaultScript)
                updateParameter(script, faultyComponent + suffix)
                save(script.toString(), folderStorage.getAbsolutePath() + File.separator + "5.kevs")

                script = generateSmall(kevoreeVersion, kevoreeCoreLibraryVersion, microsandboxVersion, experiementVersion, faultyComponent, headerFile, suffix)
//                appendAdaptationSubmitter("adaptationSubmitter.kevs", "{microsandbox.modelName}", "none", defaultScript)
                updateParameter(script, faultyComponent + suffix)
                save(script.toString(), folderStorage.getAbsolutePath() + File.separator + "6.kevs")
            }
        }
    }

    private fun appendAdaptationSubmitter(newModelPath: String, oldValue: String, newValue: String, scriptBuilder: StringBuilder) {
        scriptBuilder.append(loadFromStream(javaClass<ScriptGenerator>().getClassLoader()!!.getResourceAsStream(newModelPath)!!).toString())
        replaceValue(oldValue, newValue, scriptBuilder)
    }

    private val parameterLine = "uselessParameter = '"
    private val randomGenerator = Random()

    private fun updateParameter(scriptBuilder: StringBuilder, faultyComponent: String) {
        var position = 0
        var index = 0
        val random = randomGenerator.nextInt(7)
        for (i in 0..random) {
            position = scriptBuilder.indexOf(parameterLine, index)
            index = position + parameterLine.length
        }
        index = scriptBuilder.indexOf("\n", position)
        if (!scriptBuilder.substring(position, index).toLowerCase().contains(faultyComponent)) {
            index = scriptBuilder.indexOf("//", position)
            scriptBuilder.replace(position, index, "uselessParameter = '" + randomGenerator.nextLong() + "'//")
        }
    }
}