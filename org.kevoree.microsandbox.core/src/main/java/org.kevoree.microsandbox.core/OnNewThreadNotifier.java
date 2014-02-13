package org.kevoree.microsandbox.core;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 1/7/14
 * Time: 4:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class OnNewThreadNotifier {

    public interface HandlerSet {
        public void onHandlerSet(Object obj);
    }

    public void setListener(HandlerSet listener) {
        this.listener = listener;
    }

    HandlerSet listener;

    private static OnNewThreadNotifier ourInstance = new OnNewThreadNotifier();

    public synchronized void setHandler(Object handler) {
        if (handler != null)
            this.handler = handler;
        else
            this.handler = new Object();

        if (listener != null)
            listener.onHandlerSet(this.handler);
    }

    private Object handler;

    public static OnNewThreadNotifier getInstance() {
        return ourInstance;
    }

    private OnNewThreadNotifier() {
        handler = new Object();
    }


}
