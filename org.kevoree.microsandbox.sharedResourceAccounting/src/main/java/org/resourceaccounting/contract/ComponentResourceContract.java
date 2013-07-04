package org.resourceaccounting.contract;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 5/18/13
 * Time: 3:01 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class ComponentResourceContract extends ResourceContract {
    protected Map<String, ResourceContract> operations;

    private ResourceContract defaultContract = new ResourceContract() {
        @Override
        public int getCPU() {
            return Integer.MAX_VALUE;
        }

        @Override
        public int getMemory() {
            return Integer.MAX_VALUE;
        }

        @Override
        public int getNetworkIn() {
            return Integer.MAX_VALUE;
        }

        @Override
        public int getNetworkOut() {
            return Integer.MAX_VALUE;
        }
    };

    public ComponentResourceContract() {
        operations = new HashMap<String, ResourceContract>();
    }

    public ResourceContract getContractFor(String operation) {
        if (operations.containsKey(operation))
            return operations.get(operation);
        return defaultContract;
    }

    public void setResourceContractFor(String operation, ResourceContract contract) {
        operations.put(operation, contract);
    }
}
