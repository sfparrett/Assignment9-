import java.util.ArrayList
import kotlin.system.exitProcess
import kotlin.Array
import kotlin.test.assertEquals
import kotlin.test.assertFails
import kotlin.test.assertNull

abstract class ExprC
internal class numC(var n: Int) : ExprC()
internal class stringC(var s: String) : ExprC()
internal class idC(var name: Int) : ExprC()
internal class lamC(var body: ExprC, var parm: ArrayList<String>) : ExprC()
internal class appC(var func: ExprC, var args: ArrayList<ExprC>) : ExprC()
internal class ifC(var test: ExprC, var then: ExprC, var elsey: ExprC) : ExprC()


fun eagerEvaluation(str: String, args: ArrayList<Value>): Value {
    // numC
    if (str == "plus") {
        plus(args);
    }
    else if (str == "minus") {
        minus(args);
    }
    else if (str == "mult") {
        mult(args);
    }
    else if (str == "div") {
        div(args);
    }
    else if(str == "leq") {
        leq(args);
    }
    else if(str == "eqFunc") {
        eqFunc(args);
    }
    myError(args)
    return numV(0)
}

fun plus(args: ArrayList<Value>): Value {
    val new_args = unwrapList(args)
    if(new_args.size != 2) {
        println("Error wrong number of args for plus: ${args}")
        exitProcess(0)
    }
    return numV(new_args[0] + new_args[1])
}

fun minus(args: ArrayList<Value>): Value {
    val new_args = unwrapList(args)
    if(new_args.size != 2) {
        println("Error wrong number of args for minus: ${args}")
        exitProcess(0)
    }
    return numV(new_args[0] - new_args[1])
}

fun mult(args: ArrayList<Value>): Value {
    val new_args = unwrapList(args)
    if(new_args.size != 2) {
        println("Error wrong number of args for mult: ${args}")
        exitProcess(0)
    }
    return numV(new_args[0] * new_args[1])
}

fun div(args: ArrayList<Value>): Value {
    val new_args = unwrapList(args)
    if(new_args.size != 2) {
        println("Error wrong number of args for div: ${args}")
        exitProcess(0)
    }
    if(new_args[1] == 0) {
        println("Error division by 0: ${args}")
        exitProcess(0)
    }
    return numV(new_args[0] / new_args[1])
}

fun leq(args: ArrayList<Value>): Value {
    val new_args = unwrapList(args)
    if(new_args.size != 2) {
        println("Error wrong number of args for leq: ${args}")
        exitProcess(0)
    }
    return boolV(new_args[0] <= new_args[1])
}

fun eqFunc(args: ArrayList<Value>): Value {
    val new_args = unwrapList(args)
    if(new_args.size != 2) {
        println("Error wrong number of args for eqFunc: ${args}")
        exitProcess(0)
    }
    return boolV(new_args[0] == new_args[1]) // .equal or ==
}

fun myError(args: ArrayList<Value>): Value {
    println("ERROR ENDING PROGRAM")
    exitProcess(0)
}

fun unwrapList(vals : ArrayList<Value>): ArrayList<Int> {

    lateinit var result: ArrayList<Int>

    for (value in vals){
        if(value is numV)
        {
            result.add(value.n)
        }

        else
        {
            exitProcess(0)
        }
    }
    return result
}



// use envInitial.put(string, value) to put something in the hashmap
// envInitial.put(string, value) will also update a value in the hashmap
// use envInitial.get(string) to get the value of a string (from idC)
var envInitial : HashMap<String, Value> =
    hashMapOf("+" to primV("plus"), "-" to primV("minus"), "*" to primV("mult"), "/" to primV("div"),
        "<=" to primV("leq"), "equal?" to primV("eqFunc"), "true" to boolV(true), "false" to boolV(false),
        "error" to primV("myError"))
