package org.kevoree.microsandbox.core.instrumentation;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.InstructionAdapter;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 6/16/13
 * Time: 8:01 PM
 *
 */
public class InstrumentingProxyClass extends ClassVisitor {

    public InstrumentingProxyClass(ClassVisitor classVisitor) {
        super(Opcodes.ASM4, classVisitor);
    }

    @Override
    public MethodVisitor visitMethod(int i, String name, String desc, String s3, String[] strings) {
        if (name.equals("__reportAboutMemory__")) {
            if (desc.equals("(Ljava/lang/Object;)I")) {
                InstructionAdapter adapter =
                        new InstructionAdapter(super.visitMethod(i, name, desc, s3, strings)) {
                            @Override
                            public void visitInsn(int opcode) {
                                if (opcode == Opcodes.IRETURN) {
                                    load(0, OBJECT_TYPE);
                                    invokestatic(ExtraInstrumentationRules.MONITOR_CLASS_NAME,
                                            "reportObjectCreation",
                                            "(Ljava/lang/Object;)I");
                                    super.visitInsn(Opcodes.IRETURN);
                                }
                            }

                            @Override
                            public void visitMaxs(int i, int i2) {
                                super.visitMaxs(i+2, i2+2);
                            }
                        };
                return adapter;
            }
            else
            if (desc.equals("(Ljava/lang/Object;I)V")) {
            InstructionAdapter adapter =
                    new InstructionAdapter(super.visitMethod(i, name, desc, s3, strings)) {
                        @Override
                        public void visitInsn(int opcode) {
                            if (opcode == Opcodes.RETURN) {
                                load(0, OBJECT_TYPE);
                                load(1, Type.INT_TYPE);
                                invokestatic(ExtraInstrumentationRules.MONITOR_CLASS_NAME,
                                        "reportObjectDestruction",
                                        "(Ljava/lang/Object;I)V");
                            }
                            super.visitInsn(opcode);
                        }

                        @Override
                        public void visitMaxs(int i, int i2) {
                            super.visitMaxs(i+2, i2+2);
                        }
                    };
            return adapter;
            }
        }
        if (name.equals("__reportSocketRead__") && desc.equals("(I)V")) {
            InstructionAdapter adapter =
                    new InstructionAdapter(super.visitMethod(i, name, desc, s3, strings)) {
                        @Override
                        public void visitInsn(int opcode) {
                            if (opcode == Opcodes.RETURN) {
                                load(0, Type.INT_TYPE);
                                invokestatic(ExtraInstrumentationRules.MONITOR_CLASS_NAME,
                                        "reportNetworkDataRead",
                                        "(I)V");
                            }
                            super.visitInsn(opcode);
                        }
                    };
            return adapter;
        }
        else if (name.equals("__reportSocketWrite__") && desc.equals("(I)V")) {
            InstructionAdapter adapter =
                    new InstructionAdapter(super.visitMethod(i, name, desc, s3, strings)) {
                        @Override
                        public void visitInsn(int opcode) {
                            if (opcode == Opcodes.RETURN) {
                                load(0, Type.INT_TYPE);
                                invokestatic(ExtraInstrumentationRules.MONITOR_CLASS_NAME,
                                        "reportNetworkDataWrite",
                                        "(I)V");
                            }
                            super.visitInsn(opcode);
                        }
                    };
            return adapter;
        }
        else if (name.equals("__reportNewArray__") && desc.equals("(Ljava/lang/Object;)V")) {
            InstructionAdapter adapter =
                    new InstructionAdapter(super.visitMethod(i, name, desc, s3, strings)) {
                        @Override
                        public void visitInsn(int opcode) {
                            if (opcode == Opcodes.RETURN) {
                                load(0, OBJECT_TYPE);
                                invokestatic(ExtraInstrumentationRules.MONITOR_CLASS_NAME,
                                        "reportNewArray",
                                        "(Ljava/lang/Object;)V");
                            }
                            super.visitInsn(opcode);
                        }
                    };
            return adapter;
        }
        return super.visitMethod(i, name, desc, s3, strings);
    }
}
