package com.kymjs.project2.unit0

/**
 * Created by ZhangTao on 18/6/10.
 */
fun function() {
    val str = "hello!"

    fun say(count: Int = 10) {
        println(str)
        if (count > 0) {
            say(count - 1)
        }
    }
    say()
}

fun print(name: String = "ZhangTao"): String? {
    println("$name")
    return name
}

fun main(args: Array<String>) {
    function()
}