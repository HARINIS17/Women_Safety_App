package com.example.safezone.ui.settings

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.safezone.R
import com.example.safezone.data.local.AppDatabase
import kotlinx.coroutines.launch

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val resetBtn = findViewById<Button>(R.id.btnResetData)

        resetBtn.setOnClickListener {
            lifecycleScope.launch {
                val db = AppDatabase.getDatabase(this@SettingsActivity)
                db.clearAllTables()

                Toast.makeText(
                    this@SettingsActivity,
                    "All local data cleared",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}
