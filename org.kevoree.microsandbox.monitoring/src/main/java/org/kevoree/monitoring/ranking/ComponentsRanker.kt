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
import org.kevoree.monitoring.models.ComponentExecutionInfo
import java.util.Collections

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 6/28/13
 * Time: 12:53 PM
 *
 */
public object ComponentsRanker {

    private val definitionAspect : TypeDefinitionAspect = TypeDefinitionAspect()

    fun rank(nodeName: String,
             modelService: KevoreeModelHandlerService,
             bootstrapService : Bootstraper,
             componentRankerFunction: String
    ): List<ComponentInstance> {
        val components : MutableList<ComponentInstance> =
                ArrayList<ComponentInstance>()

        ComponentsInfoStorage.instance.updateListOfComponents(nodeName, modelService, {
            (node, instance, info) ->
            updateInfo(instance, info, node, bootstrapService)
            components.add(instance)
        }
        )

        val currentTime = System.nanoTime()
        //        println("number of components before sorting is " + components.size)

        if (componentRankerFunction.equals(ComponentRankerFunctionFactory.RANDOM_ORDER)) {
            Collections.shuffle(components)
            return components
        }
        else {
            val ranker = ComponentRankerFunctionFactory.get(componentRankerFunction)
            return components.sort(comparator { (a,b) -> ranker(a,b) as Int })
        }

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