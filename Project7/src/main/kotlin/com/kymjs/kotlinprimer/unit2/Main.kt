package com.kymjs.kotlinprimer.unit2

/**
 * Created by ZhangTao on 18/7/14.
 */
fun main(args: Array<String>) {

    val hello = Hello()
    println(hello.string2)
    hello.string = "world"
    println(hello.string2)
}

class Hello {
    var string: String? = null
        get() {
            return field + "hello"
        }
        set(value) {
            field = value + "set"
        }
    
    val string2: String? = null
        get() {
            return field + "hello"
        }
}