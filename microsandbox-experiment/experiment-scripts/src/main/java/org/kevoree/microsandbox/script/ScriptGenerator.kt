package org.kevoree.microsandbox.script

import java.io.InputStream
import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * User: Erwan Daubert - erwan.daubert@gmail.com
 * Date: 10/09/13
 * Time: 17:57
 *
 * @author Erwan Daubert
 * @version 1.0
 */
trait ScriptGenerator : FileManipulation {
    fun generateSmall(kevoreeVersion: String, kevoreCoreLibraryVersion: String, microsandboxVersion: String, experimentVersion: String,
                 faultyComponentName: String?, headerFile: String, faultyComponentSuffix: String?): StringBuilder {

        // load default script
        val scriptBuilder = loadFromStream(javaClass<ScriptGenerator>().getClassLoader()!!.getResourceAsStream(headerFile)!!)

        // load small script
        scriptBuilder.append(loadFromStream(javaClass<ScriptGenerator>().getClassLoader()!!.getResourceAsStream("smallScript.kevs")!!).toString())

        /*if (!kevoreeVersion.equals("")) {
            var index = 0
            index = scriptBuilder.indexOf("{kevoree.version}", index)
            while (index < scriptBuilder.length() && index >= 0) {
                scriptBuilder.replace(index, index + "{kevoree.version}".length(), kevoreeVersion)
                index = scriptBuilder.indexOf("{kevoree.version}", index + kevoreeVersion.length())
            }
        }*/
        replaceValue("{kevoree.version}", kevoreeVersion, scriptBuilder)

        /*if (!kevoreCoreLibraryVersion.equals("")) {
            var index = 0
            index = scriptBuilder.indexOf("{kevoree.corelibrary.version}", index)
            while (index < scriptBuilder.length() && index >= 0) {
                scriptBuilder.replace(index, index + "{kevoree.corelibrary.version}".length(), kevoreCoreLibraryVersion)
                index = scriptBuilder.indexOf("{kevoree.corelibrary.version}", index + kevoreCoreLibraryVersion.length())
            }
        }*/
        replaceValue("{kevoree.corelibrary.version}", kevoreCoreLibraryVersion, scriptBuilder)

        /*if (!microsandboxVersion.equals("")) {
            var index = 0
            index = scriptBuilder.indexOf("{kevoree.microsandbox.version}", index)
            while (index < scriptBuilder.length() && index >= 0) {
                scriptBuilder.replace(index, index + "{kevoree.microsandbox.version}".length(), microsandboxVersion)
                index = scriptBuilder.indexOf("{kevoree.microsandbox.version}", index + microsandboxVersion.length())
            }
        }*/
        replaceValue("{kevoree.microsandbox.version}", microsandboxVersion, scriptBuilder)

        /*if (!experimentVersion.equals("")) {
            var index = 0
            index = scriptBuilder.indexOf("{experiment.version}", index)
            while (index < scriptBuilder.length() && index >= 0) {
                scriptBuilder.replace(index, index + "{experiment.version}".length(), experimentVersion)
                index = scriptBuilder.indexOf("{experiment.version}", index + experimentVersion.length())
            }
        }*/
        replaceValue("{experiment.version}", experimentVersion, scriptBuilder)

        /*if (faultyComponentName != null && !faultyComponentName.equals("") && faultyComponentSuffix != null) {
            var index = 0
            index = scriptBuilder.indexOf(faultyComponentName, index)
            while (index < scriptBuilder.length() && index >= 0) {
                scriptBuilder.replace(index, index + faultyComponentName.length(), faultyComponentName + faultyComponentSuffix)
                index = scriptBuilder.indexOf(faultyComponentName, index + (faultyComponentName + faultyComponentSuffix).length())
            }
        }*/
        replaceValue(faultyComponentName, faultyComponentName + faultyComponentSuffix, scriptBuilder)

        return scriptBuilder;
    }

    fun replaceValue(oldValue : String?, newValue : String?, scriptBuilder : StringBuilder) {
        if (oldValue != null && !oldValue.equals("") && newValue != null) {
            var index = 0
            index = scriptBuilder.indexOf(oldValue, index)
            while (index < scriptBuilder.length() && index >= 0) {
                scriptBuilder.replace(index, index + oldValue.length(), newValue)
                index = scriptBuilder.indexOf(oldValue, index + newValue.length())
            }
        }
    }
}