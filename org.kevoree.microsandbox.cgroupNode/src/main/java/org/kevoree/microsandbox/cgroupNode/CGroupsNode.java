package org.kevoree.microsandbox.cgroupNode;

import com.sun.management.GarbageCollectionNotificationInfo;
import org.kevoree.annotation.*;
import org.kevoree.microsandbox.core.OnNewThreadNotifier;
import org.kevoree.microsandbox.monitoredNode.AbstractMonitoredNode;

import javax.management.ListenerNotFoundException;
import javax.management.Notification;
import javax.management.NotificationEmitter;
import javax.management.NotificationListener;
import javax.management.openmbean.CompositeData;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryUsage;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 1/7/14
 * Time: 3:57 PM
 * To change this template use File | Settings | File Templates.
 */
@DictionaryType({// FIXME How did you choose the default value ?
        @DictionaryAttribute(name = "cgroup_fs_path", defaultValue = "")
})
@NodeType
@Library(name = "JavaSE")
public class CGroupsNode extends AbstractMonitoredNode<SharedKCLFactory>
{

    private String cgroup_path = "/cgroup"; // Fedora style
    private NewThreadCreated threadCreated;
    private GCWatcher gcWatcher;

    @Start
    @Override
    public void startNode() {
        super.startNode();
        gcWatcher = new GCWatcher("gc_cycles.log");
        gcWatcher.register();
        if (getDictionary().containsKey("cgroup_fs_path"))
            cgroup_path = getDictionary().get("cgroup_fs_path").toString();

        threadCreated = new NewThreadCreated("kev/", description, getNodeName());
        OnNewThreadNotifier.getInstance().setHandler(threadCreated);
    }

    @Stop
    @Override
    public void stopNode() {
        super.stopNode();
        gcWatcher.unregister();
    }

    @Override
    protected SharedKCLFactory getClassLoaderFactory() {
        return new SharedKCLFactory(getName(), false);
    }

    private class GCWatcher implements NotificationListener {

        private PrintStream stream;
        private long maxUsed = Long.MIN_VALUE;

        public GCWatcher(String logFile) {
            try {
                stream = new PrintStream(logFile);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

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

                String sOld = (m.containsKey("PS Old Gen"))? "PS Old Gen" : "Tenured Gen";
                String sSurvivor = (m.containsKey("PS Survivor Space"))? "PS Survivor Space" : "Survivor Space";

                long used = m.get(sOld).getUsed() + m.get(sSurvivor).getUsed();
                long max = m.get(sOld).getMax() + m.get(sSurvivor).getMax();
                stream.printf("%d bytes used out of %d\n", used, max);
                if (used > maxUsed)
                {
                    stream.printf("%d IS NEW GLOBAL MAXIMUM, max %d\n", used, max);
                    maxUsed = used;
                }
                stream.flush();
            }
        }

    }
}
