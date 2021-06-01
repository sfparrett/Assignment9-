
// TASKS
// ExprC definitions

// environment stuff / primV - Riley
// Value data definitions/  serialize - Zac
// interp / ExprC data definitions - Sophia

abstract class ExprC(){

}

class numC(exp: Integer): ExprC() {
    private var numc: Integer = exp
}

class stringC(exp: String): ExprC() {
    private var stringc: String = exp
}

class idC(name: String): ExprC() {
    private var name: String = name
}

class lamC(body: ExprC, parm: Array<String>  ): ExprC() {
    private var body: ExprC = body
    private var parm: Array<String> = parm
}

class appC(exp: Integer): ExprC() {
    private var numc: Integer = exp
}

class ifC(exp: Integer): ExprC() {
    private var numc: Integer = exp
}

