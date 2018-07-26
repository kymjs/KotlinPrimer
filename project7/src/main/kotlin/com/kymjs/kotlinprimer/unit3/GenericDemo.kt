package com.kymjs.kotlinprimer.unit3

/**
 * Created by ZhangTao on 18/7/8.
 */
class Test<T> where T : Callback, T : Runnable {
    fun add(t: T) {
        t.run()
        t.callback()
    }
}

open class A : Runnable {
    override fun run() {
        println("run")
    }
}

class B : Callback, A() {
    override fun callback() {
        println("callback")
    }
}

interface Callback {
    fun callback()
}

fun main(args: Array<String>) {
    val test = Test<B>()
    test.add(B())
}
