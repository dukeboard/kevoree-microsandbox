package org.resourceaccounting.binderinjector;

import org.objectweb.asm.*;

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



    @Override
    public void visitInsn(int opcode) {
        readInstructions++;
        boolean  b = (opcode >= Opcodes.IRETURN && opcode <= Opcodes.RETURN) || opcode == Opcodes.ATHROW;
        if (b) {
            // register the consumption of resources
            registerConsumption();
        }
        // generate he normal instruction
        super.visitInsn(opcode);
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

    @Override
    public void visitMaxs(int maxStack, int maxLocals) {
        super.visitMaxs(maxStack + 3, maxLocals);
    }

    /**
     * Generate the code to notify about CPU and Memory Allocation
     */
    private void registerConsumption() {
        int countI = readInstructions - lastMarkOfBasicBlockBorder;
        registerCPUConsumption(countI);
        lastMarkOfBasicBlockBorder = readInstructions;
    }
}
