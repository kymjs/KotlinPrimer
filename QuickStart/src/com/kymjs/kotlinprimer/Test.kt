package com.kymjs.kotlinprimer

/**
 * Created by ZhangTao on 18/6/5.
 */

fun main(args: Array<String>) {
    var age: Int = 18
    var name: String = "Zhang Tao"
}

fun test(name: String): String {
    println("$name")
    return name
}

fun <T> test2(name: T): T {
    return name
}

class Main {
    fun test() {
        println("Main.test")
    }
}