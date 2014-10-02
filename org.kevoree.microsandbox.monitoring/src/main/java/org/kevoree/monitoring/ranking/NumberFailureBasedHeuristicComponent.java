package org.kevoree.monitoring.ranking;

import org.kevoree.ComponentInstance;
import org.kevoree.annotation.ComponentType;
import org.kevoree.annotation.Start;
import org.kevoree.log.Log;
import org.kevoree.microsandbox.api.heuristic.MonitoringEvent;
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

                if (nbFailure01 == null && nbFailure02 == null) {
                    return 0;
                }
                else if (nbFailure01 == null) {
                    return nbFailure02.intValue();
                }
                else if (nbFailure02 == null) {
                    return (0 - nbFailure01.intValue());
                }

                return (nbFailure02.intValue() - nbFailure01.intValue());
            }
        };
    }

    @Override
    public void triggerMonitoringEvent(MonitoringEvent event) {
        if (event.getName().equalsIgnoreCase("nbFailure")) {
            if (event.getOperation().equalsIgnoreCase("CREATE")) {
                if (nbFailures.containsKey(event.getInstancePath())) {
                    nbFailures.put(event.getInstancePath(), nbFailures.remove(event.getInstancePath()) + 1);
                } else {
                    nbFailures.put(event.getInstancePath(), 1l);
                }
            } else {
                nbFailures.remove(event.getInstancePath());
            }
        }
        else if (event.getName().equalsIgnoreCase("deployTime")) {
            if (event.getOperation().equalsIgnoreCase("CREATE")) {
                nbFailures.put(event.getInstancePath(), 0l);
            } else {
                nbFailures.remove(event.getInstancePath());
            }
        }
    }
}
