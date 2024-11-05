package com.example.custombroadcastreceiver

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var myReceiver: MyCustomBroadcastReceiver
    private lateinit var sendBroadcastButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myReceiver = MyCustomBroadcastReceiver()
        sendBroadcastButton = findViewById(R.id.sendBroadcastButton)
        sendBroadcastButton.setOnClickListener {
            val intent = Intent("com.example.CUSTOM_ACTION")
            LocalBroadcastManager.getInstance(this).sendBroadcast(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        LocalBroadcastManager.getInstance(this)
            .registerReceiver(myReceiver, IntentFilter("com.example.CUSTOM_ACTION"))
    }

    override fun onStop() {
        super.onStop()
        LocalBroadcastManager.getInstance(this).unregisterReceiver(myReceiver)
    }
}
