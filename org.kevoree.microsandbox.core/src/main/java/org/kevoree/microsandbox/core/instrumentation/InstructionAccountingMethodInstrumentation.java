package org.kevoree.microsandbox.core.instrumentation;

import org.objectweb.asm.*;
import org.objectweb.asm.commons.AnalyzerAdapter;
import org.objectweb.asm.commons.LocalVariablesSorter;

/**
* Created with IntelliJ IDEA.
* User: inti
* Date: 4/22/13
* Time: 2:48 PM
*
*/
public class InstructionAccountingMethodInstrumentation extends AbstractMethodInstrumentation {

    /**
     * A very rough way of finding basic block.
     */
    private int lastMarkOfBasicBlockBorder;

    /**
     * Current opcode index in bytecode array for this method
     */
    private int readInstructions;

//    public LocalVariablesSorter lvs;
//////    public AnalyzerAdapter aa;


    public InstructionAccountingMethodInstrumentation(MethodVisitor methodVisitor, String className) {
        super(methodVisitor, className);
        lastMarkOfBasicBlockBorder = 0;
        readInstructions = 0;
    }

    @Override
    public void visitFieldInsn(int i, String s, String s2, String s3) {
        readInstructions++;
        super.visitFieldInsn(i, s, s2, s3);
    }

    @Override
    public void visitMethodInsn(int opcode, String involvedClass, String calledMethod, String s3) {
        readInstructions++;
        super.visitMethodInsn(opcode, involvedClass, calledMethod, s3);
    }

    @Override
    public void visitTypeInsn(int opcode, String involvedClass) {
        // execute the new
        readInstructions++;
        super.visitTypeInsn(opcode, involvedClass);
    }

//    private int time;
//    private int maxStack;
//
//    @Override
//    public void visitCode() {
//        mv.visitCode();
//        mv.visitMethodInsn(Opcodes.INVOKESTATIC, ExtraInstrumentationRules.MONITOR_CLASS_NAME,
//                "getPrincipalCounter",
//                "()Ljava/util/concurrent/atomic/AtomicLong;");
//        time = lvs.newLocal(Type.getType("Ljava/util/concurrent/atomic/AtomicLong;"));
//        mv.visitVarInsn(Opcodes.ASTORE, time);
//        maxStack = 2;
//    }

    @Override
    public void visitInsn(int opcode) {
        readInstructions++;
        boolean  b = (opcode >= Opcodes.IRETURN && opcode <= Opcodes.RETURN) || opcode == Opcodes.ATHROW;
        if (b) {
            // register the consumption of resources
            registerConsumption();
//            mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/System",
//                    "currentTimeMillis", "()J");
//            mv.visitVarInsn(Opcodes.LLOAD, time);
//            mv.visitInsn(Opcodes.LSUB);
//            mv.visitInsn(Opcodes.POP);
//            maxStack = Math.max(aa.stack.size() + 4, maxStack);
        }
        // generate he normal instruction
        super.visitInsn(opcode);
    }

    @Override
    public void visitMaxs(int maxStack, int maxLocals) {
//        mv.visitMaxs(Math.max(this.maxStack, maxStack + 6), maxLocals);
        super.visitMaxs(maxStack + 3, maxLocals);
    }

    /**
     * Visit all JMP instrucions
     * @param opcode
     * @param label
     */
    @Override
    public void visitJumpInsn(int opcode, Label label) {
        readInstructions++;
        // register the consumption of resources
        registerConsumption();
        // generate the jmp instruction
        super.visitJumpInsn(opcode, label);
    }

    @Override
    public void visitLabel(Label label) {
        // register the consumption of resources
        registerConsumption();
        super.visitLabel(label);
    }

    /**
     * Visit IINC instruction
     * @param opcode
     * @param amount
     */
    @Override
    public void visitIincInsn(int opcode, int amount) {
        readInstructions++;
        super.visitIincInsn(opcode, amount);
    }

    @Override
    public void visitIntInsn(int opcode, int operand) {
        readInstructions++;
        super.visitIntInsn(opcode, operand);
    }

    @Override
    public void visitVarInsn(int opcode, int i2) {
        readInstructions++;
        super.visitVarInsn(opcode, i2);
    }

    @Override
    public void visitInvokeDynamicInsn(String s, String s2, Handle handle, Object... objects) {
        readInstructions++;
        super.visitInvokeDynamicInsn(s, s2, handle, objects);
    }

    @Override
    public void visitLdcInsn(Object o) {
        readInstructions++;
        super.visitLdcInsn(o);
    }

    @Override
    public void visitTableSwitchInsn(int i, int i2, Label label, Label... labels) {
        readInstructions++;
        // register the consumption of resources
        registerConsumption();
        super.visitTableSwitchInsn(i, i2, label, labels);
    }

    @Override
    public void visitLookupSwitchInsn(Label label, int[] ints, Label[] labels) {
        readInstructions++;
        // register the consumption of resources
        registerConsumption();
        super.visitLookupSwitchInsn(label, ints, labels);
    }

    @Override
    public void visitMultiANewArrayInsn(String s, int i) {
        readInstructions++;
        super.visitMultiANewArrayInsn(s, i);
    }

    /**
     * Generate the code to notify about CPU and Memory Allocation
     */
    private void registerConsumption() {
        int countI = readInstructions - lastMarkOfBasicBlockBorder;
        registerCPUConsumption(countI);
//        mv.visitVarInsn(Opcodes.ALOAD, time);
//        lconst(countI);
//        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL,"java/util/concurrent/atomic/AtomicLong","addAndGet","(J)J");
//        mv.visitInsn(Opcodes.POP2);
        lastMarkOfBasicBlockBorder = readInstructions;
    }
}
