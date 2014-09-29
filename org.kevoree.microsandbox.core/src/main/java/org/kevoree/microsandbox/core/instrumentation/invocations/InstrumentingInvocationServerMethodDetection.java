package org.kevoree.microsandbox.core.instrumentation.invocations;

import org.kevoree.microsandbox.core.instrumentation.AbstractMethodInstrumentation;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.MethodVisitor;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 7/5/13
 * Time: 6:31 PM
 *
 */
public class InstrumentingInvocationServerMethodDetection extends AbstractMethodInstrumentation {
    private final String methodName;

    public InstrumentingInvocationServerMethodDetection(MethodVisitor next, String className, String methodName) {
        super(next, className);
        this.methodName = methodName;
    }

    @Override
    public void visitCode() {
        super.visitCode();
        // call the integer class
        load(0, OBJECT_TYPE);
        invokevirtual(className, "getComponentName", "()Ljava/lang/String;");
        load(0, OBJECT_TYPE);
        invokevirtual(className, "getName", "()Ljava/lang/String;");
        invokestatic("java/lang/Integer", "__reportPortHandlerExecution__",
                        "(Ljava/lang/Object;Ljava/lang/Object;)V");
    }
}
