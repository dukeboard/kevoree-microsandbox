package org.daum.library.javase.copterManager.ws;

import org.webbitserver.BaseWebSocketHandler;

/**
 * User: Erwan Daubert - erwan.daubert@gmail.com
 * Date: 04/04/14
 * Time: 13:40
 *
 * @author Erwan Daubert
 * @version 1.0
 */
public class AddHandlerRequest {
    private String name;
    private BaseWebSocketHandler webSocketChannel;

    public AddHandlerRequest(String name, BaseWebSocketHandler webSocketChannel) {
        this.name = name;
        this.webSocketChannel = webSocketChannel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BaseWebSocketHandler getWebSocketChannel() {
        return webSocketChannel;
    }

    public void setWebSocketChannel(BaseWebSocketHandler webSocketChannel) {
        this.webSocketChannel = webSocketChannel;
    }
}
