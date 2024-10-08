package com.example.b1906314_buichihai_danhba

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.b1906314_buichihai_danhba.databinding.ActivityContactBinding

class ContactActivity : AppCompatActivity() {
    lateinit var binding: ActivityContactBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra("name")
        val email = intent.getStringExtra("email")
        val city = intent.getStringExtra("city")
        val phone = intent.getStringExtra("phone")


        val img = intent.getStringExtra("img")
        Glide.with(this).load(img).circleCrop().into(binding.image2B1906314)

        binding.tvHotenB1906314.text = name
        binding.tvEmailB1906314.text = email
        binding.tvAddressB1906314.text = city
        binding.tvPhoneB1906314.text = phone
    }
}