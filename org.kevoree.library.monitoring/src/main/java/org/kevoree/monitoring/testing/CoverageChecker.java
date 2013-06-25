package org.kevoree.monitoring.testing;

import org.kevoree.annotation.ComponentType;
import org.kevoree.annotation.Start;
import org.kevoree.annotation.Stop;
import org.kevoree.annotation.Update;
import org.kevoree.framework.AbstractComponentType;
import org.kevoree.kcl.*;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 6/24/13
 * Time: 3:55 PM
 * To change this template use File | Settings | File Templates.
 */
@ComponentType
public class CoverageChecker extends AbstractComponentType {
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
                    Thread.sleep(2000);
                    ClassLoader l = this.getClass().getClassLoader();
                    if (l instanceof KevoreeJarClassLoader) {
                        System.out.println("lalala coverage injection");
                    }
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
