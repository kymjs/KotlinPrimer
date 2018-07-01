package com.kymjs.project3.unit1

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView

/**
 * Created by ZhangTao on 18/6/12.
 */
class TestView : TextView {
    constructor(context: Context) : super(context) {
        println("constructor")
    }

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

}
