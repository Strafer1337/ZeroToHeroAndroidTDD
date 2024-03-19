package ru.easycode.zerotoheroandroidtdd

interface Count {
    fun increment(number: String): String

    class Base(private val step: Int, private val min: Int, private val max: Int) : Count, UiState {

        init {
            if (step < 1) throw IllegalStateException("step should be positive, but was $step")
        }
        override fun increment(number: String): UiState = (number.toInt() + step).toString()


    }
}