package org.kevoree.watchdog;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.jar.JarOutputStream;
import java.util.zip.ZipEntry;

/**
 * Created by duke on 16/05/13.
 */
public class RuntimeDowloader {

    private String getTempPath() {
        String tempPath = System.getProperty("java.io.tmpdir");
        if (!tempPath.endsWith(File.separator)) {
            tempPath = tempPath + File.separator;
        }
        return tempPath;
    }

    public File get(String runtimeURL, String version) throws IOException {
        File runtimeFile = getCache(runtimeURL, version);
        if (!runtimeFile.exists()) {
            URL url = new URL(runtimeURL);
            System.out.println("Runtime not found, downloading it...");

            if (System.getProperty("java.vm.vendor").toLowerCase().contains("robovm")) {
                InputStream in = url.openStream();
                FileOutputStream fos = new FileOutputStream(runtimeFile);
                byte data[] = new byte[1024];
                int count;
                while ((count = in.read(data, 0, 1024)) != -1) {
                    fos.write(data, 0, count);
                }
                in.close();
                fos.close();
            } else {
                ReadableByteChannel rbc = Channels.newChannel(url.openStream());
                FileOutputStream fos = new FileOutputStream(runtimeFile);
                fos.getChannel().transferFrom(rbc, 0, 1 << 24);
                fos.close();
            }
        }
        return runtimeFile;
    }

    public File getCache(String runtimeURL, String version) {
        String tempPath = getTempPath();
        File runtimeFile = new File(tempPath + File.separator + "kevoree-runtime-" + version + ".jar");
        return runtimeFile;
    }

    public File getExtRTJar() {
        String tempPath = getTempPath();
        File runtimeFile = new File(tempPath + File.separator + "ext-rt.jar");
        if (!runtimeFile.exists()) {
            System.out.print("Extended JDK jar not found ... building it ....");
            CallInstrumenter.createRTIntrumentedJar(runtimeFile);
            System.out.println("Done");
        }
        System.out.println("Extended JAR  : " + runtimeFile.getAbsoluteFile());
        return runtimeFile;
    }

    public File getExtAgent() {
        String tempPath = getTempPath();
        File agentFile = new File(tempPath + File.separator + "ext-agent" + Version.VERSION + ".jar");
        try {
            if (!agentFile.exists() || Version.VERSION.contains("SNAPSHOT")) {
                FileOutputStream fos = new FileOutputStream(agentFile);
                InputStream is = this.getClass().getClassLoader().getResourceAsStream("resourceMonitorJavaAgent.jar");
                byte data[] = new byte[1024];
                int count;
                while ((count = is.read(data, 0, 1024)) != -1) {
                    fos.write(data, 0, count);
                }
                is.close();
                fos.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return agentFile;
    }

    public File getSharedResourceAccounting() {
        String tempPath = getTempPath();
        File agentFile = new File(tempPath + File.separator + "shared-res-" + Version.VERSION + ".jar");
        try {
            if (!agentFile.exists() || Version.VERSION.contains("SNAPSHOT")) {
                FileOutputStream fos = new FileOutputStream(agentFile);
                InputStream is = this.getClass().getClassLoader().getResourceAsStream("sharedResourceAccounting.jar");
                byte data[] = new byte[1024];
                int count;
                while ((count = is.read(data, 0, 1024)) != -1) {
                    fos.write(data, 0, count);
                }
                is.close();
                fos.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return agentFile;
    }

    public File getSharedChildClassJar() {
        String tempPath = getTempPath();
        File agentFile = new File(tempPath + File.separator + "shared-childjvm-" + Version.VERSION + ".jar");
        try {
            if (!agentFile.exists() || Version.VERSION.contains("SNAPSHOT")) {
                FileOutputStream fos = new FileOutputStream(agentFile);
                JarOutputStream jarOut = new JarOutputStream(fos);

                String[] files = new String[]{"org/kevoree/watchdog/child/watchdog/ChildRunner.class", "org/kevoree/watchdog/child/watchdog/WatchdogClient.class"};
                for (int i = 0; i < files.length; i++) {
                    String file = files[i];
                    jarOut.putNextEntry(new ZipEntry(file));
                    InputStream is = this.getClass().getClassLoader().getResourceAsStream(file);
                    byte data[] = new byte[1024];
                    int count;
                    while ((count = is.read(data, 0, 1024)) != -1) {
                        jarOut.write(data, 0, count);
                    }
                    jarOut.closeEntry();
                    is.close();
                }

                jarOut.close();
                fos.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return agentFile;
    }


}
