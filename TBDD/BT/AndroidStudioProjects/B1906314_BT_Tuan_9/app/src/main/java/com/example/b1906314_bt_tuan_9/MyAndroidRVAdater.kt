package com.example.b1906314_bt_tuan_9

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAndroidRVAdapter(val context: Context, val items: ArrayList<MyAndroid>) :
    RecyclerView.Adapter<MyAndroidRVAdapter.MyAndroidViewHolder>() {

    class MyAndroidViewHolder(val view: View): RecyclerView.ViewHolder(view){
        fun binding(item: MyAndroid){
            val ivImage = view.findViewById<ImageView>(R.id.rv_iv_image)
            val tvName = view.findViewById<TextView>(R.id.rv_tv_name)
            val tvDescription = view.findViewById<TextView>(R.id.rv_tv_dec)

            ivImage.setImageResource(item.image)
            tvName.text = item.name
            tvDescription.text = item.description
        }
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyAndroidRVAdapter.MyAndroidViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return MyAndroidViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyAndroidRVAdapter.MyAndroidViewHolder, position: Int) {
        holder.binding(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

}
