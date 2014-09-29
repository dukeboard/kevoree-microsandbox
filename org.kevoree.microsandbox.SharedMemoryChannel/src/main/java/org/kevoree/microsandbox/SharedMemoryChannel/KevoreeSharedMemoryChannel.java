package org.kevoree.microsandbox.SharedMemoryChannel;

import org.ipc.memory.MemoryBasedQueueConsumer;
import org.ipc.memory.MemoryBasedQueueProducer;
import org.kevoree.*;
import org.kevoree.annotation.ChannelType;
import org.kevoree.annotation.*;
import org.kevoree.api.*;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 1/23/14
 * Time: 1:12 PM
 *
 */
@ChannelType//(theadStrategy = ThreadStrategy.SHARED_THREAD)
public class KevoreeSharedMemoryChannel implements ChannelDispatch {

    @KevoreeInject
    ModelService modelService;
    @KevoreeInject
    Context context;
    @KevoreeInject
    ChannelContext channelContext;


    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    private ConsumerSide server;

    private List<Channel> channels;
    int channelIndex;
    private int consumers;

    @Start
    public void startp() {
        List<Channel> channelList = modelService.getPendingModel().getHubs();
        channels = new ArrayList<Channel>(channelList);
        Collections.sort(channels, new Comparator<Channel>() {
            @Override
            public int compare(Channel o1, Channel o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        for (channelIndex = 0 ; channelIndex <  channels.size()
                && !channels.get(channelIndex).getName().equals(context.getInstanceName()) ; ++channelIndex);

        if (channelIndex ==  channels.size())
            channelIndex = -1;

//        logger.info("Channel {} with index {}", getName(), channelIndex);

        // a node should have a server iff
        // exist a component connected to this channel such that the
        // bind port is a provided port
        Channel mySelf = channels.get(channelIndex);
        ContainerRoot model = modelService.getPendingModel();
        consumers = 0;
        boolean needLocalConsumer = false;
        for (ContainerNode node : model.getNodes()) {
            boolean needConsumer = false;
            for (ComponentInstance instance : node.getComponents()) {
                for (org.kevoree.Port p : instance.getProvided()) {
                    for (MBinding binding : p.getBindings())
                        if (binding.getHub().getName().equals(mySelf.getName()))
                            needConsumer = true;
                }
            }
            if (needConsumer) {
                consumers ++;
                if (node.getName().equals(context.getNodeName()))
                    needLocalConsumer = true;
            }
        }
//        logger.info("Consumers {} {}", getNodeName(), consumers);
//        logger.info("Local consumer {} {}", getNodeName(), needLocalConsumer);
//        logger.info("Starting {}", getNodeName());
        if (needLocalConsumer) {
            server = new ConsumerSide(this, channelIndex);
            server.start();
        }
    }

    @Stop
    public void stopp() {
//        logger.info("TRYING TO STOP");
        if (server != null) {
            server.setStopped(true);
            try {
                server.join(1000);
                server.interrupt();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Update
    public void updatep() {
//        logger.info("TRYING TO UPDATE");
        try {
            stopp();
            startp();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dispatch(Message message) throws IOException {
        message.getPassedNodes().add(context.getNodeName());
        OutputStream stream = producer.getStreamToSendMessage();
        ObjectOutputStream oos = new ObjectOutputStream(stream);
//                oos.writeUTF(getNodeName()); // write the source
//                oos.writeObject(message.get_content());
        oos.writeObject(message);
        producer.notifySend(stream);
    }

    @Override
    public void dispatch(final Object payload, final Callback callback) {
        if (!channelContext.getRemotePortPaths().isEmpty()) {
            List<String> alreadySentToNodes = new ArrayList<String>();
            ContainerRoot currentModel = modelService.getCurrentModel().getModel();
            for (String remotePortPath : channelContext.getRemotePortPaths()) {
                org.kevoree.Port port = (org.kevoree.Port)currentModel.findByPath(remotePortPath);
                // only send data for provided ports
                if (port != null && ((ComponentInstance) port.eContainer()).getProvided().contains(port)) {
                    ContainerNode remoteNode = (ContainerNode) port.eContainer().eContainer();
                    if (!alreadySentToNodes.contains(remoteNode.path())) {
                        try {
                            if (producer == null) {
                                int count = consumers;//getOtherFragments().size() + 1;
                                producer = new MemoryBasedQueueProducer(context.getInstanceName(), count);
                            }
                            Message message = new Message();
                            message.setPayload(payload);
                            dispatch(message);
//                        logger.info("Sending info 7");
                        } catch (Exception e) {
                            logger.debug("Error while sending message ");
                        }
                        alreadySentToNodes.add(remoteNode.path());
                    }
                }
            }
        }
        dispatchLocal(payload);
    }

    public Object dispatchLocal(Object payload) {
        ContainerRoot currentModel = modelService.getCurrentModel().getModel();
        for (org.kevoree.api.Port p : channelContext.getLocalPorts()) {
            org.kevoree.Port port = (org.kevoree.Port)currentModel.findByPath(p.getPath());
            if (port != null && ((ComponentInstance) port.eContainer()).getProvided().contains(port)) {
                p.send(payload);
            }
        }
        return null;
    }

    class Message implements Serializable {
        private Object payload;
        private List<String> passedNodes;

        public Object getPayload() {
            return payload;
        }

        public void setPayload(Object payload) {
            this.payload = payload;
        }

        public List<String> getPassedNodes() {
            return passedNodes;
        }

        public void setPassedNodes(List<String> passedNodes) {
            this.passedNodes = passedNodes;
        }
    }

    /*@Override
    public Object dispatch(Message message) {
        for (org.kevoree.framework.KevoreePort p : getBindedPorts()) {
            forward(p, message);
        }

        if (getOtherFragments().size() > 0) {
            try {
                if (producer == null) {
                    int count = consumers;//getOtherFragments().size() + 1;
                    producer = new MemoryBasedQueueProducer(getName(), count);
                }
                message.getPassedNodes().add(getNodeName());
                OutputStream stream = producer.getStreamToSendMessage();
                ObjectOutputStream oos = new ObjectOutputStream(stream);
//                oos.writeUTF(getNodeName()); // write the source
//                oos.writeObject(message.get_content());
                oos.writeObject(message);
                producer.notifySend(stream);
//                        logger.info("Sending info 7");
            } catch (Exception e) {
                logger.debug("Error while sending message ");
            }
        }

//        for (KevoreeChannelFragment cf : getOtherFragments()) {
////            logger.info("fragment");
//            if (!message.getPassedNodes().contains(cf.getNodeName())) {
////                logger.info("valid fragment");
//                forward(cf, message);
//            }
//        }
        return null;
    }*/

    private MemoryBasedQueueProducer producer = null;

    /*@Override
    public ChannelFragmentSender createSender(final String remoteNodeName, final String remoteChannelName) {
        return null;
    }*/
}

class ConsumerSide extends Thread {
    private final int channelIndex;
    private boolean stopped;

    private final KevoreeSharedMemoryChannel myChannel;

    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    ConsumerSide(KevoreeSharedMemoryChannel myChannel, int channelIndex) {
        this.myChannel = myChannel;
        stopped = false;
        this.channelIndex = channelIndex;
    }

    @Override
    public void run() {
        try {
            // initialization
            MemoryBasedQueueConsumer consumer =
                    new MemoryBasedQueueConsumer(myChannel.context.getInstanceName());
            // loop waiting
            while (!isStopped()) {
//                logger.info("waiting for message");
                int id = consumer.waitForMessage();
//                logger.info("new message");
                ObjectInputStream objectInputStream = new ObjectInputStream(consumer.getMessageInputStream(id));
//                String src = objectInputStream.readUTF();
                KevoreeSharedMemoryChannel.Message m = (KevoreeSharedMemoryChannel.Message)objectInputStream.readObject();
                if (!m.getPassedNodes().contains(myChannel.context.getNodeName())) {
                    myChannel.dispatchLocal(m.getPayload());
                    consumer.notifyReception(id);
                }
//                if (!src.equals(myChannel.getNodeName()))
//                {
//                    Object obj = objectInputStream.readObject();
//                    consumer.notifyReception(id);
//                    Message m = new Message();
//                    m.set_content(obj);
//                    for (org.kevoree.framework.KevoreePort p : myChannel.getBindedPorts())
//                        myChannel.forward(p, m);
//                }
                else
                    consumer.notifyReception(id);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean isStopped() {
        return stopped;
    }

    public void setStopped(boolean stopped) {
        this.stopped = stopped;
    }
}