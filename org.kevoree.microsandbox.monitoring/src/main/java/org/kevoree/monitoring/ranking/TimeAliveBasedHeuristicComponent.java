package org.kevoree.monitoring.ranking;

import org.kevoree.ComponentInstance;
import org.kevoree.annotation.ComponentType;
import org.kevoree.annotation.Start;
import org.resourceaccounting.utils.HashMap;
import org.resourceaccounting.utils.Map;

import java.util.Comparator;

/**
 * User: Erwan Daubert - erwan.daubert@gmail.com
 * Date: 26/09/13
 * Time: 17:38
 *
 * @author Erwan Daubert
 * @version 1.0
 */
@ComponentType
public class TimeAliveBasedHeuristicComponent extends ComparatorBasedHeuristicComponent {

    private Map<String, Long> deployTimes;

    @Start
    public void start() {
        deployTimes = new HashMap<String, Long>();
    }

    @Override
    Comparator<ComponentInstance> defineComparator() {
        return new Comparator<ComponentInstance>() {
            @Override
            public int compare(ComponentInstance o1, ComponentInstance o2) {
                long deployTimeO1 = deployTimes.get(o1.path());
                long deployTimeO2 = deployTimes.get(o2.path());

                if (deployTimeO1 == 0 || deployTimeO2 == 0) {
                    // that must not appear
                    return 1;
                }

                return (int) (deployTimeO2 - deployTimeO1);
            }
        };
    }

    @Override
    public void triggerMonitoringEvent(String operation, String name, String instancePath, Long value) {
        if (name.equalsIgnoreCase("deployTime") && value != null) {
            if (operation.equalsIgnoreCase("CREATE")) {
                deployTimes.put(instancePath, value);
            } else {
                deployTimes.remove(instancePath);
            }
        }
    }
}
