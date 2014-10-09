package org.kevoree.monitoring.ranking;

import org.kevoree.ComponentInstance;
import org.kevoree.annotation.ComponentType;

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
public class InvNumberFailureBasedHeuristicComponent extends NumberFailureBasedHeuristicComponent {

    @Override
    Comparator<ComponentInstance> defineComparator() {
        return new Comparator<ComponentInstance>() {
            @Override
            public int compare(ComponentInstance o1, ComponentInstance o2) {
                Long nbFailure01 = nbFailures.get(o1.path());
                Long nbFailure02 = nbFailures.get(o2.path());

                if (nbFailure01 == null && nbFailure02 == null) {
                    return 0;
                }
                else if (nbFailure01 == null) {
                    return -nbFailure02.intValue();
                }
                else if (nbFailure02 == null) {
                    return (nbFailure01.intValue());
                }

                return (-nbFailure02.intValue() + nbFailure01.intValue());
            }
        };
    }
}
