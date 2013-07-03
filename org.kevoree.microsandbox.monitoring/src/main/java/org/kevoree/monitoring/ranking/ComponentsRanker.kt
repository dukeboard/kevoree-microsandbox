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
import org.kevoree.library.defaultNodeTypes.context.KevoreeDeployManager

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

    fun rank(nodeName: String,
                modelService: KevoreeModelHandlerService,
                bootstrapService : Bootstraper
             ): List<ComponentInstance> {
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
                        val l = KevoreeDeployManager.getRef(instance.javaClass.getName()+"_deployTime", instance.getName()) as Long
                        val c = ComponentExecutionInfo(instance.getName(), l)
                        info.put(instance.path() as String, c)
                    }
                    components.add(instance)
                    updateInfo(instance, i, node, bootstrapService)
                }
        }
        val time = System.nanoTime()
        return components.sort(comparator { (a,b) ->
            val x = info.get(a.path())
            val y = info.get(b.path())
            if ((x?.timeAlive(time) as Long) < y?.timeAlive(time) as Long)
                 1
            else
                -1
        })
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

    fun getExecutionInfo(path : String) : ComponentExecutionInfo? {
        return if (info.containsKey(path)) info.get(path) else null
    }


}