package com.example.sharedpreferencesdemo

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var loadButton: Button
    private lateinit var greetingTextView: TextView
    private lateinit var nameEditText: EditText
    private lateinit var ageEditText: EditText
    private lateinit var cityEditText: EditText
    private lateinit var saveButton: Button
    private lateinit var clearButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        greetingTextView = findViewById(R.id.tv_greeting)
        nameEditText = findViewById(R.id.et_name)
        ageEditText = findViewById(R.id.et_age)
        cityEditText = findViewById(R.id.et_city)
        saveButton = findViewById(R.id.btn_save)
        loadButton = findViewById(R.id.btn_load)
        clearButton = findViewById(R.id.btn_clear)

        saveButton.setOnClickListener {
            if (validateInputs()) {
                saveData()
            }
        }

        loadButton.setOnClickListener {
            loadData()
        }

        clearButton.setOnClickListener {
            clearData()
        }
    }

    private fun validateInputs(): Boolean {
        val name = nameEditText.text.toString().trim()
        if (name.isEmpty()) {
            greetingTextView.text = "Name cannot be empty!"
            return false
        }
        return true
    }

    private fun saveData() {
        val sharedPreferences = getSharedPreferences("UserPreferences", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val name = nameEditText.text.toString()
        val age = ageEditText.text.toString()
        val city = cityEditText.text.toString()

        editor.putString("userName", name)
        editor.putString("userAge", age)
        editor.putString("userCity", city)
        editor.apply()

        greetingTextView.text = "Data saved!"
    }

    private fun loadData() {
        val sharedPreferences = getSharedPreferences("UserPreferences", Context.MODE_PRIVATE)
        val name = sharedPreferences.getString("userName", "No name saved")
        val age = sharedPreferences.getString("userAge", "No age saved")
        val city = sharedPreferences.getString("userCity", "No city saved")

        greetingTextView.text = "Welcome, $name! Age: $age, City: $city"
    }

    private fun clearData() {
        val sharedPreferences = getSharedPreferences("UserPreferences", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()

        greetingTextView.text = "Data cleared!"
    }
}
