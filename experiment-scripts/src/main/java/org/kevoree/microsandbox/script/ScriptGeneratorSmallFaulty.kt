package org.kevoree.microsandbox.script

import java.io.BufferedWriter
import java.io.FileWriter
import java.io.File

/**
 * User: Erwan Daubert - erwan.daubert@gmail.com
 * Date: 10/09/13
 * Time: 19:07
 *
 * @author Erwan Daubert
 * @version 1.0
 */

class ScriptGeneratorSmallFaulty : FileManipulation {

    fun generate(folder : String, headerFile : String, approach:String, suffix : String) {
        val scriptGenerator = ScriptGenerator()

        var faultyComponent = "WsServer"
        var  script = scriptGenerator.generate(true, "2.0.12", "2.0.4", "1.0-SNAPSHOT", "1.0.0-SNAPSHOT", faultyComponent, headerFile, suffix)
        save(script, folder + File.separator  + faultyComponent + approach+ suffix + ".kevs")

        faultyComponent = "WebbitHTTPServer"
        script = scriptGenerator.generate(true, "2.0.12", "2.0.4", "1.0-SNAPSHOT", "1.0.0-SNAPSHOT", faultyComponent, headerFile, suffix)
        save(script, folder + File.separator  + faultyComponent + approach+ suffix + ".kevs")

        faultyComponent = "ResourcesPage"
        script = scriptGenerator.generate(true, "2.0.12", "2.0.4", "1.0-SNAPSHOT", "1.0.0-SNAPSHOT", faultyComponent, headerFile, suffix)
        save(script, folder + File.separator  + faultyComponent + approach+ suffix + ".kevs")

        faultyComponent = "FollowManager"
        script = scriptGenerator.generate(true, "2.0.12", "2.0.4", "1.0-SNAPSHOT", "1.0.0-SNAPSHOT", faultyComponent, headerFile, suffix)
        save(script, folder + File.separator  + faultyComponent + approach+ suffix + ".kevs")

        faultyComponent = "JavaFXWebBrowser"
        script = scriptGenerator.generate(true, "2.0.12", "2.0.4", "1.0-SNAPSHOT", "1.0.0-SNAPSHOT", faultyComponent, headerFile, suffix)
        save(script, folder + File.separator  + faultyComponent + approach+ suffix + ".kevs")

        faultyComponent = "WebSocketClientHandler"
        script = scriptGenerator.generate(true, "2.0.12", "2.0.4", "1.0-SNAPSHOT", "1.0.0-SNAPSHOT", faultyComponent, headerFile, suffix)
        save(script, folder + File.separator  + faultyComponent + approach+ suffix + ".kevs")

        faultyComponent = "JavaFXVideoDisplay"
        script = scriptGenerator.generate(true, "2.0.12", "2.0.4", "1.0-SNAPSHOT", "1.0.0-SNAPSHOT", faultyComponent, headerFile, suffix)
        save(script, folder + File.separator + faultyComponent + approach + suffix + ".kevs")
    }
}