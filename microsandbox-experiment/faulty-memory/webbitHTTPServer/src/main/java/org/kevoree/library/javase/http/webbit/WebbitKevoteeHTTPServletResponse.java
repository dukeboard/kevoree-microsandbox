package org.kevoree.library.javase.http.webbit;

import org.kevoree.library.javase.http.api.KevoreeHTTPServletResponse;
import org.webbitserver.HttpResponse;

import javax.servlet.ServletOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;

/**
 * User: Erwan Daubert - erwan.daubert@gmail.com
 * Date: 05/04/13
 * Time: 11:40
 *
 * @author Erwan Daubert
 * @version 1.0
 */
public class WebbitKevoteeHTTPServletResponse extends KevoreeHTTPServletResponse {

    private HttpResponse httpResponse;
    private WebbitKevoreeServletOutputStream outputStream;

    private class WebbitKevoreeServletOutputStream extends ServletOutputStream {
        private ByteArrayOutputStream stream;
        HttpResponse httpResponse;

        private ByteArrayOutputStream getStream() {
            return stream;
        }

        private WebbitKevoreeServletOutputStream(HttpResponse httpResponse) {
            stream = new ByteArrayOutputStream();
            this.httpResponse = httpResponse;
        }

        @Override
        public void write(int b) throws IOException {
            stream.write(b);
        }
    }

    public WebbitKevoteeHTTPServletResponse(HttpResponse httpResponse) {
        this.httpResponse = httpResponse;
        outputStream = new WebbitKevoreeServletOutputStream(httpResponse);
    }

    public void end() {
        if (outputStream.getStream().size() > 0) {
            httpResponse.content(outputStream.getStream().toByteArray());
        }
        httpResponse.end();
    }

    @Override
    public int getStatus() {
        return httpResponse.status();
    }

    @Override
    public boolean containsHeader(String name) {
        return httpResponse.containsHeader(name);
    }

    @Override
    public void sendError(int sc, String msg) throws IOException {
        httpResponse.status(sc);
        // Maybe error will override the status...
        httpResponse.error(new Exception(msg));
    }

    @Override
    public void sendError(int sc) throws IOException {
        httpResponse.status(sc);
    }

    @Override
    public void setDateHeader(String name, long date) {
        httpResponse.header(name, (String)null);
        addDateHeader(name, date);
    }

    @Override
    public void addDateHeader(String name, long date) {
        httpResponse.header(name, date);
    }

    @Override
    public void setHeader(String name, String value) {
        httpResponse.header(name, (String)null);
        addHeader(name, value);
    }

    @Override
    public void addHeader(String name, String value) {
        httpResponse.header(name, value);
    }

    @Override
    public void setIntHeader(String name, int value) {
        httpResponse.header(name, (String)null);
        addIntHeader(name, value);
    }

    @Override
    public void addIntHeader(String name, int value) {
        httpResponse.header(name, value);
    }

    @Override
    public void setStatus(int sc) {
        httpResponse.status(sc);
    }

    @Override
    public String getCharacterEncoding() {
        return httpResponse.charset().name();
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        return outputStream;
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        return new PrintWriter(getOutputStream());
    }

    @Override
    public void setCharacterEncoding(String charset) {
        httpResponse.charset(null);
        httpResponse.charset(Charset.forName(charset));
    }

    @Override
    public void setContentLength(int len) {
        httpResponse.header("Content-Length", (String)null);
        httpResponse.header("Content-Length", len);
    }

    @Override
    public void setContentType(String type) {
        httpResponse.header("Content-Type", type);
    }
}
