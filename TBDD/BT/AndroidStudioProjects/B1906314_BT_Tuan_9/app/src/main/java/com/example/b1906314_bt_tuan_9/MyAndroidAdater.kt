package com.example.b1906314_bt_tuan_9

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class MyAndroidAdater(val context: Context, val items: ArrayList<MyAndroid>) :
BaseAdapter()
{
    override fun getCount(): Int {
       return items.size
    }

    override fun getItem(p0: Int): Any? {
        return null
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getView(i: Int, p1: View?, p2: ViewGroup?): View {
        val view = LayoutInflater.from(context).inflate(R.layout.spinner_item, null)
        val icon = view.findViewById<ImageView>(R.id.iv_spinner)
        val name = view.findViewById<TextView>(R.id.tv_spinner)
        icon.setImageResource(items[i].image)
        name.text = items[i].name
        return view
    }

}
