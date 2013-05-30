package org.kevoree.microsandbox.samples;

import org.kevoree.annotation.ComponentType;
import org.kevoree.annotation.Start;
import org.kevoree.annotation.Stop;
import org.kevoree.framework.AbstractComponentType;
import org.kevoree.log.Log;
import org.kevoree.microsandbox.api.ContractedComponent;

import static org.kevoree.log.Log.info;

/**
 * Created with IntelliJ IDEA.
 * User: duke
 * Date: 30/05/13
 * Time: 14:19
 */

@ComponentType
public class FakeVideoAnalyzer extends AbstractComponentType implements ContractedComponent, Runnable {

    private Thread processThread = null;

    @Start
    public void start() {
        info("Starting {}@{}", getName(), getNodeName());
        processThread = new Thread(this);
        processThread.start();
    }

    @Stop
    public void stop() {
        info("Stoping {}@{}", getName(), getNodeName());
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
