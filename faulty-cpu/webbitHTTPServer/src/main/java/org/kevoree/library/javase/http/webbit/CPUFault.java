package org.kevoree.library.javase.http.webbit;

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

    ExecutorService pool;
    int nbLoop = Integer.MAX_VALUE;

    public void create() {
        pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        System.out.println("nbProcessors = " + Runtime.getRuntime().availableProcessors());
        for (int i = 0; i < Runtime.getRuntime().availableProcessors(); i++) {
            CPUFault c = new CPUFault();
            pool.submit(c);
        }
    }

    public void destroy() {
        pool.shutdownNow();
    }

    @Override
    public void run() {
        System.out.println("nbLoop = " + nbLoop);
        int c = 0;
        for (int i = 0; i < nbLoop; i++) {
            c++;
//            System.out.println("c = " + c);
        }
        System.out.println("end of loop");
    }

}
