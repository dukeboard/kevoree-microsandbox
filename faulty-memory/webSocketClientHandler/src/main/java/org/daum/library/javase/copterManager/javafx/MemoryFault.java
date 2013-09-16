package org.daum.library.javase.copterManager.javafx;

import org.kevoree.log.Log;

import java.util.Random;
import java.util.concurrent.ExecutorService;

/**
 * User: Erwan Daubert - erwan.daubert@gmail.com
 * Date: 10/09/13
 * Time: 20:57
 *
 * @author Erwan Daubert
 * @version 1.0
 */
public class MemoryFault implements Runnable {

    ExecutorService pool;
    private String name;

    byte[] cache = new byte[0];

    private int dataSize = 2000000;
    private int sleepTime = 500;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void create() {
        new Thread(this).start();
    }

    public void destroy() {
        pool.shutdownNow();
    }

    @Override
    public void run() {
        byte[] bytes;
        Random random = new Random();
        while (true) {
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

}
