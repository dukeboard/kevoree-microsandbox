package org.resourceaccounting.behavior;

import org.resourceaccounting.utils.MyList;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 5/10/13
 * Time: 6:54 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class BehaviorNodeCompound extends BehaviorNode {
    protected MyList<BehaviorNode> children = new MyList<BehaviorNode>();

    public void add(BehaviorNode node) {
        children.add(node);
    }

    public MyList<BehaviorNode> getChildren() {
        return children;
    }

    public void remove(BehaviorNodeCompound node) {
        children.remove(node);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof BehaviorNodeCompound)) return false;

        BehaviorNodeCompound node = (BehaviorNodeCompound)obj;
        if (node.getChildren().size() != children.size()) return false;

        if (!node.getClass().equals(this.getClass())) return false;

        for (int i = 0 ; i < node.children.size() ; i++) {
            if (!node.children.get(i).equals(children.get(i)))
                return false;
        }
        return true;
    }

    public void optimize() {
        for (int i = 0 ; i < children.size() ; i++) {
            BehaviorNode node = children.get(i);
            node.optimize();
        }
    }
}
