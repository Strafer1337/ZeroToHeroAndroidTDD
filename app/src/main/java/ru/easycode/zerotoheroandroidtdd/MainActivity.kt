package ru.easycode.zerotoheroandroidtdd

import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val count: Count.Base = Count.Base(2, 4, 0)

    private lateinit var uiState: UiState

    private lateinit var countTextView: TextView
    private lateinit var incrementButton: Button
    private lateinit var decrementButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        countTextView = findViewById(R.id.countTextView)
        incrementButton = findViewById(R.id.incrementButton)
        decrementButton = findViewById(R.id.decrementButton)

        if (savedInstanceState == null) {
            uiState = count.initial(countTextView.text.toString())
            uiState.apply(countTextView, incrementButton, decrementButton)
        }

        incrementButton.setOnClickListener {
            uiState = count.increment(countTextView.text.toString())
            uiState.apply(countTextView, incrementButton, decrementButton)
        }

        decrementButton.setOnClickListener {
            uiState = count.decrement(countTextView.text.toString())
            uiState.apply(countTextView, incrementButton, decrementButton)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable(UISTATE_KEY, uiState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        uiState =
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) savedInstanceState.getSerializable(
                UISTATE_KEY, UiState::class.java
            ) as UiState
            else savedInstanceState.getSerializable(UISTATE_KEY) as UiState

        uiState.apply(countTextView, incrementButton, decrementButton)
    }

    companion object {
        private const val UISTATE_KEY = "UiStateKey"
    }
}