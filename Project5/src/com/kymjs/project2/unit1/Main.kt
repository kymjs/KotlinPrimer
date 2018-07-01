package com.kymjs.project2.unit1

/**
 * Created by ZhangTao on 18/6/5.
 */


interface ITimePrinter {
    val time: Long
        get() = System.currentTimeMillis()

    fun printTime();
}


class TimePrinter : ITimePrinter {
    override fun printTime() {
        println(time)
    }
}

fun main(args: Array<String>) {
    val timePrinter = TimePrinter()
    for (i in 0..10) {
        Thread.sleep(1000)
        timePrinter.printTime()
    }
}

