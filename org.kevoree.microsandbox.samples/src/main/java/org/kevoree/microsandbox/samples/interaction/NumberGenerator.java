package org.kevoree.microsandbox.samples.interaction;

import org.kevoree.annotation.*;
import org.kevoree.framework.AbstractComponentType;
import org.kevoree.framework.MessagePort;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 7/6/13
 * Time: 3:39 PM
 *
 */
@Requires({
        @RequiredPort(name = "numbers", type = PortType.MESSAGE, optional = true)
})
@DictionaryType({
        @DictionaryAttribute(name = "frequency", defaultValue = "300")
})
@ComponentType
public class NumberGenerator extends AbstractComponentType {
    Timer t;
    Random random;
    @Start
    public void startComponent() {
        int time = Integer.valueOf(getDictionary().get("frequency").toString());
        random = new Random();
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                if (isPortBinded("numbers")) {
                    getPortByName("numbers", MessagePort.class).process(random.nextInt(200000) + 50000);
                }
            }
        };
        t = new Timer();
        t.schedule(tt, time,time);
    }

    @Stop
    public void stopComponent() {
        t.cancel();
        t = null;
    }

    @Update
    public void updateComponent() {
        stopComponent();
        startComponent();
    }
}
