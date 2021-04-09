package com.kymjs.kotlinprimer.unit3

import com.google.gson.Gson

/**
 * Created by ZhangTao on 18/7/8.
 */
inline fun <reified T> Gson.fromJson(json: String): T {
    return fromJson(json, T::class.java)
}

class View<T>(val clazz: Class<T>) {
    val presenter by lazy { clazz.newInstance() }

    companion object {
        inline operator fun <reified T> invoke() = View(T::class.java)
    }
}

class Presenter {
    override fun toString(): String {
        return "presenter"
    }
}

fun main(args: Array<String>) {
    val b = View<Presenter>().presenter
    
    val a = View.Companion.invoke<Presenter>().presenter
    println(a)
    println(b)
}