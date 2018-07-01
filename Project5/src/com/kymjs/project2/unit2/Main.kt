package com.kymjs.project2.unit2

/**
 * Created by ZhangTao on 18/6/7.
 */
class Main {
    lateinit var name: String

    val lastName by lazy {
        println("========lazy init lastName")
        "Zhang"
    }

    fun initName() {
        name = "Zhang Tao"
    }

    fun lazySample(ok: Boolean) {
        val value: Boolean by lazy {
            println("=========lazy init value")
            true
        }

        if (ok && value) {
            println("lazySample=======")
        }
    }
}

fun main(args: Array<String>) {
    val o = Main()
    o.initName()
    println("name is ${o.name}")
    println("last name is " + o.lastName)
    o.lazySample(true)
    o.lazySample(true)
}