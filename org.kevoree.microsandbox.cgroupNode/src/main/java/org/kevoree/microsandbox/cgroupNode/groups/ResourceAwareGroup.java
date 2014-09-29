package org.kevoree.microsandbox.cgroupNode.groups;

import org.kevoree.*;
import org.kevoree.annotation.*;
import org.kevoree.annotation.GroupType;
import org.kevoree.api.Context;
import org.kevoree.api.ModelService;
import org.kevoree.api.handler.ModelListener;
import org.kevoree.api.handler.UpdateCallback;
import org.kevoree.api.handler.UpdateContext;
import org.kevoree.log.Log;
import org.kevoree.microsandbox.cgroupNode.models.ImportingAndExportingModels;
import org.kevoree.microsandbox.cgroupNode.models.StrategyForModelTransformation;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by inti on 11/06/14.
 */
@GroupType
public class ResourceAwareGroup implements ModelListener {

    @KevoreeInject
    public Context context;

    @KevoreeInject
    public ModelService modelService;

    @Param(optional = true, fragmentDependent = true, defaultValue = "9000")
    Integer port;

    @Param(optional = true)
    String master;

    @Param(optional = true, defaultValue = "true")
    boolean distribute;

    private TCPServer server;

    @Override
    public boolean preUpdate(UpdateContext updateContext) {
        return true;
    }

    @Override
    public boolean initUpdate(UpdateContext updateContext) {
        return true;
    }

    @Override
    public boolean afterLocalUpdate(UpdateContext updateContext) {
        ContainerRoot proposedModel = updateContext.getProposedModel();
        Group selfGroup = (Group) proposedModel.findByPath(context.getPath());
        if (selfGroup == null) {
            Log.error("Model is not ready {}", context.getPath());
            return false;
        }
//        FragmentDictionary masterDico = selfGroup.findFragmentDictionaryByID(selfGroup.);
//        String port = "9000";
//        if (masterDico != null) {
//            DictionaryValue val = masterDico.findValuesByID("port");
//            port = val.getValue();
//        }
        // so far, we are not sending data from the master node
        if (port != 9000)
            try {
                Log.info("Connecting to {} from {}", 9000, port);
                boolean send = false;
                for (ContainerNode node : proposedModel.getNodes()) {
                    if (node.getName().equals("node0")) {
                        send = true;
                        break;
                    }
                }
                if (send) sendToOther(proposedModel, 9000);
            } catch (Exception e) {
                Log.error("Message wasn't transmitted to the other node");
                e.printStackTrace();
                return false;
            }
        return true;
    }

    @Override
    public void modelUpdated() { }

    @Override
    public void preRollback(UpdateContext updateContext) { }

    @Override
    public void postRollback(UpdateContext updateContext) { }

    @Start
    public void startGroup() {
        modelService.registerModelListener(this);
        server = new TCPServer();
        if (port == 9000)
        new Thread(server).start();
    }


    @Stop
    public void stopGroup() {
        server.setStopped(true);
        modelService.unregisterModelListener(this);
    }

    class TCPServer implements Runnable {

        public TCPServer() {
        }

        synchronized boolean isStopped() {
            return isStopped;
        }

        synchronized void setStopped(boolean stopped) {
            isStopped = stopped;
        }

        private boolean isStopped;

        @Override
        public void run() {
            ServerSocket welcomeSocket = null;
            try {
                welcomeSocket = new ServerSocket(port);
                welcomeSocket.setSoTimeout(500);
                while (!isStopped()) {
                    Socket connectionSocket = null;
                    try {
                        connectionSocket = welcomeSocket.accept();
                    } catch (SocketTimeoutException ex) {
                        continue;
                    }
                    ObjectInputStream objectInputStream =
                            new ObjectInputStream(connectionSocket.getInputStream());
                    Object o = objectInputStream.readObject();
                    Log.info("New model received for deployment");
                    connectionSocket.close();
                    ContainerRoot model = ImportingAndExportingModels.toModel(o.toString());

                    if (distribute &&
                            !StrategyForModelTransformation.isAcceptable(model, context.getNodeName())) {
                        Log.info("Modifying the model");
                        Map<String, String> nodesToCreate = new HashMap<String, String>();
                        ContainerRoot mmm = StrategyForModelTransformation.transform(model,
                                context.getNodeName(), "", nodesToCreate);
                        model = mmm;
                    }
                    else {
                        Log.info("Deploying the model as it was submitted because it is correct");
                    }

                    modelService.update(model, new UpdateCallback() {
                        @Override
                        public void run(Boolean applied) {
                            Log.info("{} update result : {}", ResourceAwareGroup.class.getSimpleName(), applied);
                        }
                    });
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (welcomeSocket != null)
                    try {
                        welcomeSocket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }
        }
    }

    public static void sendToOther(ContainerRoot msg, int port) throws Exception {
        Socket clientSocket = new Socket("localhost", port);
        ObjectOutputStream objectOutputStream =
                new ObjectOutputStream(new DataOutputStream(clientSocket.getOutputStream()));
        String modelReturn = ImportingAndExportingModels.toString(msg, new ArrayList<String>(), new ArrayList<String>());
        objectOutputStream.writeObject(modelReturn);
        clientSocket.close();
    }

}
