package com.example.layoutexploration

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val linearLayoutButton =
            findViewById<Button>(R.id.linearLayoutButton)
        linearLayoutButton.setOnClickListener { v: View? ->
            val intent = Intent(
                this@MainActivity,
                LinearLayoutActivity::class.java
            )
            startActivity(intent)
        }
        val relativeLayoutButton =
            findViewById<Button>(R.id.relativeLayoutButton)
        relativeLayoutButton.setOnClickListener { v: View? ->
            val intent = Intent(
                this@MainActivity,
                RelativeLayoutActivity::class.java
            )
            startActivity(intent)
        }
        val constraintLayoutButton =
            findViewById<Button>(R.id.constraintLayoutButton)
        constraintLayoutButton.setOnClickListener { v: View? ->
            val intent = Intent(
                this@MainActivity,
                ConstraintLayoutActivity::class.java
            )
            startActivity(intent)
        }
        val gridLayoutButton =
            findViewById<Button>(R.id.gridLayoutButton)
        gridLayoutButton.setOnClickListener { v: View? ->
            val intent = Intent(
                this@MainActivity,
                GridLayoutActivity::class.java
            )
            startActivity(intent)
        }
    }
}