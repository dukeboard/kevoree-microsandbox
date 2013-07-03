package org.kevoree.microsandbox.samples.memory;

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
public class MemoryConsumerFail extends org.kevoree.framework.AbstractComponentType implements MemoryContracted {

    java.util.List<java.lang.Object> cache = new java.util.ArrayList<java.lang.Object>();

    @Start
    public void startComponent() {
        new java.lang.Thread(new java.lang.Runnable() {
            public void run() {
                while (true) {
                    cache.add(new byte[1000000]);
                }
            }
        }).start();
    }

}
