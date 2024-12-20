package com.example.sqlitedemo

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

private lateinit var databaseHelper: DatabaseHelper
private lateinit var nameEditText: EditText
private  lateinit var ageEditText: EditText
private lateinit var resultTextView: TextView
private lateinit var addButton: Button
private lateinit var viewButton: Button
private lateinit var updateButton: Button
private lateinit var deleteButton: Button

class MainActivity : AppCompatActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        databaseHelper = DatabaseHelper(this)

        nameEditText = findViewById(R.id.et_name)
        ageEditText = findViewById(R.id.et_age)
        resultTextView = findViewById(R.id.tv_result)
        addButton = findViewById(R.id.btn_add)
        viewButton = findViewById(R.id.btn_view)
        updateButton = findViewById(R.id.btn_update)
        deleteButton = findViewById(R.id.btn_delete)

        addButton.setOnClickListener{
            addUser()
        }

        viewButton.setOnClickListener{
            viewUser()
        }

        updateButton.setOnClickListener {
            updateUser()
        }

        deleteButton.setOnClickListener {
            deleteUser()
        }
    }

    private fun addUser() {
        val name = nameEditText.text.toString()
        val age = ageEditText.text.toString().toIntOrNull()

        if (name.isNotEmpty() && age != null) {
            val success = databaseHelper.addUser(name, age)
            if (success) {
                Toast.makeText(this, "User added successfully!", Toast.LENGTH_SHORT).show()
                nameEditText.text.clear()
                ageEditText.text.clear()
            } else {
                Toast.makeText(this, "Failed to add user", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Please enter a valid name and age", Toast.LENGTH_SHORT).show()
        }
    }

    private fun viewUser() {
        val users = databaseHelper.getAllUsersSorted()
        resultTextView.text =  if (users.isNotEmpty()) {
            users.joinToString ("\n")
        } else {
            "No users found"
        }
    }

    private fun updateUser() {
        val name = nameEditText.text.toString()
        val age = ageEditText.text.toString().toIntOrNull()

        if (name.isNotEmpty() && age != null) {
            val success = databaseHelper.updateUser(name, age)
            if (success) {
                Toast.makeText(this, "User updated successfully!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "User not found.", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Please enter a valid name and age.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun deleteUser() {
        val name = nameEditText.text.toString()

        if (name.isNotEmpty()) {
            val success = databaseHelper.deleteUser(name)
            if (success) {
                Toast.makeText(this, "User deleted successfully!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "User not found.", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Please enter a valid name.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun viewSortedUsers() {
        val users = databaseHelper.getAllUsersSorted()
        resultTextView.text = if (users.isNotEmpty()) {
            users.joinToString("\n")
        } else {
            "No users found"
        }
    }

}