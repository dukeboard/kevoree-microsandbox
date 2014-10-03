package org.kevoree.monitoring.comp;

import org.resourceaccounting.LowLevelResourceMonitorProxy;
import org.resourceaccounting.ResourcePrincipal;
import org.resourceaccounting.binder.MonitoringStatusList;
import org.resourceaccounting.binder.ResourceCounter;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 6/22/13
 * Time: 8:08 PM
 *
 */
public class MyLowLevelResourceConsumptionRecorder implements LowLevelResourceMonitorProxy {

    private final static LowLevelResourceMonitorProxy instance = new MyLowLevelResourceConsumptionRecorder();

    public static LowLevelResourceMonitorProxy getInstance() {
        return instance;
    }

    @Override
    public long getMemoryConsumption(ResourcePrincipal appId) {
        assert ResourceCounter.class.getClassLoader() == null;
        return ResourceCounter.getNbObjects(appId);
    }

    @Override
    public long getExecutedInstruction(ResourcePrincipal appId) {
        assert ResourceCounter.class.getClassLoader() == null;
        return ResourceCounter.getNbInstructions(appId);
    }

    @Override
    public long getTotalSent() {
        assert ResourceCounter.class.getClassLoader() == null;
        return ResourceCounter.getTotalSent();
    }

    @Override
    public long getTotalReceived() {
        assert ResourceCounter.class.getClassLoader() == null;
        return ResourceCounter.getTotalReceived();
    }

    @Override
    public long getTotalRead() {
        assert ResourceCounter.class.getClassLoader() == null;
        return ResourceCounter.getTotalRead();
    }

    @Override
    public long getTotalWritten() {
        assert ResourceCounter.class.getClassLoader() == null;
        return ResourceCounter.getTotalWritten();
    }

    @Override
    public long getBytesSent(ResourcePrincipal appId) {
        assert ResourceCounter.class.getClassLoader() == null;
        return ResourceCounter.getNbBytesSent(appId);
    }

    @Override
    public long getBytesReceived(ResourcePrincipal appId) {
        assert ResourceCounter.class.getClassLoader() == null;
        return ResourceCounter.getNbBytesReceived(appId);
    }

    @Override
    public long getWrittenBytes(ResourcePrincipal appId) {
        assert ResourceCounter.class.getClassLoader() == null;
        return ResourceCounter.getNbWrittenBytes(appId);
    }

    @Override
    public long getReadBytes(ResourcePrincipal appId) {
        assert ResourceCounter.class.getClassLoader() == null;
        return ResourceCounter.getNbReadBytes(appId);
    }

    @Override
    public ResourcePrincipal[] getApplications() {
        assert ResourceCounter.class.getClassLoader() == null;
        return ResourceCounter.getApplications();
    }

    @Override
    public ResourcePrincipal getApplication(String appId) {
        assert ResourceCounter.class.getClassLoader() == null;
        return ResourceCounter.getApplication(appId);
    }

    @Override
    public void turnMonitoring(boolean on, boolean changeInstrumentingStatus) {
        assert ResourceCounter.class.getClassLoader() == null;
        ResourceCounter.setMonitoring(on, changeInstrumentingStatus);
    }

    @Override
    public void turnFilteredPrincipalMonitoring(boolean on, String appID) {
        assert ResourceCounter.class.getClassLoader() == null;
        ResourceCounter.turnMonitoringSinglePrincipal(on, appID);
    }

    @Override
    public void turnOnPortControllingOn(String component, String port, boolean sender, int max) {
        assert ResourceCounter.class.getClassLoader() == null;
        ResourceCounter.startControlling(component, port, sender, max);
    }

    @Override
    public int getUsesOfProvidedPort(String component, String port) {
        assert ResourceCounter.class.getClassLoader() == null;
        return ResourceCounter.getUsesOfProvidedPort(component, port);
    }

    @Override
    public int getUsesOfRequiredPort(String component, String port) {
        assert ResourceCounter.class.getClassLoader() == null;
        return ResourceCounter.getUsesOfRequiredPort(component, port);
    }

    @Override
    public boolean isScapegoat2() {
        assert ResourceCounter.class.getClassLoader() == null;
        return ResourceCounter.isScapegoat2();
    }
}
