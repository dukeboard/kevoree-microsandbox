package org.daum.library.javase.copterManager.javafx;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * User: Erwan Daubert - erwan.daubert@gmail.com
 * Date: 10/09/13
 * Time: 20:57
 *
 * @author Erwan Daubert
 * @version 1.0
 */
public class CPUFault implements Runnable {

    private final int nbThreads;
    private final long delayTime;

    ExecutorService pool;
    int nbLoop = 1000000;
    long index;

    public void create() {
        pool = Executors.newFixedThreadPool(nbThreads);
        System.out.println("nbProcessors = " + nbThreads);
        for (int i = 0; i < nbThreads; i++) {
            CPUFault c = new CPUFault(i + 1, nbThreads, delayTime);
            pool.submit(c);
        }
    }

    private CPUFault(int index, int nbThreads, long delayTime) {
        this(nbThreads, delayTime);
        this.index = index;
    }

    public CPUFault(int nbThreads, long delayTime) {
        this.nbThreads = nbThreads;
        this.delayTime = delayTime;
    }

    public void destroy() {
        pool.shutdownNow();
    }

    public int sum(int n) {
        int r = 0 ;
        // Gauss is shaking in his grave :-)
        for (int i = 0 ; i < n ; i++)
            r+=i;
        return r;
    }

    @Override
    public void run() {
        System.out.println("nbLoop = " + nbLoop);
        int c = 0;
        try {
            Thread.sleep(delayTime*index);
        } catch (InterruptedException e) {

        }
        System.out.println("begin of loop " + nbLoop);
        for (int i = 0; i < nbLoop; i++) {
            c+=sum(i);
        }
        System.out.println("end of loop " + c);
    }

}

