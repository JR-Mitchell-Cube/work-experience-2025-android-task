package com.cube.workexperience.twentyquestions.ui.history

import androidx.lifecycle.ViewModel
import com.cube.workexperience.twentyquestions.R
import com.cube.workexperience.twentyquestions.data.managers.TwentyQuestionsManager
import kotlinx.coroutines.flow.map

/**
 * In the MVVM architecture, the ViewModel is responsible for converting the business logic into
 * a data representation that can be easily displayed to the user.
 * The Android framework provides a [ViewModel] class which we extend here, which can be used for
 * this purpose.
 * This is the ViewModel for the [HistoryFragment].
 */
class HistoryViewModel : ViewModel() {

    /**
     * Get the history of all messages.
     */
    fun getMessages() = TwentyQuestionsManager.getState().map { gameState ->
        gameState.responseHistory.flatMapIndexed { index, (question, answer) ->
            listOfNotNull(
                HistoryMessageItem(
                    id = index * 2,
                    message = question,
                    backgroundColourResId = R.color.teal_200,
                    alignEnd = false,
                    iconResId = R.drawable.ic_question_black_24dp
                ),
                answer?.let {
                    HistoryMessageItem(
                        id = index * 2 + 1,
                        message = answer.messageDisplayText,
                        backgroundColourResId = R.color.purple_200,
                        alignEnd = true,
                        iconResId = R.drawable.ic_answer_black_24dp
                    )
                }
            )
        }
    }

}