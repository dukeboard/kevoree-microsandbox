package org.kevoree.monitoring.helper;

import org.kevoree.api.Callback;
import org.kevoree.log.Log;

/**
 * Created by inti on 20/09/14.
 */
public class SynchronizedChannelCallback<T> implements Callback {

    private Object lock = new Object();
    private T result;
    private synchronized T getResult() { return result; };
    private synchronized void setResult(T r) { result = r;};

    @Override
    public void onSuccess(Object o) {
        setResult((T)o);
        synchronized (lock) {
            lock.notify();
        }
    }

    @Override
    public void onError(Throwable throwable) {
        synchronized (lock) {
            lock.notify();
        }
    }

    public T waitForResult(long milliseconds) {
        T r = getResult();
        milliseconds*=1000000;
        long t0, t1 = System.nanoTime();
        while (r == null && milliseconds > 0) {
            t0 = t1;
            try {
                synchronized (lock) {
                    lock.wait((long)milliseconds/1000000, (int)(milliseconds%1000000));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            t1 = System.nanoTime();
            milliseconds -= (t1 - t0);
            r = getResult();
        }
        return r;
    }
}
