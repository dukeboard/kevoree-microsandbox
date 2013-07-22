package org.kevoree.microsandbox.samples.memory;

import org.kevoree.annotation.*;
import org.kevoree.log.Log;
import org.kevoree.microsandbox.api.contract.MemoryContracted;

/**
 * Created with IntelliJ IDEA.
 * User: duke
 * Date: 03/07/13
 * Time: 18:25
 */
@DictionaryType({
        @DictionaryAttribute(name = "dataSize", dataType = Integer.class, optional = false)
})
@ComponentType
public class MemoryConsumerMaxSize extends org.kevoree.framework.AbstractComponentType implements MemoryContracted {

    java.util.List<java.lang.Object> cache = new java.util.ArrayList<java.lang.Object>();

    private boolean running;

    @Start
    public void startComponent() {
        running = true;
        new java.lang.Thread(new java.lang.Runnable() {
            public void run() {
                while (running) {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException ignored) {
                    }
                    Log.warn("WTF !!! {}", cache.size());
                    cache.add(new byte[Integer.parseInt(getDictionary().get("dataSize").toString())]);
                }
            }
        }).start();
    }

    @Stop
    public void stop() {
        running = false;
    }

}
