package com.kymjs.project11

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.LinearLayout
import android.widget.TextView

/**
 * Created by ZhangTao on 18/7/24.
 */

const val COUNT = 50

class DemoAdapter(val context: Context) : BaseAdapter() {

    val list = arrayListOf(COUNT)
    val recycler = RecycleBin(context, R.layout.item)

    init {
        repeat(COUNT) {
            list.add((Math.random() * 10).toInt())
        }
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var itemView = convertView
        val holder: ViewHolder

        if (itemView == null) {
            itemView = View.inflate(context, R.layout.list_item, null)
            holder = ViewHolder()
            itemView?.setTag(holder)
            holder.textView = itemView?.findViewById(R.id.title)
            holder.content = itemView?.findViewById(R.id.content)
        } else {
            holder = itemView.getTag() as ViewHolder
        }

        val itemSize = list[position]
        holder.textView?.text = itemSize.toString()
        holder.content?.childCount?.let {
            if (itemSize > it) {
                repeat(itemSize - it) {
                    holder.content?.addView(recycler.borrow())
                }
            } else if (itemSize < it) {
                repeat(it - itemSize) {
                    holder.content?.getChildAt(it)?.let {
                        recycler.recycle(it)
                        holder.content?.removeView(it)
                    }
                }
            }
        }

        for (index in 0..itemSize) {
            holder.content?.getChildAt(index)?.findViewById<TextView>(R.id.text)?.text = index.toString()
        }

        return itemView!!
    }

    override fun getItem(position: Int): Any = position

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getCount(): Int = COUNT


    class ViewHolder {
        var textView: TextView? = null
        var content: LinearLayout? = null
    }
}