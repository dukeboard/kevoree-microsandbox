package org.kevoree.monitoring.helper;

import org.kevoree.api.handler.UpdateCallback;

/**
 * Created by inti on 03/06/14.
 * Shame on me, I just copied this from Francois to avoid an ugly error
 * when module org.kevoree.Komponents was imported
 */
public class SynchronizedUpdateCallback implements UpdateCallback {

    private boolean done;
    private boolean result;

    public synchronized void initialize() {
        done = false;
        result = false;
    }

    @Override
    public synchronized void run(Boolean aBoolean) {
        result = aBoolean;
        done = true;
        this.notify();
    }

    public synchronized boolean waitForResult(long timeout) {
        if (!done) {
            try {
                this.wait(timeout);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return done && result;
    }
}
