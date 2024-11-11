package com.example.imageexperiment

import android.os.Bundle
import android.widget.Button
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var layout: RelativeLayout
    private var isBackgroundOne = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        layout = findViewById(R.id.layout)

        val switchBackgroundButton = findViewById<Button>(R.id.switchBackgroundButton)
        switchBackgroundButton.setOnClickListener {
            if (isBackgroundOne) {
                layout.setBackgroundResource(R.drawable.background_image2)
            } else {
                layout.setBackgroundResource(R.drawable.background_image1)
            }
            isBackgroundOne = !isBackgroundOne // Toggle the background
        }
    }
}
