package org.kevoree.microsandbox.core; /**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 5/10/13
 * Time: 9:45 PM
 * To change this template use File | Settings | File Templates.
 */

import junit.framework.Assert;
import org.junit.Test;
import org.kevoree.microsandbox.core.instrumentation.InstrumenterCommand;
import org.kevoree.microsandbox.core.instrumentation.invocations.InstForAccountingPerInvocation;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.util.CheckClassAdapter;
import org.objectweb.asm.util.TraceClassVisitor;
import org.resourceaccounting.behavior.BehaviorNodeOperation;
import org.resourceaccounting.behavior.BehaviorNodeRepetition;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class Testing {

    @Test
    public void testingTransformer() throws IOException {
        File f = new File("testFiles/PalindromeCheckerComponent.class");
        FileInputStream file = new FileInputStream(f);
        byte[] content = new byte[(int)f.length()];
        file.read(content);
        file.close();
        ClassReader reader = new ClassReader(content);
        ClassWriter writer = new ClassWriter(reader, 0);
        ClassVisitor tmp = writer;
        tmp = new TraceClassVisitor(writer, new PrintWriter(System.out));
        tmp = new CheckClassAdapter(tmp,true);
        ClassVisitor visitor = tmp;
//        visitor = new ResourceAccountingVisitor(tmp);
        visitor = new InstForAccountingPerInvocation(tmp);
        reader.accept(visitor, ClassReader.EXPAND_FRAMES | ClassReader.SKIP_DEBUG);

    }

    @Test
    public void test2 (){
        BehaviorNodeRepetition node = new BehaviorNodeRepetition();
        BehaviorNodeRepetition n0 = new BehaviorNodeRepetition();
        n0.add(new BehaviorNodeOperation("lala"));
        BehaviorNodeRepetition n1 = new BehaviorNodeRepetition();
        n1.add(new BehaviorNodeOperation("lala"));
        node.add(n0);
        node.add(n1);
        Assert.assertEquals(node.getChildren().size(), 1);
    }

    @Test
    public void test3 () {
        InstrumenterCommand cmd = new InstrumenterCommand();
        try {
            File f = new File("testFiles/KevsParser.class");
            FileInputStream file = new FileInputStream(f);
            byte[] content = new byte[(int)f.length()];
            file.read(content);
            file.close();
            CoverageRuntime.instance$.instrument(cmd.instrument(content, "KevsParser"));
        } catch (IOException e) {
            assert(false);
        }
    }

}
