package com.kymjs.kotlinprimer

import kotlinx.coroutines.experimental.*

/**
 * Created by ZhangTao on 18/7/15.
 */

fun main(args: Array<String>) = runBlocking<Unit> {

    val job = launch() {
        println("launch..." + Thread.currentThread().name)
    }

    val job2 = async(CommonPool) {
        delay(500L)
        println("async..." + Thread.currentThread().name)
        return@async "hello"
    }

    println("job2的输出：" + job2.await())
    delay(1300L)
}
