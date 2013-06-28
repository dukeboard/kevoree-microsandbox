package org.kevoree.microsandbox.core.instrumentation.invocations;

import org.kevoree.microsandbox.core.instrumentation.AbstractMethodInstrumentation;
import org.kevoree.microsandbox.core.instrumentation.ExtraInstrumentationRules;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 5/8/13
 * Time: 7:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class OperationVisitor extends AbstractMethodInstrumentation {
    private final String methodName;

    public OperationVisitor(MethodVisitor next, String className, String methodName) {
        super(next, className);
        this.methodName = methodName;
    }

    @Override
    public void visitInsn(int opcode) {
        boolean  b = (opcode >= Opcodes.IRETURN && opcode <= Opcodes.RETURN) || opcode == Opcodes.ATHROW;
        if (b) {
            // register the consumption of resources
            invokestatic(ExtraInstrumentationRules.MONITOR_CLASS_NAME, "stopInvocation", "()V");
        }
        super.visitInsn(opcode);
    }

    @Override
    public void visitCode() {
        super.visitCode();
        // add call to ResourceCounter.newInvocation
        this.aconst(this.methodName);
        invokestatic(ExtraInstrumentationRules.MONITOR_CLASS_NAME, "newInvocation",
                "(Ljava/lang/String;)V");
    }

    @Override
    public void visitEnd() {
        invokestatic(ExtraInstrumentationRules.MONITOR_CLASS_NAME, "stopInvocation", "()V");
        super.visitEnd();
    }
}
