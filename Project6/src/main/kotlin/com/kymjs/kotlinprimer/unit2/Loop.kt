package com.kymjs.kotlinprimer.unit2

/**
 * Created by ZhangTao on 18/7/1.
 */
fun main(args: Array<String>) {
    for (i in 1..10) {
        println(i)
    }
    println("---------------")

    for (i in 10..1) {
        println(i)
    }
    println("---------------")

    for (i in 1 until 10) {
        println(i)
    }
    println("---------------")

    for (i in 10 downTo 1) {
        println(i)
    }
    println("---------------")

    for (i in 1..10 step 2) {
        println(i)
    }
    println("---------------")

    val list = arrayListOf<String>("a", "b", "c", "d")
    for (str in list) {
        println(str)
    }

    for ((index, str) in list.withIndex()) {
        println("第${index}个元素是$str")
    }

    repeat(10) {
        println(it)
    }
}
