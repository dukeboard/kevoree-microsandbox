package org.kevoree.monitoring.comp.monitor;

import com.sun.management.GarbageCollectionNotificationInfo;

import javax.management.ListenerNotFoundException;
import javax.management.Notification;
import javax.management.NotificationEmitter;
import javax.management.NotificationListener;
import javax.management.openmbean.CompositeData;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryUsage;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 6/11/13
 * Time: 4:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class GCWatcher implements NotificationListener {

    private List<ContractVerificationRequired> listeners =
            new ArrayList<ContractVerificationRequired>();

    public void register() {
        List<GarbageCollectorMXBean> mxbeans =
                ManagementFactory.getGarbageCollectorMXBeans();

        for (java.lang.management.GarbageCollectorMXBean gc : mxbeans) {

            NotificationEmitter emitter = (NotificationEmitter) gc;
            emitter.addNotificationListener(this, null, null);
        }
    }

    public void unregister() {
        List<java.lang.management.GarbageCollectorMXBean> mxbeans =
                ManagementFactory.getGarbageCollectorMXBeans();

        for (java.lang.management.GarbageCollectorMXBean gc : mxbeans) {

            NotificationEmitter emitter = (NotificationEmitter) gc;
            try {
                emitter.removeNotificationListener(this);
            } catch (ListenerNotFoundException e) {
            }
        }
    }

    @Override
    public void handleNotification(Notification notification, Object o) {
        if (notification.getType().equals(GarbageCollectionNotificationInfo.GARBAGE_COLLECTION_NOTIFICATION)) {
            //get the information associated with this notification
            GarbageCollectionNotificationInfo info =
                    GarbageCollectionNotificationInfo.from((CompositeData) notification.getUserData());

            Map<String, MemoryUsage> m = info.getGcInfo().getMemoryUsageAfterGc();
//            long eden = m.get("PS Eden Space").getUsed();
//            long survivor = m.get("PS Survivor Space").getUsed();

            long used = m.get("PS Old Gen").getUsed() + m.get("PS Survivor Space").getUsed();
            long max = m.get("PS Old Gen").getMax() + m.get("PS Survivor Space").getMax();
            for(int i = 0 ; i < listeners.size() ; i++)
                listeners.get(i).onGCVerifyContract(used, max);
        }
    }

    public void addContractVerificationRequieredListener(ContractVerificationRequired verificationRequeried) {
        listeners.add(verificationRequeried);
    }
}
