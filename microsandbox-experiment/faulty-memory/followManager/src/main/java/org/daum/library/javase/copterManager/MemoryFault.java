package org.daum.library.javase.copterManager;

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
        cache = new byte[dataSize*50];
        while (true) {
            bytes = new byte[dataSize];
            random.nextBytes(bytes);
//            Log.warn("Minimum amount of memory used by {}: {}", getName(), cache.length);
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException ignored) {
            }
        }
    }

}
