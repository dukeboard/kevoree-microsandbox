package org.kevoree.microsandbox.cgroupNode.components;

import org.kevoree.ContainerRoot;
import org.kevoree.annotation.ComponentType;
import org.kevoree.annotation.Start;
import org.kevoree.annotation.Stop;
import org.kevoree.annotation.Update;
import org.kevoree.api.service.core.script.KevScriptEngine;
import org.kevoree.api.service.core.script.KevScriptEngineException;
import org.kevoree.core.impl.KevoreeCoreBean;
import org.kevoree.framework.AbstractComponentType;
import org.kevoree.framework.ModelHandlerServiceProxy;
import org.kevoree.log.Log;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.file.*;
import java.util.Timer;

/**
 * Created by inti on 2/20/14.
 */
@ComponentType
public class NodeNameRestarter extends FromFileDeployer {

    private class Mythread extends Thread {
        @Override
        public void run() {
            Log.info("Starting restarter component");
            DatagramSocket serverSocket = null;
            try {
                serverSocket = new DatagramSocket(9876);
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
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

                getModelService().updateModel(getContainerRoot(lines[1]));

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
        Log.info("Changing component name from {}/{} to {}", getNodeName(),
                ((ModelHandlerServiceProxy)getModelService()).getProxy().getNodeName(),
                sentence);
        // doing the job
        ((KevoreeCoreBean)((ModelHandlerServiceProxy)getModelService()).getProxy()).setNodeName(sentence);
        setNodeName(sentence);
        // done
        Log.info("Changed component name to: {}/{}", getNodeName(),
                ((ModelHandlerServiceProxy)getModelService()).getProxy().getNodeName());
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
