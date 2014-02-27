package org.kevoree.microsandbox.cgroupNode.components;

import org.kevoree.ContainerRoot;
import org.kevoree.annotation.ComponentType;
import org.kevoree.annotation.Start;
import org.kevoree.annotation.Stop;
import org.kevoree.annotation.Update;
import org.kevoree.api.service.core.script.KevScriptEngine;
import org.kevoree.api.service.core.script.KevScriptEngineException;
import org.kevoree.framework.AbstractComponentType;
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
public class NodeNameRestarter extends AbstractComponentType {


    private class Mythread extends Thread {
        @Override
        public void run() {
            System.out.println("LALALLAL SERVER");
            DatagramSocket serverSocket = null;
            try {
                serverSocket = new DatagramSocket(9876);
                byte[] receiveData = new byte[1024];
                byte[] sendData = new byte[1024];
                while(true)
                {
                    DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                    serverSocket.receive(receivePacket);
                    String sentence = new String( receivePacket.getData());
                    System.out.println("RECEIVED: " + sentence);
                    InetAddress IPAddress = receivePacket.getAddress();
                    int port = receivePacket.getPort();
                    String capitalizedSentence = sentence.toUpperCase();
                    sendData = capitalizedSentence.getBytes();
                    DatagramPacket sendPacket =
                            new DatagramPacket(sendData, sendData.length, IPAddress, port);
                    serverSocket.send(sendPacket);
                }
            } catch (SocketException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Start
    public void start() {
        // FIXME, Ugly hack.
//        Log.info("I will change component name from {}/{} to {}", getNodeName(),
//                ((KevoreeCoreBean)((ModelHandlerServiceProxy)getModelService()).getProxy()).getNodeName(),
//                "hahahaha");
//        ((KevoreeCoreBean)((ModelHandlerServiceProxy)getModelService()).getProxy()).setNodeName("hahahaha");
//        setNodeName("hahahaha");
//        Log.info("I changed component name: {}/{}", getNodeName(),
//                ((KevoreeCoreBean)((ModelHandlerServiceProxy)getModelService()).getProxy()).getNodeName());
//        Log.info("This is all");
        System.out.println("ASDFFSDAFSDAFSDFSF PEPE JUAN MARIA");
//        new Mythread().start();
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
