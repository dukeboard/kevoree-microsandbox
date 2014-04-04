package org.kevoree.microsandbox.samples;

import org.kevoree.annotation.ComponentType;
import org.kevoree.annotation.KevoreeInject;
import org.kevoree.annotation.Start;
import org.kevoree.annotation.Stop;
import org.kevoree.api.Context;
import org.kevoree.log.Log;
import org.kevoree.microsandbox.api.contract.FullContracted;

/**
 * Created with IntelliJ IDEA.
 * User: duke
 * Date: 30/05/13
 * Time: 14:19
 */

@ComponentType
public class FakeVideoAnalyzer extends FullContracted implements Runnable {

    private Thread processThread = null;

    @KevoreeInject
    Context context;

    @Start
    public void start() {
        Log.info("Starting {}@{}", context.getInstanceName(), context.getNodeName());
        processThread = new Thread(this);
        processThread.start();
    }

    @Stop
    public void stop() {
        Log.info("Stoping {}@{}", context.getInstanceName(), context.getNodeName());
        try {
            processThread.stop();
            processThread = null;
        } catch (Exception e) {
            Log.error("Error while stoping the thread");
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                Log.error("can't wait the thread ...", e);
            }
        }
    }

}
