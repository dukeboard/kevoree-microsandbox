package org.microsandbox.sample;

import org.kevoree.annotation.*;
import org.kevoree.log.Log;
import org.kevoree.microsandbox.api.contract.impl.CPUMemoryContractedImpl;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.*;
import java.nio.channels.SocketChannel;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 9/5/13
 * Time: 2:22 PM
 */
@ComponentType
public class RunningExternalJarAppComponent extends CPUMemoryContractedImpl {


    @Param(optional = false)
    private String jar_path;
    @Param(optional = false)
    private String jar_main;
    @Param(optional = false)
    private String arguments;
    @Param(optional = false)
    private long delayTime;

    private ClassLoader loader;

    class WekaExecuter implements Runnable {

        @Override
        public void run() {
            long timeBefore = 0;
            try {
                Class<?> cl = loader.loadClass(jar_main);
                Method method = cl.getMethod("main", new Class[]{String[].class});

                String[] args = arguments.split(" ");
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
                e.printStackTrace();

            }
            finally {
//                System.setSecurityManager(null);
                long consumedTime = System.nanoTime() - timeBefore;
                System.out.println("============================================");
                System.out.printf(" Execution Time: %f seconds\n", consumedTime/1000000000.0);
                System.out.println("============================================");
                try {
                    Socket socket = new Socket("localhost",4444);
                    socket.getOutputStream().write(Double.toString(consumedTime/1000000000.0).getBytes());
                    socket.close();
                } catch (IOException e) { }
//                System.exit(0);
            }
        }
    }

    private class DelayStarter implements Runnable {

        @Override
        public void run() {
            int c = 0;
            try {
                Thread.sleep(delayTime);
                Log.info("Starting to execute {} {}", jar_main, arguments);
                loader = new URLClassLoader(new URL[]{new File(jar_path).toURI().toURL()}, Thread.currentThread().getContextClassLoader());
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
