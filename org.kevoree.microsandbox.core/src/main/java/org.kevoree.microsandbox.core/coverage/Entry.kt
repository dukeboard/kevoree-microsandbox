package org.kevoree.microsandbox.core

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 6/28/13
 * Time: 6:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class Entry(branchParam : Double, instrParam : Double) {
    val branchCoverage : Double = branchParam
    val instrCoverage : Double = instrParam

    /*override*/ fun toString() : String = "Branch: " + branchCoverage + " Instruction: " + instrCoverage
}