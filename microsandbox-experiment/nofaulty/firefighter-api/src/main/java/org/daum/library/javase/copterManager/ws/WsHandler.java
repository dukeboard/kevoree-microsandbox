package org.daum.library.javase.copterManager.ws;

/**
 * Created with IntelliJ IDEA.
 * User: jed
 * Date: 06/07/12
 * Time: 14:31
 * To change this template use File | Settings | File Templates.
 */
public interface WsHandler {
    public void addHandler(AddHandlerRequest request);
    public void removeHandler(String name);
}
