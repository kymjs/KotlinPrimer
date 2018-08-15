package com.kymjs.project13.unit4

import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.kymjs.project13.MainActivity
import com.kymjs.project13.R.layout.activity_main


/**
 * 返回R.layout.activity_main对应的 View，并设置监听
 */
fun test(context: MainActivity) =
        with(View.inflate(context, activity_main, null) as ViewGroup) {
            repeat(childCount) {
                with(getChildAt(it) as Button) {
                    apply { text = "button$it" }
                            .setOnClickListener {
                                takeIf { it == getChildAt(0) }?.run {
                                    MainActivity::button1.invoke(context, it)
                                } ?: let {
                                    MainActivity::button2.invoke(context, it)
                                }
                            }
                }
            }
            this
        }


fun test2() {
    My name `is`
    Zhang { Tao }
}

val My = "My"
val `is` = "is"
val Zhang = "Zhang"
val Tao = "Tao"

infix fun String.name(str: String) = "$this name$str"

inline operator fun String.invoke(block: () -> Any) {
    print(this)
    print(" ")
    println(block.invoke())
}
