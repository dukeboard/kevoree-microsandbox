package org.resourceaccounting.binder;

import org.resourceaccounting.ResourcePrincipal;
import org.resourceaccounting.utils.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 4/25/13
 * Time: 11:28 AM
 * To change this template use File | Settings | File Templates.
 */
public class ClassLoaderResourcePrincipal extends AbstractResourcePrincipal<ClassLoader> {

    public ClassLoaderResourcePrincipal(ClassLoader classLoader) {
        super(classLoader);
    }

    private static HashMap<ClassLoader, ResourcePrincipal> map = new HashMap<ClassLoader, ResourcePrincipal>();
    private static ClassLoaderResourcePrincipal nullLoader = new ClassLoaderResourcePrincipal(null);

    public static ResourcePrincipal get(ClassLoader loader) {
        synchronized (map) {
            if (loader == null) {
//                nullLoader.id = 0;
                return nullLoader;
            }
            if (map.containsKey(loader))
                return map.get(loader);

            ClassLoaderResourcePrincipal tmp = new ClassLoaderResourcePrincipal(loader);
            map.put(loader, tmp);
            return tmp;
        }
    }
}
