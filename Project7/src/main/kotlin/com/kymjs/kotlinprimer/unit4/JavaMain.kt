package com.kymjs.kotlinprimer.unit4

/**
 * Created by ZhangTao on 18/7/14.
 */
object JavaMain {

    @JvmStatic
    fun main(args: Array<String>) {
        test("")
        test2(null)
    }

    fun test(str: String) {
        println(str)
    }

    fun test2(str: String?) {
        println(str)
    }
}
