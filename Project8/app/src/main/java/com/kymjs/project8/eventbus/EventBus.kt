package com.kymjs.project8.eventbus

import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.channels.Channel
import kotlinx.coroutines.experimental.launch

/**
 * Created by ZhangTao on 18/7/13.
 */

//时间缓存池
var map = mutableMapOf<String, Channel<Any>>()

inline fun <reified T> T.post() {
    if (!map.containsKey(T::class.java.name)) {
        map.put(T::class.java.name, Channel())
    }

    launch(CommonPool) {
        map[T::class.java.name]?.send(this@post as Any)
    }
}

inline fun <T, reified R> T.onEvent(noinline action: suspend (R) -> Unit) {
    if (!map.containsKey(R::class.java.name)) {
        map.put(R::class.java.name, Channel())
    }
    launch(CommonPool) {
        val receive = map[R::class.java.name]?.receive()
        launch(UI) {
            action.invoke(receive as R)
        }
    }
}


//发送者.post("event")
//"event".post()

//接受者 onEvent(event:String)
