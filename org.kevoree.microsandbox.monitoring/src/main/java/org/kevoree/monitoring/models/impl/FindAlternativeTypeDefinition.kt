package org.kevoree.monitoring.models.impl

import org.kevoree.ContainerRoot
import org.kevoree.TypeDefinition
import java.util.HashSet

/**
 * Created with IntelliJ IDEA.
 * User: duke
 * Date: 08/07/13
 * Time: 10:44
 */

public object FindAlternativeTypeDefinition {

    public fun findCompatible(origin: TypeDefinition, models: List<ContainerRoot>): List<TypeDefinition> {
        val typeDef = HashSet<TypeDefinition>()
        val originPath = origin.path()
        if(originPath != null){
            for(model in models){
                val similarTypeDef = model.findByPath(originPath)
                if(!origin.deepModelEquals(similarTypeDef)){
                    //TODO check if contract is compatible
                    typeDef.add(similarTypeDef as TypeDefinition)
                }
            }
        }
        return typeDef.toList()
    }

}
