package com.cube.workexperience.twentyquestions.data.managers

import com.cube.workexperience.twentyquestions.data.enums.QuestionAnswer
import com.cube.workexperience.twentyquestions.data.state.TwentyQuestionsGameState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

/**
 * Singleton object maintaining the state of the twenty questions flow.
 *
 * The singleton pattern is often used in Android development where some state needs to exist
 * that is held in memory across the entire lifecycle of the app.
 */
object TwentyQuestionsManager {

    private val state = MutableStateFlow<TwentyQuestionsGameState>(TwentyQuestionsGameState())

    /**
     * Get the current state of the game.
     */
    fun getState(): StateFlow<TwentyQuestionsGameState> = state

    /**
     * Sets up the user who is asking questions.
     * @param name The name of this user.
     */
    fun setupQuestioner(name: String) {
        state.update {
            it.copy(
                questionerName = name
            )
        }
    }

    /**
     * Sets up the user who is answering the questions.
     * @param name The name of this user.
     * @param guessObject The object, place, or person that the questioner is trying to guess.
     */
    fun setupAnswerer(name: String, guessObject: String) {
        state.update {
            it.copy(
                answererName = name,
                guessObject = guessObject
            )
        }
    }

    /**
     * Add a question to the list of questions that have been asked.
     * @param question The question to add.
     */
    fun addQuestion(question: String) {
        state.update {
            it.copy(
                responseHistory = it.responseHistory + listOf(
                    Pair(question, null)
                )
            )
        }
    }

    /**
     * Answers the most recently asked question.
     * @param answer The answer to this question.
     */
    fun answerQuestion(answer: QuestionAnswer) {
        state.update {
            it.copy(
                responseHistory = if (it.responseHistory.isEmpty()) {
                    it.responseHistory
                } else {
                    it.responseHistory.take(it.responseHistory.size - 1) + it.responseHistory.last()
                        .copy(
                            second = answer
                        )
                }
            )
        }
    }
}