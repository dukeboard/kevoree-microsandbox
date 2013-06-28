package org.resourceaccounting;

import org.resourceaccounting.binder.ResourceCounter;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 4/23/13
 * Time: 5:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class ResourceConsumptionRecorder implements ResourceConsumptionRecorderMBean {
    public long getMemoryConsumption(ResourcePrincipal appId) {
        return ResourceCounter.getNbObjects(appId);
    }

    public long getExecutedInstruction(ResourcePrincipal appId) {
        return ResourceCounter.getNbInstructions(appId);
    }

    public long getTotalSent() {
        return ResourceCounter.getTotalSent();
    }

    public long getTotalReceived() {
        return getTotalReceived();
    }

    public long getBytesSent(ResourcePrincipal appId) {
        return ResourceCounter.getNbBytesSent(appId);
    }

    public long getBytesReceived(ResourcePrincipal appId) {
        return ResourceCounter.getNbBytesReceived(appId);
    }

    public ResourcePrincipal[] getApplications() {
        return ResourceCounter.getApplications();
    }

    @Override
    public ResourcePrincipal getApplication(String appId) {
        return ResourceCounter.getApplication(appId);
    }
}
