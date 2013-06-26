package org.kevoree.microsandbox.javase

import org.kevoree.library.defaultNodeTypes.command.AddInstance
import org.kevoree.Instance
import org.kevoree.api.service.core.handler.KevoreeModelHandlerService
import org.kevoree.api.service.core.script.KevScriptEngineFactory
import org.kevoree.framework.AbstractNodeType
import org.kevoree.framework.kaspects.TypeDefinitionAspect
import org.kevoree.DeployUnit
import org.kevoree.ContainerRoot
import org.kevoree.api.PrimitiveCommand
import org.kevoree.NodeType
import org.kevoree.library.defaultNodeTypes.context.KevoreeDeployManager
import org.kevoree.library.defaultNodeTypes.command.RemoveInstance
import org.kevoree.framework.KInstance
import org.kevoree.ComponentInstance
import org.kevoree.framework.KevoreeComponent
import org.kevoree.framework.AbstractComponentType
import org.kevoree.framework.KevoreeGroup
import org.kevoree.Group
import org.kevoree.framework.ChannelTypeFragmentThread
import org.kevoree.Channel
import org.kevoree.framework.AbstractGroupType
import org.kevoree.framework.AbstractChannelFragment
import org.kevoree.log.Log

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 6/26/13
 * Time: 4:52 PM
 * To change this template use File | Settings | File Templates.
 */
class MonitoredAddInstance(val c: Instance,
                                  val nodeName: String,
                                  val modelservice: KevoreeModelHandlerService,
                                  val kscript: KevScriptEngineFactory,
                                  val bs: org.kevoree.api.Bootstraper,
                                  val nt : AbstractNodeType) : PrimitiveCommand, Runnable {
    private val typeDefinitionAspect = TypeDefinitionAspect()
    var deployUnit : DeployUnit? = null
    var nodeTypeName : String? = null
    var tg : ThreadGroup? = null

    override fun execute(): Boolean {
        val model = c.getTypeDefinition()!!.eContainer() as ContainerRoot
        val node = model.findNodesByID(nodeName)
        deployUnit = typeDefinitionAspect.foundRelevantDeployUnit(c.getTypeDefinition()!!, node!!)!!
        val nodeType = node!!.getTypeDefinition()
        nodeTypeName = typeDefinitionAspect.foundRelevantHostNodeType(nodeType as NodeType, c.getTypeDefinition()!!)!!.getName()
        var subThread : Thread? = null
        try {
            tg = ThreadGroup("kev/"+c.path()!!)
            subThread = Thread(tg,this)
            subThread!!.start()
            subThread!!.join()
            KevoreeDeployManager.putRef(c.javaClass.getName()+"_tg", c.getName(), tg!!)
            return true
        } catch(e: Throwable) {
            if(subThread != null){
                try {
                    subThread!!.stop() //kill sub thread
                } catch(t : Throwable){
                    //ignore killing thread
                }
            }
            val message = "Could not start the instance " + c.getName() + ":" + c.getTypeDefinition()!!.getName() + "\n"
            Log.error(message, e)
            return false
        }
    }

    override fun undo() {
        RemoveInstance(c, nodeName, modelservice, kscript, bs,nt).execute()
    }

    override public fun run() {
        val beanClazz = bs.getKevoreeClassLoaderHandler().
                    getKevoreeClassLoader(deployUnit)!!.
                    loadClass(c.getTypeDefinition()!!.getBean())

        val newBeanInstance = beanClazz!!.newInstance()
        var newBeanKInstanceWrapper :KInstance? = null
        if(c is ComponentInstance){
            newBeanKInstanceWrapper = KevoreeComponent(newBeanInstance as AbstractComponentType,
                    nodeName,c.getName(),modelservice,bs,kscript,nt.getDataSpaceService())
            (newBeanKInstanceWrapper as KevoreeComponent).initPorts(nodeTypeName!!,c,tg!!)
        }
        if(c is Group){
            newBeanKInstanceWrapper = KevoreeGroup(newBeanInstance as AbstractGroupType,nodeName,
                    c.getName(),modelservice,bs,kscript,nt.getDataSpaceService())
        }
        if(c is Channel){
            newBeanKInstanceWrapper = ChannelTypeFragmentThread(newBeanInstance as AbstractChannelFragment,
                    nodeName,c.getName(),modelservice,bs,kscript,nt.getDataSpaceService(),tg!!)
            (newBeanKInstanceWrapper as ChannelTypeFragmentThread).initChannel()
        }

        KevoreeDeployManager.putRef(c.javaClass.getName(), c.getName(), newBeanInstance!!)
        KevoreeDeployManager.putRef(c.javaClass.getName()+"_wrapper", c.getName(), newBeanKInstanceWrapper!!)

    }

}

