package com.example.b1906314_bai_tuan_7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.b1906314_bai_tuan_7.databinding.ActivityQuiz4Binding

class Quiz_Activity_4 : AppCompatActivity() {

    lateinit var binding: ActivityQuiz4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityQuiz4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = intent.getStringExtra(Constants.USER_NAME)
        val total = intent.getIntExtra(Constants.TOTAL_QUES, 0)
        val corr = intent.getIntExtra(Constants.CORRECT_ANS, 0 )

        binding.tvScore.text = "Your score is $corr out of $total"
        binding.tvName.text = username
        binding.btnFinish.setOnClickListener{
            startActivities(arrayOf(Intent(this, Quiz_Activity::class.java)))
        }
    }
}