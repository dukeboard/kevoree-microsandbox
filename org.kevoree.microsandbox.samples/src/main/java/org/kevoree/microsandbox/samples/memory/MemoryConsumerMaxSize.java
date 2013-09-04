package org.kevoree.microsandbox.samples.memory;

import org.kevoree.annotation.*;
import org.kevoree.log.Log;
import org.kevoree.microsandbox.api.contract.MemoryContracted;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: duke
 * Date: 03/07/13
 * Time: 18:25
 */
@DictionaryType({
        @DictionaryAttribute(name = "sleepTime", dataType = Integer.class, optional = false),
        @DictionaryAttribute(name = "dataSize", dataType = Integer.class, optional = false),
        @DictionaryAttribute(name = "violate", defaultValue = "false", vals = {"true", "false"})
})
@ComponentType
public class MemoryConsumerMaxSize extends org.kevoree.framework.AbstractComponentType implements MemoryContracted {

    byte[] cache = new byte[0];

    private boolean running;

    @Start
    public void startComponent() {
        running = true;
        new java.lang.Thread(new java.lang.Runnable() {
            public void run() {
                int dataSize = Integer.parseInt(getDictionary().get("dataSize").toString());
                int sleepTime = Integer.parseInt(getDictionary().get("sleepTime").toString());
                byte[] bytes;
                Random random = new Random();boolean violate = "true".equals(getDictionary().get("violate").toString());
                int valueViolation = Integer.parseInt(getDictionary().get("memory_max_size").toString());
                while (((!violate && cache.length + dataSize <= valueViolation) || violate) && running) {
                    bytes = new byte[dataSize];
                    random.nextBytes(bytes);
                    byte[] tmp = cache;
                    cache = new byte[cache.length + bytes.length];
                    System.arraycopy(tmp, 0, cache, 0, tmp.length);
                    System.arraycopy(bytes, 0, cache, tmp.length, bytes.length);
                    Log.warn("Minimum amount of memory used by {}: {}", getName(), cache.length);
                    try {
                        Thread.sleep(sleepTime);
                    } catch (InterruptedException ignored) {
                    }
                }
            }
        }).start();
    }

    @Stop
    public void stop() {
        running = false;
    }

}
