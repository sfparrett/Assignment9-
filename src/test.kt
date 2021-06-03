import java.util.ArrayList
import kotlin.test.assertEquals
import kotlin.test.assertNull


fun testPrimV() {
    val myArrayList =  arrayListOf<Value>(numV(2), numV(1))

    val zeroArrayList =  arrayListOf<Value>(numV(1), numV(0))

    val wrongArrayList1 =  arrayListOf<Value>(boolV(true), numV(0))

    val wrongArrayList2 =  arrayListOf<Value>(numV(1), numV(2), numV(3))

    assertEquals(plus(myArrayList), numV(3))
    assertEquals(minus(myArrayList), numV(1))
    assertEquals(div(myArrayList), numV(2))
    assertEquals(mult(myArrayList), numV(2))
    assertEquals(leq(myArrayList), boolV(false))
    assertEquals(eqFunc(myArrayList), boolV(false))
    assertNull(myError(myArrayList))

    assertNull(div(zeroArrayList))

    assertNull(plus(wrongArrayList1))
    assertNull(minus(wrongArrayList1))
    assertNull(div(wrongArrayList1))
    assertNull(mult(wrongArrayList1))
    assertNull(leq(wrongArrayList1))
    assertNull(eqFunc(wrongArrayList1))

    assertNull(plus(wrongArrayList2))
    assertNull(minus(wrongArrayList2))
    assertNull(div(wrongArrayList2))
    assertNull(mult(wrongArrayList2))
    assertNull(leq(wrongArrayList2))
    assertNull(eqFunc(wrongArrayList2))
}

fun testNumV(){
    val num = numV(7);
    assertEquals(num.serialize(),"7");
}

fun testStringV(){
    val str = stringV("HelloWorld");
    assertEquals(str.serialize(),"HelloWorld");
}

fun testBoolV(){
    val boo =boolV(false);
    assertEquals(boo.serialize(),"false");
}

fun testCloV(){
    val clo = cloV(arrayListOf("1", "2", "3"), numC(7), HashMap<String, Value>());
    assertEquals(clo.serialize(),"#<procedure>");
}

fun testPrimv(){
    val prim = primV("plus");
    assertEquals(prim.serialize(),"#<primop>");
}