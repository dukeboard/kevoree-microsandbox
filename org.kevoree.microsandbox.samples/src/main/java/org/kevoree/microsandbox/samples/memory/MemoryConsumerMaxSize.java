package org.kevoree.microsandbox.samples.memory;

import org.kevoree.annotation.*;
import org.kevoree.api.Context;
import org.kevoree.log.Log;
import org.kevoree.microsandbox.api.contract.impl.MemoryContractedImpl;

import java.util.Random;


/**
 * Created with IntelliJ IDEA.
 * User: duke
 * Date: 03/07/13
 * Time: 18:25
 */
@ComponentType
public class MemoryConsumerMaxSize extends MemoryContractedImpl {

    @KevoreeInject
    Context context;

    byte[] cache = new byte[0];

    private boolean running;

    @Param(optional = false)
    int dataSize;
    @Param(optional = false)
    int sleepTime;
    @Param(defaultValue = "false")
    boolean violate;

    @Start
    public void startComponent() {
        running = true;
        new java.lang.Thread(new java.lang.Runnable() {
            String s0 = "";
            String s1 ="lala";
            public void run() {
                byte[] bytes;
                Random random = new Random();
//                int valueViolation = Integer.parseInt(getDictionary().get("memory_max_size").toString());
                while (((!violate && cache.length + dataSize <= getMemory_max_size()) || violate) && running) {
                    bytes = new byte[dataSize];
                    random.nextBytes(bytes);
                    byte[] tmp = cache;
                    cache = new byte[cache.length + bytes.length];
                    System.arraycopy(tmp, 0, cache, 0, tmp.length);
                    System.arraycopy(bytes, 0, cache, tmp.length, bytes.length);
                    Log.warn("Minimum amount of memory used by {}: {} {} {}", context.getInstanceName(), cache.length, s0, s1.toUpperCase());
                    try {
                        Thread.sleep(sleepTime);
                    } catch (InterruptedException ignored) {
                    }
                }
                bytes = null;
                random = null;
                while (true) {
                    try {
                        Thread.sleep(sleepTime);
                    } catch (InterruptedException ignored) {
                    }
                }
            }
        }
        )
        .start();
    }

    @Stop
    public void stop() {
        running = false;
    }

}
