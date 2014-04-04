package org.kevoree.monitoring.comp.viewer;

import org.kevoree.annotation.*;
import org.kevoree.monitoring.comp.MyLowLevelResourceConsumptionRecorder;
import org.resourceaccounting.LowLevelResourceMonitorProxy;


/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 6/22/13
 * Time: 7:52 PM
 *
 */
@ComponentType
public class GraphicalViewer {

    @Param(defaultValue = "1000")
    int frequency;
    @Param(defaultValue = "false", optional = true)
    boolean remote;
    @Param(defaultValue = "", optional = true)
    String remote_address;

    private PollingConsumption th;

    @Start
    public void startComponent(){
        LowLevelResourceMonitorProxy recorder = MyLowLevelResourceConsumptionRecorder.getInstance();

        th = new PollingConsumption(frequency, recorder);
        AppViewer appViewer = new AppViewer();
        th.setAppBehaviorObserver(appViewer);
        th.start();
    }

    @Stop
    public void stopComponent() {
       th.setStop(true);
    }

    @Update
    public void updateComponent() {
        stopComponent();
        startComponent();
    }
}


