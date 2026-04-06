package com.furkan.notifyassistant.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.furkan.notifyassistant.R
import com.furkan.notifyassistant.model.NotificationItem
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 * The main entry point of the application.  This activity inflates a simple
 * layout containing a status message, a few action buttons and a RecyclerView
 * to display captured notifications.  To keep the example easy to compile and
 * run without an Android Studio environment, the list is populated with a
 * single example item on startup.  The export buttons show a Toast to indicate
 * that full export functionality is omitted in this example.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Populate the list with a single example.  A real implementation would
        // retrieve persisted notifications from a database and observe updates via
        // LiveData or Flow.
        val example = NotificationItem(
            app = "Örnek Uygulama",
            title = "Merhaba Dünya",
            text = "Bu bir örnek bildirimdir.",
            time = SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(Date())
        )
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = NotificationAdapter(listOf(example))

        // Open notification listener settings so the user can grant access.
        findViewById<Button>(R.id.btnOpenSettings).setOnClickListener {
            try {
                startActivity(Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"))
            } catch (e: Exception) {
                Toast.makeText(
                    this,
                    "Ayarlar açılamadı: ${e.localizedMessage}",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

        // Show stub message when trying to export as JSON.
        findViewById<Button>(R.id.btnExportJson).setOnClickListener {
            Toast.makeText(
                this,
                "JSON dışa aktarım bu örnekte desteklenmiyor.",
                Toast.LENGTH_SHORT
            ).show()
        }

        // Show stub message when trying to export as CSV.
        findViewById<Button>(R.id.btnExportCsv).setOnClickListener {
            Toast.makeText(
                this,
                "CSV dışa aktarım bu örnekte desteklenmiyor.",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
