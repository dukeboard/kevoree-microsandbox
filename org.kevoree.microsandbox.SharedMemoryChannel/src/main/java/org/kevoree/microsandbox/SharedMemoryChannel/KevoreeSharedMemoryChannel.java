package org.kevoree.microsandbox.SharedMemoryChannel;

import org.ipc.memory.MemoryBasedQueueConsumer;
import org.ipc.memory.MemoryBasedQueueProducer;
import org.kevoree.*;
import org.kevoree.annotation.*;
import org.kevoree.annotation.ChannelType;
import org.kevoree.annotation.DictionaryType;
import org.kevoree.framework.AbstractChannelFragment;
import org.kevoree.framework.ChannelFragmentSender;
import org.kevoree.framework.message.Message;
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
@DictionaryType({
})
@ChannelType(theadStrategy = ThreadStrategy.SHARED_THREAD)
public class KevoreeSharedMemoryChannel extends AbstractChannelFragment {

    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    private ConsumerSide server;

    private List<Channel> channels;
    int channelIndex;
    private int consumers;

    @Start
    public void startp() {
        List<Channel> channelList = getModelService().getLastModel().getHubs();
        channels = new ArrayList<Channel>(channelList);
        Collections.sort(channels, new Comparator<Channel>() {
            @Override
            public int compare(Channel o1, Channel o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        for (channelIndex = 0 ; channelIndex <  channels.size()
                && !channels.get(channelIndex).getName().equals(getName()) ; ++channelIndex);

        if (channelIndex ==  channels.size())
            channelIndex = -1;

//        logger.info("Channel {} with index {}", getName(), channelIndex);

        // a node should have a server iff
        // exist a component connected to this channel such that the
        // bind port is a provided port
        Channel mySelf = channels.get(channelIndex);
        ContainerRoot model = getModelService().getLastModel();
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
                if (node.getName().equals(getNodeName()))
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

    @Override
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
    }

    private MemoryBasedQueueProducer producer = null;

    @Override
    public ChannelFragmentSender createSender(final String remoteNodeName, final String remoteChannelName) {
        return null;
    }
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
                    new MemoryBasedQueueConsumer(myChannel.getName());
            // loop waiting
            while (!isStopped()) {
//                logger.info("waiting for message");
                int id = consumer.waitForMessage();
//                logger.info("new message");
                ObjectInputStream objectInputStream = new ObjectInputStream(consumer.getMessageInputStream(id));
//                String src = objectInputStream.readUTF();
                Message m = (Message)objectInputStream.readObject();
                if (!m.getPassedNodes().contains(myChannel.getName())) {
                    for (org.kevoree.framework.KevoreePort p : myChannel.getBindedPorts())
                        myChannel.forward(p, m);
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