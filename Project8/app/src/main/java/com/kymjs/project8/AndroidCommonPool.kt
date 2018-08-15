package com.kymjs.project8

import android.os.AsyncTask
import kotlinx.coroutines.experimental.CoroutineDispatcher
import kotlinx.coroutines.experimental.Runnable
import kotlin.coroutines.experimental.CoroutineContext

/**
 * Created by ZhangTao on 18/7/11.
 */
object AndroidCommonPool : CoroutineDispatcher() {
    override fun dispatch(context: CoroutineContext, block: Runnable) {
        AsyncTask.THREAD_POOL_EXECUTOR.execute(block)
    }
}