package ru.easycode.zerotoheroandroidtdd

interface UiState {

    fun getText(): String

    data class Base(private val text: String): UiState {
        override fun getText(): String {
            return this.text
        }
    }

    data class Max(private val text: String): UiState {
        override fun getText(): String {
            return this.text
        }
    }
}