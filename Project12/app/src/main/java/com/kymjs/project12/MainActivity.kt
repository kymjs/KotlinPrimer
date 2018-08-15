package com.kymjs.project12

import android.app.ActivityManager
import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.edit
import androidx.core.content.systemService
import androidx.core.text.isDigitsOnly
import androidx.core.util.lruCache
import androidx.core.view.forEach


// https://github.com/android/android-ktx

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getSharedPreferences("key", Context.MODE_PRIVATE)
                .edit()
                .putBoolean("key", false)
                .putInt("int", 1)
                .apply()

        getSharedPreferences("key", Context.MODE_PRIVATE).edit {
            this.putBoolean("key", true)
            putInt("int", 2)
        }

        val lruCache = lruCache<String, String>(10, sizeOf = { _, _ -> 10 })

        val linearLayout = findViewById<LinearLayout>(R.id.root_layout)
        linearLayout.forEach {
            if (it is TextView) {
                it.text = "text"
            }
        }

        "13252721234.0".isDigitsOnly()

        val manager: ActivityManager = systemService()
    }
}
