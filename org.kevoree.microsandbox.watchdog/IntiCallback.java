import dacapo.Callback;

import java.lang.Double;
import java.lang.System;
import java.net.*;

/**
 * @date $Date: 2009-12-24 11:19:36 +1100 (Thu, 24 Dec 2009) $
 * @id $Id: MyCallback.java 738 2009-12-24 00:19:36Z steveb-oss $
 */
public class IntiCallback extends Callback {

    public IntiCallback() {
        super();
    }

    long time;

    public void start(String benchmark) {
        super.start(benchmark);
        System.err.flush();
        time = System.nanoTime();
    }

    public void complete(String benchmark, boolean valid) {
        super.complete(benchmark, valid);

        double t = (System.nanoTime() - time)/1000000000.0;
        String s = Double.toString(t);
        try {
            Socket socket = new Socket("localhost",4444);
            socket.getOutputStream().write(s.getBytes());
            socket.close();
        } catch (Exception e) { }
    }
}