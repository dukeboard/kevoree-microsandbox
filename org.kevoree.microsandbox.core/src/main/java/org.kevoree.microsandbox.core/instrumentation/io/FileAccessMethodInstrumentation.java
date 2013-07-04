package org.kevoree.microsandbox.core.instrumentation.io;

import org.kevoree.microsandbox.core.instrumentation.AbstractMethodInstrumentation;
import org.objectweb.asm.MethodVisitor;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 6/10/13
 * Time: 10:41 AM
 *
 */
public class FileAccessMethodInstrumentation extends AbstractMethodInstrumentation {

    public FileAccessMethodInstrumentation(MethodVisitor mi, String className) {
        super(mi, className);
    }

    @Override
    public void visitMethodInsn(int opcode, String involvedClass, String calledMethod, String s3) {

        if (calledMethod.equals("writeBytes")) {
            // generate call to the resource monitor
            callIntegerForFileWriteAccess();
            super.visitMethodInsn(opcode, involvedClass, calledMethod, s3);
        }
        else if (calledMethod.equals("readBytes")) {
            super.visitMethodInsn(opcode, involvedClass, calledMethod, s3);
            // generate call to the resource monitor
            callIntegerForFileReadAccess();
        }
        else super.visitMethodInsn(opcode, involvedClass, calledMethod, s3);
    }

    private void callIntegerForFileReadAccess() {
        this.dup();
        invokestatic("java/lang/Integer", "__reportFileRead__", "(I)V");
    }

    private void callIntegerForFileWriteAccess() {
        this.swap();
        this.dup(); // number of bytes to write
        invokestatic("java/lang/Integer", "__reportFileWrite__", "(I)V");
        this.swap();
    }
}
