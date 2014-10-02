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
import org.kevoree.kcl.api.FlexyClassLoader
import org.kevoree.library.defaultNodeTypes.command.ClassLoaderHelper
import org.kevoree.microsandbox.monitoredNode.command.MicrosandboxClassLoaderHelper
import org.kevoree.ComponentInstance

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
                    t.printStackTrace()
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
            var newKCL = ClassLoaderHelper.createInstanceClassLoader(c, nodeName, bs)!! //MicrosandboxClassLoaderHelper.createInstanceClassLoader(c, nodeName, bs)!!
            Log.debug("\t\t\tcl_created =({},{}) cl_caller=({})", newKCL, newKCL.hashCode(), this.javaClass.getClassLoader()?.hashCode())
            Thread.currentThread().setContextClassLoader(newKCL)
            Thread.currentThread().setName("KevoreeAddInstance" + c.name!!)


            if (c  is ComponentInstance) {
                val properLoader = c.typeDefinition?.deployUnits!!.map {
                    a ->
                    Pair<String, ClassLoader>(a.name!!, bs.get(a)!!)
//                    Log.info("Unit {}:{}, Loader {}", a.name, a.path(), )
                }.first!!.second

                val r = ControlAdmissionSystem.registerComponent(c)
                if (!r.valid) {
                    Log.error("Unable to execute {} because the contract is not valid in instance {}",
                            this.toString(), c.name)
                    resultSub = false
                }

                if (r.contract != null) {
                    monitoringRegistry.register(c.path() + "_contract", r.contract)

                    registerContract(r.contract, array(properLoader, newKCL).toList())
                }
            }
            var newBeanKInstanceWrapper: KInstanceWrapper
            if (c is ContainerNode) {
                newBeanKInstanceWrapper = wrapperFactory.wrap(c, this/* nodeInstance is useless because launched as external process */, tg!!, bs, modelService)
                newBeanKInstanceWrapper.kcl = newKCL
                registry.register(c, newBeanKInstanceWrapper)
                monitoringRegistry.register(c.path() + "_platformDescription", ControlAdmissionSystem.getPlatformDescription())
            } else {
                val newBeanInstance = bs.createInstance(c, newKCL)
                newBeanKInstanceWrapper = wrapperFactory.wrap(c, newBeanInstance!!, tg!!, bs, modelService)
                newBeanKInstanceWrapper.kcl = newKCL
                registry.register(c, newBeanKInstanceWrapper)
                bs.injectDictionary(c, newBeanInstance, true)

            }
            newBeanKInstanceWrapper.create()
            resultSub = true
            Thread.currentThread().setContextClassLoader(null)
            Log.info("Add instance {}", c.path())

            // injecting model registry if the component has that field
            if (c is ComponentInstance) {
                val wrapper = registry.lookup(c) as KInstanceWrapper
                val obj = wrapper.targetObj
                val fields = obj.javaClass.getDeclaredFields()
                for (f in fields) {
                    if (f.getType() == javaClass<ModelRegistry>() /*&&
                                f.isAnnotationPresent(KevoreeInject.class)*/) {
                        try {
                            f.set(obj, registry)
                        } catch (e1: IllegalAccessException) {
                            e1.printStackTrace()
                        }

                    }
                }
            }
        } catch(e: Throwable) {
            Log.error("Error while adding instance {}", e, c.name)
            resultSub = false
        }
    }

    fun registerContract(contract:ResourceContract, classLoaders : List<ClassLoader?>) {
//        Log.debug("My loader is {}", this.getClass().getClassLoader())
//        Log.debug("NUMERO {} {} {} {} {}", classLoader, contract, contract?.getMemory(), contract?.getCPU(), c.path())
        if (contract != null && (contract?.getMemory() != 0 || contract?.getCPU() != 0)) {

//            Runtime.getRuntime()
//            Log.debug("Adding to applications's list loader_hash={}, path={}, memory={}, cpu={}",
//                    classLoader.hashCode(), c.path(), contract?.getMemory(), contract?.getCPU())

//            val clzz = ClassLoader.getSystemClassLoader()?.loadClass("org.resourceaccounting.binder.MonitoringStatusList")
//            val me_instance = clzz?.getDeclaredMethod("instance")!!
//            val r = me_instance.invoke(null)
//            val me_includeApp = clzz?.getDeclaredMethod("includeApp",
//                    javaClass<String>(),
//                    javaClass<Int>(),
//                    javaClass<Boolean>(),
//                    javaClass<Boolean>())!!
//            me_includeApp.invoke(r, "kev/" + c.path(), classLoader.hashCode(), contract?.getMemory() != 0,
//                    contract?.getCPU() != 0)

            classLoaders.filter { loader -> loader!=null }.forEach {
                loader ->
                Log.debug("Registring loader {}", loader!!.hashCode())
                MonitoringStatusList.instance()?.includeApp("kev/" + c.path(), loader!!.hashCode(),
                        contract?.getMemory() != 0,
                        contract?.getCPU() != 0)
            }

            //MonitoringStatusList.instance()?.setMonitored("kev/"+c.path(), true)
        }
    }


    public override fun toString(): String {
        return "AddInstance " + c.name
    }
}

