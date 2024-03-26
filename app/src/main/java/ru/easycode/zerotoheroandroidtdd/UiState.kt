package ru.easycode.zerotoheroandroidtdd

import android.widget.Button
import android.widget.TextView
import java.io.Serializable

interface UiState : Serializable {

    fun apply(textView: TextView, button: Button)

    data class Base(private val text: String) : UiState {
        override fun apply(textView: TextView, button: Button) {
            textView.text = this.text
        }
    }

    data class Max(private val text: String) : UiState {

        override fun apply(textView: TextView, button: Button) {
            textView.text = this.text
            button.isEnabled = false
        }
    }
}