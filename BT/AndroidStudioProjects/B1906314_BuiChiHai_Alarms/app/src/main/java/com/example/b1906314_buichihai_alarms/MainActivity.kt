package com.example.b1906314_buichihai_alarms

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.b1906314_buichihai_alarms.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var alarmMngs: AlarmManager
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        alarmMngs = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        binding.btnTaoB1906314.setOnClickListener {
            val seconds = binding.edtHienThiB1906314.text.toString().toInt() * 1000
            val intent = Intent(this, MyReceiver::class.java)
            val pendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
            alarmMngs.setExact(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + seconds,pendingIntent)
            binding.tvKetQuaB1906314.append("\n"+ Date().toString())
        }
        binding.btnCnhatB1906314.setOnClickListener {
            val seconds = binding.edtHienThiB1906314.text.toString().toInt() * 1000
            val intent = Intent(this, MyReceiver::class.java)
            val pendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
            alarmMngs.setExact(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + seconds,pendingIntent)
            binding.tvKetQuaB1906314.append("\n Update:"+ Date().toString())
        }
        binding.btnHuyB1906314.setOnClickListener {
            val intent = Intent(this, MyReceiver::class.java)
            val pendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
            alarmMngs.cancel(pendingIntent)
            binding.tvKetQuaB1906314.append("\n Cancel:"+ Date().toString())
        }
    }
}