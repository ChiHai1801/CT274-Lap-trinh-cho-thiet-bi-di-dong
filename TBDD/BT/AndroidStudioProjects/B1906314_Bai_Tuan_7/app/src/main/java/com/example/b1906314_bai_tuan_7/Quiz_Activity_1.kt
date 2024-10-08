package com.example.b1906314_bai_tuan_7

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.b1906314_bai_tuan_7.databinding.ActivityQuiz1Binding

class Quiz_Activity_1 : AppCompatActivity() {
    private var currenPosition: Int = 1
    private var quesList: ArrayList<Question>? = null
    private var selectdOpt: Int = 0
    private var correctAns: Int = 0
    private var userName: String? = null

    lateinit var binding: ActivityQuiz1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuiz1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        userName = intent.getStringExtra(Constants.USER_NAME)
        quesList = Constants.getQuestion()
        binding.progressBar.max = quesList?.size!!
        correctAns = 0
        selectdOpt = 0
        currenPosition = 1
        setQuestion()

        binding.tvOpt1.setOnClickListener { setSelectedAns(binding.tvOpt1, 1) }
        binding.tvOpt2.setOnClickListener { setSelectedAns(binding.tvOpt2, 2) }
        binding.tvOpt3.setOnClickListener { setSelectedAns(binding.tvOpt3, 3) }
        binding.tvOpt4.setOnClickListener { setSelectedAns(binding.tvOpt4, 4) }

        binding.btnNext.setOnClickListener { onSubmit() }

    }

    private fun onSubmit() {
        if (selectdOpt == 0) {
            currenPosition++
            if (currenPosition <= quesList!!.size) {
                setQuestion()
            } else {
                val intent = Intent(this, Quiz_Activity_4::class.java)
                intent.putExtra(Constants.USER_NAME, userName)
                intent.putExtra(Constants.CORRECT_ANS, correctAns)
                intent.putExtra(Constants.TOTAL_QUES, quesList!!.size)
                startActivities(arrayOf(intent))
                finish()
            }
        } else {
            val question = quesList?.get(currenPosition - 1)
            if (question!!.correct != selectdOpt) {
                ansView(selectdOpt, R.color.red)
            } else {
                correctAns++
            }
            ansView(question!!.correct, R.color.Green)
            if (currenPosition == quesList!!.size) {
                binding.btnNext.text = "FINSH"
            } else {
                binding.btnNext.text = "GO TO THE NEXT QUESTION"
            }
            selectdOpt = 0
        }


    }

    private fun ansView(selected: Int, bg: Int) {
        when (selected) {
            1 -> {
                binding.tvOpt1.setBackgroundResource(bg)
            }
            2 -> {
                binding.tvOpt2.setBackgroundResource(bg)
            }
            3 -> {
                binding.tvOpt3.setBackgroundResource(bg)
            }
            4 -> {
                binding.tvOpt4.setBackgroundResource(bg)
            }
        }
    }

    private fun setSelectedAns(view: TextView, i: Int) {
        setDefaultOpt()
        selectdOpt = i
//        view.setTextColor(Color.parseColor("363A43"))
        view.setTypeface(view.typeface, Typeface.BOLD)
        //  view.setBackgroundResource(R.color.purple_200)
    }


    private fun setQuestion() {
        setDefaultOpt()
        val question: Question = quesList!![currenPosition - 1]
        binding.progressBar.progress = currenPosition
        binding.tvProgressBar.text= "$currenPosition/${binding.progressBar.max}"
        binding.tvQues.text = question.question
        binding.tvOpt1.text = question.opt1
        binding.tvOpt2.text = question.opt2
        binding.tvOpt3.text = question.opt3
        binding.tvOpt4.text = question.opt4
        binding.ivImg.setImageResource(question.img)

        if (currenPosition == quesList!!.size) {
            binding.btnNext.text = "FINSH"
        } else {
            binding.btnNext.text = "SUBMIT"
        }
    }

    private fun setDefaultOpt() {
        val opt = ArrayList<TextView>()
        opt.add(binding.tvOpt1)
        opt.add(binding.tvOpt2)
        opt.add(binding.tvOpt3)
        opt.add(binding.tvOpt4)
        for (opt in opt) {
            opt.setBackgroundResource(R.color.white)
            opt.typeface = Typeface.DEFAULT
            opt.setTextColor(Color.parseColor("#7a8089"))
        }

    }

}