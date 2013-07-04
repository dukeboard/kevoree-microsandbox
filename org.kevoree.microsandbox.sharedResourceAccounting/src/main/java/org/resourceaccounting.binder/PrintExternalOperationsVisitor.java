package org.resourceaccounting.binder;

import org.resourceaccounting.behavior.*;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 5/10/13
 * Time: 7:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class PrintExternalOperationsVisitor extends BehaviorNodeVisitor {
    @Override
    public void visitSerialOperations(BehaviorNodeSerial a) {
        if (a.getChildren().size() == 0) {
            System.out.print("empty serial");
            return;
        };
        System.out.print("(");
        for (int i = 0 ; i < a.getChildren().size() ; i++) {
            if (i > 0)
                System.out.print(",");
            a.getChildren().get(i).accept(this);
        }
        System.out.print(")");
    }

    @Override
    public void visitParallel(BehaviorNodeParallel a) {
        if (a.getChildren().size() == 0) {
            System.out.print("empty parallel");
            return;
        };
        System.out.print("(");
        for (int i = 0 ; i < a.getChildren().size() ; i++) {
            if (i > 0)
                System.out.print("|");
            a.getChildren().get(i).accept(this);
        }
        System.out.print(")");
    }

    @Override
    public void visitRepetition(BehaviorNodeRepetition a) {
        if (a.getChildren().size() == 0) {
            System.out.print("empty repetition");
            return;
        };
        System.out.print("(");
        for (int i = 0 ; i < a.getChildren().size() ; i++) {
            if (i > 0)
                System.out.print(",");
            a.getChildren().get(i).accept(this);
        }
        System.out.print(")");
        System.out.print("*");
    }

    @Override
    public void visitExternalOperations(BehaviorNodeOperation a) {
        System.out.print(a.getName());
        if (a.getCount() > 1)
            System.out.print('*');
    }

    @Override
    public void visitFlatNode(FlatBehaviorNode a) {
        if (a.getChildren().size() == 0) {
            System.out.print("empty serial");
            return;
        };
        System.out.print("(");
        for (int i = 0 ; i < a.getChildren().size() ; i++) {
            if (i > 0)
                System.out.print(",");
            a.getChildren().get(i).accept(this);
        }
        System.out.print(")");
    }
}
