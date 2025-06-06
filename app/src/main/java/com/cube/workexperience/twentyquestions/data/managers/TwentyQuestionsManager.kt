package com.cube.workexperience.twentyquestions.data.managers

import com.cube.workexperience.twentyquestions.data.state.TwentyQuestionsGameState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

/**
 * Singleton object maintaining the state of the twenty questions flow.
 */
object TwentyQuestionsManager {

    private val state = MutableStateFlow<TwentyQuestionsGameState>(TwentyQuestionsGameState())

    fun setupQuestioner(name: String) {
        state.update {
            it.copy(
                questionerName = name
            )
        }
    }

    fun setupAnswerer(name: String, guessObject: String) {
        state.update {
            it.copy(
                answererName = name,
                guessObject = guessObject
            )
        }
    }

    fun getState(): StateFlow<TwentyQuestionsGameState> = state
}