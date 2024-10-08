package com.example.b1906314_bai_tuan_7


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.b1906314_bai_tuan_7.databinding.ActivityQuizBinding


class Quiz_Activity: AppCompatActivity() {

    lateinit var binding: ActivityQuizBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityQuizBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnButton.setOnClickListener {
            if(binding.editName.text?.isEmpty() == true){
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_LONG).show()
            }
            else{
                val intent = Intent(this, Quiz_Activity_1::class.java)
                intent.putExtra("username", binding.editName.text?.toString())
                startActivity(intent)
            }

        }

    }
}