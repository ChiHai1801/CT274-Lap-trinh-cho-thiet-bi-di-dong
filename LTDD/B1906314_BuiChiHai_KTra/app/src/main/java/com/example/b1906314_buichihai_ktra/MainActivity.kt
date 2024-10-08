package com.example.b1906314_buichihai_ktra

import android.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.b1906314_buichihai_ktra.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        addEvents()


    }

    private fun addEvents() {
        binding.btnButtonB1906314.setOnClickListener {
            if(binding.editNameB1906314.text?.isEmpty() == true){
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_LONG).show()
            }
            else{
                val intent = Intent(this, BMI_Activity::class.java)
                intent.putExtra("username", binding.editNameB1906314.text?.toString())
                startActivity(intent)
            }

        }
    }

}