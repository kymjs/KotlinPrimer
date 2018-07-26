package com.kymjs.project8

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.kymjs.project8.eventbus.onEvent
import com.kymjs.project8.eventbus.post


// 1. 启动协程
// 2. 常用的三种方式，参数与返回值
// 3. 协程的轻量性
// 4. 协程的语法糖
// 5. build->intermediates->transforms->dexMerger->dex
// 6. kotlin-android
// 7. suspend / Continuation 
// 8. 在java中调用suspend function 
// 9. CoroutineImpl 
// 10. buildSequence
// 11. channel
// 12. eventbus
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        onEvent { str: String ->
            println(str)
        }
    }

    fun test1(v: View) {
        "按钮1".post()
    }

    fun test2(v: View) {
        "点击了按钮2".post()
    }

    fun test3(v: View) {
    }


// kotlin官方提供的利用channel实现view的onclick方法
//    fun View.onClick(action: suspend (View) -> Unit) {
//        val eventActor = actor<View>(UI) {
//            for (event in channel) action(event)
//        }
//        setOnClickListener {
//            eventActor.offer(it)
//        }
//    }
}
