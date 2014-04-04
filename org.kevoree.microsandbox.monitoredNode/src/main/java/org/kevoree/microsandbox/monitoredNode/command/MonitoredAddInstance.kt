package org.kevoree.microsandbox.monitoredNode

import org.kevoree.Instance
import org.kevoree.api.PrimitiveCommand
import org.kevoree.log.Log
import org.kevoree.api.KevScriptService
import org.kevoree.api.BootstrapService
import org.kevoree.api.ModelService
import org.kevoree.library.defaultNodeTypes.ModelRegistry
import org.kevoree.library.defaultNodeTypes.wrapper.WrapperFactory
import org.kevoree.library.defaultNodeTypes.wrapper.KInstanceWrapper
import org.kevoree.ContainerNode
import org.resourceaccounting.contract.ResourceContract
import org.resourceaccounting.binder.MonitoringStatusList

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 6/26/13
 * Time: 4:52 PM
 */
open class MonitoredAddInstance(val wrapperFactory: WrapperFactory, val c: Instance, val nodeName: String,
                       val registry: ModelRegistry, val monitoringRegistry: MonitoringRegistry,
                       val modelService: ModelService, val kscript: KevScriptService, val bs: BootstrapService) : PrimitiveCommand, Runnable {
    var nodeTypeName: String? = null
    var tg: ThreadGroup? = null

    var resultSub = false

    override fun execute(): Boolean {
        var subThread: Thread? = null
        try {
            tg = ThreadGroup("kev/" + c.path()!!)
            subThread = Thread(tg, this)
            subThread!!.start()
            subThread!!.join()
            if (resultSub) {
                monitoringRegistry.register(c.path() + "_tg", tg!!)
                monitoringRegistry.register(c.path() + "_deployTime", System.nanoTime())
            }
            return resultSub
        } catch(e: Throwable) {
            if (subThread != null) {
                try {
                    subThread!!.stop() //kill sub thread
                } catch(t: Throwable){
                    //ignore killing thread
                }
            }
            val message = "Could not add the instance " + c.name!! + ":" + c.typeDefinition!!.name!!
            Log.error(message, e)
            return false
        }
    }

    override fun undo() {
        MonitoredRemoveInstance(wrapperFactory, c, nodeName, registry, monitoringRegistry, modelService, kscript, bs).execute()
    }

    public override fun run() {
        try {
            var newBeanKInstanceWrapper: KInstanceWrapper?
            if (c is ContainerNode) {
                newBeanKInstanceWrapper: KInstanceWrapper? = wrapperFactory.wrap(c, this/* nodeInstance is useless because launched as external process */, tg!!, bs, modelService)
                registry.register(c, newBeanKInstanceWrapper!!)
                monitoringRegistry.register(c.path() + "_platformDescription", ControlAdmissionSystem.getPlatformDescription())
            } else {
                val newBeanInstance = bs.createInstance(c)
                newBeanKInstanceWrapper: KInstanceWrapper? = wrapperFactory.wrap(c, newBeanInstance!!, tg!!, bs, modelService)
                registry.register(c, newBeanKInstanceWrapper!!)
                bs.injectDictionary(c, newBeanInstance, true)

                var contract: ResourceContract? = null
                val r = ControlAdmissionSystem.registerComponent(c)
                if (!r.valid) {
                    Log.error("Unable to execute {} because the contract is not valid in instance {}",
                            this.toString(), c.name)
                    resultSub = false
                }

                if (r.contract != null) {
                    contract = r.contract
                    monitoringRegistry.register(c.path() + "_contract", r.contract)
                }
                val loader: ClassLoader? = bs.get(c.typeDefinition!!.deployUnit!!)
                if (loader != null) {
                    //                Log.info("------^^^^^^^ {}", c.getName())

                    if (contract != null && (contract?.getMemory() != 0 || contract?.getCPU() != 0)) {

                        //                    Log.info("------^^^^^^^ {} ^^^^^^^-------", c.getName())
                        //                    println("Classloader for " + c.getName() + " is " + loader.javaClass.getCanonicalName() + " " +
                        //                    "and has " + (loader as KevoreeJarClassLoaderCoverageInjection).loadedClasses.size +
                        //                    " loaded classes and hash " + loader.hashCode())
                        MonitoringStatusList.instance()?.includeApp("kev/" + c.path(), loader.hashCode(),
                                contract?.getMemory() != 0,
                                contract?.getCPU() != 0)
                        //                    MonitoringStatusList.instance()?.setMonitored("kev/"+c.path(), true)
                    }
                }

            }
            if (resultSub) {
                newBeanKInstanceWrapper?.create()
                resultSub = true
            }
        } catch(e: Throwable){
            Log.error("Error while adding instance {}", e, c.name)
            resultSub = false
        }
    }


    public override fun toString(): String {
        return "AddInstance " + c.name
    }
}
/*open class MonitoredAddInstance(val c: Instance,
                                val nodeName: String,
                                val modelservice: ModelService,
                                val kscript: KevScriptService,
                                val registry: ModelRegistry,
                                val bs: BootstrapService) : PrimitiveCommand, Runnable {

    private val typeDefinitionAspect = TypeDefinitionAspect()
    var deployUnit: DeployUnit? = null
    var nodeTypeName: String? = null
    var tg: ThreadGroup? = null

    override fun execute(): Boolean {

       *//* var contract: ResourceContract? = null
        if (c is ComponentInstance) {
            val cc: ComponentInstance = c as ComponentInstance
            val r = ControlAdmissionSystem.registerComponent(cc)
            if (!r.valid) {
                Log.error("Unable to execute {} because the contract is not valid in instance {}",
                        this.toString(), c.getName())
                return false
            }

            if (r.contract != null) {
                contract = r.contract
                KevoreeDeployManager.putRef(c.javaClass.getName() + "_contract", c.getName(), r.contract!!)
            }
        }*//*

        val model = c.getTypeDefinition()!!.eContainer() as ContainerRoot
        val node = model.findNodesByID(nodeName)
        deployUnit = typeDefinitionAspect.foundRelevantDeployUnit(c.getTypeDefinition()!!, node!!)!!
        if (c is ComponentInstance) {
            val loader: ClassLoader? = bs.getKevoreeClassLoaderHandler().getKevoreeClassLoader(deployUnit)
            if (loader != null) {
                //                Log.info("------^^^^^^^ {}", c.getName())

                if (contract != null && (contract?.getMemory() != 0 || contract?.getCPU() != 0)) {

                    //                    Log.info("------^^^^^^^ {} ^^^^^^^-------", c.getName())
                    //                    println("Classloader for " + c.getName() + " is " + loader.javaClass.getCanonicalName() + " " +
                    //                    "and has " + (loader as KevoreeJarClassLoaderCoverageInjection).loadedClasses.size +
                    //                    " loaded classes and hash " + loader.hashCode())
                    MonitoringStatusList.instance()?.includeApp("kev/" + c.path(), loader.hashCode(),
                            contract?.getMemory() != 0,
                            contract?.getCPU() != 0)
                    //                    MonitoringStatusList.instance()?.setMonitored("kev/"+c.path(), true)
                }
            }
        }

        val nodeType = node.getTypeDefinition()
        nodeTypeName = typeDefinitionAspect.foundRelevantHostNodeType(nodeType as NodeType,
                c.getTypeDefinition()!!)!!.getName()
        var subThread: Thread? = null
        try {
            tg = ThreadGroup("kev/" + c.path()!!)
            subThread = Thread(tg, this)
            subThread!!.start()
            subThread!!.join()
            KevoreeDeployManager.putRef(c.javaClass.getName() + "_tg", c.getName(), tg!!)
            KevoreeDeployManager.putRef(c.javaClass.getName() + "_deployTime", c.getName(), System.nanoTime())
            KevoreeDeployManager.putRef(c.javaClass.getName() + "_platformDescription", c.getName(),
                    ControlAdmissionSystem.getPlatformDescription() as Any)
            return true
        } catch(e: Throwable) {
            if (subThread != null) {
                try {
                    subThread!!.stop() //kill sub thread // TODO : that's wrong
                } catch(t: Throwable) {
                    //ignore killing thread
                }
            }
            val message = "Could not start the instance " + c.getName() + ":" + c.getTypeDefinition()!!.getName() + "\n"
            Log.error(message, e)
            return false
        }
    }

    override fun undo() {
        MonitoredRemoveInstance(c, nodeName, modelservice, kscript, bs, nt).execute()
    }

    override public fun run() {
        val beanClazz = bs.getKevoreeClassLoaderHandler().
        getKevoreeClassLoader(deployUnit)!!.
        loadClass(c.getTypeDefinition()!!.getBean())

        val newBeanInstance = beanClazz!!.newInstance()
        var newBeanKInstanceWrapper: KInstance? = null
        if (c is ComponentInstance) {
            newBeanKInstanceWrapper = KevoreeComponent(newBeanInstance as AbstractComponentType,
                    nodeName, c.getName(), modelservice, bs, kscript, nt.getDataSpaceService())
            (newBeanKInstanceWrapper as KevoreeComponent).initPorts(nodeTypeName!!, c, tg!!)
        }
        if (c is Group) {
            newBeanKInstanceWrapper = KevoreeGroup(newBeanInstance as AbstractGroupType, nodeName,
                    c.getName(), modelservice, bs, kscript, nt.getDataSpaceService())
        }
        if (c is Channel) {
            newBeanKInstanceWrapper = ChannelTypeFragmentThread(newBeanInstance as AbstractChannelFragment,
                    nodeName, c.getName(), modelservice, bs, kscript, nt.getDataSpaceService(), tg!!)
            (newBeanKInstanceWrapper as ChannelTypeFragmentThread).initChannel()
        }

        KevoreeDeployManager.putRef(c.javaClass.getName(), c.getName(), newBeanInstance!!)
        KevoreeDeployManager.putRef(c.javaClass.getName() + "_wrapper", c.getName(), newBeanKInstanceWrapper!!)

    }


    public override fun toString(): String? {
        return "MonitoredAddInstance " + c.getName() + "@" + nodeName + ":" + c.getTypeDefinition()!!.getName()
    }
}*/

