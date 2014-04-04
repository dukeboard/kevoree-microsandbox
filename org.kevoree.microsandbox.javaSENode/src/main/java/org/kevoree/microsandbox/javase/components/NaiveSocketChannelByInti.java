package org.kevoree.microsandbox.javase.components;

import org.kevoree.*;
import org.kevoree.annotation.*;
import org.kevoree.annotation.ChannelType;
import org.kevoree.api.*;
import org.kevoree.api.Port;
import org.slf4j.LoggerFactory;

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
@ChannelType//(theadStrategy = ThreadStrategy.SHARED_THREAD)
/*@DictionaryType({
        @DictionaryAttribute(name = "port", optional = true, fragmentDependant = true)
})*/
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

    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    @Start
    public void startp() {
        try {
            if (context.getNodeName().equals("node0")) {
                portServer = parsePortNumber(context.getNodeName());
                server = new TCPServer(portServer, this);
                t_server = new Thread(server);
                t_server.start();
            }

        } catch (Exception e) {
            logger.error("Starting ", e);
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
        if (!channelContext.getRemotePortPaths().isEmpty()) {
            List<String> alreadySentToNodes = new ArrayList<String>();
            for (String remotePortPath : channelContext.getRemotePortPaths()) {
                org.kevoree.Port port = modelService.getCurrentModel().getModel().findByPath(remotePortPath, org.kevoree.Port.class);
                // only send data for provided ports
                if (port != null && ((ComponentInstance) port.eContainer()).getProvided().contains(port)) {
                    ContainerNode remoteNode = (ContainerNode) port.eContainer().eContainer();
                    if (!alreadySentToNodes.contains(remoteNode.path())) {
                        try {
                            lock_sender.lock();
                            int portInteger = parsePortNumber(remoteNode.getName());
                            TCPClient.send(payload, portInteger);
//                        logger.info("Sending");
                        } catch (Exception e) {
                            logger.debug("Error while sending message to " + remoteNode.getName());
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
        for (Port p : channelContext.getLocalPorts()) {
            org.kevoree.Port port = modelService.getCurrentModel().getModel().findByPath(p.getPath(), org.kevoree.Port.class);
            if (port != null && ((ComponentInstance) port.eContainer()).getProvided().contains(port)) {
                p.send(payload);
            }
        }
        return null;
    }

    private java.util.concurrent.locks.Lock lock_sender = new ReentrantLock();

    /*@Override
    public ChannelFragmentSender createSender(final String remoteNodeName, final String remoteChannelName) {
        logger.info("Creating Sender in NaiveIntiSocketChannel");
        return new ChannelFragmentSender() {
            @Override
            public Object sendMessageToRemote(Message message) {
                try {
                    lock_sender.lock();
                    if (!remoteNodeName.equals(getNodeName())) {
                        if (!message.getPassedNodes().contains(getNodeName()))
                            message.getPassedNodes().add(getNodeName());
                        message.setDestNodeName(remoteNodeName);

                        int port = parsePortNumber(remoteNodeName);
                        TCPClient.send(message, port);
//                        logger.info("Sending");
                    }
                } catch (Exception e) {
                    logger.debug("Error while sending message to " + remoteNodeName);
                } finally {
                    lock_sender.unlock();
                }
                return null;
            }
        };
    }*/

    public int parsePortNumber(String nodeName) throws IOException {
        try {
            //logger.debug("look for port on " + nodeName);
            Channel instance = modelService.getCurrentModel().getModel().findHubsByID(context.getInstanceName());
            FragmentDictionary fragmentDictionary = instance.findFragmentDictionaryByID(nodeName);
            if (fragmentDictionary != null) {
                DictionaryValue dictionaryValue = fragmentDictionary.findValuesByID("port");
                if (dictionaryValue != null) {
                    return Integer.parseInt(dictionaryValue.getValue());
                }
            }
            return 7000;
//            return Integer.parseInt(KevoreePropertyHelper.instance$.getProperty(getModelElement(), "port", true, nodeName));
        } catch (NumberFormatException e) {
            throw new IOException(e);
        }
    }
}

class TCPServer implements Runnable {

    private final int portServer;
    private final NaiveSocketChannelByInti myChannel;

    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    public TCPServer(int portServer, NaiveSocketChannelByInti myChannel) {
        this.portServer = portServer;
        this.myChannel = myChannel;
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
        String clientSentence;
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
                for (Port p : myChannel.channelContext.getLocalPorts()) {
                    org.kevoree.Port port = myChannel.modelService.getCurrentModel().getModel().findByPath(p.getPath(), org.kevoree.Port.class);
                    if (port != null && ((ComponentInstance) port.eContainer()).getProvided().contains(port)) {
                        p.send(o);
                    }
                }

//                clientSentence = m.get_content().toString();
//                logger.info("Received : " + clientSentence);
//                System.err.printf("Received %s\n", clientSentence);
//
//                if (!m.getPassedNodes().contains(myChannel.getNodeName()))
//                    m.getPassedNodes().add(myChannel.getNodeName());

                // logger.debug("Reiceive msg to  "+msg.getDestNodeName());
//                myChannel.remoteDispatch(m);

                connectionSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
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

class TCPClient {
    static Socket clientSocket;

    public static void send(Object msg, int port) throws Exception {
//        String sentence;
//        String modifiedSentence;
//        BufferedReader inFromServer = new BufferedReader( new InputStreamReader(System.in));
        clientSocket = new Socket("localhost", port);

        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outToServer);
//        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//        sentence = inFromUser.readLine();
        objectOutputStream.writeObject(msg);
//        outToServer.writeBytes(sentence + '\n');
        clientSocket.close();
    }
}
