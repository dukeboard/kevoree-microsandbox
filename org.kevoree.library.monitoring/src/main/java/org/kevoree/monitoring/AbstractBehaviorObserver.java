package org.kevoree.monitoring;

import org.resourceaccounting.ResourcePrincipal;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 4/28/13
 * Time: 1:04 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractBehaviorObserver<T> implements AppBehaviorObserver{
    private boolean stopped = false;

    private HashMap<ResourcePrincipal, T> mapping = new HashMap<ResourcePrincipal, T>();

    @Override
    public void informationChange(ResourcePrincipal principal) {
        updateAssociatedValue(principal, mapping.get(principal));
    }

    @Override
    public void newApp(ResourcePrincipal principal) {
        T v = getNewAssociatedValue(principal);
        mapping.put(principal, v);
        updateAssociatedValue(principal, v);
    }

    protected abstract void updateAssociatedValue(ResourcePrincipal principal, T v);

    protected abstract T getNewAssociatedValue(ResourcePrincipal principal);

    @Override
    public void removeApp(ResourcePrincipal rp) {
        mapping.remove(rp);
    }

    @Override
    public boolean isStopped() {
        return stopped;
    }

    protected final void stop() {
        stopped = true;
    }
}
