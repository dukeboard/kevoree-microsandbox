package org.resourceaccounting.behavior;


/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 5/10/13
 * Time: 6:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class BehaviorNodeRepetition extends BehaviorNodeCompound {

    public void add(BehaviorNode node) {
        if (children.indexOf(node) != -1) return;
        super.add(node);
    }

    @Override
    public void accept(BehaviorNodeVisitor visitor) {
        visitor.visitRepetition(this);
    }

    public final void optimize() {
        for (int i = children.size() - 1; i > 0 ; i--) {
            if (children.get(i).equals(children.get(i-1))) {
                children.removeIndex(i);
            }
        }
        super.optimize();
    }
}
