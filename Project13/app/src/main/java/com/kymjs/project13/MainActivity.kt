package com.kymjs.project13

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.kymjs.project13.unit3.JavaCode
import com.kymjs.project13.unit3.Task
import com.kymjs.project13.unit3.UI
import com.kymjs.project13.unit3.start
import com.kymjs.project13.unit4.test

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(test(this))
        start()
    }

    fun button1(v: View) {
        JavaCode.async(object : Task() {
            override fun run() {
                println("task==========${Thread.currentThread().name}")
                Thread.sleep(1000)
            }
        })
    }

    fun button2(v: View) {
        JavaCode.ui(object : UI() {
            override fun run() {
                println("ui==========${Thread.currentThread().name}")
            }
        })
    }
}
