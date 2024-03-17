package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var rootLayout: ViewGroup
    private lateinit var titleTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rootLayout = findViewById(R.id.rootLayout)
        titleTextView = findViewById(R.id.titleTextView)
        val removeButton: Button = findViewById(R.id.removeButton)

        removeButton.setOnClickListener {
            rootLayout.removeView(titleTextView)
        }

        savedInstanceState?.let {
            val isRemoved = savedInstanceState.getBoolean("isRemoved")
            if (isRemoved)
                rootLayout.removeView(titleTextView)
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        // titleTextView.visibility = savedInstanceState.getInt("ttw_visibility")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean("isRemoved", findViewById<TextView>(R.id.titleTextView) == null)
    }
}