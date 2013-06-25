package org.resourceaccounting.binder;

import org.resourceaccounting.ResourcePrincipal;
import org.resourceaccounting.utils.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 4/29/13
 * Time: 5:39 PM
 *
 */
public class ThreadResourcePrincipal extends AbstractResourcePrincipal<Thread> {

    /**
     * This is not thread safe
     *
     * @param object
     */
    protected ThreadResourcePrincipal(Thread object) {
        super(object);
    }

    private static HashMap<Long, ResourcePrincipal> map = new HashMap<Long, ResourcePrincipal>();

    private static ResourcePrincipal unique = new ThreadResourcePrincipal(null);

    public static ResourcePrincipal get(Thread thread) {
        //return unique;
        synchronized (map) {
            if (map.containsKey(thread.getId()))
                return map.get(thread.getId());

            ThreadResourcePrincipal tmp = new ThreadResourcePrincipal(thread);
            map.put(thread.getId(), tmp);
            return tmp;
        }
    }
}
