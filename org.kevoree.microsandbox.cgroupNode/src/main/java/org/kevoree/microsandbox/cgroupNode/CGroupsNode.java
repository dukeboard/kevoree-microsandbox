package org.kevoree.microsandbox.cgroupNode;

import org.kevoree.ComponentInstance;
import org.kevoree.Instance;
import org.kevoree.annotation.*;
import org.kevoree.api.PrimitiveCommand;
import org.kevoree.api.service.core.handler.ModelListener;
import org.kevoree.kompare.JavaSePrimitive;
import org.kevoree.microsandbox.core.OnNewThreadNotifier;
import org.kevoree.microsandbox.cgroupNode.commands.CGroupAddInstance;
import org.kevoree.microsandbox.monitoredNode.AbstractMonitoredNode;
import org.kevoreeadaptation.AdaptationPrimitive;

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

    @Start
    @Override
    public void startNode() {
        super.startNode();

        if (getDictionary().containsKey("cgroup_fs_path"))
            cgroup_path = getDictionary().get("cgroup_fs_path").toString();

        threadCreated = new NewThreadCreated("kev/", description, getNodeName());
        OnNewThreadNotifier.getInstance().setHandler(threadCreated);
    }

    @Override
    protected SharedKCLFactory getClassLoaderFactory() {
        return new SharedKCLFactory(getName(), true);
    }

    @Override
    public PrimitiveCommand getPrimitive(AdaptationPrimitive p) {
        String pTypeName = p.getPrimitiveType().getName();
        if (pTypeName.equals(JavaSePrimitive.instance$.getAddInstance())) {
            Instance instance = (Instance) p.getRef();
            if (instance instanceof ComponentInstance)
                threadCreated.addComponent((ComponentInstance)instance);
//            System.out.println("Something " + pTypeName + " " + (instance).getName());
            return new CGroupAddInstance(instance,
                    getNodeName(), this.getModelService(),
                    this.getKevScriptEngineFactory(),
                    this.getBootStrapperService(),
                    this);
        }
        // FIXME, add a proper remove command
        if (pTypeName.equals(JavaSePrimitive.instance$.getRemoveInstance())) {
            return null;
//            return new MonitoredRemoveInstance((Instance) p.getRef(),
//                    getNodeName(), this.getModelService(),
//                    this.getKevScriptEngineFactory(),
//                    this.getBootStrapperService(),
//                    this);
        }
        return super.getPrimitive(p);
    }
}
