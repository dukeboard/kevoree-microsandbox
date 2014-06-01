package org.kevoree.microsandbox.cgroupNode.components;

import org.kevoree.log.Log;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by inti on 3/11/14.
 */
class PROCESSBasedStrategy implements SlaveRuntimeDeployer {

    @Override
    public boolean deploy(String nodeName, String fileName) {
        try {
            String jarPath = Log.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
            String path = jarPath.substring(0,jarPath.lastIndexOf("/") + 1);
            ProcessBuilder builder = new ProcessBuilder("java",
                    "-Dproject.version=" + System.getProperty("project.version"),
                    "-Dkevoree.corelibrary.version=" + System.getProperty("kevoree.corelibrary.version"),
                    "-Dinterproccess.lock.library="+System.getProperty("interproccess.lock.library"),
                    "-Dthread.control.library="+System.getProperty("thread.control.library"),
                    "-Dnode.bootstrap="+fileName,
                    "-Xbootclasspath/p:"+ path +"ext-rt.jar:"
                            + path + "shared-res-1.1.jar",
                    "-javaagent:" + path + "ext-agent1.1.jar",
                    String.format("-Dnode.name=%s", nodeName),
                    "-jar",
                    jarPath);

            if (!Files.exists(Paths.get(nodeName))) {
                Files.createDirectory(Paths.get(nodeName));
            }
            builder = builder.directory(new File(nodeName));
            Process process = builder.
                    redirectOutput(ProcessBuilder.Redirect.INHERIT).
                    redirectError(ProcessBuilder.Redirect.INHERIT).start();

            return true;
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
