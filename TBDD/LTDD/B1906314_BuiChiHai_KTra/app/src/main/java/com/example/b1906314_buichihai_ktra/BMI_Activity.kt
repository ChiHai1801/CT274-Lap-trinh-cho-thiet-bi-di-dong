package com.example.b1906314_buichihai_ktra

import android.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.b1906314_buichihai_ktra.databinding.ActivityBmiBinding
import com.example.b1906314_buichihai_ktra.databinding.ActivityMainBinding
import kotlin.math.roundToInt

class BMI_Activity : AppCompatActivity() {
    lateinit var binding: ActivityBmiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBmiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        addEvents()
    }

    private fun addEvents() {
        val options =
            arrayOf("Weight in Kg & Height in Cm", "Weight in Pounds (lb) & Height in Inch (in)")
        val adapter = ArrayAdapter(this, R.layout.simple_spinner_item, options)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.SPB1906314.adapter = adapter

        binding.SPB1906314.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                val selected = options[position]
                Toast.makeText(this@BMI_Activity, "you selected $selected", Toast.LENGTH_LONG)
                    .show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }


        val options1 = arrayOf("Male", "Female", "Unknown")
        val adapter1 = ArrayAdapter(this, R.layout.simple_spinner_item, options1)
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.SpinnerGenderB1906314.adapter = adapter1

        binding.SpinnerGenderB1906314.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    p0: AdapterView<*>?,
                    p1: View?,
                    position: Int,
                    p3: Long
                ) {
                    val selected = options1[position]
                    Toast.makeText(this@BMI_Activity, "you selected $selected", Toast.LENGTH_LONG)
                        .show()
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {

                }
            }

        // reset dữ liệu
        binding.btnResetB1906314.setOnClickListener {

            binding.SPB1906314.setSelection(0)
            binding.SpinnerGenderB1906314.setSelection(0)

            binding.etAgeB1906314.setText("")
            binding.etWeightB1906314.setText("")
            binding.etHeightB1906314.setText("")
            // binding.tvNameB1906314.setText("")
            binding.AgeeB1906314.setText("")
            binding.tvGenderB1906314.setText("")
            binding.tvResulB1906314.setText("")
            binding.tvCategoryB1906314.setText("")

        }

        binding.btnCalculateBMIB1906314.setOnClickListener {

            val age = binding.etAgeB1906314.text.toString()
            val gender = binding.SpinnerGenderB1906314.selectedItem.toString()
            val position = binding.SPB1906314.selectedItemPosition.toString().toInt()
            var weight = binding.etWeightB1906314.text.toString().toInt()
            var height = binding.etHeightB1906314.text.toString().toInt()
            var kq = 0.2f


            binding.AgeeB1906314.setText(age)
            binding.tvGenderB1906314.setText(gender)

            if (position == 0) {
                var temp = height.toDouble() / 100
                kq = (weight / (temp * temp)).toFloat()
            } else {
                kq = 703 * (weight.toFloat()) / (height * height).toFloat()

            }


            binding.tvResulB1906314.setText(kq.toString())
            if (kq < 16) {
                binding.tvCategoryB1906314.setText("Severe Thinness")
            } else if (kq > 16 && kq <= 17) {
                binding.tvCategoryB1906314.setText("Moderate Thinness")
            } else if (kq > 17 && kq <= 18.5) {
                binding.tvCategoryB1906314.setText("Mild Thinness")
            } else if (kq > 18.5 && kq <= 25) {
                binding.tvCategoryB1906314.setText("Normal")
            } else if (kq > 25 && kq <= 30) {
                binding.tvCategoryB1906314.setText("Overweight")
            } else if (kq > 30 && kq <= 35) {
                binding.tvCategoryB1906314.setText("Obese Class I")
            } else if (kq > 35 && kq <= 40) {
                binding.tvCategoryB1906314.setText("Obese Class II")
            } else if (kq > 40) {
                binding.tvCategoryB1906314.setText("Obese Class III")
            }
        }

            // Hiển thị tên
            val username = intent.getStringExtra(Constants.USER_NAME)
            binding.tvNameB1906314.text = username


            // chở về giao diện trước
            binding.btnBackB1906314.setOnClickListener {
                startActivities(arrayOf(Intent(this, MainActivity::class.java)))
            }
    }
}