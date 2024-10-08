package com.example.demo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.demo.databinding.ActivityMainBinding
import java.util.zip.Inflater

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        addEvent()
    }

    private fun addEvent() {
        binding.btnNext.setOnClickListener {
            if (binding.edtName.text?.isEmpty() == true){
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_LONG).show()
            }else{
                val intent = Intent(this, BMI_Activity::class.java)
                intent.putExtra("username", binding.edtName.text?.toString())
                startActivity(intent)
            }
        }
    }
}