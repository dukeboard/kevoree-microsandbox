package org.kevoree.microsandbox.api.contract

import org.kevoree.TypeDefinition
import org.kevoree.DictionaryType
import org.kevoree.annotation.Param

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
        val isFullContracted = javaClass<FullContracted>().getDeclaredFields().all {
            attribute ->
            attribute.getAnnotation(javaClass<Param>()) == null
            ||
            (attribute.getAnnotation(javaClass<Param>()) != null && typeDefinition.dictionaryType?.attributes?.filter { dictionaryAttribute -> dictionaryAttribute.name.equals(attribute.getName()) }?.size() == 1)
        }
        val isMemoryContracted = javaClass<MemoryContracted>().getDeclaredFields().all {
            attribute ->
            attribute.getAnnotation(javaClass<Param>()) == null
            ||
            (attribute.getAnnotation(javaClass<Param>()) != null && typeDefinition.dictionaryType?.attributes?.filter { dictionaryAttribute -> dictionaryAttribute.name.equals(attribute.getName()) }?.size() == 1)
        }
        val isCPUContracted = javaClass<CPUContracted>().getDeclaredFields().all {
            attribute ->
            attribute.getAnnotation(javaClass<Param>()) == null
            ||
            (attribute.getAnnotation(javaClass<Param>()) != null && typeDefinition.dictionaryType?.attributes?.filter { dictionaryAttribute -> dictionaryAttribute.name.equals(attribute.getName()) }?.size() == 1)
        }
        val isNetworkContracted = javaClass<NetworkContracted>().getDeclaredFields().all {
            attribute ->
            attribute.getAnnotation(javaClass<Param>()) == null
            ||
            (attribute.getAnnotation(javaClass<Param>()) != null && typeDefinition.dictionaryType?.attributes?.filter { dictionaryAttribute -> dictionaryAttribute.name.equals(attribute.getName()) }?.size() == 1)
        }
        val isThroughputContracted = javaClass<ThroughputContracted>().getDeclaredFields().all {
            attribute ->
            attribute.getAnnotation(javaClass<Param>()) == null
            ||
            (attribute.getAnnotation(javaClass<Param>()) != null && typeDefinition.dictionaryType?.attributes?.filter { dictionaryAttribute -> dictionaryAttribute.name.equals(attribute.getName()) }?.size() == 1)
        }

        return isFullContracted || isMemoryContracted || isCPUContracted || isNetworkContracted || isThroughputContracted
    }
}