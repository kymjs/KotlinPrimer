@file:JvmName("KotlinCode")
@file:JvmMultifileClass
package com.kymjs.project13.unit1

object Test {
    @JvmStatic
    fun sayMessage(msg: String) {
        println(msg)
    }
}

fun doFunction(block: (i: Int) -> Unit) {
    block.invoke(1)
}
