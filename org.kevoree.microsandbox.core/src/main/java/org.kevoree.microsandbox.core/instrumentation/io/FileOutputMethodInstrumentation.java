package org.kevoree.microsandbox.core.instrumentation.io;

import org.kevoree.microsandbox.core.instrumentation.AbstractMethodInstrumentation;
import org.objectweb.asm.MethodVisitor;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 6/10/13
 * Time: 10:41 AM
 * To change this template use File | Settings | File Templates.
 */
public class FileOutputMethodInstrumentation extends AbstractMethodInstrumentation {
    public FileOutputMethodInstrumentation(MethodVisitor mi, String className) {
        super(mi, className);
    }

    @Override
    public void visitMethodInsn(int opcode, String involvedClass, String calledMethod, String s3) {

        if (calledMethod.equals("writeBytes")) {
            // generate call to the resource monitor
            System.out.println("Instrumenting the class FileOutputStream");
//            this.dup();
//            registerHardDiskWrite();

            super.visitMethodInsn(opcode, involvedClass, calledMethod, s3);
        }
        else super.visitMethodInsn(opcode, involvedClass, calledMethod, s3);
    }
}
