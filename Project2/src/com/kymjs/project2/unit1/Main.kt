package com.kymjs.project2.unit1

import java.io.File

/**
 * Created by ZhangTao on 18/6/5.
 */

fun main(args: Array<String>) {
    val file = File("Project2.iml")
    println(file.readText())
}

