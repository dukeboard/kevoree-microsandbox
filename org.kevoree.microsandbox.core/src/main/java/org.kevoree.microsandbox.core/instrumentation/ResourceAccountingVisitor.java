package org.kevoree.microsandbox.core.instrumentation;

import org.objectweb.asm.*;
import org.objectweb.asm.commons.InstructionAdapter;
import org.kevoree.microsandbox.core.instrumentation.memory.AdaptingExistentFinalizeInRT;
import org.kevoree.microsandbox.core.instrumentation.memory.MemoryAllocationMethodInstrumentation;

/**
* Created with IntelliJ IDEA.
* User: inti
* Date: 4/22/13
* Time: 2:47 PM
*
*
*/
public class ResourceAccountingVisitor extends ClassVisitor {


    boolean hasFinalize = false;
    private String className;
    private boolean shouldAddField;
    private boolean isEnum = false;

    public ResourceAccountingVisitor(ClassVisitor classVisitor) {
        super(Opcodes.ASM4, classVisitor);
    }

    @Override
    public MethodVisitor visitMethod(int flags, String methodName, String signature, String s3, String[] strings) {
        if (shouldAddField && methodName.equals("finalize") && signature.equals("()V")) {
            hasFinalize = true;
            return new AdaptingExistentFinalizeInRT(className,
                    super.visitMethod(flags,
                            methodName,
                            signature,
                            s3,
                            strings));
        }
        return getMethodInstrumenting(flags, methodName, signature, s3, strings);
    }

    private AbstractMethodInstrumentation getMethodInstrumenting(int flags, String methodName,
                                                                 String signature,
                                                                 String s3,
                                                                 String[] strings) {

        MethodVisitor mv = super.visitMethod(flags, methodName, signature, s3, strings);
        if (!isEnum) {
            if (className.contains("MemoryConsumer"))
                System.out.println("Using memory instrumenter");
            mv = new MemoryAllocationMethodInstrumentation(mv,className,true);
        }
        return new InstructionAccountingMethodInstrumentation(mv, className);
    }

    @Override
    public void visit(int classVersion, int flags, String name,
                      String signature, String superclass, String[] strings) {
        className = name;
        isEnum = (flags & Opcodes.ACC_ENUM) != 0;

//        isClassRelateToFileOutput = className.equals("java/io/FileOutputStream");

        shouldAddField = ((flags & Opcodes.ACC_ENUM) == 0) &&
                ((flags & Opcodes.ACC_INTERFACE) == 0) &&
                ((flags & Opcodes.ACC_ABSTRACT) == 0) &&
                ((flags & Opcodes.ACC_ANNOTATION) == 0);

        super.visit(classVersion, flags, name, signature, superclass, strings);
    }

    @Override
    public void visitEnd() {
        // add a finalize method if the class does not have one
        if (shouldAddField && !hasFinalize) {
            InstructionAdapter mv = new InstructionAdapter(super.visitMethod(Opcodes.ACC_PUBLIC,
                    "finalize", "()V", null, new String[]{"java/lang/Throwable"}));
            mv.visitCode();
            mv.load(0, Type.getObjectType(className));
            mv.dup();
            mv.getfield(className, "__principalID__", "I");
            mv.invokestatic("java/lang/Integer", "__reportAboutMemory__", "(Ljava/lang/Object;I)V");

            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(3, 3);
            mv.visitEnd();
        }
        if (shouldAddField) {
            // add a field to store the owner resource principal, used in finalize
            FieldVisitor fv = cv.visitField(Opcodes.ACC_PUBLIC,
                    "__principalID__",
                    "I",
                    null, null);
            if (fv != null) {
                fv.visitEnd();
            }
        }
        super.visitEnd();
    }
}
