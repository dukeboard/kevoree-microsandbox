package org.kevoree.microsandbox.core.instrumentation.threads;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.commons.InstructionAdapter;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 1/5/14
 * Time: 8:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class ThreadStartDetector extends InstructionAdapter {
    private final String targetClass;
    private final String targetMethod;

    public ThreadStartDetector(MethodVisitor methodVisitor,
                               String targetClass,
                               String targetMethod) {
        super(Opcodes.ASM5, methodVisitor);
        this.targetClass = targetClass.replace('.','/');
        this.targetMethod = targetMethod.replace('.','/');
    }

    @Override
    public void visitCode() {
        super.visitCode();
        invokestatic(targetClass, targetMethod, "()V");
    }
}
