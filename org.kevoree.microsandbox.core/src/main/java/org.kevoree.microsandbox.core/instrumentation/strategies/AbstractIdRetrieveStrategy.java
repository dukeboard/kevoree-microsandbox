package org.kevoree.microsandbox.core.instrumentation.strategies;

import org.kevoree.microsandbox.core.instrumentation.IdRetrieveStrategy;
import org.objectweb.asm.commons.InstructionAdapter;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 4/30/13
 * Time: 1:53 PM
 *
 */
public abstract class AbstractIdRetrieveStrategy implements IdRetrieveStrategy {
    protected InstructionAdapter instructionAdapter = null;

    public AbstractIdRetrieveStrategy(InstructionAdapter instructionAdapter) {
        this.instructionAdapter = instructionAdapter;
    }
}
