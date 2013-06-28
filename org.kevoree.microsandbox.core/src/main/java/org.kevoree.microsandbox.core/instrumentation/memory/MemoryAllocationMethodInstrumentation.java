package org.kevoree.microsandbox.core.instrumentation.memory;

import org.kevoree.microsandbox.core.instrumentation.AbstractMethodInstrumentation;
import org.kevoree.microsandbox.core.instrumentation.ExtraInstrumentationRules;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 6/15/13
 * Time: 11:21 PM
 *
 *
 */
public class MemoryAllocationMethodInstrumentation extends AbstractMethodInstrumentation {

    private int countOfNew = 0;
    private int additionalsDup = 0;
    private boolean accountForArrays = false;

    public MemoryAllocationMethodInstrumentation(MethodVisitor visitor, String className, boolean accountForArrays) {
        super(visitor, className);
        this.accountForArrays = accountForArrays;
        if (className.contains("MemoryConsumer")) {
            System.out.println("Magic on " + className);
        }
    }

    @Override
    public void visitMethodInsn(int opcode, String involvedClass, String calledMethod, String s3) {
        super.visitMethodInsn(opcode, involvedClass, calledMethod, s3);
        if ( opcode == Opcodes.INVOKESPECIAL
                && calledMethod.equals("<init>")
                && ExtraInstrumentationRules.isMemoryAccountable(involvedClass)
                ) {
            if (countOfNew > 0) {
                dup();
                invokestatic("java/lang/Integer", "__reportAboutMemory__", "(Ljava/lang/Object;)I");
                putfield(involvedClass, "__principalID__", "I");
                countOfNew --;
            }
        }
    }

    @Override
    public void visitTypeInsn(int opcode, String involvedClass) {
        // execute the new
        super.visitTypeInsn(opcode, involvedClass);
        if (opcode == Opcodes.NEW
                && ExtraInstrumentationRules.isMemoryAccountable(involvedClass)
                ) {
            // register the creation of the new object
            this.dup();
            additionalsDup++;
            countOfNew++; // we need this var because of calls to parent constructors
        }
        else if (accountForArrays && opcode == Opcodes.ANEWARRAY) {
            dup();
            invokestatic("java/lang/Integer", "__reportNewArray__", "(Ljava/lang/Object;)V");
        }
    }

    @Override
    public void visitIntInsn(int opcode, int operands) {
        super.visitIntInsn(opcode, operands);
        if (accountForArrays && opcode == Opcodes.NEWARRAY) {
            dup();
            invokestatic("java/lang/Integer", "__reportNewArray__", "(Ljava/lang/Object;)V");
        }
    }

    @Override
    public void visitMaxs(int maxStack, int maxLocals) {
        int total = 0;
        if (additionalsDup > 0)
            total += additionalsDup + 3;
        super.visitMaxs(maxStack + total, maxLocals);
    }
}
