package org.microsandbox.sample;

import org.kevoree.annotation.*;
import org.kevoree.framework.AbstractComponentType;
import org.kevoree.microsandbox.api.contract.CPUContracted;
import org.kevoree.microsandbox.api.contract.MemoryContracted;

import java.io.File;
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
 * To change this template use File | Settings | File Templates.
 */
@DictionaryType({
        @DictionaryAttribute(name = "weka_path",dataType = String.class, optional = false),
        @DictionaryAttribute(name = "weka_classifier", dataType = String.class, optional = false),
        @DictionaryAttribute(name = "classifier_arguments", dataType = String.class, optional = false)
})
@ComponentType
public class RunningWekaComponent extends AbstractComponentType
                    implements MemoryContracted, CPUContracted {


    private String path;
    private String test;
    private ClassLoader loader;
    private String arg;

    class WekaExecuter implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(15000);
                Class<?> cl = loader.loadClass(test);
                Method method = cl.getMethod("main", new Class[]{String[].class});

                String[] args = arg.split(" ");
                long timeBefore = System.currentTimeMillis();
                method.invoke(null,new Object[]{args});
                long consumedTime = System.currentTimeMillis() - timeBefore;
                System.out.println("============================================");
                System.out.println(" Time taken to execute Weka : " + consumedTime);
                System.out.println("============================================");
                System.exit(0);

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
                System.err.println("Not a big deal if the test has finished");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    @Start
    public void start() {
        path = getDictionary().get("weka_path").toString();
        test = getDictionary().get("weka_classifier").toString();
        arg = getDictionary().get("classifier_arguments").toString() + " -o -x 2 -t /home/inti/resources.arff";
        try {
            loader = new URLClassLoader(new URL[]{new File(path).toURI().toURL()}, this.getClass().getClassLoader());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Thread th = new Thread(new WekaExecuter());
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
