package org.kevoree.microsandbox.core.instrumentation.invocations;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 7/5/13
 * Time: 6:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class DetectingInvocationReceptions extends ClassVisitor {

    private String className;
    private boolean conditionsToBeValidComponent;

    public DetectingInvocationReceptions(ClassVisitor next) {
        super(Opcodes.ASM4, next);
        className = "";
        conditionsToBeValidComponent = false;
    }

    @Override
    public void visit(int version, int flags, String name, String signature, String superName,
                      String[] interfaces) {
        super.visit(version, flags, name, signature, superName, interfaces);
        className = name;
        conditionsToBeValidComponent = (superName.equals("org/kevoree/framework/AbstractComponentType"));

    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String s3, String[] strings) {
        if (conditionsToBeValidComponent) {
            return new InstrumentingInvocationServerMethodDetection(
                    super.visitMethod(access, name, desc, s3, strings),
                    className, name);
        }
        return super.visitMethod(access, name, desc, s3, strings);
    }
}
