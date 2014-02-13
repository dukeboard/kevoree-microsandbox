package org.ipc.memory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 2/5/14
 * Time: 2:44 PM
 *
 */
public class GlobalResource {
    private FileChannel file;
    private FileLock lock;
    ServerSocket serverSocket;
    private String globalId;

    public GlobalResource(String globalId) {
        this.globalId = globalId;
    }

    public synchronized boolean hasToInitialize() {
//        System.out.printf("Message 0\n");
        boolean result = false;
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile("/tmp/f"+globalId+".txt", "rw");
            file = randomAccessFile.getChannel();
            lock = file.tryLock();
            if (lock != null)
                result = true;
        } catch (FileNotFoundException e) {
//            System.out.printf("Message 1\n");
            e.printStackTrace();
        } catch (IOException e) {
//            System.out.printf("Message 2\n");
            e.printStackTrace();
        }
        catch (OverlappingFileLockException e) {
            return false;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        if (result) {
            // maybe, it is not owned by a different classloader
            int port = getPortFromId(globalId);
            try {
                serverSocket = new ServerSocket(port,0, InetAddress.getLocalHost());
            } catch (IOException e) {
                result =false;
//                System.out.printf("Message 3\n");
                e.printStackTrace();
            }
        }
        return result;
    }

    private int getPortFromId(String id) {
        int hash = id.hashCode() * 117 % 1119 + 50000;
        return hash;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        if (serverSocket != null)
            serverSocket.close();
    }
}
