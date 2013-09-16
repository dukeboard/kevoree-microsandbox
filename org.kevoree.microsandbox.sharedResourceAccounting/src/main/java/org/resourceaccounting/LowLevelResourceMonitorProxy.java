package org.resourceaccounting;


/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 4/23/13
 * Time: 5:24 PM
 * To change this template use File | Settings | File Templates.
 */
public interface LowLevelResourceMonitorProxy {
    long getMemoryConsumption(ResourcePrincipal appId);
    long getExecutedInstruction(ResourcePrincipal appId);
    long getTotalSent();
    long getTotalReceived();
    long getTotalRead();
    long getTotalWritten();
    long getBytesSent(ResourcePrincipal appId);
    long getBytesReceived(ResourcePrincipal appId);
    long getWrittenBytes(ResourcePrincipal appId);
    long getReadBytes(ResourcePrincipal appId);
    ResourcePrincipal[] getApplications();
    ResourcePrincipal getApplication(String appId);
    void turnMonitoring(boolean on, boolean changeInstrumentingStatus);

    /**
     * Enable the monitoring of one principal
     * @param on true if you want to enable filtered monitoring, false to disable it
     * @param appID if on == true, it is the ID of the principal you want to include in the set of monitored
     */
    void turnFilteredPrincipalMonitoring(boolean on, String appID);
    void turnOnPortControllingOn(String component, String port, boolean sender, int max);


    int getUsesOfProvidedPort(String component, String port);

    int getUsesOfRequiredPort(String component, String port);
}
