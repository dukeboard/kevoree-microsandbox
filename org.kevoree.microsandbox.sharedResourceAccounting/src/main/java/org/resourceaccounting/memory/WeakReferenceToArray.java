package org.resourceaccounting.memory;

import java.lang.ref.WeakReference;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 6/17/13
 * Time: 2:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class WeakReferenceToArray extends WeakReference<Object> {

    private final int size;

    public int getSize() {
        return size;
    }

    public WeakReferenceToArray(Object referent, PrincipalReferenceQueue q, int size) {
        super(referent, q);
        this.size = size;
        q.rf.add(this);
    }


}
