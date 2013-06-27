package org.kevoree.monitoring.comp.monitor;

import org.resourceaccounting.ResourcePrincipal;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 6/15/13
 * Time: 10:01 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ContractVerificationRequired {
    public void verifyContract(ResourcePrincipal principal, Object obj);
    public void onGCVerifyContract(long used, long max);
}
