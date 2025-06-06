package com.cube.workexperience.twentyquestions.data.managers

import com.cube.workexperience.twentyquestions.data.enums.QuestionAnswer
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

    fun addQuestion(question: String) {
        state.update {
            it.copy(
                responseHistory = it.responseHistory + listOf(
                    Pair(question, null)
                )
            )
        }
    }

    fun answerQuestion(answer: QuestionAnswer) {
        state.update {
            it.copy(
                responseHistory = if (it.responseHistory.isEmpty()) {
                    it.responseHistory
                } else {
                    it.responseHistory.take(it.responseHistory.size - 1) + it.responseHistory.last().copy(
                        second = answer
                    )
                }
            )
        }
    }
}