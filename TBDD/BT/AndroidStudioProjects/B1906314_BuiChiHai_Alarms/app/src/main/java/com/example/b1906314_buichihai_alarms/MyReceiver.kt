package com.example.b1906314_buichihai_alarms

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import java.util.*

class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        Toast.makeText(context, Date().toString(),
            Toast.LENGTH_SHORT).show()
    }
}