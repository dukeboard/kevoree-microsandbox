package org.kevoree.microsandbox.core.instrumentation;

import org.kevoree.microsandbox.core.instrumentation.memory.AdaptingExistentFinalizeInRT;
import org.kevoree.microsandbox.core.instrumentation.threads.ThreadStartDetector;
import org.objectweb.asm.*;

/**
 *
 */
public class ThreadCreationVisitor extends ClassVisitor {
    private final String targetClass;
    private final String targetMethod;
    private String className;
    private boolean isPotentialThread = false;

    public ThreadCreationVisitor(ClassVisitor classVisitor,
                                 String targetClass, String targetMethod) {
        super(Opcodes.ASM4, classVisitor);
        this.targetClass = targetClass;
        this.targetMethod = targetMethod;
    }

    @Override
    public MethodVisitor visitMethod(int flags, String methodName,
                                     String signature, String s3,
                                     String[] interfaces) {
        if (isPotentialThread &&
                methodName.equals("run") &&
                signature.equals("()V")) {

            return new ThreadStartDetector(
                    super.visitMethod(flags,
                            methodName,
                            signature,
                            s3,
                            interfaces),
                    targetClass,
                    targetMethod);
        }
        return super.visitMethod(flags, methodName, signature, s3, interfaces);
    }

    @Override
    public void visit(int classVersion, int flags, String name,
                      String signature, String superclass, String[] interfaces) {
        className = name;
        isPotentialThread = name.equals("java/lang/Thread") ||
                            superclass.equals("java/lang/Thread");

        for (int i = 0 ; !isPotentialThread && interfaces != null && i < interfaces.length ; ++i) {
            isPotentialThread = interfaces[i].equals("java.lang/Runnable");
        }

        super.visit(classVersion, flags, name, signature, superclass, interfaces);
    }

    @Override
    public void visitEnd() {
        // FIXME: Do something???
        if (isPotentialThread) {

        }
        super.visitEnd();
    }
}
