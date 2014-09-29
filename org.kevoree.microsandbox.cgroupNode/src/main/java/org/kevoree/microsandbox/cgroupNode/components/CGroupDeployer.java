package org.kevoree.microsandbox.cgroupNode.components;

import org.kevoree.*;
import org.kevoree.annotation.Input;
import org.kevoree.annotation.KevoreeInject;
import org.kevoree.annotation.Param;
import org.kevoree.api.Context;
import org.kevoree.api.ModelService;
import org.kevoree.api.handler.ModelListener;
import org.kevoree.api.handler.UpdateContext;
import org.kevoree.kevscript.KevScriptEngine;
import org.kevoree.kevscript.KevScriptExporter;
import org.kevoree.log.Log;
import org.kevoree.microsandbox.cgroupNode.CGroupsNode;
import org.kevoree.microsandbox.cgroupNode.helper.SynchronizedUpdateCallback;
import org.kevoree.microsandbox.cgroupNode.models.ImportingAndExportingModels;
import org.kevoree.microsandbox.cgroupNode.models.StrategyForModelTransformation;

import java.io.*;
import java.util.*;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 1/8/14
 * Time: 6:14 PM
 */
@org.kevoree.annotation.ComponentType
public class CGroupDeployer extends FromFileDeployer implements ModelListener {

    @KevoreeInject
    ModelService modelService;
    @KevoreeInject
    Context context;

    @Param(optional = true, defaultValue = "")
    String log_file_for_experiments;
    @Param(optional = true, defaultValue = "")
    String KevScriptToDeploy;
    @Param(optional = true, defaultValue = "false")
    boolean CRIU_Based_Deployment;
    @Param(optional = true, defaultValue = "true")
    boolean distributed_deployment;

    SlaveRuntimeDeployer deployerStrategy;
    private long initialTime;
    private OutputStream logOutputStream;
    private long totalForkTime;
    private int countForks;

    @org.kevoree.annotation.Start
    public void start() {
        modelService.registerModelListener(this);

        if (log_file_for_experiments == null || log_file_for_experiments.isEmpty()) {
            if (logOutputStream == null)
                logOutputStream = System.err;
        } else try {
            logOutputStream = new FileOutputStream(log_file_for_experiments);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (KevScriptToDeploy==null || KevScriptToDeploy.isEmpty())
            return;

        deployerStrategy = SlaveRuntimeDeployerFactory.get(CRIU_Based_Deployment ?
                                                           SlaveRuntimeDeployerFactory.CRIU :
                                                           SlaveRuntimeDeployerFactory.PROCESSBasedStrategy);
        ContainerRoot model = ImportingAndExportingModels.fromFile(KevScriptToDeploy, repositories, packages);

        Timer timer = new Timer();
        timer.schedule(new MyTimerTask(model), 100);
    }

    @org.kevoree.annotation.Stop
    public void stop() {
        modelService.unregisterModelListener(this);
    }

    @org.kevoree.annotation.Update
    public void update() {
        stop();
        start();
    }

    @Override
    public boolean initUpdate(UpdateContext updateContext) {
        return true;
    }

    @Override
    public boolean afterLocalUpdate(UpdateContext updateContext) {
        return true;
    }

    @Override
    public void modelUpdated() { }

    public void preRollback(UpdateContext updateContext) { }

    @Override
    public void postRollback(UpdateContext updateContext) { }

    @Override
    public boolean preUpdate(UpdateContext updateContext) {

        Log.info("TRYING TO UPDATE {}", System.nanoTime());
        // print current model
        printModel("Current Model", updateContext.getCurrentModel());
        // print proposed model
        printModel("Proposed Model", updateContext.getProposedModel());

        Log.info("TRYING TO UPDATE (AFTER PRINTING) {}", System.nanoTime());


        if (distributed_deployment &&
                !StrategyForModelTransformation.isAcceptable(updateContext.getProposedModel(), context.getNodeName())) {

            try {
                Map<String, String> nodesToCreate = new HashMap<String, String>();
                ContainerRoot mmm = StrategyForModelTransformation.transform(updateContext.getProposedModel(),
                        context.getNodeName(), context.getInstanceName(), nodesToCreate);

                final File file = File.createTempFile("kevModel", ".kevs");
                file.deleteOnExit();
                PrintWriter writer = new PrintWriter(file);

                writer.write(ImportingAndExportingModels.toString(mmm,repositories, packages)); // KevScriptExporter.export(model);
                writer.close();

                Log.info("FILE => " + file.getAbsolutePath());

                printModel("New model to deploy", mmm);
                initialTime = System.nanoTime();

                totalForkTime = 0;
                countForks = 0;

                ThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(
                        Runtime.getRuntime().availableProcessors() / 2);
                executor.execute(new MyTimerTask(mmm));
                for (final String nodeName : nodesToCreate.values()) {
                    executor.execute(new Runnable() {
                        @Override
                        public void run() {
                            long forkTime = System.nanoTime();
                            deployerStrategy.deploy(nodeName, file.getAbsolutePath());

                            forkTime = System.nanoTime() - forkTime;
                            totalForkTime += forkTime;
                            countForks++;

                            Log.info("Time for FORKING was {} milliseconds (Average = {})",
                                    nano2milli(forkTime), nano2milli(totalForkTime / countForks));
                        }
                    });
                }


            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
//            Timer timer = new Timer();
//            timer.schedule(new MyTimerTask(another), 50);

            return false;
        }
        Log.info("Accepting model as it is");
        if (initialTime == 0)
            initialTime = System.nanoTime();
        return true;
    }

    private class MyTimerTask extends TimerTask {
        ContainerRoot model;

        MyTimerTask(ContainerRoot model) {
            this.model = model;
        }

        @Override
        public void run() {
//            Channel ch = model.getHubs().get(0);
//            org.kevoree.Dictionary dico = ch.getDictionary();
//            if (dico != null) {
//                for (DictionaryValue value : dico.getValues()) {
//                    Log.info("La madre {} {}:{}", value.getAttribute().getName(),
//                            value.getValue(), value.getTargetNode().getName());
//                }
//            }
            SynchronizedUpdateCallback callback = new SynchronizedUpdateCallback();
            callback.initialize();
//            Log.info("{} {}\n", modelService, model);
            modelService.update(model, callback);
            callback.waitForResult(5000);
        }
    }

    private void printModel(String title, ContainerRoot model) {
        Log.debug("Model: {}\n", title);
        for (ContainerNode node : model.getNodes()) {
            Log.debug("Node - {} : {}\n", node.getName(),
                    node.getTypeDefinition().getName());
            for (ComponentInstance componentInstance : node.getComponents()) {
                Log.debug("\t=> {} : {}\n", componentInstance.getName(),
                        componentInstance.getTypeDefinition().getName());
            }
        }
    }


    long totalTime = 0;
    int count = 0;

    @Input
    public void startNotification(Object obj) {
        String[] s = obj.toString().split(",");
        long tmp = Long.parseLong(s[1]) - initialTime;
        totalTime += tmp;
        count++;
        PrintWriter ps = new PrintWriter(logOutputStream);
        Log.info("Node {} started in {} milliseconds. (Average = {}, Total = {})",
                s[0], nano2milli(tmp), nano2milli(totalTime) / count, nano2milli(totalTime));

        ps.printf("Node %s started in %f milliseconds. (Average = %f, Total = %f)\n",
                s[0], nano2milli(tmp), nano2milli(totalTime) / count, nano2milli(totalTime));
        ps.flush();
    }

    private double nano2milli(long nanoseconds) {
        return nanoseconds / 1000000.0;
    }
}
