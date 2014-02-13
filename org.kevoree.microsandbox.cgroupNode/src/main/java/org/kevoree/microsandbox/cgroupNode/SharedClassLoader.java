package org.kevoree.microsandbox.cgroupNode;

import jet.runtime.typeinfo.JetValueParameter;
import org.ipc.memory.GlobalResource;
import org.ipc.memory.InterprocessLock;
import org.ipc.memory.MemoryBasedQueueConsumer;
import org.ipc.memory.MemoryBasedQueueProducer;
import org.kevoree.kcl.KevoreeJarClassLoader;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 2/4/14
 * Time: 6:37 PM
 *
 */
public class SharedClassLoader extends KevoreeJarClassLoader {

    private final String nodeName;
    MemoryBasedQueueProducer prod;
    MemoryBasedQueueConsumer cons;

    public long getTotalTime() {
        return totalTime.get();
    }

    private AtomicLong totalTime;

    /**
     * This runs in the context of non-main loaders
     */
    private class ClassLoadedListener extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    int id = cons.waitForMessage();
                    InputStream stream = cons.getMessageInputStream(id);
                    DataInputStream dataInputStream = new DataInputStream(stream);
                    String className = dataInputStream.readUTF();
                    int pos = dataInputStream.readInt();
                    int len = dataInputStream.readInt();
                    cons.notifyReception(id);
//                    System.out.println("Class " + className + " was remotely loaded");
                    classNameToPosInBuffer.put(className, new Pair(className, pos, len));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private class AnotherThread extends Thread {
        @Override
        public void run() {
            while (true) {
                Pair p = null;
                try {
                    p = queue.poll(2, TimeUnit.SECONDS);
                    if (p != null)
                        broadcastClassLoading(p.name, p.pos, p.len);
                } catch (InterruptedException e) {
//                    e.printStackTrace();
                }
            }
        }
    }

    private class Pair {
        String name;
        int pos, len;

        private Pair(String s, int pos, int len) {
            this.name = s;
            this.pos = pos;
            this.len = len;
        }
    }

    private static AtomicInteger lastId = new AtomicInteger(0);

    private boolean useShared = false;

    private Map<String, Pair> classNameToPosInBuffer = new ConcurrentHashMap<String, Pair>(18,0.9f,2);
    private MappedByteBuffer sharedMemory;
    private Thread consumerThread;
    private GlobalResource globalResource;
    private InterprocessLock lock;
    private ReentrantLock lightweightLock = new ReentrantLock();
    private ArrayBlockingQueue<Pair> queue = new ArrayBlockingQueue<Pair>(10000);

    private final int id;

    public SharedClassLoader(String nodeName, boolean useShared) {
        this.nodeName = nodeName;
        this.useShared = useShared;
        id = lastId.addAndGet(1);
        totalTime = new AtomicLong(0);
        if (!useShared) return;
        try {
            globalResource = new GlobalResource("sharedClassLoaderMemory");
            boolean b = globalResource.hasToInitialize();
            RandomAccessFile randomAccessFile =
                    new RandomAccessFile("/tmp/mapped_sharedClassLoaderMemory.txt", "rw");
            int size = 10*1024*1024;
            if (b)
                randomAccessFile.setLength(size);
            FileChannel fileChannel = randomAccessFile.getChannel();
            sharedMemory = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, size);


            prod = new MemoryBasedQueueProducer("loadingChannel", 200);
            cons = new MemoryBasedQueueConsumer("loadingChannel");
            lock = new InterprocessLock(("sharedClassLoaderMemory_lock").getBytes(), b);
            if (b) {
                lock.lock();
                sharedMemory.putInt(0, 4);
                lock.unlock();
            }
            consumerThread = new ClassLoadedListener();
            consumerThread.start();
//            new AnotherThread().start();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void broadcastClassLoading(String className, int pos, int len) {
        try {
            classNameToPosInBuffer.put(className, new Pair(className, pos, len));
            OutputStream stream = prod.getStreamToSendMessage();
            DataOutputStream dataOutputStream = new DataOutputStream(stream);
            dataOutputStream.writeUTF(className);
            dataOutputStream.writeInt(pos);
            dataOutputStream.writeInt(len);
            prod.notifySend(stream);
//            System.out.println("Putting in queue " + (++counter) + ":" + className);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    int counter = 0;

    @Override
    protected Class<? extends Object> loadClass(
            @JetValueParameter(name = "className", type = "?Ljava/lang/String;") String className,
            @JetValueParameter(name = "resolveIt", type = "Z") boolean resolveIt) {

        long before = System.nanoTime();

        Class<? extends Object> r = findLoadedClass(className);
        if (r == null) {
            if (!useShared)
                r = super.loadClass(className, resolveIt);
            else {
                Pair pair = classNameToPosInBuffer.get(className);;
                if (pair == null) {
//            System.out.printf("NOOOOOOOOOO, the class %s has been loaded in local classloader\n",
//                   className);
                    r = super.loadClass(className, resolveIt);
                }
                else {
//                    System.out.printf("GOOOOOOOOOOD, the class %s has" +
//                            " been loaded from a remote classloader\n", className);
                    r = defineClass(className, getBuffer(pair.pos, pair.len), null);
                }
            }
        }

        long after = System.nanoTime();
        long p = totalTime.get();
        totalTime.addAndGet(after - before);
        long c = totalTime.get();
//        if (c/1000000 != p/1000000)
//            System.out.println("Loading Time " + c/1000000 + " in " + nodeName + ":" + id);
        return r;

    }

    @Override
    public byte[] loadClassBytes(
            @JetValueParameter(name = "className", type = "Ljava/lang/String;") String className) {
        byte[] r = super.loadClassBytes(className);
        if (!useShared)
            return r;
        if (r != null) {
//            System.out.printf("Class %s was loaded at last\n", className);
//            try {
            lock.lock();
            int pos = sharedMemory.getInt(0);
//                queue.put(new Pair(className, pos, r.length));
            sharedMemory.putInt(0, pos + r.length);
            lock.unlock();

            ByteBuffer slice = getBuffer(pos, r.length);

            slice.put(r);
            broadcastClassLoading(className, pos, r.length);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            finally {
//            }
        } else {
        }
        return r;
    }

    private ByteBuffer getBuffer(int p, int l) {
        lightweightLock.lock();
        sharedMemory.position(p);
        ByteBuffer b = sharedMemory.slice();
        lightweightLock.unlock();
        b.limit(l);
        return b;
    }
}
