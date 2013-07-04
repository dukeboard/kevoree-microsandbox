package org.resourceaccounting.behavior;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 5/10/13
 * Time: 6:33 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class BehaviorNodeVisitor {
    public void visitSerialOperations(BehaviorNodeSerial behaviorNodeSerial) {

    }

    public void visitParallel(BehaviorNodeParallel behaviorNodeParallel) {

    }

    public void visitRepetition(BehaviorNodeRepetition behaviorNodeRepetition) {

    }

    public void visitExternalOperations(BehaviorNodeOperation behaviorNodeOperation) {

    }

    public void visitFlatNode(FlatBehaviorNode node) {

    }
}
