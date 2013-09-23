package org.daum.library.javase.copterManager;


import org.daum.library.javase.copterManager.cache.MemCache;
import org.kevoree.annotation.ComponentType;
import org.kevoree.annotation.DictionaryAttribute;
import org.kevoree.annotation.DictionaryType;
import org.kevoree.library.javase.http.api.AbstractParentHTTPHandler;
import org.kevoree.library.javase.http.api.HTTPHelper;
import org.kevoree.microsandbox.api.contract.FullContracted;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created with IntelliJ IDEA.
 * User: jed
 * Date: 26/06/12
 * Time: 09:17
 */
@DictionaryType({
        @DictionaryAttribute(name = "uselessParameter", optional = true)})
@ComponentType
public class ResourcesPageFaultyMemory extends AbstractParentHTTPHandler implements FullContracted {
    private MemoryFault fault;

    @Override
    public void start() throws Exception {
        fault = new MemoryFault();
        fault.create();
        super.start();
    }

    @Override
    public void stop() throws Exception {
        fault.destroy();
        super.stop();
    }

    /* @Override
    public KevoreeHttpResponse process(KevoreeHttpRequest kevoreeHttpRequest, KevoreeHttpResponse kevoreeHttpResponse)
    {
        String url = kevoreeHttpRequest.getUrl().replace(getDictionary().get("urlpattern").toString().replace("*",""),"");
        kevoreeHttpResponse.setRawContent(MemCache.getRessource(url));
        return kevoreeHttpResponse;
    }*/

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OutputStream stream = resp.getOutputStream();
        String url = applyPatternToRemove(req.getRequestURI());
        stream.write(MemCache.getRessource(url));
        stream.flush();
        resp.addHeader("Content-Type", HTTPHelper.getHttpHeaderFromURL(url));
    }
}
