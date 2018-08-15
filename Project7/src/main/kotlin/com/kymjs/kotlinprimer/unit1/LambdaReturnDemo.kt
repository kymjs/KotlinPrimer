package com.kymjs.kotlinprimer.unit1

/**
 * Created by ZhangTao on 18/7/8.
 */

val runnable = Runnable {
    println("runnable")
}

fun main(args: Array<String>) {
    test1 {
        println("hello")
        return@test1
        println("hello1")
    }
    println("hello2")

    test2({
        println("hello")
    }, runnable::run)
}

inline fun test1(crossinline l: () -> Unit) {
    l.invoke()
    return
}

inline fun test2(l0: () -> Unit, noinline l1: () -> Unit): () -> Unit {
    l0.invoke()
    l1.invoke()
    println("test2")
    return l1
}
