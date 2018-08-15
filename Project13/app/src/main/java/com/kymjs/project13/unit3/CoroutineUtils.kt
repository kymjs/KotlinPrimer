package com.kymjs.project13.unit3

import android.os.AsyncTask
import kotlinx.coroutines.experimental.CoroutineDispatcher
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.channels.Channel
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

val channel = Channel<Runnable>(1)

abstract class Task : Runnable
abstract class UI : Runnable

suspend fun async(task: Task) {
    channel.send(task)
}

suspend fun ui(task: UI) {
    channel.send(task)
}

fun start() {
    launch(AndroidCommonPool) {
        while (true) {
            val t = channel.receive()
            when (t) {
                is UI -> {
                    launch(UI) { t.run() }
                }
                is Task -> {
                    t.run()
                }
            }
        }
    }
}

object AndroidCommonPool : CoroutineDispatcher() {
    override fun dispatch(context: CoroutineContext, block: Runnable) {
        AsyncTask.THREAD_POOL_EXECUTOR.execute(block)
    }
}