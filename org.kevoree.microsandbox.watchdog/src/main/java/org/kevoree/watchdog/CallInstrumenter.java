package org.kevoree.watchdog;

import org.kevoree.watchdog.child.jvm.LocateRuntimeJar;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created with IntelliJ IDEA.
 * User: duke
 * Date: 04/07/13
 * Time: 11:02
 */
public class CallInstrumenter {

    public static void createRTIntrumentedJar(File target) {
        try {
            File instrumenterJar = copyToTemp(CallInstrumenter.class.getClassLoader().getResourceAsStream("jarInstrumenter.jar"));
            URL[] urls = new URL[1];
            urls[0] = new URL("file:///" + instrumenterJar.getAbsolutePath());
            URLClassLoader cl = new URLClassLoader(urls);
            Class mainClazz = cl.loadClass("org.kevoree.microsandbox.jarInstrument.Main");
            String rtJar = LocateRuntimeJar.locateRuntimeJar().getAbsolutePath();
            Method mainM = mainClazz.getMethod("main", String[].class);
            String[] args = new String[3];
            args[0] = rtJar;
            args[1] = target.getCanonicalPath();
            args[2] = "true";
            mainM.invoke(null, (Object) args);
            instrumenterJar.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static File copyToTemp(InputStream is) throws IOException {
        File tempFile = File.createTempFile("jarInstrumentJar", ".jar");
        FileOutputStream fos = new FileOutputStream(tempFile);
        byte data[] = new byte[1024];
        int count;
        while ((count = is.read(data, 0, 1024)) != -1) {
            fos.write(data, 0, count);
        }
        is.close();
        fos.close();
        return tempFile;
    }


}
