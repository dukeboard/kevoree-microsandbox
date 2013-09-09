package org.kevoree.monitoring.strategies;

import org.kevoree.ContainerRoot;
import org.kevoree.api.Bootstraper;
import org.kevoree.api.service.core.handler.KevoreeModelHandlerService;
import org.kevoree.api.service.core.handler.ModelListener;
import org.kevoree.monitoring.comp.monitor.ContractVerificationRequired;
import org.kevoree.monitoring.comp.monitor.GCWatcher;
import org.kevoree.monitoring.ranking.ComponentsInfoStorage;
import org.kevoree.monitoring.strategies.monitoring.MonitoringStrategy;
import org.resourceaccounting.ResourcePrincipal;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 7/9/13
 * Time: 5:38 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractMonitoringTask implements Runnable, ContractVerificationRequired, ModelListener {
    protected final String nodeName;
    protected final Bootstraper bootstraper;
    protected final KevoreeModelHandlerService service;
    protected boolean stopped;
    protected GCWatcher gcWatcher;
    protected Object msg;
    protected String nameOfRankerFunction;
    protected MonitoringStrategy currentStrategy;

    public AbstractMonitoringTask(Bootstraper bootstraper,
                                  KevoreeModelHandlerService service,
                                  String nameOfRankerFunction,
                                  String nodeName) {
        this.bootstraper = bootstraper;
        this.service = service;
        this.nameOfRankerFunction = nameOfRankerFunction;
        this.nodeName= nodeName;
        msg = new Object();
    }

    protected void waitMessage() {
        synchronized (msg) {
            try {
                msg.wait();
            } catch (InterruptedException e) {

            }
        }
    }

    public synchronized boolean isStopped() {
        return stopped;
    }

    public synchronized void stop() {
        stopped = true;
        synchronized (msg) {
            msg.notify();
        }
    }

    @Override
    public void verifyContract(ResourcePrincipal principal, Object obj) {
        currentStrategy.verifyContract(principal, obj);
    }

    @Override
    public void onGCVerifyContract(long used, long max) {
        if (currentStrategy != null)
            currentStrategy.onGCVerifyContract(used, max);
    }

    @Override
    public boolean preUpdate(ContainerRoot containerRoot, ContainerRoot containerRoot2) {
        return true;
    }

    @Override
    public boolean initUpdate(ContainerRoot containerRoot, ContainerRoot containerRoot2) {
        return true;
    }

    @Override
    public boolean afterLocalUpdate(ContainerRoot containerRoot, ContainerRoot containerRoot2) {
        return true;
    }

    @Override
    public void modelUpdated() {
        ComponentsInfoStorage.instance.refresh(nodeName, service);
    }

    @Override
    public void preRollback(ContainerRoot containerRoot, ContainerRoot containerRoot2) { }

    @Override
    public void postRollback(ContainerRoot containerRoot, ContainerRoot containerRoot2) { }
}
