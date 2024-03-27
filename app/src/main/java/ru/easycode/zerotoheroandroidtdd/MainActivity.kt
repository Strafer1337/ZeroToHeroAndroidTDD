package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val titleTextView: TextView = findViewById(R.id.titleTextView)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        val actionButton: Button = findViewById(R.id.actionButton)

        actionButton.setOnClickListener {
            actionButton.isEnabled = false
            progressBar.visibility = View.VISIBLE

            actionButton.postDelayed({
                titleTextView.visibility = View.VISIBLE
                actionButton.isEnabled = true
                progressBar.visibility = View.GONE
            }, 3000)
/*
* вторая версия
 */
//            Handler(Looper.getMainLooper()).postDelayed({
//                titleTextView.visibility = View.VISIBLE
//                actionButton.isEnabled = true
//                progressBar.visibility = View.GONE
//            }, 3000)
        }
    }
}