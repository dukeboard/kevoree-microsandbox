package org.resourceaccounting.binder;

import org.resourceaccounting.contract.ComponentResourceContract;
import org.resourceaccounting.contract.ResourceContract;
import org.resourceaccounting.ResourcePrincipal;

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

    private transient T associatedObject;

    private static int lastID = 3;
    protected int id;
    protected long nbObjects;
    protected long nbInstructions;
    protected int nbBytesSent;
    protected int nbBytesReceived;
    protected long nbBytesWrite;
    protected long nbBytesRead;

    protected long last_nbInstructions;
    protected int last_nbBytesSent;
    protected int last_nbBytesReceived;
    protected long last_nbBytesWrite;
    protected long last_nbBytesRead;

    protected transient ResourceContract contract;

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

    public void increaseExecutedInstructions(int n) {
        nbInstructions += n;
    }

    public void increaseOwnedObjects(int n) {
        nbObjects += n;
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

    public final long getExecutedInstructions() {
        long tmp = nbInstructions - last_nbInstructions;
        last_nbInstructions = nbInstructions;
        return tmp;
    }

    public final long getAllocatedObjects() {
        return nbObjects;
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
