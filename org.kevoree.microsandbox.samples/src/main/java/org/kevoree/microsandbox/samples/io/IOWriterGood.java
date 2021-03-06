package org.kevoree.microsandbox.samples.io;

import org.kevoree.annotation.ComponentType;
import org.kevoree.annotation.Start;
import org.kevoree.annotation.Stop;
import org.kevoree.annotation.Update;
import org.kevoree.framework.AbstractComponentType;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 7/4/13
 * Time: 7:18 AM
 * To change this template use File | Settings | File Templates.
 */
@ComponentType
public class IOWriterGood extends AbstractComponentType {

    @Start
    public void startComponent() {
        System.out.println("Starting component : " + IOWriterGood.class.getCanonicalName());
        FileOutputStream f = null;
        try {
            f = new FileOutputStream("lala.txt");
            PrintWriter pw = new PrintWriter(f);
            pw.print("La cancion mas hermosa del mundo");
        } catch (FileNotFoundException e) {

        }
        finally {
            if (f != null) {
                try {
                    f.close();
                } catch (IOException e) { }
            }
        }
    }

    @Stop
    public void stopComponent() {

    }

    @Update
    public void updateComponent() {
        stopComponent();
        startComponent();
    }
}
