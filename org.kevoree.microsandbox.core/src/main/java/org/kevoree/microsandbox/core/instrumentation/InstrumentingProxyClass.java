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
        super(Opcodes.ASM5, classVisitor);
    }

    @Override
    public MethodVisitor visitMethod(int i, String name, String desc, String s3, String[] strings) {
        if (name.equals("__reportAboutMemory__")) {
            if (desc.equals("(Ljava/lang/Object;)I")) {
                MethodVisitor visitor = new MethodVisitor(Opcodes.ASM5,
                        super.visitMethod(i, name, desc, s3, strings)) {
                    @Override
                    public void visitInsn(int opcode) {
                        if (opcode == Opcodes.IRETURN) {
                            mv.visitVarInsn(Type.getType("Ljava/lang/Object;").getOpcode(Opcodes.ILOAD), 0);
                            mv.visitMethodInsn(Opcodes.INVOKESTATIC,
                                    ExtraInstrumentationRules.MONITOR_CLASS_NAME,
                                    "reportObjectCreation",
                                    "(Ljava/lang/Object;)I", false);
                        }
                        super.visitInsn(opcode);
                    }

                    @Override
                    public void visitMaxs(int i, int i2) {
                        super.visitMaxs(i+2, i2+2);
                    }
                };
                return visitor;
            }
            if (desc.equals("(Ljava/lang/Object;I)V")) {
                MethodVisitor visitor = new MethodVisitor(Opcodes.ASM5,
                        super.visitMethod(i, name, desc, s3, strings)) {
                    @Override
                    public void visitInsn(int opcode) {
                        if (opcode == Opcodes.RETURN) {
                            mv.visitVarInsn(Type.getType("Ljava/lang/Object;").getOpcode(Opcodes.ILOAD), 0);
                            mv.visitVarInsn(Type.INT_TYPE.getOpcode(Opcodes.ILOAD), 1);
                            mv.visitMethodInsn(Opcodes.INVOKESTATIC,
                                    ExtraInstrumentationRules.MONITOR_CLASS_NAME,
                                    "reportObjectDestruction",
                                    "(Ljava/lang/Object;I)V", false);

                        }
                        super.visitInsn(opcode);
                    }

                    @Override
                    public void visitMaxs(int i, int i2) {
                        super.visitMaxs(i+2, i2+2);
                    }
                };
                return visitor;
            }
        }
        else
        if (name.equals("__reportSocketRead__") && desc.equals("(I)V")) {
            MethodVisitor visitor = new MethodVisitor(Opcodes.ASM5,
                    super.visitMethod(i, name, desc, s3, strings)) {
                @Override
                public void visitInsn(int opcode) {
                    if (opcode == Opcodes.RETURN) {
                        mv.visitVarInsn(Type.INT_TYPE.getOpcode(Opcodes.ILOAD), 0);
                        mv.visitMethodInsn(Opcodes.INVOKESTATIC,
                                ExtraInstrumentationRules.MONITOR_CLASS_NAME,
                                "reportNetworkDataRead",
                                "(I)V", false);

                    }
                    super.visitInsn(opcode);
                }

                @Override
                public void visitMaxs(int i, int i2) { super.visitMaxs(i+1, i2+1); }
            };
            return visitor;
        }
        else if (name.equals("__reportSocketWrite__") && desc.equals("(I)V")) {
            MethodVisitor visitor = new MethodVisitor(Opcodes.ASM5,
                    super.visitMethod(i, name, desc, s3, strings)) {
                @Override
                public void visitInsn(int opcode) {
                    if (opcode == Opcodes.RETURN) {
                        mv.visitVarInsn(Type.INT_TYPE.getOpcode(Opcodes.ILOAD), 0);
                        mv.visitMethodInsn(Opcodes.INVOKESTATIC,
                                ExtraInstrumentationRules.MONITOR_CLASS_NAME,
                                "reportNetworkDataWrite",
                                "(I)V", false);

                    }
                    super.visitInsn(opcode);
                }

                @Override
                public void visitMaxs(int i, int i2) { super.visitMaxs(i+1, i2+1); }
            };
            return visitor;
        }
        else if (name.equals("__reportFileWrite__") && desc.equals("(I)V")) {
            MethodVisitor visitor = new MethodVisitor(Opcodes.ASM5,
                    super.visitMethod(i, name, desc, s3, strings)) {
                @Override
                public void visitInsn(int opcode) {
                    if (opcode == Opcodes.RETURN) {
                        mv.visitVarInsn(Type.INT_TYPE.getOpcode(Opcodes.ILOAD), 0);
                        mv.visitMethodInsn(Opcodes.INVOKESTATIC,
                                ExtraInstrumentationRules.MONITOR_CLASS_NAME,
                                "reportFileDataWrite",
                                "(I)V", false);

                    }
                    super.visitInsn(opcode);
                }

                @Override
                public void visitMaxs(int i, int i2) { super.visitMaxs(i+1, i2+1); }
            };
            return visitor;
        }
        else if (name.equals("__reportFileRead__") && desc.equals("(I)V")) {
            MethodVisitor visitor = new MethodVisitor(Opcodes.ASM5,
                    super.visitMethod(i, name, desc, s3, strings)) {
                @Override
                public void visitInsn(int opcode) {
                    if (opcode == Opcodes.RETURN) {
                        mv.visitVarInsn(Type.INT_TYPE.getOpcode(Opcodes.ILOAD), 0);
                        mv.visitMethodInsn(Opcodes.INVOKESTATIC,
                                ExtraInstrumentationRules.MONITOR_CLASS_NAME,
                                "reportFileDataRead",
                                "(I)V", false);

                    }
                    super.visitInsn(opcode);
                }

                @Override
                public void visitMaxs(int i, int i2) { super.visitMaxs(i+1, i2+1); }
            };
            return visitor;
        }
        else if (name.equals("__reportNewArray__") && desc.equals("(Ljava/lang/Object;)V")) {
            MethodVisitor visitor = new MethodVisitor(Opcodes.ASM5,
                    super.visitMethod(i, name, desc, s3, strings)) {
                @Override
                public void visitInsn(int opcode) {
                    if (opcode == Opcodes.RETURN) {
                        mv.visitVarInsn(Type.getType("Ljava/lang/Object;").getOpcode(Opcodes.ILOAD), 0);
                        mv.visitMethodInsn(Opcodes.INVOKESTATIC,
                                ExtraInstrumentationRules.MONITOR_CLASS_NAME,
                                "reportNewArray",
                                "(Ljava/lang/Object;)V", false);

                    }
                    super.visitInsn(opcode);
                }

                @Override
                public void visitMaxs(int i, int i2) { super.visitMaxs(i+1, i2+1); }
            };
            return visitor;
        }
        else if (name.equals("__reportPortProcessingRequest__")
                && desc.equals("(Ljava/lang/Object;Ljava/lang/Object;)V")) {
            MethodVisitor visitor = new MethodVisitor(Opcodes.ASM5,
                    super.visitMethod(i, name, desc, s3, strings)) {
                @Override
                public void visitInsn(int opcode) {
                    if (opcode == Opcodes.RETURN) {
                        int tmp = Type.getType("Ljava/lang/Object;").getOpcode(Opcodes.ILOAD);
                        mv.visitVarInsn(tmp, 0);
                        mv.visitVarInsn(tmp, 1);
                        mv.visitMethodInsn(Opcodes.INVOKESTATIC,
                                ExtraInstrumentationRules.MONITOR_CLASS_NAME,
                                "reportPortProcessingRequest",
                                "(Ljava/lang/Object;Ljava/lang/Object;)V", false);
                    }
                    super.visitInsn(opcode);
                }

                @Override
                public void visitMaxs(int i, int i2) {
                    super.visitMaxs(i+2, i2+2);
                }
            };
            return visitor;
        }
        else
        if (name.equals("__reportPortHandlerExecution__") &&
                desc.equals("(Ljava/lang/Object;Ljava/lang/Object;)V")) {
            MethodVisitor visitor = new MethodVisitor(Opcodes.ASM5,
                  super.visitMethod(i, name, desc, s3, strings)) {
              @Override
              public void visitInsn(int opcode) {
                  if (opcode == Opcodes.RETURN) {
                      int tmp = Type.getType("Ljava/lang/Object;").getOpcode(Opcodes.ILOAD);
                      mv.visitVarInsn(tmp, 0);
                      mv.visitVarInsn(tmp, 1);
                      mv.visitMethodInsn(Opcodes.INVOKESTATIC,
                              ExtraInstrumentationRules.MONITOR_CLASS_NAME,
                              "reportPortHandlerExecution",
                              "(Ljava/lang/Object;Ljava/lang/Object;)V", false);
                  }
                  super.visitInsn(opcode);
              }

              @Override
              public void visitMaxs(int i, int i2) {
                  super.visitMaxs(i+2, i2+2);
              }
            };
            return visitor;
        }
        else
        if (name.equals("__reportNewThread__") &&
                desc.equals("()V")) {
            MethodVisitor visitor = new MethodVisitor(Opcodes.ASM5,
                    super.visitMethod(i, name, desc, s3, strings)) {
                @Override
                public void visitInsn(int opcode) {
                    if (opcode == Opcodes.RETURN) {
                        mv.visitMethodInsn(Opcodes.INVOKESTATIC,
                                ExtraInstrumentationRules.MONITOR_CLASS_NAME,
                                "reportNewThread",
                                "()V", false);
                    }
                    super.visitInsn(opcode);
                }
            };
            return visitor;
        }



        return super.visitMethod(i, name, desc, s3, strings);
    }
}
