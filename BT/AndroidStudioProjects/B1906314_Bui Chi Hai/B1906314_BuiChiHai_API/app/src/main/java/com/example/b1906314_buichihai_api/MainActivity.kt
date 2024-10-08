package com.example.b1906314_buichihai_api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.b1906314_buichihai_api.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.awaitResponse
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val api = Retrofit.Builder()
            .baseUrl("https://catfact.ninja/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(ApiRequests::class.java)

        GlobalScope.launch(Dispatchers.IO) {
            val response = api.getFact().awaitResponse()
            if (response.isSuccessful){
                val data = response.body()!!
                withContext(Dispatchers.Main){
                    binding.pbB1906314.visibility = View.GONE
                    binding.tvFactB1906314.text = data.fact
                    binding.tvLengthB1906314.text = data.length.toString()
                }
            }
        }
    }
}