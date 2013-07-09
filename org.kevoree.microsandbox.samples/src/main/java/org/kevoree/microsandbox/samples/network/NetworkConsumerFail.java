package org.kevoree.microsandbox.samples.network;

import org.kevoree.annotation.ComponentType;
import org.kevoree.annotation.Start;
import org.kevoree.microsandbox.api.contract.FullContracted;
import org.kevoree.microsandbox.api.contract.NetworkContracted;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * User: duke
 * Date: 03/07/13
 * Time: 18:25
 */

@ComponentType
public class NetworkConsumerFail extends org.kevoree.framework.AbstractComponentType implements FullContracted {

    java.util.List<Object> cache = new java.util.ArrayList<Object>();

    @Start
    public void startComponent() {
        new Thread(new Runnable() {
            public void run() {
                byte[] bytes = new byte[1024];
                while (true) {
                    try {
                        URL url = new URL("http://www.google.com");
                        InputStream stream = url.openStream();
                        int n = 0;
                        int c = 0;
                        while ((n = stream.read(bytes)) != -1) {
//                            String ss = new String(bytes,n);
                            c += n;
                        }
                        System.out.println("total " + c);
                        stream.close(); // yeah, I know, this is completely wrong, but using a finally is ugly and
                        // I am lazy
                        Thread.sleep(500);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                    } catch (IOException e) {
                        e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                    } catch (InterruptedException e) {
                        e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                    }

                }
            }
        }).start();
    }

}
