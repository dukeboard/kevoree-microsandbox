package org.kevoree.monitoring;

import org.resourceaccounting.ResourcePrincipal;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 4/27/13
 * Time: 2:08 PM
 * To change this template use File | Settings | File Templates.
 */
public interface AppBehaviorObserver {
    void informationChange(ResourcePrincipal principal);

    void newApp(ResourcePrincipal principal);

    void removeApp(ResourcePrincipal rp);

    boolean isStopped();
}
