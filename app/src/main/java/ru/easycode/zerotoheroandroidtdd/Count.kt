package ru.easycode.zerotoheroandroidtdd

interface Count {
    fun increment(number: String): UiState

    fun decrement(number: String): UiState

    fun initial(number: String): UiState

    class Base(private val step: Int, private val max: Int, private val min: Int) : Count {

        init {
            if (step < 1) throw IllegalStateException("step should be positive, but was $step")
            if (max < 1) throw IllegalStateException("max should be positive, but was $max")
            if (max < step) throw IllegalStateException("max should be more than step")
            if (max < min) throw IllegalStateException("max should be more than min")
        }

        override fun increment(number: String): UiState {
            val digits = number.toInt()
            val result = digits + step
            return initial(result.toString())
        }

        override fun decrement(number: String): UiState {
            val digits = number.toInt()
            val result = digits - step
            return initial(result.toString())
        }

        override fun initial(number: String): UiState {
            return if (number.toInt() + step > max) {
                UiState.Max(number)
            } else if (number.toInt() - step < min) {
                UiState.Min(number)
            } else {
                UiState.Base(number)
            }
        }
    }
}