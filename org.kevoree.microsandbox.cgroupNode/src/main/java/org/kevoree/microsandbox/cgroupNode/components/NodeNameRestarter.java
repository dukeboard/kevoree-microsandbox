package org.kevoree.microsandbox.cgroupNode.components;

import org.kevoree.annotation.*;
import org.kevoree.api.Context;
import org.kevoree.core.impl.KevoreeCoreBean;
import org.kevoree.komponents.helpers.SynchronizedUpdateCallback;
import org.kevoree.log.Log;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Created by inti on 2/20/14.
 */
@ComponentType
public class NodeNameRestarter extends FromFileDeployer {

    @KevoreeInject
    Context context;
    @Param(optional = false)
    int udp_port;

    private class Mythread extends Thread {
        @Override
        public void run() {
            Log.info("Starting restarter component");
            DatagramSocket serverSocket = null;
            try {
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket = new DatagramSocket(udp_port/*9876*/);
                serverSocket.receive(receivePacket);
                String sentence = new String(
                        receivePacket.getData(), receivePacket.getOffset(), receivePacket.getLength());
                String[] lines = sentence.split("\n");

//                changeNameOfNode(lines[0]);

                Log.debug("File {}", lines[1]);

                serverSocket.send(new DatagramPacket("OK".getBytes(),
                        "OK".getBytes().length,
                        receivePacket.getAddress(),
                        receivePacket.getPort()));

                serverSocket.close();

                Log.info("BEFORE UPDATE MODEL NANOTIME {}", System.nanoTime());

                SynchronizedUpdateCallback callback = new SynchronizedUpdateCallback();
                callback.initialize();
                modelService.update(getContainerRoot(lines[1]), callback);
                callback.waitForResult(5000);
            } catch (SocketException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                if (serverSocket != null && !serverSocket.isClosed()) {
                    serverSocket.close();
                }
            }
        }
    }

    private void changeNameOfNode(String sentence) {
        // FIXME, Ugly hack.
        Log.info("Changing component name from {}/{} to {}", context.getNodeName(),
                ((KevoreeCoreBean) modelService).getNodeName(),
                sentence);
        // doing the job
        // FIXME is it ok like this ????
        ((KevoreeCoreBean)modelService).setNodeName(sentence);
        // done
        Log.info("Changed component name to: {}/{}", context.getNodeName(),
                ((KevoreeCoreBean)modelService).getNodeName());
    }

    @Start
    public void start() {
        new Mythread().start();
    }

    @Stop
    public void stop() {
    }

    @Update
    public void update() {
        stop();
        start();
    }
}
