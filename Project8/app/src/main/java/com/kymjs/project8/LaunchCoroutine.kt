package com.kymjs.project8

import android.widget.TextView
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking
import okhttp3.OkHttpClient
import okhttp3.Request
import java.net.URL

/**
 * Created by ZhangTao on 18/7/8.
 */

// 用于执行协程任务
fun launchCoroutine1() = launch {

}

// 用于执行协程任务， 通常只用于启动最外层协程
fun launchCoroutine2() = runBlocking {

}

// 用于执行协程任务，并得到执行结果
fun launchCoroutine3() = async {

}


private val mOkHttpClient = OkHttpClient()
private val mRequest = Request.Builder().url("https://baidu.com").get().build()

fun displayDashboard(textView: TextView) = runBlocking {
    launch(UI) {
        val job = async(AndroidCommonPool) {
            //不考虑异常的情况
            mOkHttpClient.newCall(mRequest).execute().body()?.string()
        }
        textView.text = job.await()
    }
}


//suspend,  被suspend修饰的函数只能被有 suspend 修饰的函数调用
//因为suspend修饰的函数(或lambda)被编译后会多一个参数类型叫Continuation，
//协程的异步调用本质上就是一次回调
suspend fun getHtml(): String {
    return async(AndroidCommonPool) { URL("http://baidu.com").readText() }.await()
}