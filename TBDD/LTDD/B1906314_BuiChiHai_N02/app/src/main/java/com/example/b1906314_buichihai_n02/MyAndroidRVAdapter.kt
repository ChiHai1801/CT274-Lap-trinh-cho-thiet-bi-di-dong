package com.example.b1906314_buichihai_n02

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAndroidRVAdapter(val context: Context, val items: ArrayList<MyAndroid>) :
    RecyclerView.Adapter<MyAndroidRVAdapter.MyAndroidViewHolder>() {

    class MyAndroidViewHolder(val view: View): RecyclerView.ViewHolder(view){
        fun binding(item: MyAndroid){
            val HoTen = view.findViewById<TextView>(R.id.HoTen)
            val Gtinh = view.findViewById<TextView>(R.id.Gtinh)
            val Lop = view.findViewById<TextView>(R.id.Lop)
            val Diem = view.findViewById<TextView>(R.id.Diem)

            HoTen.text = item.Ten
            Gtinh.text = item.Gtinh
            Lop.text = item.lop
            Diem.text = item.diem
        }
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyAndroidRVAdapter.MyAndroidViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.qly_items, parent, false)
        return MyAndroidViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyAndroidRVAdapter.MyAndroidViewHolder, position: Int) {
        holder.binding(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

}


