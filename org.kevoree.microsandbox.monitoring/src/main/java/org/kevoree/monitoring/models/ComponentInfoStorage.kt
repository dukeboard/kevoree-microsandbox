package org.kevoree.monitoring.ranking

import java.util.HashMap
import org.kevoree.ComponentInstance
import org.kevoree.api.service.core.handler.KevoreeModelHandlerService
import org.kevoree.ContainerNode
import org.kevoree.monitoring.models.ComponentExecutionInfo
import org.kevoree.monitoring.models.ModelID
import org.kevoree.monitoring.models.IdAssigner
import org.kevoree.log.Log
import org.kevoree.microsandbox.api.contract.MemoryContracted
import org.kevoree.microsandbox.api.contract.CPUContracted
import org.kevoree.microsandbox.api.contract.NetworkContracted
import org.kevoree.microsandbox.api.contract.ThroughputContracted
import org.kevoree.microsandbox.api.contract.FullContracted
import org.kevoree.Instance
import org.kevoree.TypeDefinition
import org.kevoree.library.defaultNodeTypes.context.KevoreeDeployManager

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 7/7/13
 * Time: 9:19 PM
 *
 */
public object ComponentsInfoStorage {

    private val info: HashMap<String, ComponentExecutionInfo> = HashMap<String, ComponentExecutionInfo>()

    var idAssigner: IdAssigner? = null

    private fun getOrIncludeInfo(instance: ComponentInstance, id: ModelID): ComponentExecutionInfo? {
        return if (info.containsKey(instance.path())) {
            info.get(instance.path())
        }
        else {
            val l = KevoreeDeployManager.getRef(instance.javaClass.getName() + "_deployTime", instance.getName()) as Long
            val c = ComponentExecutionInfo(instance, id, l)
            info.put(instance.path() as String, c)
        }
    }

    fun getExecutionInfo(path: String): ComponentExecutionInfo? {
        return if (info.containsKey(path)) info.get(path) else null
    }

    fun updateListOfComponents(nodeName: String,
                               modelService: KevoreeModelHandlerService,
                               fn: (ContainerNode, ComponentInstance, ComponentExecutionInfo?) -> Unit): Unit {
        val root = modelService.getLastModel()
        val id = idAssigner?.getID(root)
        if (id != null) {
            val node = root?.findNodesByID(nodeName) // more efficient than filter
            node?.getComponents()?.forEach {
                /*root?.getNodes()?.filter { node -> nodeName.equals(node.getName()) }?.
                    forEach {
                        node -> node.getComponents().forEach {*/
                instance ->
                // only component that define contract must be monitor ?
                // TODO maybe define a "helper" if we plan to define new typeDefinition for new type of contract
                if (isContractedComponent(instance)) {
                    val i = ComponentsInfoStorage.getOrIncludeInfo(instance, id!!)
                    fn(node!!, instance, i);
                }
            }
            //            }
        } else {
            Log.warn("Maybe there is a mistake because an id was not found on the model")
        }
    }

    fun refresh(nodeName: String,
                modelService: KevoreeModelHandlerService): Unit {
        val id = idAssigner?.getID(modelService.getLastModel())
        ComponentsInfoStorage.updateListOfComponents(nodeName, modelService, {
            (node, instance, info) ->
            if (idAssigner?.isNewVersion(instance.path(), id) as Boolean)
                info?.markNewVersion(id)
        })
    }

    fun isContractedComponent(instance: Instance): Boolean {
        return (isTypeOf(instance.getTypeDefinition()!!, javaClass<FullContracted>().getSimpleName())
        || isTypeOf(instance.getTypeDefinition()!!, javaClass<MemoryContracted>().getSimpleName())
        || isTypeOf(instance.getTypeDefinition()!!, javaClass<CPUContracted>().getSimpleName())
        || isTypeOf(instance.getTypeDefinition()!!, javaClass<NetworkContracted>().getSimpleName())
        || isTypeOf(instance.getTypeDefinition()!!, javaClass<ThroughputContracted>().getSimpleName()))
    }

    fun isTypeOf(typeDefinition: TypeDefinition, superTypeName: String): Boolean {
        return superTypeName.equals(typeDefinition.getName()) || typeDefinition.getSuperTypes().find{ superType -> isTypeOf(superType, superTypeName) } != null
    }
}