package com.kymjs.project8

import android.util.Log
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import kotlin.concurrent.thread

/**
 * Created by ZhangTao on 18/7/9.
 */

fun makeThread() {
    repeat(100000) {
        thread {
            repeat(10) {
                Log.d("thread", "$it")
            }
        }
    }
}

fun makeCoroutine() {
    repeat(100000) {
        launch(UI) {
            repeat(10) {
                Log.d("coroutine", "$it")
            }
        }
    }
}
