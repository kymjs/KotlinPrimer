package com.kymjs.kotlinprimer

import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.channels.ReceiveChannel
import kotlinx.coroutines.experimental.channels.consumeEach
import kotlinx.coroutines.experimental.channels.produce
import kotlinx.coroutines.experimental.channels.take
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking


// ChannelCoroutine 的动态代理
fun put() = produce(CommonPool) {
    var i = 0
    while (true) {
        send(i++)
    }
}

fun get(channel: ReceiveChannel<Int>) = launch(CommonPool) {
    channel.take(10).consumeEach {
        println("接收到：： $it")
    }
}

fun main(args: Array<String>) = runBlocking<Unit> {
    val producer = put()
    get(producer).join()
    producer.cancel()
}
