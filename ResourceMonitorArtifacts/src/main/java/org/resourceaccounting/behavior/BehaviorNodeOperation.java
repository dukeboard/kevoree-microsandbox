package org.resourceaccounting.behavior;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 5/10/13
 * Time: 6:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class BehaviorNodeOperation extends BehaviorNode {
    private String name;

    private int count;

    public BehaviorNodeOperation(String name) {
        this.name = name;
        count = 1;
    }

    public void increaseCount(int n) {
        count += n;
    }

    public int getCount() {
        return count;
    }

    @Override
    public void accept(BehaviorNodeVisitor visitor) {
        visitor.visitExternalOperations(this);
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BehaviorNodeOperation that = (BehaviorNodeOperation) o;

        if (!name.equals(that.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
