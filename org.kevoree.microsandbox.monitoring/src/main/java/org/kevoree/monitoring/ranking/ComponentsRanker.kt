package org.kevoree.monitoring.ranking

import org.kevoree.ComponentInstance
import java.lang.ref.WeakReference
import java.util.ArrayList
import org.kevoree.api.service.core.handler.KevoreeModelHandlerService
import org.kevoree.ContainerNode
import java.util.HashMap
import org.kevoree.framework.kaspects.TypeDefinitionAspect
import org.kevoree.DeployUnit
import org.kevoree.microsandbox.core.CoverageRuntime
import org.kevoree.TypeDefinition
import org.kevoree.api.Bootstraper
import java.util.NoSuchElementException
import org.kevoree.microsandbox.core.Entry

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 6/28/13
 * Time: 12:53 PM
 *
 */
public object ComponentsRanker {

    private val info : HashMap<String, ComponentExecutionInfo> = HashMap<String, ComponentExecutionInfo>()
    private val definitionAspect : TypeDefinitionAspect = TypeDefinitionAspect()

    private class MyIterator(val components : MutableList<ComponentInstance>) : Iterator<ComponentInstance> {

        var index = 0

        public override fun next(): ComponentInstance {
            if (index > components.size)
                throw NoSuchElementException()
            return components.get(index++)
        }
        public override fun hasNext(): Boolean = index < components.size

    }

    fun rank(nodeName: String,
             modelService: KevoreeModelHandlerService,
             bootstrapService : Bootstraper
             ): Iterator<ComponentInstance> {
        val components : MutableList<ComponentInstance> =
                ArrayList<ComponentInstance>()

        val root = modelService.getLastModel()

        root?.getNodes()?.filter { node -> nodeName.equals(node.getName()) }?.forEach { node->
                for (instance : ComponentInstance in node.getComponents())
                {
                    val i : ComponentExecutionInfo? = if (info.containsKey(instance.path())) {
                        info.get(instance.path())
                    }
                    else {
                        components.add(instance)
                        info.put(instance.path() as String, ComponentExecutionInfo(instance.getName()))
                    }

                    updateInfo(instance, i, node, bootstrapService);
                }
        }
        return MyIterator(components)
    }

    private fun updateInfo(instance: ComponentInstance,
                   i : ComponentExecutionInfo?,
                   node : ContainerNode,
                   bootstraper: Bootstraper) {

        var unit : DeployUnit? = definitionAspect.
                                    foundRelevantDeployUnit(instance.getTypeDefinition() as TypeDefinition, node)
        var loader : ClassLoader? = bootstraper.getKevoreeClassLoaderHandler().getKevoreeClassLoader(unit)
        var entry : Entry? = CoverageRuntime.calculateCoverage(loader as ClassLoader)
        i?.setBranchCoverage((entry?.branchCoverage!!))
        i?.setInstructionCoverage((entry?.instrCoverage!!))

    }


}