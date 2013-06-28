package org.kevoree.monitoring.comp.monitor;

import org.kevoree.ComponentInstance;
import org.resourceaccounting.ResourcePrincipal;

import java.util.Iterator;
import java.util.TimerTask;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 6/28/13
 * Time: 6:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class LocalMonitoring extends TimerTask implements MonitoringStrategy {
    public LocalMonitoring(Iterator<ComponentInstance> rank) {
    }

    @Override
    public void actionOnContractViolation() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isThereContractViolation() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void init() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void pause() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void stop() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void verifyContract(ResourcePrincipal principal, Object obj) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void onGCVerifyContract(long used, long max) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void run() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
