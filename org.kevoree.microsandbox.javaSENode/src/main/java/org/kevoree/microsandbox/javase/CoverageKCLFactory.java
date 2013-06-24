package org.kevoree.microsandbox.javase;

import org.kevoree.kcl.KevoreeJarClassLoader;
import org.kevoree.kcl.KevoreeJarClassLoaderCoverageInjection;
import org.kevoree.tools.aether.framework.KCLFactory;

/**
 * Created by duke on 24/06/13.
 */
public class CoverageKCLFactory implements KCLFactory {
    @Override
    public KevoreeJarClassLoader createClassLoader() {
        return new KevoreeJarClassLoaderCoverageInjection();
    }
}
