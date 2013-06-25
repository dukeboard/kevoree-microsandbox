package org.resourceaccounting.binder;

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
    protected long nbInstructions;
    protected long nbObjects;
    protected int id;
    protected int nbBytesSent;
    protected int nbBytesReceived;
    protected long nbBytesWrite;

    protected transient ResourceContract contract;

    public ResourceContract getContract() {
        return contract;
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

    public final long getExecutedInstructions() {
        return nbInstructions;
    }

    public final long getAllocatedObjects() {
        return nbObjects;
    }

    public long getBytesSent() {
        return nbBytesSent;
    }

    public long getBytesReceived() {
        return nbBytesReceived;
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
