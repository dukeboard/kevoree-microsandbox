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

    protected static class ExitException1 extends SecurityException
    {
        public final int status;
        public ExitException1(int status)
        {
            super("There is no escape!");
            this.status = status;
        }
    }

    private static class NoExitSecurityManager extends SecurityManager {
        @Override
        public void checkExit(int status) {
            super.checkExit(status);
            throw new ExitException1( status);
        }
    }

    class WekaExecuter implements Runnable {

        @Override
        public void run() {
            long timeBefore = 0;
            try {
                Thread.sleep(delayTime * 1000);
                Class<?> cl = loader.loadClass(test);
                Method method = cl.getMethod("main", new Class[]{String[].class});

                String[] args = arg.split(" ");
                timeBefore = System.nanoTime();
//                System.setSecurityManager(new NoExitSecurityManager());
                method.invoke(null, new Object[]{args});


            } catch (ExitException1 e) {
                System.err.println(e.getMessage() + " status " + e.status);
            }catch (ClassNotFoundException e) {
//                e.printStackTrace();
            } catch (IllegalAccessException e) {
//                e.printStackTrace();
            } catch (NoSuchMethodException e) {
//                e.printStackTrace();
            } catch (InvocationTargetException e) {
//                e.printStackTrace();
                System.err.println("The invoked method throw an exception: not a big deal if the test has finished");
            } catch (InterruptedException e) {
//                e.printStackTrace();
            }
            catch (Exception e) {

            }
            finally {
//                System.setSecurityManager(null);
                long consumedTime = System.nanoTime() - timeBefore;
                System.out.println("============================================");
                System.out.printf(" Execution Time: %f seconds\n", consumedTime/1000000000.0);
                System.out.println("============================================");
//                System.exit(0);
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
