package com.kymjs.kotlinprimer.unit1

/**
 * Created by ZhangTao on 18/7/1.
 */
class User(var age: Int, var name: String) {
    operator fun component1() = age
    operator fun component2() = name
    operator fun component3() = name
}
