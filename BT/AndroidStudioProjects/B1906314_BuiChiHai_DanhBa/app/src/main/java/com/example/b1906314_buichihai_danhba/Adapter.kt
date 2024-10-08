package com.example.b1906314_buichihai_danhba

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class Adapter(private val dataset: ArrayList<Result>): RecyclerView.Adapter<Adapter.ViewHolder>() {
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val tvEmail: TextView
        val tvTen: TextView
        val tvAddress: TextView
        val tvPhone: TextView
        val img : ImageView
        init {
            tvEmail = view.findViewById(R.id.Email_b1906314)
            tvTen = view.findViewById(R.id.Name_b1906314)
            tvAddress = view.findViewById(R.id.Address_b1906314)
            tvPhone = view.findViewById(R.id.Phone_b1906314)
            img = view.findViewById(R.id.image1_b1906314)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_activity_items, null)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvTen.setText(dataset[position].name.title + ". "+dataset[position].name.first + " " + dataset[position].name.last)
        holder.tvEmail.setText(dataset[position].email)
        holder.tvPhone.setText(dataset[position].phone)

        holder.tvAddress.setText(dataset[position].location.city)
        Glide.with(holder.itemView.context).load(dataset[position].picture.thumbnail).circleCrop().into(holder.img)
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, ContactActivity::class.java)
            intent.putExtra("name", dataset[position].name.first)
            intent.putExtra("email", dataset[position].email)
            intent.putExtra("phone", dataset[position].phone)
            intent.putExtra("city", dataset[position].location.city)
            intent.putExtra("img", dataset[position].picture.thumbnail)
            holder.itemView.context.startActivity(intent)
        }
    }
}