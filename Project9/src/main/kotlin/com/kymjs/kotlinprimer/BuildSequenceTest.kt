package com.kymjs.kotlinprimer

import kotlin.coroutines.experimental.buildSequence

/**
 * Created by ZhangTao on 18/7/12.
 */

// inferred type is Sequence<Int>
val fibonacci = buildSequence {
    yield(1) // first Fibonacci number
    var cur = 1
    var next = 1
    while (true) {
        yield(next) // next Fibonacci number
        val tmp = cur + next
        cur = next
        next = tmp
    }
}

// 1. yield 可以按需调用，无限的返回数据，
//     yield 非常适合一些在无法预知终止条件的场景，比如直接读已经写好的本地文本，每次读一条
//     现在很多手机现在都有一种假装打电话的功能，你可以提前编辑好手机里要说的内容和每段内容的间隔，
//     手机自动响起来，你就可以跟手机对话了，这种场景就非常适合。

fun main(args: Array<String>) {
    fibonacci.take(100).iterator().forEach {
        print("$it ")
    }
}
