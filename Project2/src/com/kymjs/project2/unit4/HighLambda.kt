package com.kymjs.project2.unit4


/**
 * Created by ZhangTao on 18/6/11.
 */

inline fun onlyif(isDebug: Boolean, block: () -> Unit) {
    if (isDebug) block()
}

fun main(args: Array<String>) {

    val runnable = Runnable {
        println("Runnable::run")
    }

    val function: () -> Unit

    function = runnable::run

    onlyif(true, function)
}