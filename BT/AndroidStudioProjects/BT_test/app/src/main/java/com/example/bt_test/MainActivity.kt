package com.example.bt_test

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bt_test.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var alarmMng: AlarmManager
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        alarmMng = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        binding.btnTao.setOnClickListener {
            val seconds = binding.edText.text.toString().toInt() * 1000
            val intent = Intent(this, MyReceiver::class.java)
            val pendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
            alarmMng.setExact(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + seconds,pendingIntent)
            binding.tvKQ.append("\n"+Date().toString())
        }
        binding.btnUp.setOnClickListener {
            val seconds = binding.edText.text.toString().toInt() * 1000
            val intent = Intent(this, MyReceiver::class.java)
            val pendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
            alarmMng.setExact(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + seconds,pendingIntent)
            binding.tvKQ.append("\n Update:"+ Date().toString())
        }
        binding.btnHuy.setOnClickListener {
            val intent = Intent(this, MyReceiver::class.java)
            val pendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
            alarmMng.cancel(pendingIntent)
            binding.tvKQ.append("\n Cancel:"+ Date().toString())
        }
    }
}