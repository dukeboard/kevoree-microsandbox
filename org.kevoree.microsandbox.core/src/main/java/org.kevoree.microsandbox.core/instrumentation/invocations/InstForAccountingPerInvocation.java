package org.kevoree.microsandbox.core.instrumentation.invocations;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 5/8/13
 * Time: 5:18 PM
 * This class is a visitor which implement the instrumentation of classes to support
 * resource accounting per invocation of operations in Kevoree Components.
 * Instead of accounting per Component, this class inserts instructions to create
 * a <see #href>ResourcePrincipal</> in each invocation.
 * After that, each call to account for resource consumption is associated with the
 * new Principal.
 *
 * General idea:
 * 1 - Insert instructions to notify about the execution of a new Invocation at the begin
 *     of each operation.
 * 2 - Insert instruction to notify about the end of the the invocation at the end of
 *     each operation.
 * 3 - The resource monitor creates a new ResourcePrincipal associated to the calling thread
 * 4 - Each operation to allocate resource charges the consumption to such a principal
 */
public class InstForAccountingPerInvocation extends ClassVisitor {
    private String className;
    private int conditionsToBeValidComponent;

    public InstForAccountingPerInvocation(ClassVisitor next) {
        super(Opcodes.ASM4, next);
        className = "";
        conditionsToBeValidComponent = 0;
    }

    @Override
    public void visit(int classVersion, int classScope, String name, String signature,
                      String superClass, String[] interfaces) {
        super.visit(classVersion, classScope, name, signature, superClass, interfaces);
        className = name;
        if (superClass.equals("org/kevoree/framework/AbstractComponentType")) conditionsToBeValidComponent++;

        // TODO : What am I doing??? What ugly way of programming is this?
        // todo : In an agent, I do not have an easy way of discovering if a class
        // todo : is inside a component, so I will assume a pattern in the name
        // todo : it seems to me that in kevoree this should be easy to do in the proper way
        // todo : because every component is deployed in its own classloader
        if (name.startsWith("org/kevoree/library/javase/helloworld")) conditionsToBeValidComponent++;


    }

    @Override
    public MethodVisitor visitMethod(int i, String name, String desc, String s3, String[] strings) {
        // TODO : In fact, I should execute this for every class. Why? Because of the way Java handles events.
        // TODO : Remember, a listener is called from Java library and it can call an external  Kevoree operation.
        // TODO : The problem is that moving this to every class crashes the solution. The reason I could not discover
        if (conditionsToBeValidComponent > 0) {
            if (name.startsWith("operation") && desc.equals("(Ljava/lang/Object;)V")) {
                BehaviorRecorderVisitor rv = new BehaviorRecorderVisitor(
                        super.visitMethod(i, name, desc, s3, strings),
                        className,name,desc, null, null);
                return new OperationVisitor(rv, className, name);
            }
            else {
                BehaviorRecorderVisitor rv = new BehaviorRecorderVisitor(
                        super.visitMethod(i, name, desc, s3, strings),
                        className,name,desc, s3, strings);
                return rv;
            }
        }
        return super.visitMethod(i, name, desc, s3, strings);
    }

    public boolean wasComponent() {
        return conditionsToBeValidComponent > 0;
    }
}
