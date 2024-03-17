package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val hideButton: Button = findViewById(R.id.hideButton)
        val titleTextView: TextView = findViewById(R.id.titleTextView)

//        if (savedInstanceState != null)
//            titleTextView.text = savedInstanceState.getString("ttw")
        hideButton.setOnClickListener {
            titleTextView.visibility = View.INVISIBLE
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        val titleTextView: TextView = findViewById(R.id.titleTextView)
        titleTextView.visibility = savedInstanceState.getInt("ttw_visibility")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        val titleTextView: TextView = findViewById(R.id.titleTextView)
        outState.putInt("ttw_visibility", titleTextView.visibility)
    }
}