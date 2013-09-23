package org.kevoree.microsandbox.script

import java.io.File

/**
 * User: Erwan Daubert - erwan.daubert@gmail.com
 * Date: 10/09/13
 * Time: 19:07
 *
 * @author Erwan Daubert
 * @version 1.0
 */

class ScriptGeneratorSmallFaulty(val kevoreeVersion : String, val kevoreeCoreLibraryVersion : String, val microsandboxVersion : String, val experiementVersion : String) : ScriptGenerator, FileManipulation {

    fun generate(folder : String, headerFile : String, approach:String, suffix : String) {

        val faultyComponents = array("WsServer", "WebbitHTTPServer", "ResourcesPage", "FollowManager", "JavaFXWebBrowser", "WebSocketClientHandler", "JavaFXVideoDisplay")

        faultyComponents.forEach{
            faultyComponent ->
            var  script = generateSmall(kevoreeVersion, kevoreeCoreLibraryVersion, microsandboxVersion, experiementVersion, faultyComponent, headerFile, suffix)
            save(script.toString(), folder + File.separator  + faultyComponent + approach+ suffix + ".kevs")
        }
    }
}