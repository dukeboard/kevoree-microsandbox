package org.kevoree.monitoring.comp.viewer;

import org.kevoree.annotation.*;
import org.kevoree.framework.AbstractComponentType;
import org.kevoree.monitoring.comp.MyLowLevelResourceConsumptionRecorder;
import org.resourceaccounting.LowLevelResourceMonitorProxy;


/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 6/22/13
 * Time: 7:52 PM
 *
 */
@DictionaryType({
        @DictionaryAttribute(name = "frequency", defaultValue = "1000"),
        @DictionaryAttribute(name = "remote", defaultValue = "false", optional = true),
        @DictionaryAttribute(name = "remote_address", defaultValue = "", optional = true)
})
@ComponentType
public class GraphicalViewer extends AbstractComponentType {

    private PollingConsumption th;

    @Start
    public void startComponent(){
        int frequency = Integer.valueOf(getDictionary().get("frequency").toString());
        Boolean b = Boolean.valueOf((String)getDictionary().get("remote"));
        LowLevelResourceMonitorProxy recorder = MyLowLevelResourceConsumptionRecorder.getInstance();

        if (b) {
            String address = (String)getDictionary().get("remote_address");
        }

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


