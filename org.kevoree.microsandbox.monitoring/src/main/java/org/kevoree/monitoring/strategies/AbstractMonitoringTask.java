package org.kevoree.monitoring.strategies;

import org.kevoree.ComponentInstance;
import org.kevoree.api.BootstrapService;
import org.kevoree.api.ModelService;
import org.kevoree.microsandbox.api.heuristic.MonitoringEvent;
import org.kevoree.microsandbox.api.heuristic.RankingHeuristicComponent;
import org.kevoree.monitoring.comp.monitor.ContractVerificationRequired;
import org.kevoree.monitoring.comp.monitor.GCWatcher;
import org.kevoree.monitoring.comp.monitor.MonitoringComponent;
import org.kevoree.monitoring.strategies.monitoring.MonitoringStrategy;
import org.resourceaccounting.ResourcePrincipal;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 7/9/13
 * Time: 5:38 PM
 */
public abstract class AbstractMonitoringTask implements Runnable, ContractVerificationRequired, /*ModelListener,*/ RankingHeuristicComponent {
    protected final String nodeName;
    protected final BootstrapService bootstraper;
    protected final ModelService service;
    protected boolean stopped;
    protected GCWatcher gcWatcher;
    protected final Object msg;
    //    protected String nameOfRankerFunction;
    protected MonitoringComponent monitoringComponent;
    protected MonitoringStrategy currentStrategy;

    public AbstractMonitoringTask(BootstrapService bootstraper,
                                  ModelService service,/*String nameOfRankerFunction*/
                                  MonitoringComponent monitoringComponent,
                                  String nodeName) {
        this.bootstraper = bootstraper;
        this.service = service;
//        this.nameOfRankerFunction = nameOfRankerFunction;
        this.monitoringComponent = monitoringComponent;
        this.nodeName = nodeName;
        msg = new Object();
    }

    protected void waitMessage() {
        synchronized (msg) {
            try {
                msg.wait();
            } catch (InterruptedException ignored) {

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

    public ComponentInstance[] getRankingOrder(String nodeName) {
        if (monitoringComponent != null) {
            return monitoringComponent.getRankingOrder(nodeName);
        } else {
           return new ComponentInstance[0];
        }
    }

    @Override
    public void triggerMonitoringEvent(MonitoringEvent event) {
        if (monitoringComponent != null) {
            monitoringComponent.triggerMonitoringEvent(event);
        }
    }

    /*@Override
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
    public void preRollback(ContainerRoot containerRoot, ContainerRoot containerRoot2) {
    }

    @Override
    public void postRollback(ContainerRoot containerRoot, ContainerRoot containerRoot2) {
    }*/
}
