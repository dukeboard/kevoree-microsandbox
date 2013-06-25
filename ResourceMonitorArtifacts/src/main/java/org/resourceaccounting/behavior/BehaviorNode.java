package org.resourceaccounting.behavior;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 5/10/13
 * Time: 6:32 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class BehaviorNode {
    public abstract void accept(BehaviorNodeVisitor visitor);

    public void optimize() {

    }

    public void merge(BehaviorNode behavior, boolean addInsteadOfMax) {

    }
}
