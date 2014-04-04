package org.kevoree.microsandbox.samples;

import org.kevoree.*;
import org.kevoree.annotation.ComponentType;
import org.kevoree.annotation.KevoreeInject;
import org.kevoree.annotation.Start;
import org.kevoree.annotation.Stop;
import org.kevoree.api.Context;
import org.kevoree.api.ModelService;
import org.kevoree.api.handler.UUIDModel;
import org.kevoree.api.handler.UpdateCallback;
import org.kevoree.cloner.DefaultModelCloner;
import org.kevoree.log.Log;
import org.kevoree.microsandbox.monitoredNode.MonitoringRegistry;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: duke
 * Date: 30/05/13
 * Time: 14:35
 */
@ComponentType
public class SandboxReasoner implements Runnable {

    @KevoreeInject
    Context context;
    @KevoreeInject
    ModelService modelService;
//    @KevoreeInject
    MonitoringRegistry monitoringRegistry;

    private ScheduledExecutorService schduler = null;
    private ThreadMXBean tbean = null;
    private DefaultModelCloner cloner = new DefaultModelCloner();

    @Start
    public void start() {
        Log.info("Starting Reasoner {}@{}", context.getInstanceName(), context.getNodeName());
        schduler = Executors.newScheduledThreadPool(1);
        tbean = ManagementFactory.getThreadMXBean();
        schduler.scheduleAtFixedRate(this, 2000, 5000, TimeUnit.MILLISECONDS);
        monitoringRegistry = MonitoringRegistry.getInstance();
    }

    @Stop
    public void stop() {
        Log.info("Stoping Reasoner {}@{}", context.getInstanceName(), context.getNodeName());
        schduler.shutdownNow();
        schduler = null;
        tbean = null;
    }

    @Override
    public void run() {
        ContainerRoot currentModel = modelService.getCurrentModel().getModel();
        Log.info("Perf stats =====> ");
        try {
            for (String key : monitoringRegistry.getRegistry().keySet()) {
                if (key.contains("_tg")) {  //TODO far better ....
                    ThreadGroup tg = (ThreadGroup) monitoringRegistry.getRegistry().get(key);
                    Thread[] lists = new Thread[tg.activeCount()];
                    tg.enumerate(lists);
                    long globalWallTime = 0l;
                    for (Thread t : lists) {
                        globalWallTime = globalWallTime + tbean.getThreadCpuTime(t.getId());
                    }
                    String threadGroupKevoreeInstancePath = tg.getName().substring(tg.getName().indexOf("/") + 1);
                    Object foundedInstance = currentModel.findByPath(threadGroupKevoreeInstancePath);
                    if (foundedInstance != null) {
                        //Ok founded, check the contract
                        Instance kevInstance = (Instance) foundedInstance;
                        if (kevInstance.getDictionary() != null) {
                            DictionaryValue val = kevInstance.getDictionary().findValuesByID("cpu_wall_time");
                            if (val != null) {
                                try {
                                    long contractWallTime = Long.parseLong(val.getValue());
                                    if (globalWallTime >= contractWallTime) {
                                        System.out.println("Contract violated , expected " + contractWallTime + " while found : " + globalWallTime);
                                        //simple reaction , remove the component

                                        UUIDModel uuidModel = modelService.getCurrentModel();
                                        ContainerRoot clonedModel = (ContainerRoot) cloner.clone(uuidModel.getModel());
                                        ContainerNode node = clonedModel.findNodesByID(context.getNodeName());
                                        node.removeComponents(clonedModel.findByPath(threadGroupKevoreeInstancePath, ComponentInstance.class));
                                        modelService.compareAndSwap(clonedModel, uuidModel.getUUID(), new UpdateCallback() {
                                            @Override
                                            public void run(Boolean aBoolean) {
                                                if (aBoolean) {
                                                    System.out.println("Model Updated by " + context.getInstanceName());
                                                }
                                            }
                                        });

                                    } else {
                                        System.out.println("Contract respected " + threadGroupKevoreeInstancePath + " : " + globalWallTime);
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    } else {
                        Log.warn("TG not currently found on the platform " + threadGroupKevoreeInstancePath);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.info("<----------------- ");
    }
}
