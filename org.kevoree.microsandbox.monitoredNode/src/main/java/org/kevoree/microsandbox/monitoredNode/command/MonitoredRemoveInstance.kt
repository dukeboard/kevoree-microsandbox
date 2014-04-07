package org.kevoree.microsandbox.monitoredNode

import org.kevoree.Instance
import org.kevoree.api.PrimitiveCommand
import org.kevoree.api.BootstrapService
import org.kevoree.api.ModelService
import org.kevoree.library.defaultNodeTypes.wrapper.WrapperFactory
import org.kevoree.library.defaultNodeTypes.ModelRegistry
import org.kevoree.api.KevScriptService
import org.kevoree.library.defaultNodeTypes.wrapper.KInstanceWrapper
import org.kevoree.log.Log
import org.kevoree.ContainerNode

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 6/27/13
 * Time: 2:40 PM
 */
open class MonitoredRemoveInstance(val wrapperFactory: WrapperFactory, val c: Instance, val nodeName: String, val registry: ModelRegistry, val monitoringRegistry: MonitoringRegistry, val modelService: ModelService, val kscript: KevScriptService, val bs: BootstrapService) : PrimitiveCommand {
    override fun undo() {
        try {
            MonitoredAddInstance(wrapperFactory, c, nodeName, registry, monitoringRegistry, modelService, kscript, bs).execute()
            val newCreatedWrapper = registry.lookup(c)
            if (newCreatedWrapper is KInstanceWrapper) {
                bs.injectDictionary(c, newCreatedWrapper.targetObj, false)
            }
        } catch(e: Exception) {
            Log.error("Error during rollback", e)
        }
    }

    override fun execute(): Boolean {
        try {
            val previousWrapper = registry.lookup(c)
            if (previousWrapper is KInstanceWrapper) {
                previousWrapper.destroy()
            }
            registry.drop(c)
            if (c is ContainerNode) {
                monitoringRegistry.drop(c.path() + "_platformDescription")
            } else {
                monitoringRegistry.drop(c.path() + "_contract")
            }
            monitoringRegistry.drop(c.path() + "_tg")
            monitoringRegistry.drop(c.path() + "_deployTime")
            return true
        } catch(e: Exception) {
            return false
        }
    }

    /*override*/ fun toString(): String {
        return "RemoveInstance ${c.name}"
    }
}
/*
class MonitoredRemoveInstance(val wrapperFactory: WrapperFactory, val c: Instance, val nodeName: String, val modelservice: ModelService,
                              val kscript: KevScriptService, val bs: BootstrapService): PrimitiveCommand {

    private val typeDefinitionAspect = TypeDefinitionAspect()

    override fun undo() {
        try {
            MonitoredAddInstance(c, nodeName, modelservice, kscript, bs).execute()
            UpdateDictionary(c, nodeName).execute() // TODO : fix this because he developer can specify more
                                                    // consumption
        } catch(e: Exception) {
        }
    }

    override fun execute(): Boolean {
        Log.debug("CMD REMOVE INSTANCE EXECUTION - " + c.getName() + " - type - " + c.getTypeDefinition()!!.getName())
        try {
            if (c is ComponentInstance)
                ControlAdmissionSystem.unregisterComponent(c as ComponentInstance)
            KevoreeDeployManager.clearRef(c.javaClass.getName()+"_tg", c.getName())
            KevoreeDeployManager.clearRef(c.javaClass.getName()+"_wrapper", c.getName())
            KevoreeDeployManager.clearRef(c.javaClass.getName(), c.getName())
            KevoreeDeployManager.clearRef(c.javaClass.getName()+"_deployTime", c.getName())
            KevoreeDeployManager.clearRef(c.javaClass.getName()+"_contract",c.getName())
            KevoreeDeployManager.clearRef(c.javaClass.getName()+"_platformDescription", c.getName())
            return true
        } catch(e: Exception){
            Log.error("RemoveInstance "+c.getName() + " - type - " + c.getTypeDefinition()!!.getName()+" ",e)
            return false
        }
    }

}*/
