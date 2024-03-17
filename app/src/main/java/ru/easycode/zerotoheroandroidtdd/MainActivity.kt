package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var titleTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val hideButton: Button = findViewById(R.id.hideButton)
        titleTextView = findViewById(R.id.titleTextView)

        savedInstanceState?.let {
            titleTextView.visibility = savedInstanceState.getInt("ttw_visibility")
        }

        hideButton.setOnClickListener {
            titleTextView.visibility = View.INVISIBLE // or GONE
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("ttw_visibility", titleTextView.visibility)
    }
}