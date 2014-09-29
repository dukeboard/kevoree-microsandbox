package org.kevoree.microsandbox.javase.components;

import org.kevoree.*;
import org.kevoree.annotation.*;
import org.kevoree.annotation.ChannelType;
import org.kevoree.api.*;
import org.kevoree.api.Port;
import org.kevoree.log.Log;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;


/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 1/13/14
 * Time: 1:45 PM
 */
@ChannelType
public class NaiveSocketChannelByInti implements ChannelDispatch {

    @Param(fragmentDependent = true, optional = true, defaultValue = "7000")
    protected int port;

    @KevoreeInject
    protected Context context;
    @KevoreeInject
    protected ModelService modelService;
    @KevoreeInject
    protected ChannelContext channelContext;

    private TCPServer server;
    private Thread t_server;
    private int portServer;


    @Start
    public void startp() {
        try {
            Log.info("\t\t\tINTI - STARTING A NAIVE SOCKET CHANNEL BY INTI IN NODE {}", modelService.getNodeName());
//            if (context.getNodeName().equals("node0")) {
                portServer = port;//parsePortNumber(context.getNodeName());
                server = new TCPServer();
                t_server = new Thread(server);
                t_server.start();
//            }

        } catch (Exception e) {
            Log.error("Starting ", e);
        }

    }

    @Stop
    public void stopp() {
        if (server != null) {
            server.setStopped(true);
        }
        if (t_server != null) {
            t_server.interrupt(); // just to break the accept
        }
    }

    @Update
    public void updatep() {
        int p = 0;
        try {
            p = parsePortNumber(context.getNodeName());
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (p != portServer) {
            try {
                stopp();
                Thread.sleep(800);
                startp();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void dispatch(final Object payload, final Callback callback) {
//        Log.info("\tINTI - DISSSSSSSSSSSSSSSSSSSSSSSPATCH {} {} {}",
//                context.getInstanceName(),
//                context.getNodeName(),
//                payload);
        if (!channelContext.getRemotePortPaths().isEmpty()) {
//            Log.info("\tINTI - DISSSSSSSSSSSSSSSSSSSSSSSPATCH to REMOTE {} {} {}",
//                    context.getInstanceName(),
//                    context.getNodeName(),
//                    payload);
            ContainerRoot model = modelService.getCurrentModel().getModel();
            List<String> alreadySentToNodes = new ArrayList<String>();
            for (String remotePortPath : channelContext.getRemotePortPaths()) {
                org.kevoree.Port port = (org.kevoree.Port)model.findByPath(remotePortPath/*, org.kevoree.Port.class*/);
//                Log.info("\t\tINTI - DISSSSSSSSSSSSSSSSSSSSSSSPATCH to REMOTE {} {}",
//                        remotePortPath, port.path());
                // only sendToOther data for provided ports
                if (port != null && ((ComponentInstance) port.eContainer()).getProvided().contains(port)) {
                    ContainerNode remoteNode = (ContainerNode) port.eContainer().eContainer();
                    if (!alreadySentToNodes.contains(remoteNode.path())) {
//                        Log.info("\t\tINTI - DISSSSSSSSSSSSSSSSSSSSSSSPATCH WILL SEND TO REMOTE");
                        try {
                            lock_sender.lock();
                            int portInteger = parsePortNumber(remoteNode.getName());
                            Log.debug("Channel in node {} is trying to sendToOther to port {}",
                                    context.getNodeName(), portInteger);
                            sendToOther(payload, portInteger);
                        } catch (Exception e) {
                            Log.error("Error while sending message to {}. Error\n{}",
                                    remoteNode.getName(), e.toString());
                        } finally {
                            lock_sender.unlock();
                        }
                        alreadySentToNodes.add(remoteNode.path());
                    }
                }
            }
        }
        dispatchLocal(payload);
    }

    public Object dispatchLocal(Object payload) {
        ContainerRoot model = modelService.getCurrentModel().getModel();
        for (Port p : channelContext.getLocalPorts()) {
            org.kevoree.Port port = (org.kevoree.Port)model.findByPath(p.getPath()/*, org.kevoree.Port.class*/);
            if (port != null && ((ComponentInstance) port.eContainer()).getProvided().contains(port)) {
                p.send(payload);
            }
        }
        return null;
    }

    private java.util.concurrent.locks.Lock lock_sender = new ReentrantLock();

    public int parsePortNumber(String nodeName) throws IOException {
        try {
            //logger.debug("look for port on " + nodeName);
            Channel instance = modelService.getCurrentModel().getModel().findHubsByID(context.getInstanceName());
            FragmentDictionary fragmentDictionary = instance.findFragmentDictionaryByID(nodeName);
            if (fragmentDictionary != null) {
                Value dictionaryValue = fragmentDictionary.findValuesByID("port");
//                DictionaryValue dictionaryValue = fragmentDictionary.findValuesByID("port");
                if (dictionaryValue != null) {
                    return Integer.parseInt(dictionaryValue.getValue());
                }
            }
            return 7000;
        } catch (NumberFormatException e) {
            throw new IOException(e);
        }
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
                welcomeSocket = new ServerSocket(portServer);
                welcomeSocket.setSoTimeout(500);
                while (!isStopped()) {
                    Socket connectionSocket = null;
                    try {
                        connectionSocket = welcomeSocket.accept();
                    } catch (SocketTimeoutException ex) {
                        continue;
                    }
                    InputStream inputStream = connectionSocket.getInputStream();

                    ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
                    Object o = objectInputStream.readObject();
                    ContainerRoot model = modelService.getCurrentModel().getModel();
                    for (Port p : channelContext.getLocalPorts()) {
                        org.kevoree.Port port = (org.kevoree.Port)model.findByPath(p.getPath()/*, org.kevoree.Port.class*/);
                        if (port != null && ((ComponentInstance) port.eContainer()).getProvided().contains(port)) {
                            p.send(o);
                        }
                    }
                    connectionSocket.close();
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

    public static void sendToOther(Object msg, int port) throws Exception {
        Socket clientSocket = new Socket("localhost", port);
        ObjectOutputStream objectOutputStream =
                new ObjectOutputStream(new DataOutputStream(clientSocket.getOutputStream()));
        objectOutputStream.writeObject(msg);
        clientSocket.close();
    }
}
