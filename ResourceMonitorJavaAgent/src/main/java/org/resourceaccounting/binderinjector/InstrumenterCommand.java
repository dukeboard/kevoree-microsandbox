package org.resourceaccounting.binderinjector;

import org.objectweb.asm.*;
import org.objectweb.asm.util.CheckClassAdapter;
import org.objectweb.asm.util.TraceClassVisitor;
import org.resourceaccounting.binderinjector.invocations.InstForAccountingPerInvocation;
import org.resourceaccounting.binderinjector.io.NetworkAccessInstrumentation;
import org.resourceaccounting.binderinjector.memory.AddPrincipalIdentifier;
import org.resourceaccounting.binderinjector.memory.MemoryAllocationMethodInstrumentation;

import java.io.FileInputStream;
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
    public byte[] instrument(byte[] code, String className) {
        ClassReader reader = new ClassReader(code);
        ClassWriter writer = new ClassWriter(reader, 0);
        ClassVisitor tmp = writer;
        if (true) {
            if (className.contains("MemoryConsumer"))
                tmp = new TraceClassVisitor(writer, new PrintWriter(System.out));
            tmp = new CheckClassAdapter(tmp,true);
        }
        ClassVisitor visitor = new ResourceAccountingVisitor(tmp);

        visitor = new InstForAccountingPerInvocation(visitor);
        reader.accept(visitor, ClassReader.EXPAND_FRAMES);
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
                            className.startsWith("java/util/ArrayList"));
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

    public byte[] instrumentProxyClass(byte[] code) {
        ClassReader reader = new ClassReader(code);
        ClassWriter writer = new ClassWriter(reader, 0);
        ClassVisitor visitor = new InstrumentingProxyClass(writer);
        //visitor = new CheckClassAdapter(visitor,true);
        reader.accept(visitor, ClassReader.EXPAND_FRAMES);
        return writer.toByteArray();
    }
}
