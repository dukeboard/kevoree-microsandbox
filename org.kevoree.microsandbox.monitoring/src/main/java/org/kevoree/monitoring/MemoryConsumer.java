package org.kevoree.monitoring;

import org.kevoree.annotation.ComponentType;
import org.kevoree.annotation.Start;
import org.kevoree.annotation.Stop;
import org.kevoree.annotation.Update;
import org.kevoree.framework.AbstractComponentType;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 6/18/13
 * Time: 5:47 PM
 * To change this template use File | Settings | File Templates.
 */

@ComponentType
public class MemoryConsumer extends AbstractComponentType
        implements ContractedComponent{

    private class Th extends Thread {
        private synchronized boolean isB() {
            return b;
        }

        private synchronized void setB(boolean b) {
            this.b = b;
        }

        boolean b;
        @Override
        public void run() {
            while (!isB()) {
                try {
                    Thread.sleep(200);
                    int[] ar = new  int[1024];
                } catch (InterruptedException e) {

                }
            }
        }
    }

    Th th;

    @Start
    public void startComponent() {
        th = new Th();
        th.start();
    }

    @Stop
    public void stopComponent() {
        th.setB(true);
    }

    @Update
    public void updateComponent() {
        stopComponent();
        startComponent();
    }

}
