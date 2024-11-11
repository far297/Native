package com.example.segmentedcontrolexperiment

import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        val fragmentContainer = findViewById<FrameLayout>(R.id.fragmentContainer)

        // Add tabs
        tabLayout.addTab(tabLayout.newTab().setText("First Tab"))
        tabLayout.addTab(tabLayout.newTab().setText("Second Tab"))
        // Load the first fragment by default
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, FirstFragment())
                .commit()
        }
        // Set a listener for tab selection
        tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                var fragment: Fragment? = null
                when (tab.position) {
                    0 -> fragment = FirstFragment()
                    1 -> fragment = SecondFragment()
                }
                if (fragment != null) {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, fragment)
                        .commit()
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }
}