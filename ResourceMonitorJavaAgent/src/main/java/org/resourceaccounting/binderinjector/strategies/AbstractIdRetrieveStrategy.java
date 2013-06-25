package org.resourceaccounting.binderinjector.strategies;

import org.objectweb.asm.commons.InstructionAdapter;
import org.resourceaccounting.binderinjector.IdRetrieveStrategy;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 4/30/13
 * Time: 1:53 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractIdRetrieveStrategy implements IdRetrieveStrategy {
    protected InstructionAdapter instructionAdapter = null;

    public AbstractIdRetrieveStrategy(InstructionAdapter instructionAdapter) {
        this.instructionAdapter = instructionAdapter;
    }
}
