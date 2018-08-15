package com.kymjs.kotlinprimer.unit4

/**
 * Created by ZhangTao on 18/7/8.
 */
fun main(args: Array<String>) {
    var a: String = ""

    println(getValue(a))
}

fun getValue(s: String): String {
    return "1" + s.length
}
