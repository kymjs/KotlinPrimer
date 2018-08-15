package com.kymjs.project11

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

class MainActivity : AppCompatActivity() {

    val recycler = RecycleBin(this, R.layout.item)
    lateinit var itemView: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun test(v: View) {
        itemView = recycler.borrow()
    }

    fun test2(v: View) {
        recycler.recycle(itemView)
    }

    fun test3(v: View) {
        startActivity(Intent(this, DemoActivity::class.java))
    }
}
