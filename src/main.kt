
import java.util.ArrayList
import java.lang.reflect.Array
import java.util.Hashtable
import kotlin.system.exitProcess



fun env_extend( env: HashMap<String, Value> , parms : ArrayList<String>, argvals : ArrayList<Value>) {
    var i = 0;
    if (parms.size == argvals.size) {
        while (i < parms.size) {
            env[parms[i]] = argvals[i];
            i++;
        }
    }
    else{
        System.out.println("GIYA invalid app");
        exitProcess(0);
    }
}


fun interp(exp: ExprC, env: HashMap<String, Value>): Value {
    // numC
    if (exp is numC) {
        return numV(exp.n);
        // stringC
    } else if (exp is stringC) {
        return stringV(exp.s);
        // lamC
    } else if (exp is lamC) {

        // Array from ArrayList here
        return cloV(exp.parm, exp.body, env);
        // idC
    } else if (exp is idC) {
        return numV(4);
        // this is wrong needs to be changed to env lookup

        // ifC
    } else if (exp is ifC) {

        var result = interp(exp.then, env);
        if(result is boolV){
            if (result.b){
                return interp(exp.then, env);
            }
            else if (result.b == false){
                return interp(exp.elsey, env);
            }
            else{
                System.out.println("GIYA non-boolean test");
                exitProcess(0);
            }
        }
    }
    // appC
    else if(exp is appC){
        var match = interp(exp.func, env);
        if (match is cloV){
            lateinit var argvals: ArrayList<Value>
            for (arg in exp.args) {
                argvals.add(interp(arg, env));
            }
            // hopefully this env is updated

            // make an Array from an ArrayList

            env_extend(env, match.parms, argvals)
            return interp (match.body, env);
        }

        else if (match is primV){

            //[(primV op)
            //    (define arg-vals (map (lambda ([a : ExprC]) (interp a env)) args) )
            //(op arg-vals)]

            lateinit var argvals: ArrayList<Value>
            for (arg in exp.args) {
                argvals.add(interp(arg, env));
            }

            return eagerEvaluation(match.op, argvals)

            // return match.op(argvals) // we need argvals to be unwrapped
            // return match // THIS IS WRONG WHAT IS OP????
            // Racket: (define arg-vals (map (lambda ([a : ExprC]) (interp a env)) args)) (op arg-vals)]
        }
        else{
            System.out.println("GIYA invalid appC");
            exitProcess(0);
        }

    }
    System.out.println("GIYA invalid appC");
    exitProcess(0);

}

fun main(args : ArrayList<String>) {
    testPrimV()
    testBoolV()
    testCloV()
    testNumV()
    testPrimv()
    testStringV()
}


// Riley Test