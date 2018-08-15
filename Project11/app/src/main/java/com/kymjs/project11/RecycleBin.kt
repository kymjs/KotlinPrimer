package com.kymjs.project11

import android.content.Context
import android.view.View
import kotlinx.io.pool.DefaultPool


/**
 * Created by ZhangTao on 18/7/23.
 */
class RecycleBin(val context: Context, val id: Int) : DefaultPool<View>(COUNT) {
    public override fun produceInstance() = View.inflate(context, id, null)
}
