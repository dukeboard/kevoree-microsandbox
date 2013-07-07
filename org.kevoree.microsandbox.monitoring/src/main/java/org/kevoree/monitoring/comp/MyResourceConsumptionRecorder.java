package org.kevoree.monitoring.comp;

import org.resourceaccounting.ResourceConsumptionRecorderMBean;
import org.resourceaccounting.ResourcePrincipal;
import org.resourceaccounting.binder.ResourceCounter;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 6/22/13
 * Time: 8:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class MyResourceConsumptionRecorder implements ResourceConsumptionRecorderMBean {

    private final static ResourceConsumptionRecorderMBean instance = new MyResourceConsumptionRecorder();

    public static ResourceConsumptionRecorderMBean getInstance() {
        return instance;
    }

    @Override
    public long getMemoryConsumption(ResourcePrincipal appId) {
        return ResourceCounter.getNbObjects(appId);
    }

    @Override
    public long getExecutedInstruction(ResourcePrincipal appId) {
        return ResourceCounter.getNbInstructions(appId);
    }

    @Override
    public long getTotalSent() {
        return ResourceCounter.getTotalSent();
    }

    @Override
    public long getTotalReceived() {
        return ResourceCounter.getTotalReceived();
    }

    @Override
    public long getTotalRead() {
        return ResourceCounter.getTotalRead();
    }

    @Override
    public long getTotalWritten() {
        return ResourceCounter.getTotalWritten();
    }

    @Override
    public long getBytesSent(ResourcePrincipal appId) {
        return ResourceCounter.getNbBytesSent(appId);
    }

    @Override
    public long getBytesReceived(ResourcePrincipal appId) {
        return ResourceCounter.getNbBytesReceived(appId);
    }

    @Override
    public long getWrittenBytes(ResourcePrincipal appId) {
        return ResourceCounter.getNbWrittenBytes(appId);
    }

    @Override
    public long getReadBytes(ResourcePrincipal appId) {
        return ResourceCounter.getNbReadBytes(appId);
    }

    @Override
    public ResourcePrincipal[] getApplications() {
        return ResourceCounter.getApplications();
    }

    @Override
    public ResourcePrincipal getApplication(String appId) {
        return ResourceCounter.getApplication(appId);
    }

    @Override
    public void turnMonitoring(boolean on) {
        ResourceCounter.setMonitoring(on);
    }

    @Override
    public int getUsesOfProvidedPort(String component, String port) {
        return ResourceCounter.getUsesOfProvidedPort(component, port);
    }

    @Override
    public int getUsesOfRequiredPort(String component, String port) {
        return ResourceCounter.getUsesOfRequiredPort(component, port);
    }
}
