package com.kymjs.kotlinprimer.unit2

/**
 * Created by ZhangTao on 18/7/8.
 */

const val a = 0
const val a1 = ""

fun main(args: Array<String>) {
    val person = Person(1990)
    println(person.age)
    person.oneYearsLater()
    println(person.age)
}

class A {
    companion object {
        const val s = 0
    }

    var num: Int = 0
        set(value) {
            field = value + 1
        }
}