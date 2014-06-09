package org.kevoree.microsandbox.cgroupNode;

import com.sun.management.GarbageCollectionNotificationInfo;
import org.kevoree.*;
import org.kevoree.annotation.*;
import org.kevoree.annotation.NodeType;
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
 */
@NodeType
@Library(name = "JavaSE")
public class CGroupsNode extends AbstractMonitoredNode<SharedKCLFactory>
{

    @Param(defaultValue = "/cgroup")// Fedora style
    String cgroup_fs_path;

    private NewThreadCreated threadCreated;
    private GCWatcher gcWatcher;

    @Start
    @Override
    public void startNode() {
        super.startNode();
        gcWatcher = new GCWatcher("gc_cycles.log");
        gcWatcher.register();

        threadCreated = new NewThreadCreated("kev/", description, context.getNodeName());
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
        return new SharedKCLFactory(context.getInstanceName(), false);
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

//                for (String name: m.keySet())
//                    stream.printf("\tSpace !!!!!!!!!!!!!!!!!!!!! %s %d\n", name, m.get(name).getUsed());

                String sOld = (m.containsKey("PS Old Gen"))? "PS Old Gen" : "Tenured Gen";
                String sSurvivor = (m.containsKey("PS Survivor Space"))? "PS Survivor Space" : "Survivor Space";

                long used = m.get(sOld).getUsed() + m.get(sSurvivor).getUsed();
                long max = m.get(sOld).getMax() + m.get(sSurvivor).getMax();
                if (m.containsKey("Metaspace")) {
                    used += m.get("Metaspace").getUsed();
                    max += m.get("Metaspace").getMax();
                }
                if (m.containsKey("Code Cache")) {
                    used += m.get("Code Cache").getUsed();
                    max += m.get("Code Cache").getMax();
                }
                if (m.containsKey("Compressed Class Space")) {
                    used += m.get("Compressed Class Space").getUsed();
                    max += m.get("Compressed Class Space").getMax();
                }
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
