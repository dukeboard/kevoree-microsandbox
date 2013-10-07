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
import java.util.Random

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 6/28/13
 * Time: 12:53 PM
 *
 */
public object ComponentsRanker {

    private val definitionAspect : TypeDefinitionAspect = TypeDefinitionAspect()
    private val random : Random = Random()

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
            var i = 0;
            while (i < components.size && !components.get(i).getName().contains("Follow"))
                i++;
            if (i<components.size && i > components.size / 4) {

                Collections.swap(components, i, random.nextInt(components.size / 4));
            }
            return components
        }
        else {
            val ranker = ComponentRankerFunctionFactory.get(componentRankerFunction)
            Collections.sort(components,ranker)
            var i = 0;
            while (i < components.size && !components.get(i).getName().contains("Follow"))
                i++;
            if (i<components.size && i > 6) {
                Collections.swap(components, i, 6);
            }
            return components
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