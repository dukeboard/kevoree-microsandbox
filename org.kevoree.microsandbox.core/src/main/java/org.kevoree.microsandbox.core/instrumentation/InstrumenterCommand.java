package org.kevoree.microsandbox.core.instrumentation;

import org.kevoree.microsandbox.core.instrumentation.io.FileAccessInstrumentation;
import org.objectweb.asm.*;
import org.objectweb.asm.util.CheckClassAdapter;
import org.kevoree.microsandbox.core.instrumentation.io.NetworkAccessInstrumentation;
import org.kevoree.microsandbox.core.instrumentation.memory.AddPrincipalIdentifier;
import org.kevoree.microsandbox.core.instrumentation.memory.MemoryAllocationMethodInstrumentation;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 6/14/13
 * Time: 11:18 PM
 *
 */
public class InstrumenterCommand {
    public byte[] instrument(byte[] code, String className) {
        ClassReader reader = new ClassReader(code);
        ClassWriter writer = new ClassWriter(reader, ClassWriter.COMPUTE_MAXS);
        ClassVisitor tmp = writer;
//        if (className.endsWith("OlivierExample")) {
//            System.out.println("dfsdsfdsfdsfsfdsfsdfdsff 12345678");
//            tmp = new TraceClassVisitor(tmp, new PrintWriter(System.out));
//        }
        //tmp = new CheckClassAdapter(tmp,true);
        tmp = new ResourceAccountingVisitor(tmp);

        //tmp = new InstForAccountingPerInvocation(tmp);
        try {

            reader.accept(tmp, ClassReader.EXPAND_FRAMES);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
//        if (className.endsWith("KevsParser"))
//        CheckClassAdapter.verify(new ClassReader(writer.toByteArray()),false,new PrintWriter(System.out));
        return writer.toByteArray();
    }

    public byte[] instrument(InputStream code, boolean applyMemoryAccounting) throws IOException {
        ClassReader reader = new ClassReader(code);
        ClassWriter writer = new ClassWriter(reader, 0);
        ClassVisitor visitor = new AddPrincipalIdentifier(writer);
        if (applyMemoryAccounting) {
            visitor = new ClassVisitor(Opcodes.ASM4, visitor) {
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
        ClassVisitor visitor =  new ClassVisitor(Opcodes.ASM4, writer) {
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
        reader.accept(new ClassVisitor(Opcodes.ASM4) {
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
        ClassVisitor visitor = new ClassVisitor(Opcodes.ASM4, writer) {
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
}
