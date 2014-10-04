package org.kevoree.monitoring.strategies.monitoring;

import kotlin.Pair;
import org.resourceaccounting.ResourcePrincipal;

/**
 * Created by inti on 01/10/14.
 */
public class DefaultMemorySubstrategy implements MemorySubstrategy {
    @Override
    public long getMemoryConsumption(Object user_data) {
        Pair<ResourcePrincipal, DataForCheckingContract> pair = (Pair<ResourcePrincipal, DataForCheckingContract>)user_data;
        DataForCheckingContract dataForCheckingContract = pair.getSecond();
        return dataForCheckingContract.lastMem;
    }

    @Override
    public void newCycle() {
        // nothing
    }
}
