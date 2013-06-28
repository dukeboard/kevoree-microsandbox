package org.kevoree.microsandbox.core.instrumentation.memory;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.InstructionAdapter;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 6/15/13
 * Time: 7:52 PM
 *
 * This class assumes that the class visitor which create this method visitor
 * is visiting a class with a definition of __principalID__
 */
public class AdaptingExistentFinalizeInRT extends InstructionAdapter {
    private final String className;

    public AdaptingExistentFinalizeInRT(String classname, MethodVisitor visitor) {
        super(Opcodes.ASM4, visitor);
        this.className = classname;
    }

    @Override
    public void visitInsn(int opcode) {
        boolean  b = (opcode == Opcodes.RETURN);
        if (b) {
            load(0, Type.getObjectType(className));
            dup();
            getfield(className, "__principalID__", "I");
            invokestatic("java/lang/Integer", "__reportAboutMemory__", "(Ljava/lang/Object;I)V");
        }
        // generate the normal instruction
        super.visitInsn(opcode);
    }

}
