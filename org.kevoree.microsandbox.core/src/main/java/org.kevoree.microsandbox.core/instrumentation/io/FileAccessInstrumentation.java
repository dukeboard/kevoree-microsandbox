package org.kevoree.microsandbox.core.instrumentation.io;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 7/4/13
 * Time: 7:01 AM
 * To change this template use File | Settings | File Templates.
 */
public class FileAccessInstrumentation extends ClassVisitor {
    private String className;

    public FileAccessInstrumentation(ClassVisitor classVisitor) {
        super(Opcodes.ASM5, classVisitor);
    }

    @Override
    public void visit(int i, int i2, String s, String s2, String s3, String[] strings) {
        super.visit(i, i2, s, s2, s3, strings);
        className = s;
    }

    @Override
    public MethodVisitor visitMethod(int flags, String methodName, String signature, String s3, String[] strings) {
        MethodVisitor mv = super.visitMethod(flags, methodName, signature, s3, strings);
        return new FileAccessMethodInstrumentation(mv, className);
    }
}
