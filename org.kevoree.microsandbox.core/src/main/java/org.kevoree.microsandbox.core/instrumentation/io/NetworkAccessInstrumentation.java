package org.kevoree.microsandbox.core.instrumentation.io;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 6/15/13
 * Time: 9:44 PM
 *
 * This visitor assumes that the class being visited is java/net/SocketInputStream
 * or java/net/SocketOutputStream. However, nothing really important will happen if this
 * assertion is false. Only if someone decide to use this visitor with a class that contains
 * method socketRead0 or socketWrite0. In such a case everything will fail. :-)
 */
public class NetworkAccessInstrumentation extends ClassVisitor {

    private String className;

    public NetworkAccessInstrumentation(ClassVisitor classVisitor) {
        super(Opcodes.ASM4, classVisitor);
    }

    @Override
    public void visit(int i, int i2, String s, String s2, String s3, String[] strings) {
        super.visit(i, i2, s, s2, s3, strings);
        className = s;
    }

    @Override
    public MethodVisitor visitMethod(int flags, String methodName, String signature, String s3, String[] strings) {
        MethodVisitor mv = super.visitMethod(flags, methodName, signature, s3, strings);
        return new NetworkAccessMethodInstrumentation(mv, className);
    }
}
