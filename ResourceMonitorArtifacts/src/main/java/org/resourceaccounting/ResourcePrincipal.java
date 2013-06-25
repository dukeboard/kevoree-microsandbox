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

    long getExecutedInstructions();
    long getAllocatedObjects();
    long getBytesSent();
    long getBytesReceived();
    long getCPUUsage();

    int getId();


    ResourceContract getContract();
}

