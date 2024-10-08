package com.example.b1906314_buichihai_n02

import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.b1906314_buichihai.MyData
import com.example.b1906314_buichihai_n02.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var helper: MyData
    lateinit var db: SQLiteDatabase
    lateinit var rs: Cursor
    var selectedId = 0
    val items = ArrayList<MyAndroid>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)





        binding.RVB1906314.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        val adapter = MyAndroidRVAdapter(this, items)
        binding.RVB1906314.adapter = adapter

    }

    private fun updateData() {
        selectedId = rs.getString(0).toInt()
        binding .setText(rs.getString(1))
        binding.edtEmailB1906314.setText(rs.getString(2))
        binding.edtSoDTB1906314.setText(rs.getString(3))
        binding.tvTotalB1906314.setText("Total: ${rs.count} users_b1906314")
    }
}