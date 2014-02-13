package org.kevoree.microsandbox.javase.components;

import org.kevoree.annotation.*;
import org.kevoree.framework.AbstractComponentType;
import org.kevoree.framework.MessagePort;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 1/23/14
 * Time: 5:23 PM
 *
 */
@Provides({
        @ProvidedPort(name = "pong", type = PortType.MESSAGE)
})
@Requires({
        @RequiredPort(name = "ping", type = PortType.MESSAGE, optional = true)
})
@DictionaryType({
        @DictionaryAttribute(name = "count", defaultValue = "1000000")
})
@ComponentType
public class PingPongComponent extends AbstractComponentType {
    int count = 0;
    int max;

    @Start
    public void start() {
        max = Integer.parseInt(getDictionary().get("count").toString());
        if (getNodeName().equals("node0") && getName().startsWith("pingpong0"))
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(15000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Start pings");
                    int [] a = new int[100];
                    if (isPortBinded("ping")) {
                        MessagePort p = getPortByName("ping", MessagePort.class);
                        for (int i = 0 ; i < max ; ++i) {
        //                    System.out.println("Sending " + i);
                            for (int j = 0 ; j < a.length ; j++)
                                a[j] = i;
                            p.process(a);
                        }
                    }

                }
            }).start();
    }

    @Stop
    public void stop() {

    }

    @Update
    public void update() {
        stop();
        start();
    }

    long time0;

    @Port(name = "pong")
    public void pong(Object obj) {
//        if (count % 200000 == 0)
//            System.out.println(getName() + " " + count);
        if (count == 0)
            time0 = System.nanoTime();
        if (count < max) {
//            MessagePort p = getPortByName("ping", MessagePort.class);
//            p.process(obj);
//            System.out.println(obj.toString());
            count++;
        }
        if (count == max) {
            System.out.println("Used time " + (System.nanoTime() - time0)/1000000000);
        }
    }
}
