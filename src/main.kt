// data definitions
// ExprCs





// interp function

fun interp(args: Array<String>) {
    println("Hello, vLemonn!")
}

fun interp(exp: ExprC, env: Environment): Value {
    if (exp is numC){
        print("numC")
    }
    else if (exp is stringC){
        print("stringC")
    }
    else if (exp is lamC){
        print("lamC")
    }
    else if(exp is idC){
        print("idC")
    }
    else if(exp is ifC){
        print("ifC")
    }
    else{ // appC
        print("ifC")

    }
    return new Value();

}

fun main(args: Array<String>) {
    println("Hello, vLemonn!")
}


