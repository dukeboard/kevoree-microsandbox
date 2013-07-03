package org.kevoree.microsandbox.samples.network;

import org.kevoree.annotation.ComponentType;
import org.kevoree.annotation.Start;
import org.kevoree.microsandbox.api.MemoryContracted;

/**
 * Created with IntelliJ IDEA.
 * User: duke
 * Date: 03/07/13
 * Time: 18:25
 */

@ComponentType
public class NetworkConsumerFail extends org.kevoree.framework.AbstractComponentType implements MemoryContracted {

    java.util.List<Object> cache = new java.util.ArrayList<Object>();

    @Start
    public void startComponent() {
        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    cache.add(new byte[1000000]);
                }
            }
        }).start();
    }

}
