package com.example.b1906314_bui_chi_hai_ct274

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.b1906314_bui_chi_hai_ct274.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var helper: MyDB
    lateinit var db: SQLiteDatabase
    lateinit var rs: Cursor
    var selectedId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        helper = MyDB(applicationContext)
        db = helper.readableDatabase
        rs = db.rawQuery("select * from users_b1906314", null)
        if (rs.moveToFirst())
            updateData()
        binding.btnBackB1906314.setOnClickListener {
            if (!rs.moveToPrevious())
                rs.moveToFirst()
            updateData()

        }

        binding.btnNextB1906314.setOnClickListener {
            if (!rs.moveToNext())
                rs.moveToFirst()
            updateData()
        }

        binding.btnDeleteB1906314.setOnClickListener {
            db.delete("users_b1906314","id=?", arrayOf(selectedId.toString()))
            reloadData()
        }

        binding.btnSaveB1906314.setOnClickListener {
            var cv = ContentValues()
            cv.put("fullname", binding.edtHoTenB1906314 .text.toString())
            cv.put("email", binding.edtEmailB1906314.text.toString())
            cv.put("phone", binding.edtSoDTB1906314.text.toString())
            db.update("users_b1906314", cv, "id=?", arrayOf(selectedId.toString()))
            reloadData()
        }

        binding.btnAddB1906314.setOnClickListener {
            val cv = ContentValues()
            cv.put("fullname", binding.edtHoTenB1906314.text.toString())
            cv.put("email", binding.edtEmailB1906314.text.toString())
            cv.put("phone", binding.edtSoDTB1906314.text.toString())
            db.insert("users_b1906314", null, cv)
            reloadData()
        }
    }

    private fun reloadData() {
        rs = db.rawQuery("select * from users_b1906314", null)
        rs.moveToLast()
        updateData()

    }

    private fun updateData() {
        selectedId = rs.getString(0).toInt()
        binding.edtHoTenB1906314.setText(rs.getString(1))
        binding.edtEmailB1906314.setText(rs.getString(2))
        binding.edtSoDTB1906314.setText(rs.getString(3))
        binding.tvTotalB1906314.setText("Total: ${rs.count} users_b1906314")
    }

    override fun onDestroy() {
        super.onDestroy()
        rs.close()

    }
}