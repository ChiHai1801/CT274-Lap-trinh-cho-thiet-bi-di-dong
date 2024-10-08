package com.example.b1906314_buichihai_broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.b1906314_buichihai_broadcastreceiver.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var receiver: BroadcastReceiver
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val filter = IntentFilter()
        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        receiver = object : BroadcastReceiver() {
            override fun onReceive(p0: Context?, p1: Intent?) {
                val state = p1?.getBooleanExtra("state", false)
                binding.tvHienThiB1906314.setText("Airplane mode: $state")
                Toast.makeText(p0, state.toString(), Toast.LENGTH_SHORT).show()
            }
        }
        registerReceiver(receiver, filter)

        binding.btnSendB1906314.setOnClickListener(){
            // API < 26
            //sendBroadcast(Intent("MyReceiver"))
            // API >= 26
            sendBroadcast(Intent(applicationContext, MyReceiver::class.java))
        }
    }
    override fun onDestroy() {
        unregisterReceiver(receiver)
        super.onDestroy()
    }


}