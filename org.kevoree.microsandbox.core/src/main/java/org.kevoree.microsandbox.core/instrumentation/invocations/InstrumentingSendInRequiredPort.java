package org.kevoree.microsandbox.core.instrumentation.invocations;

import org.kevoree.microsandbox.core.instrumentation.AbstractMethodInstrumentation;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 7/5/13
 * Time: 4:58 PM
 *
 */
public class InstrumentingSendInRequiredPort extends AbstractMethodInstrumentation {
    private final String methodName;

    public InstrumentingSendInRequiredPort(MethodVisitor next, String className, String methodName) {
        super(next, className);
        this.methodName = methodName;
    }

    @Override
    public void visitCode() {
        super.visitCode();
        // calling a method in Integer to detect the call
        load(0, OBJECT_TYPE);
        invokevirtual(className, "getComponentName", "()Ljava/lang/String;");
        load(0, OBJECT_TYPE);
        invokevirtual(className, "getName", "()Ljava/lang/String;");
        invokestatic("java/lang/Integer", "__reportPortProcessingRequest__",
                        "(Ljava/lang/Object;Ljava/lang/Object;)V");
    }
}
