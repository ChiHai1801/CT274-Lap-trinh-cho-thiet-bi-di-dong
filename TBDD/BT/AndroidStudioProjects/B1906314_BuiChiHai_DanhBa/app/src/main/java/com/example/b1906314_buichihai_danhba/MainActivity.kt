package com.example.b1906314_buichihai_danhba


import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.b1906314_buichihai_danhba.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.awaitResponse
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        binding.RVB1906314.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        CoroutineScope(Dispatchers.IO).launch {
            getQuotes();
        }
    }

    suspend fun getQuotes() {
        val contact = Retrofit.Builder()
            .baseUrl("https://randomuser.me/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(Interface::class.java)
        val response = contact.getQuotes().awaitResponse()
        val data = response.body()!!
        Log.i("ctu: size", data.results.size.toString())
        withContext(Dispatchers.Main) {
            binding.RVB1906314.visibility = View.VISIBLE
            var adapter = Adapter(data.results)
            binding.RVB1906314.adapter = adapter
        }
    }
}