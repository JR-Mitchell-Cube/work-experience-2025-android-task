package com.cube.workexperience.twentyquestions.ui.history

import androidx.lifecycle.ViewModel
import com.cube.workexperience.twentyquestions.R
import com.cube.workexperience.twentyquestions.data.enums.QuestionAnswer
import com.cube.workexperience.twentyquestions.data.managers.TwentyQuestionsManager
import kotlinx.coroutines.flow.map

class HistoryViewModel : ViewModel() {

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
                        message = when (answer) {
                            QuestionAnswer.YES -> "Yes"
                            QuestionAnswer.NO -> "No"
                            QuestionAnswer.GUESSED_CORRECTLY -> "Well done! You guessed correctly!"
                        },
                        backgroundColourResId = R.color.purple_200,
                        alignEnd = true,
                        iconResId = R.drawable.ic_answer_black_24dp
                    )
                }
            )
        }
    }

}