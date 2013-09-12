package org.resourceaccounting.binder;

import org.resourceaccounting.contract.ComponentResourceContract;
import org.resourceaccounting.contract.ResourceContract;
import org.resourceaccounting.ResourcePrincipal;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 4/29/13
 * Time: 5:28 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractResourcePrincipal<T> implements ResourcePrincipal {

    public T getAssociatedObject() {
        return associatedObject;
    }

    private boolean isBeingMonitored = false;

    private transient T associatedObject;

    private static int lastID = 3;
    protected int id;
    protected AtomicLong nbObjects = new AtomicLong(0);
    protected int nbBytesSent;
    protected int nbBytesReceived;
    protected long nbBytesWrite;
    protected long nbBytesRead;

    protected int last_nbBytesSent;
    protected int last_nbBytesReceived;
    protected long last_nbBytesWrite;
    protected long last_nbBytesRead;

    protected transient ResourceContract contract;


//    private transient Lock lockInstructions = new ReentrantLock();
//    private transient Lock lockMemory = new ReentrantLock();

    public ResourceContract getContract() {
        return contract;
    }

    public void setContract(ResourceContract contract) {
        this.contract = new ComponentResourceContract(contract) {
        };
    }

    /**
     * This is not thread safe
     * @param object
     */
    protected AbstractResourcePrincipal(T object) {
        associatedObject = object;
        id = lastID++;
    }

    public void increaseOwnedObjects(int n) {
        nbObjects.addAndGet(n);
//        lockMemory.lock();
//            nbObjects += n;
//        lockMemory.unlock();
    }

    public void increaseBytesSent(int n) {
        nbBytesSent += n;
    }

    public void increaseBytesReceived(int n) {
        nbBytesReceived += n;
    }

    public void increaseFileWrite(int n) {
        nbBytesWrite += n;
    }

    public void increaseFileRead(int n) {
        nbBytesRead += n;
    }

    public final long getAllocatedObjects() {
        return nbObjects.get();
    }

    public long getBytesSent() {
        long tmp = nbBytesSent - last_nbBytesSent;
        last_nbBytesSent = nbBytesSent;
        return tmp;
    }

    public long getBytesReceived() {
        long tmp = nbBytesReceived - last_nbBytesReceived;
        last_nbBytesReceived = nbBytesReceived;
        return tmp;
    }

    public long getWrittenBytes() {
        long tmp = nbBytesWrite - last_nbBytesWrite;
        last_nbBytesWrite = nbBytesWrite;
        return tmp;
    }

    public long getReadBytes() {
        long tmp = nbBytesRead - last_nbBytesRead;
        last_nbBytesRead = nbBytesRead;
        return tmp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractResourcePrincipal that = (AbstractResourcePrincipal) o;

        return id == that.id;
    }


    @Override
    public boolean isBeingMonitored() {
        return isBeingMonitored;
    }

    public void markAsMonitored(boolean mark) {
        isBeingMonitored = mark;
    }

    @Override
    public int hashCode() {
        return id;
    }

    public long getCPUUsage() {
        return 0;
    }

    public int getId() {
        return id;
    }
}
