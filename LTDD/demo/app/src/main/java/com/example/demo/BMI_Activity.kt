package com.example.demo

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterViewAnimator
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.demo.databinding.ActivityBmiBinding

class BMI_Activity : AppCompatActivity() {
    lateinit var binding: ActivityBmiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBmiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        addEvent()
    }

    private fun addEvent() {
        val options =
            arrayOf("Weight in Kg & Height in Cm", "Weight in Pounds (lb) & Height in Inch (in)")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, options)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spn.adapter = adapter

        binding.spn.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                val selected = options[position]
                Toast.makeText(this@BMI_Activity, "you selected $selected", Toast.LENGTH_LONG)
                    .show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }


        val options1 =
            arrayOf("Male", "Female", "Unknown")
        val adapter1 = ArrayAdapter(this, android.R.layout.simple_spinner_item, options1)
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spnGender.adapter = adapter1

        binding.spnGender.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                val selected = options1[position]
                Toast.makeText(this@BMI_Activity, "you selected $selected", Toast.LENGTH_LONG)
                    .show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }

        binding.btnReset.setOnClickListener {
            binding.spn.setSelection(0)
            binding.edtAge.setText("")
            binding.spnGender.setSelection(0)
            binding.edtWeight.setText("")
            binding.edtHeight.setText("")
            binding.tvName.setText("")
            binding.tvAge.setText("")
            binding.tvGender.setText("")
            binding.tvResul.setText("")
            binding.tvCategory.setText("")
        }

        binding.btnBack.setOnClickListener {
            startActivities(arrayOf(Intent(this, MainActivity::class.java)))
        }

        binding.btnCalculte.setOnClickListener {
            val age =binding.edtAge.text.toString()
            val gender = binding.spnGender.selectedItem.toString()
            val position = binding.spn.selectedItemPosition.toString().toInt()
            var height = binding.edtHeight.text.toString().toInt()
            var weight = binding.edtHeight.text.toString().toInt()
            var kq = 0.2f

            binding.tvAge.setText(age)
            binding.tvGender.setText(gender)

            if(position == 0){
                var temp = height.toDouble() /100
                kq = (weight / (temp * temp)).toFloat()
            }else{
                kq = 703 * (weight.toFloat()) / (height * height).toFloat()
            }
            binding.tvResul.setText(kq.toString())
            if(kq<16){
                binding.tvCategory.setText("Severe Thinness")
            }else if (kq>16 && kq<=17 ){
                binding.tvCategory.setText("Moderate Thinness")
            }else if (kq>17 && kq<=18.5 ){
                binding.tvCategory.setText("Mild Thinness")
            }else if (kq>18.5 && kq<=25 ){
                binding.tvCategory.setText("Normal")
            }else if (kq>25 && kq<=30 ){
                binding.tvCategory.setText("Overweight")
            }else if (kq>30 && kq<=35 ){
                binding.tvCategory.setText("Obese Class I")
            }else if (kq>35 && kq<=40 ){
                binding.tvCategory.setText("Obese Class II")
            }else if (kq>40 ){
                binding.tvCategory.setText("Obese Class III")
            }

        }
    }
}