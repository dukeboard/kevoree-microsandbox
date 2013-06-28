package org.kevoree.microsandbox.core.instrumentation.invocations;

import org.kevoree.microsandbox.core.instrumentation.AbstractMethodInstrumentation;
import org.kevoree.microsandbox.core.instrumentation.ExtraInstrumentationRules;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.analysis.*;

import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 5/13/13
 * Time: 1:58 PM
 *
 * Used to instrument methods in such a way that any attempt to use an external operation
 * is recorded
 * (i.e. in the case of Kevoree it can be an external port)
 *
 * Additionally, we record the creation of new threads wih he aim of detecting calls to
 * external operations in different threads.
 */
public class BehaviorRecorderVisitor extends AbstractMethodInstrumentation {
    private final String methodName;
    private MethodVisitor next1;

    private class NodeInControlFlowGraph extends Frame {

        boolean backEdge = false;
        int address = -1;

        public NodeInControlFlowGraph(int i, int i2) {
            super(i, i2);
        }

        public NodeInControlFlowGraph(Frame frame) {
            super(frame);
        }
    }

    private class MyAnalyzer extends Analyzer {

        public MyAnalyzer(Interpreter interpreter) {
            super(interpreter);
        }

        @Override
        protected Frame newFrame(int i, int i2) {
            return new NodeInControlFlowGraph(i, i2);
        }

        @Override
        protected Frame newFrame(Frame frame) {
            return new NodeInControlFlowGraph(frame);
        }

        @Override
        protected void newControlFlowEdge(int src, int dst) {
            NodeInControlFlowGraph frameSrc = (NodeInControlFlowGraph)getFrames()[src];
//            Frame frameDst = getFrames()[dst];
            if (dst < src) {
                frameSrc.backEdge = true;
                frameSrc.address = dst;
            }
        }
    }

    protected BehaviorRecorderVisitor(MethodVisitor visitor, String className, String methodName, String desc, String a, String[] aa) {
        super(new MethodNode(Opcodes.ASM4, Opcodes.ACC_PUBLIC,
                methodName, desc, a,aa), className);
        this.methodName = methodName;
        next1 = visitor;
    }

    @Override
    public void visitEnd() {
        //super.visitEnd();
        Analyzer analyzer = new MyAnalyzer(new BasicInterpreter());
        MethodNode mm = ((MethodNode)mv);
        try {
            Frame[] frames = analyzer.analyze(className, ((MethodNode)mv));
            LinkedList<AbstractInsnNode> l1 = new LinkedList<AbstractInsnNode>();
            LinkedList<AbstractInsnNode> l2 = new LinkedList<AbstractInsnNode>();
            for (int i = frames.length - 1 ; i >= 0 ; i--) {
                if (frames[i]!= null && ((NodeInControlFlowGraph)frames[i]).backEdge) {
                    int index = ((NodeInControlFlowGraph)frames[i]).address;
                    AbstractInsnNode currentInst = mm.instructions.get(i+1);
                    AbstractInsnNode dst = mm.instructions.get(index);

                    l2.add(dst);
                    l1.add(currentInst);


                }
            }
            for (int i = 0 ; i < l2.size() ; i ++) {
                mm.instructions.insertBefore(l2.get(i),
                        new MethodInsnNode(Opcodes.INVOKESTATIC, ExtraInstrumentationRules.MONITOR_CLASS_NAME,
                                "push", "()V"));
                mm.instructions.insert(l1.get(i),
                        new MethodInsnNode(Opcodes.INVOKESTATIC, ExtraInstrumentationRules.MONITOR_CLASS_NAME,
                                "pop", "()V"));
            }
        } catch (AnalyzerException e) {
//            e.printStackTrace();
        }
        mm.accept(next1);
    }

    @Override
    public void visitMethodInsn(int opcode, String s, String s2, String s3) {
        if (opcode == Opcodes.INVOKEVIRTUAL
                && s.equals("java/lang/Thread")
                && s2.equals("start")) {
            // the invocation is creating a new Thread, associate the new Thread to the invocation
            dup();
            invokestatic(ExtraInstrumentationRules.MONITOR_CLASS_NAME, "associateToInvocation", "(Ljava/lang/Thread;)V");
        }
        else if (opcode == Opcodes.INVOKEINTERFACE && s.endsWith("Port")
                && s2.equals("process")){
            // calling other operation, record the fact in the invocation
            // TODO : Only works if the class is using the class MessagePort, too tied
            swap(); // before this the stack is objRef, message
            dup(); // before this the stack is message, objRef
            invokeinterface("org/kevoree/framework/Port", "getName", "()Ljava/lang/String;"); // message, objRef, objRef
            invokestatic(ExtraInstrumentationRules.MONITOR_CLASS_NAME, "externalOperationCall", "(Ljava/lang/String;)V"); // message, objRef, strName
            swap(); // objRef, message
        }
        super.visitMethodInsn(opcode, s, s2, s3);
    }

    @Override
    public void visitMaxs(int maxStacks, int maxLocals) {
        super.visitMaxs(maxStacks+1, maxLocals);    //To change body of overridden methods use File | Settings | File Templates.
    }
}
