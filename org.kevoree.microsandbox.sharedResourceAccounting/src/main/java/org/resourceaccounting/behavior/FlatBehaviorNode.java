package org.resourceaccounting.behavior;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 5/20/13
 * Time: 7:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class FlatBehaviorNode extends BehaviorNodeCompound {

    public void add(BehaviorNode node) {
        int index = children.indexOf(node);
        if (index != -1) {
            BehaviorNodeOperation operation = (BehaviorNodeOperation)children.get(index);
            operation.increaseCount(1);
            return;
        }
        super.add(node);
    }

    @Override
    public void accept(BehaviorNodeVisitor visitor) {
        visitor.visitFlatNode(this);
    }

    public final void optimize() {
        for (int i = children.size() - 1; i > 0 ; i--) {
            if (children.get(i).equals(children.get(i-1))) {
                children.removeIndex(i);
            }
        }
        super.optimize();
    }

    @Override
    public void merge(BehaviorNode behavior, boolean addInsteadOfMax) {
        if (behavior instanceof FlatBehaviorNode) {
            FlatBehaviorNode flat = (FlatBehaviorNode)behavior;
            for (int i = 0 ; i < flat.children.size() ; i++) {
                BehaviorNodeOperation op1 = (BehaviorNodeOperation)flat.getChildren().get(i);
                int index = children.indexOf(op1);
                if (index != -1) {
                    BehaviorNodeOperation nodeOperation =
                            (BehaviorNodeOperation)children.get(index);
                    int max = nodeOperation.getCount() - op1.getCount();
                    if (!addInsteadOfMax) {
                        if (max > 0)
                            nodeOperation.increaseCount(max);
                    }
                    else {
                        if (max < 0)
                            max = -max;
                        max++;
                        nodeOperation.increaseCount(max);
                    }
                }
                else children.add(op1);
            }
        }
    }
}
