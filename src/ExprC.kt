import java.util.ArrayList

abstract class ExprC
internal class numC(var n: Int) : ExprC()
internal class stringC(var s: String) : ExprC()
internal class idC(var name: Int) : ExprC()
internal class lamC(var body: ExprC, var parm: ArrayList<String>) : ExprC()
internal class appC(var func: ExprC, var args: ArrayList<ExprC>) : ExprC()
internal class ifC(var test: ExprC, var then: ExprC, var elsey: ExprC) : ExprC()



abstract class Value(){

}

class primV(func: (arr: Array) ->  Value ) : Value() {
    private var op: (arr: Array) ->  Value = op
}



fun plus(args: IntArray): Int {
    if(args.size != 2) {
        println("Error wrong number of args for plus: ${args.asList()}")
        exitProcess(0)
    }
    return args[0] + args[1]
}

fun minus(args: IntArray): Int {
    if(args.size != 2) {
        println("Error wrong number of args for minus: ${args.asList()}")
        exitProcess(0)
    }
    return args[0] - args[1]
}

fun mult(args: IntArray): Int {
    if(args.size != 2) {
        println("Error wrong number of args for mult: ${args.asList()}")
        exitProcess(0)
    }
    return args[0] * args[1]
}

fun div(args: IntArray): Int {
    if(args.size != 2) {
        println("Error wrong number of args for div: ${args.asList()}")
        exitProcess(0)
    }
    if(args[1] == 0) {
        println("Error division by 0: ${args.asList()}")
        exitProcess(0)
    }
    return args[0] / args[1]
}

fun leq(args: IntArray): Boolean {
    if(args.size != 2) {
        println("Error wrong number of args for leq: ${args.asList()}")
        exitProcess(0)
    }
    return args[0] <= args[1]
}

fun eqFunc(args: IntArray): Boolean {
    if(args.size != 2) {
        println("Error wrong number of args for eqFunc: ${args.asList()}")
        exitProcess(0)
    }
    return args[0] == args[1] // .equal or ==
}

fun myError(args: IntArray): Boolean {
    println("ERROR ENDING PROGRAM")
    exitProcess(0)
}

// use envInitial.put(string, value) to put something in the hashmap
// envInitial.put(string, value) will also update a value in the hashmap
// use envInitial.get(string) to get the value of a string (from idC)
var envInitial : HashMap<String, Value> =
hashMapOf("+" to primV(plus), "-" to primV(minus), "*" to primV(mult), "/" to primV(div),
"<=" to primV(leq), "equal?" to primV(eqFunc), "true" to boolV(true), "false" to boolV(false),
"error" to primV(myError))

fun plus(args: list<Int>) {
    return args[0] + args[1]
}