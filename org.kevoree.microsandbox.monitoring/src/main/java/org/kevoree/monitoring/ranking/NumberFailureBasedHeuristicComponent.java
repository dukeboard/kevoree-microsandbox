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
public class NumberFailureBasedHeuristicComponent extends ComparatorBasedHeuristicComponent {

    protected Map<String, Long> nbFailures = new HashMap<String, Long>();

    @Start
    public void start() {
        nbFailures.clear();
    }

    @Override
    Comparator<ComponentInstance> defineComparator() {
        return new Comparator<ComponentInstance>() {
            @Override
            public int compare(ComponentInstance o1, ComponentInstance o2) {
//                System.err.println("O1 => " + o1);
//                System.err.println("O2 => " + o2);
//                System.err.println("nbFailures => " + nbFailures);
                Long nbFailure01 = nbFailures.get(o1.path());
                Long nbFailure02 = nbFailures.get(o2.path());

                if ((nbFailure01 == null || nbFailure02 == null)) {
                    // that must not appear
                    return 0;
                }

                return (int) (nbFailure01 - nbFailure02);
            }
        };
    }

    @Override
    public void triggerMonitoringEvent(String operation, String name, String instancePath, Long value) {
        if (name.equalsIgnoreCase("nbFailure")) {
            if (operation.equalsIgnoreCase("CREATE")) {
                if (nbFailures.get(instancePath) != null) {
                    nbFailures.put(instancePath, nbFailures.remove(instancePath) + 1);
                } else {
                    nbFailures.put(instancePath, 1l);
                }
            } else {
                nbFailures.remove(instancePath);
            }
        }
    }
}
