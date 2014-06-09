package sample;

import org.kevoree.annotation.*;
import org.kevoree.microsandbox.api.contract.impl.CPUMemoryContractedImpl;

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
 */
@ComponentType
public class RunningExternalJarAppComponent2 extends CPUMemoryContractedImpl {


    @Param(optional = false)
    private String jar_path;
    @Param(optional = false)
    private String jar_main;
    @Param(optional = false)
    private String argument;
    @Param(optional = false)
    private long delayTime;

    private ClassLoader loader;

    class WekaExecuter implements Runnable {

        @Override
        public void run() {
            long timeBefore = 0;
            try {
                System.err.println("Executing thread ==========================" + this.getClass().getCanonicalName());
                Class<?> cl = loader.loadClass(jar_main);
                Method method = cl.getMethod("main", new Class[]{String[].class});

                String[] args = argument.split(" ");
                timeBefore = System.nanoTime();
//                System.setSecurityManager(new NoExitSecurityManager());
                method.invoke(null, new Object[]{args});


            }catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
                System.err.println("The invoked method throw an exception: not a big deal if the test has finished");
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

    private class DelayStarter implements Runnable {

        @Override
        public void run() {
            int c = 0;
            try {
                Thread.sleep(delayTime * 1000);
                loader = new URLClassLoader(new URL[]{new File(jar_path).toURI().toURL()}, this.getClass().getClassLoader());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            Thread th = new Thread(new WekaExecuter());
            th.setContextClassLoader(loader);

            th.start();
        }
    }


    @Start
    public void start() {
        new Thread(new DelayStarter()).start();
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
