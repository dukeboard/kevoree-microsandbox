package org.kevoree.microsandbox.cgroupNode.components;

import org.kevoree.ContainerRoot;
import org.kevoree.annotation.*;
import org.kevoree.api.Context;
import org.kevoree.api.handler.UpdateCallback;
import org.kevoree.core.impl.KevoreeCoreBean;
import org.kevoree.log.Log;
import org.kevoree.microsandbox.cgroupNode.helper.SynchronizedUpdateCallback;
import org.kevoree.microsandbox.cgroupNode.models.ImportingAndExportingModels;

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
                serverSocket = new DatagramSocket(udp_port + 9875/*9876*/);
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


                ContainerRoot modelToDeploy = ImportingAndExportingModels.fromFile(lines[1], repositories, packages);
                Log.info("BEFORE UPDATE MODEL NANOTIME {}", System.nanoTime());
                SynchronizedUpdateCallback callback = new SynchronizedUpdateCallback();
                callback.initialize();
                modelService.update(modelToDeploy, callback);
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
