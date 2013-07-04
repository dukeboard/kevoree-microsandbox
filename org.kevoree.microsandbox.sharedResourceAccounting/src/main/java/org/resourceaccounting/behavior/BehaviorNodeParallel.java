package org.resourceaccounting.behavior;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 5/10/13
 * Time: 6:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class BehaviorNodeParallel extends BehaviorNodeCompound {
    private BehaviorNode left;
    private BehaviorNode right;

    public BehaviorNodeParallel(BehaviorNode left, BehaviorNode right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public void accept(BehaviorNodeVisitor visitor) {
        visitor.visitParallel(this);
    }
}
