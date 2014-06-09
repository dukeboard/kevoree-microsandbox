package org.kevoree.microsandbox.core.instrumentation.memory;

import org.objectweb.asm.*;
import org.objectweb.asm.commons.InstructionAdapter;


/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 6/15/13
 * Time: 12:22 AM
 *
 *
 * This Visitor assumes that the class being visited inherits from Object
 */
public class AddPrincipalIdentifier extends ClassVisitor {

    private String className;
    private boolean hasFinalize = false;

    public AddPrincipalIdentifier(ClassVisitor classVisitor) {
        super(Opcodes.ASM5, classVisitor);
    }

    @Override
    public void visit(int classVersion, int flags, String name,
                      String signature, String superclass, String[] strings) {
        className = name;

        super.visit(classVersion, flags, name, signature, superclass, strings);
    }

    @Override
    public MethodVisitor visitMethod(int flags,
                                     String methodName,
                                     String signature,
                                     String s3,
                                     String[] strings) {

        if (!hasFinalize) {
            hasFinalize = (methodName.equals("finalize") && signature.equals("()V"));
            if (hasFinalize) {
                return new AdaptingExistentFinalizeInRT(className,
                        super.visitMethod(flags, methodName, signature, s3, strings));
            }
        }

        return super.visitMethod(flags, methodName, signature, s3, strings);
    }


    @Override
    public void visitEnd() {
        // add a finalize method if the class does not have one
        if (!hasFinalize) {
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

        // add a field to store the owner resource principal, used in finalize
        FieldVisitor fv = cv.visitField(Opcodes.ACC_PUBLIC | Opcodes.ACC_TRANSIENT,
                "__principalID__",
                "I",
                null, null);
        if (fv != null) {
            fv.visitEnd();
        }
        super.visitEnd();
    }

}
