package org.resourceaccounting.memory;

import org.resourceaccounting.utils.MyList;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 6/17/13
 * Time: 2:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class PrincipalReferenceQueue extends ReferenceQueue<Object>
        implements Runnable{

    MyList<WeakReferenceToArray> rf;

    private ReferenceLostListener listener;

    public void run() {
        while (true) {
            try {
                Reference<?> w = remove();
                if (w instanceof WeakReferenceToArray) {
                    WeakReferenceToArray wa = (WeakReferenceToArray)w;
                    rf.remove(wa);
                    listener.onReferenceLost(wa.getSize());
                }
            } catch (InterruptedException e) {

            }
        }
    }

    public PrincipalReferenceQueue(ReferenceLostListener l) {
        listener = l;
        rf = new MyList<WeakReferenceToArray>();
        Thread th = new Thread(this);
        th.setDaemon(false);
        th.start();
    }
}
