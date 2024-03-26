package ru.easycode.zerotoheroandroidtdd

import android.widget.Button
import android.widget.TextView

interface UiState {

    fun apply(textView: TextView, incrementButton: Button, decrementButton: Button)

    data class Base(private val text: String) : UiState {
        override fun apply(textView: TextView, incrementButton: Button, decrementButton: Button) {
            textView.text = this.text
            incrementButton.isEnabled = true
            decrementButton.isEnabled = true
        }
    }

    data class Max(private val text: String) : UiState {

        override fun apply(textView: TextView, incrementButton: Button, decrementButton: Button) {
            textView.text = this.text
            incrementButton.isEnabled = false
            decrementButton.isEnabled = true
        }
    }

    data class Min(private val text: String) : UiState {
        override fun apply(textView: TextView, incrementButton: Button, decrementButton: Button) {
            textView.text = this.text
            incrementButton.isEnabled = true
            decrementButton.isEnabled = false
        }
    }
}