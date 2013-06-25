package org.resourceaccounting.binderinjector.io;

import org.objectweb.asm.MethodVisitor;
import org.resourceaccounting.binderinjector.AbstractMethodInstrumentation;

public class NetworkAccessMethodInstrumentation extends AbstractMethodInstrumentation {
    public NetworkAccessMethodInstrumentation(MethodVisitor visitor, String className) {
        super(visitor, className);
    }

    @Override
    public void visitMethodInsn(int opcode, String involvedClass, String calledMethod, String s3) {

        if (calledMethod.equals("socketRead0")) {
            super.visitMethodInsn(opcode, involvedClass, calledMethod, s3);
            // generate call to the resource monitor
            callIntegerForNetworkBytesReceived();
//            registerNetworkBytesReceived();
        }
        else if (calledMethod.equals("socketWrite0")) {
            callIntegerForNetworkBytesSent();
//            registerNetworkBytesSent();
            super.visitMethodInsn(opcode, involvedClass, calledMethod, s3);
        }
        else {
            super.visitMethodInsn(opcode, involvedClass, calledMethod, s3);
        }
    }

    private void callIntegerForNetworkBytesSent() {
        this.dup(); // number of byte to write
        invokestatic("java/lang/Integer", "__reportSocketWrite__", "(I)V");
    }

    private void callIntegerForNetworkBytesReceived() {
        dup(); // number of read byte
        invokestatic("java/lang/Integer", "__reportSocketRead__", "(I)V");
    }

}