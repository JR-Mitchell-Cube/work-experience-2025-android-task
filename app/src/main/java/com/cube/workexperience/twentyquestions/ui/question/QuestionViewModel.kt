package com.cube.workexperience.twentyquestions.ui.question

import androidx.lifecycle.ViewModel
import com.cube.workexperience.twentyquestions.data.enums.QuestionerSubmitMode
import com.cube.workexperience.twentyquestions.data.managers.TwentyQuestionsManager
import kotlinx.coroutines.flow.map

class QuestionViewModel : ViewModel() {

    /**
     * Data class representing the state of the question screen
     */
    data class ViewState(
        val mainTitle: String? = null,
        val subtitle: String? = null,
        val previousRoundTitle: String? = null,
        val editBoxTitle: String? = null,
        val editBoxHint: String? = null,
        val editBoxAutofillHint: String? = null,
        val submitButtonEnabled: Boolean = true,
        val submitMode: QuestionerSubmitMode
    )

    fun getState() = TwentyQuestionsManager.getState().map { gameState ->
        when {
            gameState.questionerName == null -> {
                ViewState(
                    mainTitle = "Hello, player!",
                    subtitle = "Please enter your name to proceed",
                    editBoxTitle = "Player name:",
                    editBoxHint = "Enter your name...",
                    editBoxAutofillHint = "name",
                    submitButtonEnabled = true,
                    submitMode = QuestionerSubmitMode.SUBMIT_NAME
                )
            }
            gameState.answererName == null -> {
                ViewState(
                    mainTitle = "Hello, ${gameState.questionerName}!",
                    subtitle = "Waiting for the answerer to provide their name and the object that you will be trying to guess...",
                    submitButtonEnabled = false,
                    submitMode = QuestionerSubmitMode.SUBMIT_NAME
                )
            }
            gameState.responseHistory.lastOrNull()?.let { it.second == null } != true -> {
                val questionNumber = gameState.responseHistory.size + 1
                ViewState(
                    mainTitle = "Hello, ${gameState.questionerName}!",
                    subtitle = "Ask question number ${questionNumber}!",
                    editBoxTitle = "Question:",
                    editBoxHint = "Ask a yes or no question...",
                    submitButtonEnabled = true,
                    submitMode = QuestionerSubmitMode.SUBMIT_QUESTION
                )
            }
            else -> {
                // Waiting for a response
                ViewState(
                    mainTitle = "Hello, ${gameState.questionerName}!",
                    subtitle = "Waiting for the answerer to answer yoyr last question...",
                    submitButtonEnabled = false,
                    submitMode = QuestionerSubmitMode.SUBMIT_QUESTION
                )
            }
        }
    }

    fun onSubmit(text: String, mode: QuestionerSubmitMode) {
        when (mode) {
            QuestionerSubmitMode.SUBMIT_NAME -> TwentyQuestionsManager.setupQuestioner(text)
            QuestionerSubmitMode.SUBMIT_QUESTION -> TwentyQuestionsManager.addQuestion(text)
        }
    }
}