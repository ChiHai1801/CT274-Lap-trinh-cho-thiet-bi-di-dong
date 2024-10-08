package com.example.b1906314_buichihai_n02

import android.content.ContentValues
import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.b1906314_buichihai.MyData
import com.example.b1906314_buichihai_n02.databinding.ActivityQlyBinding

class Qly_Activity : AppCompatActivity() {
    lateinit var binding: ActivityQlyBinding
    lateinit var helper: MyData
    lateinit var db: SQLiteDatabase
    lateinit var rs: Cursor
    var selectedId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityQlyBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        addEvent()
    }

    private fun addEvent() {

        // nút button trở về giao diện MainActivity
        binding.btnTroVeB1906314.setOnClickListener {
            startActivities(arrayOf(Intent(this, MainActivity::class.java)))
        }

        binding.btnLuuB1906314.setOnClickListener {
            val cv = ContentValues()
            cv.put("ten", binding.edtHoTenB1906314.text.toString())
            cv.put("email", binding.editEmailB1906314.text.toString())
            cv.put("gioitinh", binding.rdoNamB1906314.text.toString())
            reloadData()
        }

        helper = MyData(applicationContext)
        db = helper.readableDatabase
        rs = db.rawQuery("select * from user_b1906314", null)
        if(rs.moveToFirst())
            updateData()
    }

    private fun reloadData() {
        rs = db.rawQuery("select * from user_b1906314", null)
        rs.moveToLast()
        updateData()
    }

    private fun updateData() {
        selectedId = rs.getString((0)).toInt()
        binding.edtHoTenB1906314.setText(rs.getString(1))
        binding.editEmailB1906314.setText(rs.getString(2))
        binding.rdoNamB1906314.setText(rs.getString(3))
          }
}