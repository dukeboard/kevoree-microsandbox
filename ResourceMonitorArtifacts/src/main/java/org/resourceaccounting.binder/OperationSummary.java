package org.resourceaccounting.binder;

import org.resourceaccounting.behavior.BehaviorNode;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 5/21/13
 * Time: 2:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class OperationSummary {
    private BehaviorNode node;

    private int executionCount;

    private double executedInstructions;
    private double consumedMemory;
    private double bytesSent;
    private double bytesReceived;

    public double getExecutedInstructions() {
        return executedInstructions / executionCount;
    }

    public double getConsumedMemory() {
        return consumedMemory / executionCount;
    }

    public double getBytesSent() {
        return bytesSent / executionCount;
    }

    public double getBytesReceived() {
        return bytesReceived / executionCount;
    }
    public OperationSummary(BehaviorNode node,
                            long executedInstructions, long consumedMemory,
                            long bytesSent, long bytesReceived) {
        this.node = node;
        this.executedInstructions = executedInstructions;
        this.consumedMemory = consumedMemory;
        this.bytesSent = bytesSent;
        this.bytesReceived = bytesReceived;
        executionCount = 1;
    }

    public void merge(BehaviorNode node,
                      long executedInstructions, long consumedMemory,
                      long bytesSent, long bytesReceived) {
        this.node.merge(node, false);
        this.executedInstructions += executedInstructions;
        this.consumedMemory += consumedMemory;
        this.bytesSent += bytesSent;
        this.bytesReceived += bytesReceived;
        executionCount++;
    }

    public BehaviorNode getNode() {
        return node;
    }


}
