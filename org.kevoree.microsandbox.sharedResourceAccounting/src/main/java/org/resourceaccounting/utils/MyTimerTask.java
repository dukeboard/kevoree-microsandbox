package org.resourceaccounting.utils;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 6/16/13
 * Time: 9:17 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class MyTimerTask implements Runnable {

    int timeT;
    MyTimerTask task;

    public void executeAtFixedRate(int time) {
        timeT = time;
        task = this;
        Thread th =new Thread(new Runnable() {
            public void run() {
                boolean in = false;
                while (!in) {
                    try {
                        Thread.sleep(timeT);
                        task.run();
                    } catch (InterruptedException e) {
                        in = true;
                    }
                }
            }
        });
        th.setDaemon(false);
        th.start();
    }
}
