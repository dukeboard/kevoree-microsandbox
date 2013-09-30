package org.kevoree.monitoring.ranking;

import org.kevoree.ComponentInstance;

import java.util.Comparator;

/**
 * User: Erwan Daubert - erwan.daubert@gmail.com
 * Date: 26/09/13
 * Time: 17:38
 *
 * @author Erwan Daubert
 * @version 1.0
 */
public class InvNumberFailureBasedHeuristicComponent extends NumberFailureBasedHeuristicComponent {

    @Override
    Comparator<ComponentInstance> defineComparator() {
        return new Comparator<ComponentInstance>() {
            @Override
            public int compare(ComponentInstance o1, ComponentInstance o2) {
                long nbFailure01 = nbFailures.get(o1.path());
                long nbFailure02 = nbFailures.get(o2.path());

                if (nbFailure01 == 0 || nbFailure02 == 0) {
                    // that must not appear
                    return 1;
                }

                return (int) (nbFailure02 - nbFailure01);
            }
        };
    }
}
