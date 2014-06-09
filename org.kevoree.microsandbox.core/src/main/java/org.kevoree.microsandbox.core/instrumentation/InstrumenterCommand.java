package org.kevoree.microsandbox.core.instrumentation;

import org.kevoree.microsandbox.core.instrumentation.invocations.DetectingInvocationReceptions;
import org.kevoree.microsandbox.core.instrumentation.invocations.DetectingInvocationRequests;
import org.kevoree.microsandbox.core.instrumentation.io.FileAccessInstrumentation;
import org.objectweb.asm.*;
import org.objectweb.asm.util.CheckClassAdapter;
import org.kevoree.microsandbox.core.instrumentation.io.NetworkAccessInstrumentation;
import org.kevoree.microsandbox.core.instrumentation.memory.AddPrincipalIdentifier;
import org.kevoree.microsandbox.core.instrumentation.memory.MemoryAllocationMethodInstrumentation;
import org.objectweb.asm.util.TraceClassVisitor;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 6/14/13
 * Time: 11:18 PM
 *
 */
public class InstrumenterCommand {
    public byte[] instrument(byte[] code, String className, boolean instr_mem,
                             boolean instr_instr, boolean thread_creation) {

        ClassReader reader = new ClassReader(code);
        ClassWriter writer = new ClassWriter(reader, ClassWriter.COMPUTE_MAXS);
        ClassVisitor tmp = writer;

//        if (className.equals("org/dacapo/harness/TestHarness")) {
//            tmp = new TraceClassVisitor(tmp, new PrintWriter(System.out));
        tmp = new ResourceAccountingVisitor(tmp, instr_mem, instr_instr);
        if (thread_creation) {
//            System.out.println("Adding the option to instrument thread calls");
            tmp = new ThreadCreationVisitor(tmp,
                    "java/lang/Integer",
                    "__reportNewThread__");
        }

//            tmp = new CheckClassAdapter(tmp,true);
//        }

        //tmp = new InstForAccountingPerInvocation(tmp);

        try {
            tmp = new DetectingInvocationRequests(tmp);
            tmp = new DetectingInvocationReceptions(tmp);
            reader.accept(tmp, ClassReader.EXPAND_FRAMES);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return writer.toByteArray();
    }

    public byte[] instrument(InputStream code, boolean applyMemoryAccounting) throws IOException {
        ClassReader reader = new ClassReader(code);
        ClassWriter writer = new ClassWriter(reader, 0);
        ClassVisitor visitor = new AddPrincipalIdentifier(writer);
        if (applyMemoryAccounting) {
            visitor = new ClassVisitor(Opcodes.ASM5, visitor) {
                String className;
                @Override
                public void visit(int i, int i2, String s, String s2, String s3, String[] strings) {
                    super.visit(i, i2, s, s2, s3, strings);
                    className = s;
                }

                @Override
                public MethodVisitor visitMethod(int i, String s, String s2, String s3, String[] strings) {
                    return new MemoryAllocationMethodInstrumentation(
                            super.visitMethod(i, s, s2, s3, strings),
                            className,
                            true);
                }
            };
        }
        visitor = new CheckClassAdapter(visitor,true);
        reader.accept(visitor, ClassReader.EXPAND_FRAMES);
        code.close();
        return writer.toByteArray();
    }

    public byte[] instrumentForMemoryAccounting(InputStream code) throws IOException {
        ClassReader reader = new ClassReader(code);
        ClassWriter writer = new ClassWriter(reader, 0);
        ClassVisitor visitor =  new ClassVisitor(Opcodes.ASM5, writer) {
                String className;
                @Override
                public void visit(int i, int i2, String s, String s2, String s3, String[] strings) {
                    super.visit(i, i2, s, s2, s3, strings);
                    className = s;
                }

                @Override
                public MethodVisitor visitMethod(int i, String s, String s2, String s3, String[] strings) {
                    return new MemoryAllocationMethodInstrumentation(
                            super.visitMethod(i, s, s2, s3, strings),
                            className,
                            className.equals("java/util/ArrayList")); // TODO : What's this mean?
                }
            };
        visitor = new CheckClassAdapter(visitor,true);
        reader.accept(visitor, ClassReader.EXPAND_FRAMES);
        code.close();
        return writer.toByteArray();
    }

    public String getSuperClass(InputStream code) throws IOException {
        ClassReader reader = new ClassReader(code);
        final String[] superClass = {null};
        reader.accept(new ClassVisitor(Opcodes.ASM5) {
            @Override
            public void visit(int classVersion, int flags, String name,
                              String signature, String superclass, String[] strings) {

                super.visit(classVersion, flags, name, signature, superclass, strings);

                boolean isClass = ((flags & Opcodes.ACC_INTERFACE) == 0) &&
                        ((flags & Opcodes.ACC_ENUM) == 0) &&
                        ((flags & Opcodes.ACC_ANNOTATION) == 0) ;

                if (isClass)
                    superClass[0] = (superclass == null)? "java/lang/Object":superclass;


            }
        }, ClassReader.EXPAND_FRAMES);

        code.close();
        return superClass[0];
    }

    public byte[] createIntegerClass(InputStream code) throws IOException {
        ClassReader reader = new ClassReader(code);
        ClassWriter writer = new ClassWriter(reader, 0);
        ClassVisitor visitor = new ClassVisitor(Opcodes.ASM5, writer) {
            @Override
            public void visitEnd() {
                // adding method to catch object finalization
                MethodVisitor mv = super.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC,
                        "__reportAboutMemory__","(Ljava/lang/Object;I)V",null,null);
                mv.visitCode();
                mv.visitInsn(Opcodes.RETURN);
                mv.visitMaxs(3, 3);
                mv.visitEnd();

                // adding method to catch object creation
                mv = super.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC,
                        "__reportAboutMemory__","(Ljava/lang/Object;)I",null,null);
                mv.visitCode();
                mv.visitInsn(Opcodes.ICONST_0);
                mv.visitInsn(Opcodes.IRETURN);
                mv.visitMaxs(3, 3);
                mv.visitEnd();

                mv = super.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC,
                        "__reportNewArray__","(Ljava/lang/Object;)V",null,null);
                mv.visitCode();
                mv.visitInsn(Opcodes.RETURN);
                mv.visitMaxs(3, 3);
                mv.visitEnd();

                // adding method to report socket read
                mv = super.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC,
                        "__reportSocketRead__","(I)V",null,null);
                mv.visitCode();
                mv.visitInsn(Opcodes.RETURN);
                mv.visitMaxs(3, 3);
                mv.visitEnd();

                // adding method to report socket write
                mv = super.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC,
                        "__reportSocketWrite__","(I)V",null,null);
                mv.visitCode();
                mv.visitInsn(Opcodes.RETURN);
                mv.visitMaxs(3, 3);
                mv.visitEnd();

                // adding method to report file write
                mv = super.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC,
                        "__reportFileWrite__","(I)V",null,null);
                mv.visitCode();
                mv.visitInsn(Opcodes.RETURN);
                mv.visitMaxs(3, 3);
                mv.visitEnd();

                // adding method to report file read
                mv = super.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC,
                        "__reportFileRead__","(I)V",null,null);
                mv.visitCode();
                mv.visitInsn(Opcodes.RETURN);
                mv.visitMaxs(3, 3);
                mv.visitEnd();

                // adding method to report attempts of sending messages
                mv = super.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC,
                        "__reportPortProcessingRequest__",
                        "(Ljava/lang/Object;Ljava/lang/Object;)V",null,null);
                mv.visitCode();
                mv.visitInsn(Opcodes.RETURN);
                mv.visitMaxs(4, 4);
                mv.visitEnd();

                // adding method to report attempts of sending messages
                mv = super.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC,
                        "__reportPortHandlerExecution__",
                        "(Ljava/lang/Object;Ljava/lang/Object;)V",null,null);
                mv.visitCode();
                mv.visitInsn(Opcodes.RETURN);
                mv.visitMaxs(4, 4);
                mv.visitEnd();

                // adding method to report thread creation
                mv = super.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC,
                        "__reportNewThread__",
                        "()V",null,null);
                mv.visitCode();
                mv.visitInsn(Opcodes.RETURN);
                mv.visitMaxs(4, 4);
                mv.visitEnd();

                super.visitEnd();
            }
        };
        visitor = new CheckClassAdapter(visitor,true);
        reader.accept(visitor, ClassReader.EXPAND_FRAMES);
        code.close();
        return writer.toByteArray();
    }

    public byte[] modifyingNetworkClass(InputStream code) throws IOException {
        ClassReader reader = new ClassReader(code);
        ClassWriter writer = new ClassWriter(reader, 0);
        ClassVisitor visitor = new NetworkAccessInstrumentation(writer);
        visitor = new CheckClassAdapter(visitor,true);
        reader.accept(visitor, ClassReader.EXPAND_FRAMES);
        code.close();
        return writer.toByteArray();
    }

    public byte[] modifyingFileAccessClass(InputStream code) throws IOException {
        ClassReader reader = new ClassReader(code);
        ClassWriter writer = new ClassWriter(reader, 0);
        ClassVisitor visitor = new FileAccessInstrumentation(writer);
        visitor = new CheckClassAdapter(visitor,true);
        reader.accept(visitor, ClassReader.EXPAND_FRAMES);
        code.close();
        return writer.toByteArray();
    }

    public byte[] instrumentProxyClass(byte[] code) {
        ClassReader reader = new ClassReader(code);
        ClassWriter writer = new ClassWriter(reader, 0);
        ClassVisitor visitor = new InstrumentingProxyClass(writer);
        //visitor = new CheckClassAdapter(visitor,true);
        reader.accept(visitor, ClassReader.EXPAND_FRAMES);
        return writer.toByteArray();
    }

    public byte[] instrumentThreadCreationDetection(byte[] code, String className,
                                                    String targetClass, String targetMethod) {
        ClassReader reader = new ClassReader(code);
        ClassWriter writer = new ClassWriter(reader, ClassWriter.COMPUTE_MAXS);
        ClassVisitor tmp = writer;
//      tmp = new TraceClassVisitor(tmp, new PrintWriter(System.out));
        //tmp = new CheckClassAdapter(tmp,true);
        tmp = new ThreadCreationVisitor(tmp, targetClass, targetMethod);

        try {
//            tmp = new DetectingInvocationRequests(tmp);
//            tmp = new DetectingInvocationReceptions(tmp);
            reader.accept(tmp, ClassReader.EXPAND_FRAMES);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return writer.toByteArray();
    }
}
