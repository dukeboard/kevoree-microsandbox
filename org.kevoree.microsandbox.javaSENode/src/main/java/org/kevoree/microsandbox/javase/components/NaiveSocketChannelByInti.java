package org.kevoree.microsandbox.javase.components;

import org.kevoree.annotation.*;
import org.kevoree.framework.AbstractChannelFragment;
import org.kevoree.framework.ChannelFragmentSender;
import org.kevoree.framework.KevoreeChannelFragment;
import org.kevoree.framework.KevoreePropertyHelper;
import org.kevoree.framework.message.Message;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.concurrent.locks.ReentrantLock;


/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 1/13/14
 * Time: 1:45 PM
 *
 */
@ChannelType(theadStrategy = ThreadStrategy.SHARED_THREAD)
@DictionaryType({
        @DictionaryAttribute(name = "port", optional = true, fragmentDependant = true)
})
public class NaiveSocketChannelByInti extends AbstractChannelFragment {

    private TCPServer server;
    private Thread t_server;
    private int portServer;

    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    @Start
    public void startp() {
        try {
            portServer = parsePortNumber(getNodeName());
            server = new TCPServer(portServer, this);
            t_server = new Thread(server);
            t_server.start();

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
            p = parsePortNumber(getNodeName());
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
    public Object dispatch(Message message) {
//        logger.info("Trying to dispatch in NaiveIntiSocketChannel");
        if (delegate != null) {
//            logger.info("It will delegate");
        }
        for (org.kevoree.framework.KevoreePort p : getBindedPorts()) {
//            logger.info("port");
            forward(p, message);
        }
        for (KevoreeChannelFragment cf : getOtherFragments()) {
//            logger.info("fragment");
            if (!message.getPassedNodes().contains(cf.getNodeName())) {
//                logger.info("valid fragment");
                forward(cf, message);
            }
        }
        return null;
    }

//    @Override
//    public Object forward(KevoreePort d, Message msg) {
//        ChannelFragmentSender my_sender = createSender(d.)
//    }

    private java.util.concurrent.locks.Lock lock_sender = new ReentrantLock();

    @Override
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
    }

    public int parsePortNumber(String nodeName) throws IOException {
        try {
            //logger.debug("look for port on " + nodeName);

            return Integer.parseInt(KevoreePropertyHelper.instance$.getProperty(getModelElement(), "port", true, nodeName));
        } catch (NumberFormatException e) {
            throw new IOException(e.getMessage());
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
            while(!isStopped())
            {
                Socket connectionSocket = null;
                try {
                    connectionSocket = welcomeSocket.accept();
                }
                catch (SocketTimeoutException ex) {
                    continue;
                }
                InputStream inputStream = connectionSocket.getInputStream();

                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
                Message m = (Message)objectInputStream.readObject();

                clientSentence = m.get_content().toString();
//                logger.info("Received : " + clientSentence);
//                System.err.printf("Received %s\n", clientSentence);
//
//                if (!m.getPassedNodes().contains(myChannel.getNodeName()))
//                    m.getPassedNodes().add(myChannel.getNodeName());

                // logger.debug("Reiceive msg to  "+msg.getDestNodeName());
//                myChannel.remoteDispatch(m);

                for (org.kevoree.framework.KevoreePort p : myChannel.getBindedPorts())
                    myChannel.forward(p, m);

                connectionSocket.close();

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally {
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
    public static void send(Message msg, int port) throws Exception
    {
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
