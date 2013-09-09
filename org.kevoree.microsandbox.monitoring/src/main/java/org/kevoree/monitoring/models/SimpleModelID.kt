package org.kevoree.monitoring.models

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 7/7/13
 * Time: 10:34 PM
 * To change this template use File | Settings | File Templates.
 */
class SimpleModelID(val id : Int) : ModelID {
    public override fun isTheSameAs(other: ModelID?): Boolean {
        if (other is SimpleModelID) {
            val tmp = other as SimpleModelID
            return tmp.id == id;
        }
        return false;
    }
    /*public override fun isTheSameAs(other: ((ModelID?) -> Boolean)?): Boolean {
        return other!!(this)
    }*/


    public override fun toString(): String? = id.toString()
}