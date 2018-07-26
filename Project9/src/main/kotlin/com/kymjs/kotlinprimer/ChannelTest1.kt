package com.kymjs.kotlinprimer

import kotlinx.coroutines.experimental.channels.Channel
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking

/**
 * Created by ZhangTao on 18/7/13.
 */
fun main(args: Array<String>) = runBlocking {
    val c = Channel<Int>()
    launch {
        get(c)
    }
    launch {
        put(c)
    }
    Unit
}

suspend fun get(channel: Channel<Int>) {
    while (true) {
        println(channel.receive())
    }
}

suspend fun put(channel: Channel<Int>) {
    var i = 0
    while (true) {
        channel.send(i++)
    }
}
