package org.kevoree.microsandbox.samples;

import org.kevoree.annotation.ComponentType;
import org.kevoree.annotation.Start;
import org.kevoree.annotation.Stop;
import org.kevoree.annotation.Update;
import org.kevoree.framework.AbstractComponentType;
import org.kevoree.microsandbox.api.FullContractedComponent;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 7/1/13
 * Time: 1:27 AM
 *
 */
@ComponentType
public class CPUConsumer extends AbstractComponentType implements FullContractedComponent {

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
                    int sum = 0;
                    for (int i = 0 ; i < 1000000 ; i++)
                        sum += i;
//                    System.out.print(sum);
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
