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
class ScriptGenerator : FileManipulation {
    fun generate(small : Boolean = true, kevoreeVersion : String, kevoreCoreLibraryVersion : String, microsandboxVersion : String, experimentVersion : String, faultyComponentName : String, headerFile : String, faultyComponentSuffix : String): String {

        /*// test if we want a small configuration
        var small = true
        if (args.find { arg -> arg.equalsIgnoreCase("-big") } != null) {
            small = true
        }

        // get the kevoree version
        val kevoreeVersionArg = args.find { arg -> arg.toLowerCase().startsWith("-kevoree-version=") }
        var kevoreeVersion = ""
        if (kevoreeVersionArg != null) {
            kevoreeVersion = kevoreeVersionArg.substring("-kevoree-version=".length())
        }

        // get the experiment version
        val kevoreeCorelibVersionArg = args.find { arg -> arg.toLowerCase().startsWith("-kevoree-corelibrary-version=") }
        var kevoreeCorelibVersion = ""
        if (kevoreeCorelibVersionArg != null) {
            kevoreeCorelibVersion = kevoreeCorelibVersionArg.substring("-kevoree-corelibrary-version=".length())
        }

        // get the experiment version
        val experimentVersionArg = args.find { arg -> arg.toLowerCase().startsWith("-experiment-version=") }
        var experimentVersion = ""
        if (experimentVersionArg != null) {
            experimentVersion = experimentVersionArg.substring("-experiment-version=".length())
        }

        // get the faulty component
        val faultyComponentArg = args.find { arg -> arg.toLowerCase().startsWith("-faulty-component=") }
        var faultyComponent = ""
        var componentSuffix = ""
        if (faultyComponentArg != null) {
            faultyComponent = faultyComponentArg.substring("-faulty-component=".length())

            // get the component suffix
            val componentSuffixArg = args.find { arg -> arg.toLowerCase().startsWith("-component-suffix=") }
            if (componentSuffixArg != null) {
                componentSuffix = componentSuffixArg.substring("-component-suffix=".length())
            } else {
                System.err.println("The -faulty-component must be used with -component-suffix")
                System.exit(-1);
            }
        }*/



        // load default script
        val scriptBuilder = loadFromStream(javaClass<ScriptGenerator>().getClassLoader()!!.getResourceAsStream(headerFile)!!)

        if (small) {
            // load small script
            scriptBuilder.append(loadFromStream(javaClass<ScriptGenerator>().getClassLoader()!!.getResourceAsStream("smallScript.kevs")!!).toString())
        } else {
            // TODO
        }

        if (!kevoreeVersion.equals("")) {
            var index = 0
            index = scriptBuilder.indexOf("{kevoree.version}", index)
            while (index < scriptBuilder.length() && index >= 0) {
                scriptBuilder.replace(index, index + "{kevoree.version}".length(), kevoreeVersion)
                index = scriptBuilder.indexOf("{kevoree.version}", index + kevoreeVersion.length())
            }
        }

        if (!kevoreCoreLibraryVersion.equals("")) {
            var index = 0
            index = scriptBuilder.indexOf("{kevoree.corelibrary.version}", index)
            while (index < scriptBuilder.length() && index >= 0) {
                scriptBuilder.replace(index, index + "{kevoree.corelibrary.version}".length(), kevoreCoreLibraryVersion)
                index = scriptBuilder.indexOf("{kevoree.corelibrary.version}", index + kevoreCoreLibraryVersion.length())
            }
        }

        if (!microsandboxVersion.equals("")) {
            var index = 0
            index = scriptBuilder.indexOf("{kevoree.microsandbox.version}", index)
            while (index < scriptBuilder.length() && index >= 0) {
                scriptBuilder.replace(index, index + "{kevoree.microsandbox.version}".length(), microsandboxVersion)
                index = scriptBuilder.indexOf("{kevoree.microsandbox.version}", index + microsandboxVersion.length())
            }
        }

        if (!experimentVersion.equals("")) {
            var index = 0
            index = scriptBuilder.indexOf("{experiment.version}", index)
            while (index < scriptBuilder.length() && index >= 0) {
                scriptBuilder.replace(index, index + "{experiment.version}".length(), experimentVersion)
                index = scriptBuilder.indexOf("{experiment.version}", index + experimentVersion.length())
            }
        }

        if (!faultyComponentName.equals("")) {
            var index = 0
            index = scriptBuilder.indexOf(faultyComponentName, index)
            while (index < scriptBuilder.length() && index >= 0) {
                scriptBuilder.replace(index, index + faultyComponentName.length(), faultyComponentName + faultyComponentSuffix)
                index = scriptBuilder.indexOf(faultyComponentName, index + (faultyComponentName + faultyComponentSuffix).length())
            }
        }

        return scriptBuilder.toString();
    }
}