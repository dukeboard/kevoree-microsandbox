package org.resourceaccounting.invocations;

import org.resourceaccounting.utils.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 7/6/13
 * Time: 6:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class InvocationAmountTable {
    private HashMap<String, HashMap<String, Integer>> data;

    public InvocationAmountTable() {
        data = new HashMap<String, HashMap<String, Integer>>();
    }

    public synchronized void addInvocation(String component, String operation) {
        if (!data.containsKey(component))
            data.put(component, new HashMap<String, Integer>());
        HashMap<String, Integer> tmp = data.get(component);
        if (!tmp.containsKey(operation))
            tmp.put(operation, 1);
        else {
            Integer x = tmp.get(operation);
            tmp.put(operation, x + 1);
        }
    }

    public synchronized int getNumberOfInvocations(String component, String operation) {
        if (!data.containsKey(component) || !data.get(component).containsKey(operation))
            return 0;
        return data.get(component).get(operation);
    }

    public synchronized void clear() {
        data.clear();
    }
}
