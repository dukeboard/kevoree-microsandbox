package org.resourceaccounting.memory;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 6/17/13
 * Time: 2:36 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ReferenceLostListener {
    public void onReferenceLost(int size);
}
