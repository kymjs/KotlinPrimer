package com.kymjs.kotlinprimer.unit2

/**
 * Created by ZhangTao on 18/7/1.
 */

fun main(args: Array<String>) {
//    val a = arrayOf("4", "0", "7", "i", "f", "w", "0", "9")
//    val index = arrayOf(5, 3, 9, 4, 8, 3, 1, 9, 2, 1, 7)
//
//    index
//            .filter {
//                it < a.size
//            }
//            .map {
//                a[it]
//            }
//            .reduce { s, s1 ->
//                "$s$s1"
//            }
//            .also {
//                println("密码是：$it")
//            }
    myOperator()
}

fun myOperator() {
    val list: List<Int> = listOf(1, 2, 3, 4, 5)
    list.convert {
        it + 1
    }.forEach {
        print(it)
    }
}

inline fun <T, E> Iterable<T>.convert(action: (T) -> E): Iterable<E> {
    val list: MutableList<E> = mutableListOf()
    for (item in this) list.add(action(item))
    return list
}