import java.lang.reflect.Array
import java.util.Hashtable

abstract class Value {

    internal abstract fun serialize(): String

}

class numV(private val n: Int) : Value() {

    override fun serialize(): String {
        return Integer.toString(n)
    }
}

class stringV(private val s: String) : Value() {

    override fun serialize(): String {
        return s
    }
}

class boolV(private val b: Boolean) : Value() {

    override fun serialize(): String {
        return java.lang.Boolean.toString(b)
    }
}

class cloV(private val parms: Array, private val body: ExprC, private val env: Hashtable<String, Value>) : Value() {

    override fun serialize(): String {
        return "#<primop>"
    }
}

//dont need the data?
class cloV(private val parms: Array, private val body: ExprC, private val env: Hashtable<String, Value>) : Value() {

    override fun serialize(): String {
        return "#<procedure>"
    }
}

//not sure how to represent data but also dont need the data
/*class primV(private val op: String) : Value() {

    override fun serialize(): String {
        return "#<primop>"
    }
}*/

class primV(private val op: (arr: Array) -> Value) : Value() {

    override fun serialize(): String {
        return "#<primop>"
    }
}