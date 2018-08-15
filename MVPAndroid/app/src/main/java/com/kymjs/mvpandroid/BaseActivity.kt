package com.kymjs.mvpandroid

import android.support.v7.app.AppCompatActivity

open class BaseActivity<T>(val clazz: Class<T>) : AppCompatActivity() {
    val presenter by lazy { clazz.newInstance() }

    companion object {
        inline operator fun <reified T> invoke() = BaseActivity(T::class.java)
    }
}