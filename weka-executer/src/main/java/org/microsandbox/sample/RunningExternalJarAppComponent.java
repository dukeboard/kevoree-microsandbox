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
        @DictionaryAttribute(name = "jar_path",dataType = String.class, optional = false),
        @DictionaryAttribute(name = "jar_main", dataType = String.class, optional = false),
        @DictionaryAttribute(name = "arguments", dataType = String.class, optional = false),
        @DictionaryAttribute(name = "delayTime", dataType = Long.class, optional = false)
})
@ComponentType
public class RunningExternalJarAppComponent extends AbstractComponentType
                    implements MemoryContracted, CPUContracted {


    private String path;
    private String test;
    private ClassLoader loader;
    private String arg;
    private long delayTime;

    class WekaExecuter implements Runnable {

        @Override
        public void run() {
            long timeBefore = 0;
            try {
                Thread.sleep(delayTime);
                Class<?> cl = loader.loadClass(test);
                Method method = cl.getMethod("main", new Class[]{String[].class});

                String[] args = arg.split(" ");
                timeBefore = System.currentTimeMillis();
                method.invoke(null,new Object[]{args});


            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
            } catch (IllegalAccessException e) {
//                e.printStackTrace();
            } catch (NoSuchMethodException e) {
//                e.printStackTrace();
            } catch (InvocationTargetException e) {
//                e.printStackTrace();
                System.err.println("Not a big deal if the test has finished");
            } catch (InterruptedException e) {
//                e.printStackTrace();
            }
            catch (Exception e) {

            }
            finally {
                long consumedTime = System.currentTimeMillis() - timeBefore;
                System.out.println("============================================");
                System.out.println(" Time taken to execute : " + consumedTime);
                System.out.println("============================================");
                System.exit(0);
            }
        }
    }


    @Start
    public void start() {
        path = getDictionary().get("jar_path").toString();
        test = getDictionary().get("jar_main").toString();
        arg = getDictionary().get("arguments").toString();
        delayTime = Long.parseLong(getDictionary().get("delayTime").toString());
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
