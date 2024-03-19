package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var rootLayout: LinearLayout
    private lateinit var countTextView: TextView
    private lateinit var incrementButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rootLayout = findViewById(R.id.rootLayout)
        countTextView = findViewById(R.id.countTextView)
        incrementButton = findViewById(R.id.incrementButton)

        incrementButton.setOnClickListener {
            Count.Base(2).increment(countTextView.text.toString()).also {
                if (it.toInt() < 4) countTextView.text = it
                else if (it.toInt() == 4) {
                    countTextView.text = it
                    incrementButton.isEnabled = false
                }
                else {
                    incrementButton.isEnabled = false
                }
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("countTextViewState", countTextView.text.toString())
        outState.putBoolean("incrementButtonEnabled", incrementButton.isEnabled)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        countTextView.text = savedInstanceState.getString("countTextViewState")
        incrementButton.isEnabled = savedInstanceState.getBoolean("incrementButtonEnabled")
    }
}