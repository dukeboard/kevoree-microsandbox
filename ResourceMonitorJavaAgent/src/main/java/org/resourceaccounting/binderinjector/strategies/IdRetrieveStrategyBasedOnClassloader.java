package org.resourceaccounting.binderinjector.strategies;

import org.objectweb.asm.commons.InstructionAdapter;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 4/30/13
 * Time: 1:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class IdRetrieveStrategyBasedOnClassloader extends AbstractIdRetrieveStrategy {


    private String className;

    public IdRetrieveStrategyBasedOnClassloader(InstructionAdapter instructionAdapter, String className) {
        super(instructionAdapter);
        this.className = className;
    }

    public void generateByteCodeToGetId() {
        instructionAdapter.visitLdcInsn(className);
        instructionAdapter.invokestatic("java/lang/Class", "forName", "(Ljava/lang/String;)Ljava/lang/Class;");
        instructionAdapter.invokevirtual("java/lang/Class", "getClassLoader" , "()Ljava/lang/ClassLoader;");
        instructionAdapter.invokestatic("org/resourceaccounting/binder/ClassLoaderResourcePrincipal", "get",
                "(Ljava/lang/ClassLoader;)Lorg/resourceaccounting/ResourcePrincipal;");
    }
}
