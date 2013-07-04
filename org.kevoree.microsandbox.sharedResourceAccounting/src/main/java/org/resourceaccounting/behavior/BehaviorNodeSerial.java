package org.resourceaccounting.behavior;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 5/10/13
 * Time: 6:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class BehaviorNodeSerial extends BehaviorNodeCompound {

    @Override
    public void accept(BehaviorNodeVisitor visitor) {
        visitor.visitSerialOperations(this);
    }
}
