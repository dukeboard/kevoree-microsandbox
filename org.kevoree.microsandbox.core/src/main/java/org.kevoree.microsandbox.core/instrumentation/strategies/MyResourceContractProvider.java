package org.kevoree.microsandbox.core.instrumentation.strategies;

import org.resourceaccounting.contract.ComponentResourceContract;
import org.resourceaccounting.contract.ResourceContract;
import org.resourceaccounting.contract.ResourceContractProvider;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 5/18/13
 * Time: 10:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class MyResourceContractProvider implements ResourceContractProvider {

    private URLClassLoader contractLoader = null;

    private ResourceContract withoutLimits = new ComponentResourceContract() {
        @Override
        public int getCPU() {
            return Integer.MAX_VALUE;
        }

        @Override
        public int getMemory() {
            return Integer.MAX_VALUE;
        }

        @Override
        public int getNetworkIn() {
            return Integer.MAX_VALUE;
        }

        @Override
        public int getNetworkOut() {
            return Integer.MAX_VALUE;
        }

        @Override
        public ResourceContract getContractFor(String operation) {
            return this;
        }
    };
    private String packageName;

    public MyResourceContractProvider(String contractFile, String packageName) {
        try {
            this.packageName = packageName;
            URL url = new File(contractFile).toURI().toURL();
            contractLoader = URLClassLoader.newInstance(
                    new URL[]{url},
                    MyResourceContractProvider.class.getClassLoader()
            );

        } catch (MalformedURLException e) {
        }
    }

    public ResourceContract obtainContractFor(String componentName) {
        int index = componentName.lastIndexOf('[') + 1;
        componentName = componentName.substring(index);
        componentName = componentName.replace(']',' ');
        componentName = componentName.trim();
        Class<?> clazz = null;
        ResourceContract tmp = withoutLimits;
        try {
            clazz = Class.forName(packageName+"." + componentName + "Contract", true, contractLoader);
            Class<? extends ResourceContract> runClass = clazz.asSubclass(ResourceContract.class);
            // Avoid Class.newInstance, for it is evil.
            Constructor<? extends ResourceContract> ctor = runClass.getConstructor();
            tmp = ctor.newInstance();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (InvocationTargetException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (NoSuchMethodException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (InstantiationException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IllegalAccessException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        return tmp;
    }
}
