package org.resourceaccounting;

import org.resourceaccounting.contract.ResourceContract;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 4/25/13
 * Time: 11:02 AM
 * To change this template use File | Settings | File Templates.
 */
public interface ResourcePrincipal extends Serializable {
    void increaseExecutedInstructions(int n);
    void increaseOwnedObjects(int n);
    void increaseBytesSent(int n);
    void increaseBytesReceived(int n);
    void increaseFileWrite(int n);
    void increaseFileRead(int n);

    /**
     * Since last time the value was asked
     * @return
     */
    long getExecutedInstructions();

    long getAllocatedObjects();

    /**
     * Since last time the value was asked
     * @return
     */
    long getBytesSent();

    /**
     * Since last time the value was asked
     * @return
     */
    long getBytesReceived();

    /**
     * Since last time the value was asked
     * @return
     */
    long getWrittenBytes();

    /**
     * Since last time the value was asked
     * @return
     */
    long getReadBytes();


    long getCPUUsage();

    int getId();


    ResourceContract getContract();
    void setContract(ResourceContract contract);

    /**
     * Indicae if the principal is being monitored
     * @return
     */
    boolean isBeingMonitored();
}

