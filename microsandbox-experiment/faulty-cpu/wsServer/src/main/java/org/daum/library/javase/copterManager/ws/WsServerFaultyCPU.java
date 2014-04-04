package org.daum.library.javase.copterManager.ws;


import org.kevoree.annotation.*;
import org.kevoree.api.Context;
import org.kevoree.log.Log;
import org.kevoree.microsandbox.api.contract.impl.CPUMemoryThroughputContractedImpl;
import org.webbitserver.BaseWebSocketHandler;
import org.webbitserver.WebServer;
import org.webbitserver.WebServers;

import java.util.HashMap;
import java.util.concurrent.ExecutionException;


/**
 * Created with IntelliJ IDEA.
 * User: jed
 * Date: 22/06/12
 * Time: 13:14
 */
@Library(name = "JavaSE")
@ComponentType
public class WsServerFaultyCPU extends CPUMemoryThroughputContractedImpl implements WsHandler {

    @Param(defaultValue = "8092")
    int port;
    @Param
    String uselessParameter;

    @KevoreeInject
    Context context;


    private WebServer webServer;

    private HashMap<String, BaseWebSocketHandler> wspages;

    private CPUFault fault;

    @Start
    public void start() {
        fault = new CPUFault(2, 23000);
        fault.create();
        Log.debug("Starting {}", context.getInstanceName());
        wspages = new HashMap<String, BaseWebSocketHandler>();
        startWebSock();
    }

    @Update
    public void update() {
            stopWebSock();
            startWebSock();
    }


    @Stop
    public void stopServer() {
        fault.destroy();
        Log.debug("Stopping {}", context.getInstanceName());
        stopWebSock();
    }


    public void startWebSock() {
        webServer = WebServers.createWebServer(port);
        for (String key : wspages.keySet()) {
            webServer.add(key, wspages.get(key));
        }
        webServer.start();
    }

    public void stopWebSock() {
        if (webServer != null) {
            try {
                webServer.stop().get();
            } catch (InterruptedException e) {
                Log.error("WsServer.stopWebSock", e);
            } catch (ExecutionException e) {
                Log.error("WsServer.stopWebSock", e);
            }
        }
        webServer = null;
    }

    @Input
    @Override
    public void addHandler(AddHandlerRequest request) {

        Log.warn("Adding WS " + request.getName());
        if (!wspages.containsKey(request.getName())) {
            wspages.put(request.getName(), request.getWebSocketChannel());
            stopWebSock();
            startWebSock();

        } else {
            Log.warn("Already added " + request.getName());
        }

    }


    @Input
    @Override
    public void removeHandler(String name) {
        wspages.remove(name);
        Log.warn("Removing WS " + name);
        stopWebSock();
        startWebSock();
    }


}