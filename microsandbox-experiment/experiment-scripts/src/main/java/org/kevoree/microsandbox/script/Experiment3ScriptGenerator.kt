package org.kevoree.microsandbox.script

import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.PrintWriter
import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 9/24/13
 * Time: 4:29 PM
 * To change this template use File | Settings | File Templates.
 */
public object Experiment3ScriptGenerator {
    fun all_files(dstFilePatternName : String): Unit {
        val file = "templateForExperiment3.kevs"
        val stream = javaClass<ScriptGenerator>().getClassLoader()!!.getResourceAsStream(file)!!
        val reader = BufferedReader(InputStreamReader(stream))
        var s = ""

        var line = reader.readLine()
        while (line != null) {
            s += line + "\n"
            line = reader.readLine()
        }

        reader.close()
        val a = Array<Int>(6 , {i -> Math.pow(2.0, i + 2.0).toInt() })
        val rootE3 = dstFilePatternName + File.separator + "e3"
        File(rootE3).mkdir()
        for (i in a) {
            val setE3 = rootE3 + File.separator + i
            File(setE3).mkdir()
            generate(s, setE3 + File.separator, i)
        }
    }
    private fun generate(template : String, dstFilePatternName : String, nbExtra : Int): Unit {
        val files = array(dstFilePatternName + "all-components" + ".kevs",
                            dstFilePatternName + "random" + ".kevs",
                            dstFilePatternName + "number_of_failures" + ".kevs",
                            dstFilePatternName + "inv_number_of_failures" + ".kevs"
                         )
        val finedGrainedStrategies = array("all-components", "single-monitoring", "single-monitoring", "single-monitoring")
        val rankingFunctions = array("number_of_failures", "random_order", "number_of_failures", "inv_number_of_failures")
        val code = generateExtraCode(nbExtra)
        for (i in 0 .. finedGrainedStrategies.size) {
            createFile(template, code, rankingFunctions[i], finedGrainedStrategies[i], files[i])
        }
    }

    private fun createFile(template: String, code: String, rankingF : String,finedGrainedStrategy : String,  filename : String) {
        val s = template.replaceFirst("\\{ranking.function\\}",
                rankingF).replaceFirst("\\{fine.grained.strategy\\}", finedGrainedStrategy)
        val oStream = FileOutputStream(filename)
        try {
            // first the template
            oStream.write(s.toByteArray())
            oStream.write(code.toByteArray())
        }
        finally {
            oStream.close()
        }
    }

    private fun generateExtraCode(nbExtra : Int): String {
        var r = "\n\nmerge 'mvn:org.kevoree.microsandbox.experiment/contracted-fake-console/1.0.0-SNAPSHOT'\n"
        r += "merge 'mvn:org.kevoree.microsandbox.experiment/number-generator/1.0.0-SNAPSHOT'\n"
        for (i in 1 .. nbExtra) {
            r += "addComponent ContractedConsole$i@node0:ContractedFakeConsole { memory_max_size ='4000', cpu_wall_time ='5000' }\n"
        }
        r += "addComponent numberGenerator_fancy@node0 : NumberGenerator {}\n"
        r += "addChannel cInitial : defMSG\n"
        r += "bind numberGenerator_fancy.output@node0 => cInitial\n"
        r += "bind ContractedConsole1.input@node0 => cInitial\n"

        for (i in 2 .. nbExtra) {
            r += "addChannel c${i-1}To${i} : defMSG\n"
            r += "bind ContractedConsole${i-1}.output@node0 => c${i-1}To${i}\n" +
                    "bind ContractedConsole${i}.input@node0 => c${i-1}To${i}\n"
        }
        return r;
    }
}