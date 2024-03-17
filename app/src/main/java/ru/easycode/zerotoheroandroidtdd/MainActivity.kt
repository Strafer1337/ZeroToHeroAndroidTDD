package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val changeButton: Button = findViewById(R.id.changeButton)
        val titleTextView: TextView = findViewById(R.id.titleTextView)

//        if (savedInstanceState != null)
//            titleTextView.text = savedInstanceState.getString("ttw")

        changeButton.setOnClickListener {
            titleTextView.text = getString(R.string.and_dev)
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        val titleTextView: TextView = findViewById(R.id.titleTextView)
        titleTextView.text = savedInstanceState.getString("ttw")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        val titleTextView: TextView = findViewById(R.id.titleTextView)
        outState.putString("ttw", titleTextView.getText().toString())
    }
}