package org.kevoree.microsandbox.samples.benchmark;

import org.kevoree.annotation.ComponentType;
import org.kevoree.annotation.Start;
import org.kevoree.annotation.Stop;
import org.kevoree.annotation.Update;
import org.kevoree.framework.AbstractComponentType;
import org.kevoree.log.Log;

import java.io.IOException;
import java.nio.file.*;

/**
 * Created by inti on 2/20/14.
 */
@ComponentType
public class NodeNameRestarter extends AbstractComponentType {


    private class Mythread extends Thread {
        @Override
        public void run() {
            try {
                WatchService watcher = FileSystems.getDefault().newWatchService();
                Path dir = Paths.get("/home/inti");
                WatchKey key0 = dir.register(watcher,
                        StandardWatchEventKinds.ENTRY_CREATE,
                        StandardWatchEventKinds.ENTRY_DELETE,
                        StandardWatchEventKinds.ENTRY_MODIFY);

                for (;;) {

                    // wait for key to be signaled
                    WatchKey key;
                    try {
                        key = watcher.take();
                    } catch (InterruptedException x) {
                        return;
                    }

                    for (WatchEvent<?> event: key.pollEvents()) {
                        WatchEvent.Kind<?> kind = event.kind();

                        // This key is registered only
                        // for ENTRY_CREATE events,
                        // but an OVERFLOW event can
                        // occur regardless if events
                        // are lost or discarded.
                        if (kind == StandardWatchEventKinds.OVERFLOW) {
                            continue;
                        }

                        // The filename is the
                        // context of the event.
                        WatchEvent<Path> ev = (WatchEvent<Path>)event;
                        Path filename = ev.context();

                        // Verify that the new
                        //  file is a text file.
//                        try {
                            Log.info("File {} was {}", filename, kind);
                            // Resolve the filename against the directory.
                            // If the filename is "test" and the directory is "foo",
                            // the resolved name is "test/foo".
//                            Path child = dir.resolve(filename);
//                            if (!Files.probeContentType(child).equals("text/plain")) {
//                                System.err.format("New file '%s'" +
//                                        " is not a plain text file.%n", filename);
//                                continue;
//                            }
//                        } catch (IOException x) {
//                            System.err.println(x);
//                            continue;
//                        }

                        // Email the file to the
                        //  specified email alias.
//                        System.out.format("Emailing file %s%n", filename);
                        //Details left to reader....
                    }

                    // Reset the key -- this step is critical if you want to
                    // receive further watch events.  If the key is no longer valid,
                    // the directory is inaccessible so exit the loop.
                    boolean valid = key.reset();
                    if (!valid) {
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Start
    public void start() {
        // FIXME, Ugly hack.
//        Log.info("I will change component name from {}/{} to {}", getNodeName(),
//                ((KevoreeCoreBean)((ModelHandlerServiceProxy)getModelService()).getProxy()).getNodeName(),
//                "hahahaha");
//        ((KevoreeCoreBean)((ModelHandlerServiceProxy)getModelService()).getProxy()).setNodeName("hahahaha");
//        setNodeName("hahahaha");
//        Log.info("I changed component name: {}/{}", getNodeName(),
//                ((KevoreeCoreBean)((ModelHandlerServiceProxy)getModelService()).getProxy()).getNodeName());
        new Mythread().start();
    }

    @Stop
    public void stop() {
    }

    @Update
    public void update() {
        stop();
        start();
    }
}
