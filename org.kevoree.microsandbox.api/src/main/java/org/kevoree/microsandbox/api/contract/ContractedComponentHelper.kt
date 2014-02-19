package org.kevoree.microsandbox.api.contract

import org.kevoree.annotation.DictionaryType
import org.kevoree.TypeDefinition

/**
 * User: Erwan Daubert - erwan.daubert@gmail.com
 * Date: 26/09/13
 * Time: 17:47
 *
 * @author Erwan Daubert
 * @version 1.0
 */
object ContractedComponentHelper {
    fun isContractedComponent(typeDefinition: TypeDefinition): Boolean {
        val isFullContracted = javaClass<FullContracted>().getAnnotation(javaClass<DictionaryType>())?.value()?.toList()?.all {
            dictionaryAttribute ->
            typeDefinition.getDictionaryType()?.getAttributes()?.filter{ attribute -> attribute.getName().equals(dictionaryAttribute.name()) }?.size() == 1
        }
        val isMemoryContracted = javaClass<MemoryContracted>().getAnnotation(javaClass<DictionaryType>())?.value()?.toList()?.all {
            dictionaryAttribute ->
            typeDefinition.getDictionaryType()?.getAttributes()?.filter{ attribute -> attribute.getName().equals(dictionaryAttribute.name()) }?.size() == 1
        }
        val isCPUContracted = javaClass<CPUContracted>().getAnnotation(javaClass<DictionaryType>())?.value()?.toList()?.all {
            dictionaryAttribute ->
            typeDefinition.getDictionaryType()?.getAttributes()?.filter{ attribute -> attribute.getName().equals(dictionaryAttribute.name()) }?.size() == 1
        }
        val isNetworkContracted = javaClass<NetworkContracted>().getAnnotation(javaClass<DictionaryType>())?.value()?.toList()?.all {
            dictionaryAttribute ->
            typeDefinition.getDictionaryType()?.getAttributes()?.filter{ attribute -> attribute.getName().equals(dictionaryAttribute.name()) }?.size() == 1
        }
        val isThroughputContracted = javaClass<ThroughputContracted>().getAnnotation(javaClass<DictionaryType>())?.value()?.toList()?.all {
            dictionaryAttribute ->
            typeDefinition.getDictionaryType()?.getAttributes()?.filter{ attribute -> attribute.getName().equals(dictionaryAttribute.name()) }?.size() == 1
        }

        return (isFullContracted != null && isFullContracted!!) ||
            (isMemoryContracted != null && isMemoryContracted!!) ||
            (isCPUContracted != null && isCPUContracted!!) ||
            (isNetworkContracted != null && isNetworkContracted!!) ||
            (isThroughputContracted != null && isThroughputContracted!!)
    }
}