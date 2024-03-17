package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var titleTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val changeButton: Button = findViewById(R.id.changeButton)
        titleTextView = findViewById(R.id.titleTextView)

        savedInstanceState?.let {
            titleTextView.text = it.getString("ttw")
        }

        changeButton.setOnClickListener {
            titleTextView.text = getString(R.string.and_dev)
        }
    }

//    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
//        super.onRestoreInstanceState(savedInstanceState)
//
//        val titleTextView: TextView = findViewById(R.id.titleTextView)
//        titleTextView.text = savedInstanceState.getString("ttw")
//    }
//
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("ttw", titleTextView.getText().toString())
    }
}