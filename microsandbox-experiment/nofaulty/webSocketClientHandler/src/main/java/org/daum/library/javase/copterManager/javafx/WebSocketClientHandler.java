package org.daum.library.javase.copterManager.javafx;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.kevoree.annotation.*;
import org.kevoree.api.Port;
import org.kevoree.microsandbox.api.contract.impl.CPUMemoryThroughputContractedImpl;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * User: Erwan Daubert - erwan.daubert@gmail.com
 * Date: 01/08/13
 * Time: 11:36
 *
 * @author Erwan Daubert
 * @version 1.0
 */
@ComponentType
public class WebSocketClientHandler extends CPUMemoryThroughputContractedImpl {

    final String scriptOnOpen = "showMessage('Connected!')";
    final String scriptOnClose = "showMessage('Lost connection')";

    private WebSocketClient client;

    @Param(defaultValue = "ws://localhost:8092/followmanager", optional = true)
    private String wsURL;
    @Param
    String uselessParameter;

    @Output
    Port handle;

    @Start
    public void start() throws InterruptedException, URISyntaxException {
        client = new WebSocketClientImpl(new URI(wsURL));
        client.connectBlocking();
    }

    @Stop
    public void stop() throws InterruptedException {
        if (client != null) {
            client.closeBlocking();
            client = null;
        }
    }

    @Update
    public void update() throws InterruptedException, URISyntaxException {
        start();
        stop();
    }

    private class WebSocketClientImpl extends WebSocketClient {

        public WebSocketClientImpl(URI serverURI) {
            super(serverURI);
        }

        @Override
        public void onOpen(ServerHandshake serverHandshake) {
            if (handle.getConnectedBindingsSize() > 0) {
                handle.send(scriptOnOpen);
            }
        }

        @Override
        public void onMessage(String message) {
            final String script = "onMessageReceived('" + message + "');";
            if (handle.getConnectedBindingsSize() > 0) {
                handle.send(script);
            }
        }

        @Override
        public void onClose(int i, String s, boolean b) {
            if (handle.getConnectedBindingsSize() > 0) {
                handle.send(scriptOnClose);
            }
        }

        @Override
        public void onError(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
