package org.kevoree.microsandbox.http_proxy_component;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.*;
import org.kevoree.annotation.*;
import org.kevoree.log.Log;
import org.littleshoot.proxy.HttpFilters;
import org.littleshoot.proxy.HttpFiltersAdapter;
import org.littleshoot.proxy.HttpFiltersSourceAdapter;
import org.littleshoot.proxy.HttpProxyServer;
import org.littleshoot.proxy.impl.DefaultHttpProxyServer;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@ComponentType
public class HttpProxyComponent {

    @Param(defaultValue = "true")
    boolean log;

    @Param(optional = false)
    int port;

    private List<Integer> ports = new ArrayList<Integer>();

    int currentPort = 0;

    private synchronized int increaseAndGet() {
        int tmp = currentPort;
        currentPort ++;
        if (currentPort == ports.size())
            currentPort = 0;
        return tmp;
    }

    @KevoreeInject
    org.kevoree.api.Context context;

//    @Output
//    org.kevoree.api.Port out;

    @Input
    public synchronized void onNewBackend(Object port) {
        int newPort = Integer.parseInt(port.toString());
        if (!ports.contains(newPort))
            ports.add(newPort);
//        String msg = message+" from "+context.getInstanceName()+"@"+context.getNodeName();
//        System.out.println(msg);
//        out.send(msg);
//        return msg;
    }

    private HttpProxyServer server;

    @Start
    public void start() {
        Log.info("Starting Proxy:{} at port {}", context.getInstanceName(), port);
         server = DefaultHttpProxyServer.bootstrap()
                 .withPort(port).withAllowLocalOnly(false)
                 .withFiltersSource(new HttpFiltersSourceAdapter() {
                     public HttpFilters filterRequest(HttpRequest originalRequest, ChannelHandlerContext ctx) {
                         return new HttpFiltersAdapter(originalRequest) {

                             @Override
                             public HttpResponse clientToProxyRequest(HttpObject httpObject) {
                                 if (httpObject instanceof HttpRequest) {
                                     HttpRequest request = (HttpRequest) httpObject;
                                     try {
                                         URI uri = URI.create(request.getUri());
                                         if (uri.getHost().equals("inti.magic.site")) {
                                             printHttpRequest(request);
                                             int portIndex = increaseAndGet();

                                             Log.info("\t\t\t I have to translate the request and send it to localhost:{}", ports.get(portIndex));

                                             URI newUri = new URI(uri.getScheme(), uri.getUserInfo(), "localhost",
                                                     ports.get(portIndex), uri.getPath(), uri.getQuery(), uri.getFragment());
                                             request.setUri(newUri.toString());
                                         }
                                         return null;
                                     } catch (URISyntaxException e) {
                                         e.printStackTrace();
                                     }
                                 }
                                 HttpResponse response = new DefaultHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.BAD_GATEWAY);
                                 return response;
                             }
                         };

                     }
                 }).start();

                 }

    private void printHttpRequest(HttpRequest request) {
        String s = "";
        for (Map.Entry<String, String> entry : request.headers().entries()) {
            s += String.format("\t\t%s -> %s\n", entry.getKey(), entry.getValue());
        }
        Log.debug("A messsage is being sent: \n" +
                        "uri={}\n" +
                        "method={}\n" +
                        "protocolVersion={}\n" +
                        "headers=\n{}\n",
                request.getUri(),
                request.getMethod(),
                request.getProtocolVersion(),
                s);
    }

    @Stop
    public void stop() {
        server.stop();
    }

    @Update
    public void update() {
        stop();
        start();
    }

}



