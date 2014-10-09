package org.kevoree.microsandbox.http_proxy_component;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.HttpObject;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponse;
import org.kevoree.annotation.*;
import org.littleshoot.proxy.HttpFilters;
import org.littleshoot.proxy.HttpFiltersAdapter;
import org.littleshoot.proxy.HttpFiltersSourceAdapter;
import org.littleshoot.proxy.HttpProxyServer;
import org.littleshoot.proxy.impl.DefaultHttpProxyServer;

@ComponentType
public class HttpProxyComponent {

//    @Param(defaultValue = "true")
//    boolean log;

    @KevoreeInject
    org.kevoree.api.Context context;

//    @Output
//    org.kevoree.api.Port out;

//    @Input
//    public String in(Object i) {
//        String msg = message+" from "+context.getInstanceName()+"@"+context.getNodeName();
//        System.out.println(msg);
//        out.send(msg);
//        return msg;
//    }

    private HttpProxyServer server;

    @Start
    public void start() {
//         server = DefaultHttpProxyServer.bootstrap()
//                 .withPort(8080)
//                 .withFiltersSource(new HttpFiltersSourceAdapter() {
//                     public HttpFilters filterRequest(HttpRequest originalRequest, ChannelHandlerContext ctx) {
//                         return new HttpFiltersAdapter(originalRequest) {
//
//                             @Override
//                             public HttpResponse requestPre(HttpObject httpObject) {
//                                 // TODO: implement your filtering here
//                                 return null;
//                             }
//
//                             @Override
//                             public HttpResponse requestPost(HttpObject httpObject) {
//                                 // TODO: implement your filtering here
//                                 return null;
//                             }
//
//                             @Override
//                             public HttpObject responsePre(HttpObject httpObject) {
//                                 // TODO: implement your filtering here
//                                 return httpObject;
//                             }
//
//                             @Override
//                             public HttpObject responsePost(HttpObject httpObject) {
//                                 // TODO: implement your filtering here
//                                 return httpObject;
//                             }
//                         };
//                     }
//                 })
//                 .start();

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



