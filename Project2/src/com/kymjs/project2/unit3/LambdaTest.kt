package com.kymjs.project2.unit3

/**
 * Created by ZhangTao on 18/6/11.
 */

val print = { name: String ->
    println(name)
}

val lambdaA = { a: Int, b: Int, c: Int, d: Int, e: Int, f: Int, g: Int, h: Int,
                i: Int, j: Int, k: Int, l: Int, m: Int, n: Int, o: Int, p: Int,
                q: Int, r: Int, s: Int, t: Int, u: Int, v: Int, w: Int ->
    println("zhang tao")
}

fun main(args: Array<String>) {
//    print("hello")
    lambdaA(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1)
}
