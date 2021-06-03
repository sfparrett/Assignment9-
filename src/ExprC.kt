import java.util.ArrayList

abstract class ExprC
internal class numC(var n: Int) : ExprC()
internal class stringC(var s: String) : ExprC()
internal class idC(var name: Int) : ExprC()
internal class lamC(var body: ExprC, var parm: ArrayList<String>) : ExprC()
internal class appC(var func: ExprC, var args: ArrayList<ExprC>) : ExprC()
internal class ifC(var test: ExprC, var then: ExprC, var elsey: ExprC) : ExprC()


