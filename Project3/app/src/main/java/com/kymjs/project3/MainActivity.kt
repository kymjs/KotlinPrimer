package com.kymjs.project3

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.kymjs.project3.unit1.TestView


open class MainActivity : View.OnClickListener, AppCompatActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<View>(R.id.textview).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        TestView(this)
    }
}
