package org.kevoree.microsandbox.monitoredNode;

import java.util.HashMap;
import java.util.Map;

/**
 * User: Erwan Daubert - erwan.daubert@gmail.com
 * Date: 03/04/14
 * Time: 11:21
 *
 * @author Erwan Daubert
 * @version 1.0
 */
public class MonitoringRegistry {
    protected Map<String, Object> registry = new HashMap<String, Object>();

    public Object lookup(String key) {
        return registry.get(key);
    }

    public void register(String key, Object obj) {
        registry.put(key, obj);
    }

    public void drop(String key) {
        registry.remove(key);
    }

    public void clear() {
        registry.clear();
    }

    public Map<String, Object> getRegistry() {
        return registry;
    }

    private MonitoringRegistry() {}

    private static MonitoringRegistry instance;

    public static synchronized MonitoringRegistry getInstance() {
        if (instance == null) {
            instance = new MonitoringRegistry();
        }
        return instance;
    }
}
