package org.kevoree.microsandbox.script

import java.io.BufferedWriter
import java.io.FileWriter
import java.io.File
import java.io.InputStream
import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * User: Erwan Daubert - erwan.daubert@gmail.com
 * Date: 10/09/13
 * Time: 19:24
 *
 * @author Erwan Daubert
 * @version 1.0
 */
public trait FileManipulation {

    fun loadFromStream(stream: InputStream): StringBuilder {
        val stringBuilder = StringBuilder()
        var bufferedReader = BufferedReader(InputStreamReader(stream))

        var line = bufferedReader.readLine()
        while (line != null) {
            stringBuilder.append(line)?.append("\n")
            line = bufferedReader.readLine()
        }

        return stringBuilder
    }
    fun save(script: String, path: String) {
        val writer = BufferedWriter(FileWriter(File(path)))
        writer.write(script)
        writer.flush()
        writer.close()
    }
}