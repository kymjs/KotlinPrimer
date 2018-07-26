package com.kymjs.kotlinprimer.unit4

/**
 * Created by ZhangTao on 18/7/6.
 */

fun main(args: Array<String>) {
    for (i in 1..100 step 20) {
        print("$i " + "str")
    }

    for (i in 1.rangeTo(100) step 20) {
        print("$i ")
    }
}
