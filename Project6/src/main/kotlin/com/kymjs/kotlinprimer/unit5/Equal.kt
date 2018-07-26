package com.kymjs.kotlinprimer.unit5

/**
 * Created by ZhangTao on 18/7/7.
 */

fun main(s: Array<String>) {

    val string = "string"
//    val javaString = String("string")
    val newString = StringBuilder("string").toString()
    val newString2 = String("string".toByteArray())

    println(string === newString)
    println(string == newString)
    println(string === newString2)
    println(string == newString2)
}