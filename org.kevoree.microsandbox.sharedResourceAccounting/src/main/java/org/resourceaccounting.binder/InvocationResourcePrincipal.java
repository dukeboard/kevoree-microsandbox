package org.resourceaccounting.binder;

import org.resourceaccounting.*;
import org.resourceaccounting.behavior.*;
import org.resourceaccounting.contract.ComponentResourceContract;
import org.resourceaccounting.utils.HashMap;
import org.resourceaccounting.utils.MyList;


/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 5/8/13
 * Time: 9:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class InvocationResourcePrincipal extends AbstractResourcePrincipal<String> {

    public final ResourcePrincipal parent;

    private int users = 1;

    public boolean isReadyToBeFree() {
        return users == 0;
    }

    public void increaseUsers() {
        users++;
    }

    public void decreaseUsers() {
        users --;
    }

    /**
     * Tree of external calls that this invocation performs
     */
    HashMap<Long, BehaviorNodeCompound> externalOperations;

    /**
     * Indicate the node of the tree which acts as parent for new external operations
     */
    HashMap<Long, MyList<BehaviorNodeCompound>> currentNode;

    /**
     * This is not thread safe
     *
     * @param operation
     */
    protected InvocationResourcePrincipal(String operation, ResourcePrincipal parent) {
        super(operation);
        this.parent = parent;
        externalOperations = new HashMap<Long, BehaviorNodeCompound>(3);
        Long l = Thread.currentThread().getId();
        BehaviorNodeCompound node = new FlatBehaviorNode();
        externalOperations.put(l, node);
        currentNode = new HashMap<Long, MyList<BehaviorNodeCompound>>();
        MyList<BehaviorNodeCompound> stack = new MyList<BehaviorNodeCompound>();
        stack.push(node);
        currentNode.put(l, stack);
//        contract = ((ComponentResourceContract)parent.getContract()).getContractFor(operation);
    }

    private void updateParent(int i, int o, int s, int r, int wf) {
        synchronized (parent) {
            parent.increaseExecutedInstructions(i);
            parent.increaseOwnedObjects(o);
            parent.increaseBytesSent(s);
            parent.increaseBytesReceived(r);
            parent.increaseFileWrite(wf);
        }
    }

    @Override
    public void increaseExecutedInstructions(int n) {
        super.increaseExecutedInstructions(n);
        updateParent(n, 0, 0, 0,0);
    }

    @Override
    public void increaseOwnedObjects(int n) {
        super.increaseOwnedObjects(n);
        updateParent(0, n, 0, 0, 0);
    }

    @Override
    public void increaseBytesSent(int n) {
        super.increaseBytesSent(n);
        updateParent(0, 0, n, 0, 0);
    }

    @Override
    public void increaseBytesReceived(int n) {
        super.increaseBytesReceived(n);
        updateParent(0, 0, 0, n, 0);
    }

    @Override
    public void increaseFileWrite(int n) {
        super.increaseFileWrite(n);
        updateParent(0,0,0,0,n);
    }

    private void addNode(BehaviorNode node, Thread thread) {
        Long l = thread.getId();
        long idThread = l;
        if (!externalOperations.containsKey(idThread)) {
            FlatBehaviorNode node0 = new FlatBehaviorNode();
            externalOperations.put(l, node0);
            MyList<BehaviorNodeCompound> stack = new MyList<BehaviorNodeCompound>();
            stack.push(node0);
            currentNode.put(l, stack);
        }
        currentNode.get(idThread).peek().add(node);
    }

    public final void addCallToExternalOperation(String operationName, Thread thread) {
        addNode(new BehaviorNodeOperation(operationName), thread);
        if (operationName.equals("newPortToCheckThreads")) {
            MyList<BehaviorNode> a = currentNode.get(thread.getId()).peek().getChildren();
            for (int i = 0 ; i < a.size() ; i++) {
                BehaviorNodeOperation op = (BehaviorNodeOperation)a.get(i);
                if (op.getName().equals("newPortToCheckThreads")) {
                    System.out.printf("operation executed %d times in invocation %d , thread %d\n",
                            op.getCount(), id, thread.getId());
                }
            }
        }
    }

    public void push(Thread thread) {
        // TODO : Add per thread behavior
//        BehaviorNodeCompound node = new BehaviorNodeRepetition();
//        addNode(node);
//        currentNode.push(node);
    }

    public boolean pop(Thread thread) {
        // TODO : Add per thread behavior
//        if (currentNode.peek() instanceof BehaviorNodeRepetition) {
//            BehaviorNodeCompound node = currentNode.pop();
//            if (node.getChildren().size() == 0) {
//                currentNode.peek().remove(node);
//            }
//            return true;
//        }
//        return false;
        return true;
    }

    /**
     * Called on invocationStop
     */
    public void stopInvocation(Thread thread) {
        // TODO : Add per thread behavior
    }

    public void recordInParent() {
        // TODO : This is crap because we are unable to create a proper Sequence Diagram with multi-thread
        BehaviorNodeCompound r = new FlatBehaviorNode();
        for (BehaviorNodeCompound node : externalOperations.values()) {
            node.optimize();
            r.merge(node, true);
        }
        ((ThreadGroupResourcePrincipal)parent).storeOperationInformation(getAssociatedObject(),r,this);
    }

    @Override
    public int getId() {
        return parent.getId();
    }
}
