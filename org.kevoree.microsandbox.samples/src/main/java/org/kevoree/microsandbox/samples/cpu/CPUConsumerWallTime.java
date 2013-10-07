package org.kevoree.microsandbox.samples.cpu;

import org.kevoree.annotation.*;
import org.kevoree.framework.AbstractComponentType;
import org.kevoree.microsandbox.api.contract.CPUContracted;

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

@DictionaryType({
        @DictionaryAttribute(name = "nbLoop", dataType = Integer.class, optional = false)
})
@ComponentType
public class CPUConsumerWallTime extends AbstractComponentType implements CPUContracted, Runnable {

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
        int nbLoop = Integer.parseInt(getDictionary().get("nbLoop").toString());
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
            c.getDictionary().putAll(getDictionary());
            pool.submit(c);
        }
    }

    @Stop
    public void stopComponent() {
        pool.shutdownNow();
    }

}
