package org.kevoree.microsandbox.samples.cpu;

import org.kevoree.annotation.ComponentType;
import org.kevoree.annotation.Param;
import org.kevoree.annotation.Start;
import org.kevoree.annotation.Stop;
import org.kevoree.microsandbox.api.contract.impl.CPUContractedImpl;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 7/1/13
 * Time: 1:27 AM
 */
@ComponentType
public class CPUConsumerWallTime extends CPUContractedImpl implements Runnable {

    @Param(optional = false)
    int nbLoop;

    public int sum(int n) {
        int r = 0 ;
        // Gauss is shaking in his grave :-)
        for (int i = 0 ; i < n ; i++)
            r+=i;
        return r;
    }

    @Override
    public void run() {
        try {
            System.setErr(new PrintStream("/dev/null"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        System.out.println("nbLoop = " + nbLoop);
        int c = 0;
        for (int i = 0; i < nbLoop; i++) {
            c+=sum(i);
            System.err.print("c = " + c);
            if (i % 80 == 0)
                System.err.println();
        }
        System.out.println("end of loop " + c);
    }

    ExecutorService pool;

    @Start
    public void startComponent() {
        pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        System.out.println("nbProcessors = " + Runtime.getRuntime().availableProcessors());
        for (int i = 0; i < Runtime.getRuntime().availableProcessors(); i++) {
            CPUConsumerWallTime c = new CPUConsumerWallTime();
            c.nbLoop = this.nbLoop;
            pool.submit(c);
        }
    }

    @Stop
    public void stopComponent() {
        pool.shutdownNow();
    }

}
