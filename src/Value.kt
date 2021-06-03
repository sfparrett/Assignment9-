import java.lang.reflect.Array
import java.util.Hashtable

abstract class Value {
    internal abstract fun serialize(): String

}

class numV( val n: Int) : Value() {

    override fun serialize(): String {
        return Integer.toString(n)
    }
}

class stringV( val s: String) : Value() {

    override fun serialize(): String {
        return s
    }
}

class boolV( val b: Boolean) : Value() {

    override fun serialize(): String {
        return java.lang.Boolean.toString(b)
    }
}

class cloV(val parms: ArrayList<String>, val body: ExprC, val env: HashMap<String, Value>) : Value() {

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

class primV( val op: String) : Value() {

    override fun serialize(): String {
        return "#<primop>"
    }
}