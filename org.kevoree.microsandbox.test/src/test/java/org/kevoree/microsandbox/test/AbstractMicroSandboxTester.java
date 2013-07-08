package org.kevoree.microsandbox.test;

import junit.framework.TestCase;
import org.kevoree.watchdog.Runner;
import org.kevoree.watchdog.child.jvm.JVMStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: duke
 * Date: 08/07/13
 * Time: 13:36
 */
public class AbstractMicroSandboxTester extends TestCase implements JVMStream.LineHandler {

    private BlockingQueue<Object> block = new ArrayBlockingQueue<Object>(1);


    private Stack<String> toRead = new Stack<String>();

    public void runSandbox(String kevsClassLoaderPath, int timeout, List<String> linestoObserve)  {
        for(String l : linestoObserve){
            toRead.add(l);
        }
        Object result = null;
        try {
            File tempFile = File.createTempFile("kevsTempFile",".kevs");
            FileOutputStream fos = new FileOutputStream(tempFile);
            InputStream is = this.getClass().getClassLoader().getResourceAsStream(kevsClassLoaderPath);
            byte data[] = new byte[1024];
            int count;
            while ((count = is.read(data, 0, 1024)) != -1) {
                fos.write(data, 0, count);
            }
            is.close();
            fos.close();

            //put in param
            String[] params = new String[2];
            params[0] = "LATEST";
            params[1] = tempFile.getAbsolutePath();

            Runner.checker.lineHandler = this;
            Runner.main(params);
            result = block.poll(timeout, TimeUnit.MILLISECONDS);

            tempFile.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //remove temp kevs file

        if(result == null){
            fail();
        }

    }


    @Override
    public void handle(String line) {

        System.out.println(line);

        if(line.equals(toRead.firstElement())){
            toRead.pop();
        }
        if(toRead.empty()){
            try {
                block.put("sucess");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
