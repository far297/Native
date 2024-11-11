package com.example.controlexperiment

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Initialize UI elements
        val editText = findViewById<EditText>(R.id.editText)
        val button = findViewById<Button>(R.id.button)
        val checkBox = findViewById<CheckBox>(R.id.checkBox)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val spinner = findViewById<Spinner>(R.id.spinner)
        // Set up spinner data
        val options = arrayOf("Option A", "Option B", "Option C")
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item, options
        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
        // Button click listener
        button.setOnClickListener { v: View? ->
            val input = editText.text.toString()
            val isChecked = checkBox.isChecked
            val selectedId = radioGroup.checkedRadioButtonId
            val selectedRadioButton =
                findViewById<RadioButton>(selectedId)
            val selectedRadioText = selectedRadioButton?.text?.toString() ?: "None"
            val selectedSpinner =
                spinner.selectedItem.toString()
            // Show a Toast message with the collected input
            Toast.makeText(
                this, """
     Input: $input
     Checked: $isChecked
     Selected Radio: $selectedRadioText
     Selected Spinner: $selectedSpinner
     """.trimIndent(),
                Toast.LENGTH_LONG
            ).show()
        }
    }
}