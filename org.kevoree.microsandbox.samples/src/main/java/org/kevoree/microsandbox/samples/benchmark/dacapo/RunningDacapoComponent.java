package org.kevoree.microsandbox.samples.benchmark.dacapo;

import org.jetbrains.annotations.NotNull;
import org.kevoree.annotation.*;
import org.kevoree.kcl.api.FlexyClassLoader;
import org.kevoree.log.Log;
import org.kevoree.microsandbox.api.contract.impl.CPUMemoryContractedImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 9/5/13
 * Time: 2:22 PM
 */
@ComponentType
public class RunningDacapoComponent extends CPUMemoryContractedImpl {

    @Param
    private String dacapo_path;
    @Param
    private String dacapo_test;
    @Param(defaultValue = "1")
    private Integer dacapo_n;
    private ClassLoader loader;

    class MyLoader extends URLClassLoader {

        int i = 0;

        public MyLoader(URL[] urls, ClassLoader parent) {
            super(urls, parent);
        }

        @NotNull
        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            return super.findClass(name);
        }
    }

    class DacapoExecuter extends Thread {

        @Override
        public void run() {
            try {
                Class<?> cl = loader.loadClass("Harness");
                Method method = cl.getMethod("main", new Class[]{String[].class});

                method.invoke(null,new Object[]{new String[]{
                        "-noValidation",
                        "-n",
                        dacapo_n.toString(),
                        dacapo_test}});

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
//                e.printStackTrace();
                Log.error("Not a big deal if the test has finished");
            }
        }
    }


    @Start
    public void start() {
        try {
//            FlexyClassLoader ll = (FlexyClassLoader)Thread.currentThread().getContextClassLoader();
//            ll.load(new FileInputStream(new File(dacapo_path).toURI().toURL().getFile()));
//            Log.debug("\n\n\n\t\t\t{}\n\n\n", ll);

            loader = new MyLoader(new URL[]{new File(dacapo_path).toURI().toURL()},
                    Thread.currentThread().getContextClassLoader());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Thread th = new Thread(new DacapoExecuter());
        Log.debug("Within RunningDacapoComponent => TG {}",  th.getThreadGroup().getName());
        th.setContextClassLoader(loader);
        th.start();
    }

    @Stop
    public void stop() {

    }

    @Update
    public void update() {
        stop();
        start();
    }
}
