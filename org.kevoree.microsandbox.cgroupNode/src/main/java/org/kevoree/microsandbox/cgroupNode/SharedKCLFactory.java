package org.kevoree.microsandbox.cgroupNode;

import org.kevoree.DeployUnit;
//import org.kevoree.bootstrap.kernel.KevoreeCLFactory;
import org.kevoree.kcl.api.FlexyClassLoader;
import org.kevoree.log.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 2/6/14
 * Time: 2:17 PM
 *
 */
public class SharedKCLFactory // implements KevoreeCLFactory
{
    private final boolean useShared;
    private final String nodeName;

    public SharedKCLFactory(String name, boolean shared) {
        this.nodeName = name;
        useShared = shared;
    }

//    @Override
    public FlexyClassLoader createClassLoader(DeployUnit deployUnit, File file) {
        Log.info("USING OR AT LEAST CALLING THE CLASSLOADER FACTORY");
        System.out.println("USING OR AT LEAST CALLING THE CLASSLOADER FACTORY");
        System.err.println("USING OR AT LEAST CALLING THE CLASSLOADER FACTORY");
//        InterprocessLock lll = new InterprocessLock("llllllllll".getBytes(), false);
//        System.err.println("New classloader created");
        FlexyClassLoader classLoader = new SharedClassLoader(nodeName, useShared);
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
