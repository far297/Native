package com.example.menuexperiment

import android.os.Bundle
import android.view.ContextMenu
import android.view.ContextMenu.ContextMenuInfo
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var textView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        registerForContextMenu(textView) // Register the TextView for context menu
    }

    // Inflate the options menu (three-dot menu)
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    // Handle options menu item selections
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_settings) {
            textView!!.text = "Settings selected"
            return true
        } else if (item.itemId == R.id.action_about) {
            textView!!.text = "About selected"
            return true
        } else {
            return super.onOptionsItemSelected(item)
        }
    }

    // Inflate the context menu (long-press menu)
    override fun onCreateContextMenu(menu: ContextMenu, v: View, menuInfo: ContextMenuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.main_menu, menu)
        menu.setHeaderTitle("Choose an option")
    }

    // Handle context menu item selections
    override fun onContextItemSelected(item: MenuItem): Boolean {
        val itemId = item.itemId
        if (itemId == R.id.action_settings) {
            textView!!.text = "Settings selected from context menu"
            return true
        } else if (itemId == R.id.action_about) {
            textView!!.text = "About selected from context menu"
            return true
        }
        return super.onContextItemSelected(item)
    }
}