package org.kevoree.microsandbox.http_proxy_component;

import org.kevoree.annotation.*;
import org.kevoree.log.Log;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.URLClassLoader;

@ComponentType
public class WebServerExecuter {

    @Param(optional = false)
    String path_to_sosie;

    @Param(optional = false)
    String path_to_mdms;

    @Param(optional = false)
    int port;

    @KevoreeInject
    org.kevoree.api.Context context;

    @Output
    org.kevoree.api.Port registerBackend;

    class ServerExecuter implements Runnable {

        private ClassLoader loader;

        public ServerExecuter(ClassLoader loader) {
            this.loader = loader;
        }

        @Override
        public void run() {
            long timeBefore = 0;
            try {
                Class<?> cl = loader.loadClass("org.ringojs.tools.launcher.Main");
                Method method = cl.getMethod("main", new Class[]{String[].class});

                String[] args = new String[] {
                        path_to_mdms,
                        String.format("--port=%d",port)
                };
                timeBefore = System.nanoTime();
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
//                long consumedTime = System.nanoTime() - timeBefore;
//                System.out.println("============================================");
//                System.out.printf(" Execution Time: %f seconds\n", consumedTime/1000000000.0);
//                System.out.println("============================================");
//                try {
//                    Socket socket = new Socket("localhost",4444);
//                    socket.getOutputStream().write(Double.toString(consumedTime/1000000000.0).getBytes());
//                    socket.close();
//                } catch (IOException e) { }
//                System.exit(0);
            }
        }
    }

    private class DelayStarter implements Runnable {

        @Override
        public void run() {
            int c = 0;
            try {
//                Thread.sleep(200);
                String jar_path = path_to_sosie + "/run.jar";
                ClassLoader loader = new URLClassLoader(new URL[]{new File(jar_path).toURI().toURL()}, Thread.currentThread().getContextClassLoader());
                Thread th = new Thread(new ServerExecuter(loader));
                th.setContextClassLoader(loader);
                th.start();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

        }
    }

    @Start
    public void start() {
        // let's start the backend
        new Thread(new DelayStarter()).start();
        // let's register the backend
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    while (registerBackend.getConnectedBindingsSize() == 0) {
                        Thread.sleep(100);
                    }
                    if (registerBackend.getConnectedBindingsSize() > 0) {
                        registerBackend.send(port);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @Stop
    public void stop() {}

    @Update
    public void update() {System.out.println("Param updated!");}

}



