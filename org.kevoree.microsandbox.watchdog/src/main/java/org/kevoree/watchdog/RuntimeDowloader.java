package org.kevoree.watchdog;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
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
//        if (!runtimeFile.exists()) {
            System.out.print("Extended JDK jar not found ... building it ....");
            CallInstrumenter.createRTIntrumentedJar(runtimeFile);
            System.out.println("Done");
//        }
        System.out.println("Extended JAR  : " + runtimeFile.getAbsoluteFile());
        return runtimeFile;
    }

    public File getExtAgent() {
        return createFileFromResource(this.getClass().getClassLoader(),
                "resourceMonitorJavaAgent.jar",
                "ext-agent" + Version.VERSION + ".jar"
                );
    }

    private File getHeapAnalysis() {
        return createFileFromResource(this.getClass().getClassLoader(),"heapanalysis.jar");
    }

    public File getHeapExplorerLibrary() {
        File heapAnalysis_file = getHeapAnalysis();
        try {
            URL url = heapAnalysis_file.toURL();
            URLClassLoader urlClassLoader = URLClassLoader.newInstance(new URL[]{
                    url
            });
            File agentFile = createFileFromResource(urlClassLoader, "libheapViewer.so");

            // extract config.ini and all the plugins
            File configFile = createFileFromResource(urlClassLoader, "config.ini");
            File lib_directory = new File(getTempPath() + File.separator + "lib");
            lib_directory.mkdir();

            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(configFile)));
            String line = reader.readLine();
            ArrayList<String> l = new ArrayList<String>();
            while (line != null) {
                l.add(getTempPath() + line);
                createFileFromResource(urlClassLoader, line);
                line = reader.readLine();
            }
            reader.close(); // this is wrong

            PrintWriter printWriter = new PrintWriter(configFile);
            for (String s : l)
                printWriter.println(s);
            printWriter.close(); // wrong again

            return agentFile;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private File createFileFromResource(ClassLoader classLoader, String resourceName) {
        return createFileFromResource(classLoader, resourceName, resourceName);
    }

    public File getSharedResourceAccounting() {
        return createFileFromResource(this.getClass().getClassLoader(),
                "sharedResourceAccounting.jar",
                "shared-res-" + Version.VERSION + ".jar"
                );
    }

    public File getSharedChildClassJar() {

        String tempPath = getTempPath();
        File agentFile = new File(tempPath + File.separator + "shared-childjvm-" + Version.VERSION + ".jar");
        try {
//            if (!agentFile.exists() || Version.VERSION.contains("SNAPSHOT")) {
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
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return agentFile;
    }


    private File createFileFromResource(ClassLoader classLoader, String resourceName, String outputName) {
        String tempPath = getTempPath();
        File file = new File(tempPath + File.separator + outputName);
        try {
//            if (!file.exists() || Version.VERSION.contains("SNAPSHOT")) {
                FileOutputStream fos = new FileOutputStream(file);
                InputStream is = classLoader.getResourceAsStream(resourceName);
                byte data[] = new byte[1024];
                int count;
                while ((count = is.read(data, 0, 1024)) != -1) {
                    fos.write(data, 0, count);
                }
                is.close();
                fos.close();
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return file;
    }
}
