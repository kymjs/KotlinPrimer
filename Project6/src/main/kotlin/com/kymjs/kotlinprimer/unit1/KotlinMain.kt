package com.kymjs.kotlinprimer.unit1

/**
 * Created by ZhangTao on 18/7/1.
 */
fun main(args: Array<String>) {
    val user = User(12, "name")
    val (age, name, nickname) = user
    println(age)
    println(name)

    val map = mapOf<String, String>("key" to "key", "value" to "value")
    for ((k, v) in map) {
        println("$k---$v")
    }
}