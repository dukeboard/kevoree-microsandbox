package org.kevoree.microsandbox.cgroupNode;

import org.kevoree.kcl.KevoreeJarClassLoader;
import org.kevoree.tools.aether.framework.KCLFactory;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 2/6/14
 * Time: 2:17 PM
 *
 */
public class SharedKCLFactory implements KCLFactory {
    private final boolean useShared;
    private final String nodeName;

    public SharedKCLFactory(String name, boolean shared) {
        this.nodeName = name;
        useShared = shared;
    }

    @Override
    public KevoreeJarClassLoader createClassLoader() {
//        InterprocessLock lll = new InterprocessLock("llllllllll".getBytes(), false);
//        System.err.println("New classloader created");
        return new SharedClassLoader(nodeName, useShared);
    }
}
