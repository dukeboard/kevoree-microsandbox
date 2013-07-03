package org.resourceaccounting;


/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 4/23/13
 * Time: 5:24 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ResourceConsumptionRecorderMBean {
    long getMemoryConsumption(ResourcePrincipal appId);
    long getExecutedInstruction(ResourcePrincipal appId);
    long getTotalSent();
    long getTotalReceived();
    long getBytesSent(ResourcePrincipal appId);
    long getBytesReceived(ResourcePrincipal appId);
    ResourcePrincipal[] getApplications();
    ResourcePrincipal getApplication(String appId);
    void turnMonitoring(boolean on);
}
