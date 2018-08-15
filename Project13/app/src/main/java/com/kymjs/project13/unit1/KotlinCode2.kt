@file:JvmName("KotlinCode")
@file:JvmMultifileClass

package com.kymjs.project13.unit1

fun doFunction(block: () -> Unit) {
    block.invoke()
}
