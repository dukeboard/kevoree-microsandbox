package org.kevoree.microsandbox.javase

import org.kevoree.Instance
import org.kevoree.api.service.core.handler.KevoreeModelHandlerService
import org.kevoree.api.service.core.script.KevScriptEngineFactory
import org.kevoree.framework.AbstractNodeType
import org.kevoree.api.PrimitiveCommand
import org.kevoree.framework.kaspects.TypeDefinitionAspect
import org.kevoree.log.Log
import org.kevoree.library.defaultNodeTypes.context.KevoreeDeployManager
import org.kevoree.library.defaultNodeTypes.command.UpdateDictionary
import org.kevoree.ComponentInstance

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 6/27/13
 * Time: 2:40 PM
 * To change this template use File | Settings | File Templates.
 */
class MonitoredRemoveInstance(val c: Instance, val nodeName: String, val modelservice: KevoreeModelHandlerService,
                              val kscript: KevScriptEngineFactory, val bs: org.kevoree.api.Bootstraper, val nt : AbstractNodeType): PrimitiveCommand {

    private val typeDefinitionAspect = TypeDefinitionAspect()

    override fun undo() {
        try {
            MonitoredAddInstance(c, nodeName, modelservice, kscript, bs,nt).execute()
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

}