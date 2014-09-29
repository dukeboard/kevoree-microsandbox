package org.kevoree.microsandbox.javase;

import org.kevoree.DeployUnit;
//import org.kevoree.bootstrap.kernel.KevoreeCLFactory;
import org.kevoree.kcl.api.FlexyClassLoader;
import org.kevoree.log.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by duke on 24/06/13.
 */
public class CoverageKCLFactory /*implements KevoreeCLFactory*/ {

//    @Override
    public FlexyClassLoader createClassLoader(DeployUnit deployUnit, File file) {
        FlexyClassLoader classLoader = new KevoreeJarClassLoaderCoverageInjection();
        classLoader.setKey(deployUnit.path());
        try {
            classLoader.load(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            Log.error("Error while opening JAR {} : ", file.getAbsolutePath());
        } finally {
            return classLoader;
        }
    }
}
