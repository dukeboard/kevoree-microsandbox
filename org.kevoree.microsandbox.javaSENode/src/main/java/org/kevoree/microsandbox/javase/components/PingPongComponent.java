package org.kevoree.microsandbox.javase.components;

import org.kevoree.annotation.*;
import org.kevoree.api.Context;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 1/23/14
 * Time: 5:23 PM
 *
 */
@ComponentType
public class PingPongComponent {
    int count = 0;

    @Param(defaultValue = "1000000")
    int maxCount;


    @Output
    org.kevoree.api.Port ping;

    @KevoreeInject
    protected Context context;

    @Start
    public void start() {
        if (context.getNodeName().equals("node0") && context.getInstanceName().startsWith("pingpong0"))
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
                    if (ping.getConnectedBindingsSize() > 0) {
                        for (int i = 0; i < maxCount; ++i) {
                            //                    System.out.println("Sending " + i);
                            for (int j = 0; j < a.length; j++)
                                a[j] = i;
                            ping.send(a);
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

    @Input
    public void pong(Object obj) {
//        if (count % 200000 == 0)
//            System.out.println(getName() + " " + count);
        if (count == 0)
            time0 = System.nanoTime();
        if (count < maxCount) {
//            MessagePort p = getPortByName("ping", MessagePort.class);
//            p.process(obj);
//            System.out.println(obj.toString());
            count++;
        }
        if (count == maxCount) {
            System.out.println("Used time " + (System.nanoTime() - time0)/1000000000);
        }
    }
}
