package com.example.menuexperiment;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        registerForContextMenu(textView); // Register the TextView for context menu
    }

    // Inflate the options menu (three-dot menu)
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    // Handle options menu item selections
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_settings) {
            textView.setText("Settings selected");
            return true;
        } else if (item.getItemId() == R.id.action_about) {
            textView.setText("About selected");
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    // Inflate the context menu (long-press menu)
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.main_menu, menu);
        menu.setHeaderTitle("Choose an option");
    }

    // Handle context menu item selections
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.action_settings) {
            textView.setText("Settings selected from context menu");
            return true;
        } else if (itemId == R.id.action_about) {
            textView.setText("About selected from context menu");
            return true;
        }
        return super.onContextItemSelected(item);
    }
}
