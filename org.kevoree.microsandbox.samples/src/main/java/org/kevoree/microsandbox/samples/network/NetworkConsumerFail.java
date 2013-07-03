package org.kevoree.microsandbox.samples.network;

import org.kevoree.annotation.ComponentType;
import org.kevoree.annotation.Start;
import org.kevoree.microsandbox.api.MemoryContracted;
import org.kevoree.microsandbox.api.NetworkContracted;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * User: duke
 * Date: 03/07/13
 * Time: 18:25
 */

@ComponentType
public class NetworkConsumerFail extends org.kevoree.framework.AbstractComponentType implements NetworkContracted {

    java.util.List<Object> cache = new java.util.ArrayList<Object>();

    @Start
    public void startComponent() {
        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        URL url = new URL("www.google.com");
                        //TODO
                    } catch (MalformedURLException e) {
                        e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                    }
                }
            }
        }).start();
    }

}
