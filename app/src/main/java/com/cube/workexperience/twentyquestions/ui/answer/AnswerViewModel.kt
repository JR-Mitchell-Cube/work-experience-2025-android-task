package com.cube.workexperience.twentyquestions.ui.answer

import androidx.lifecycle.ViewModel
import com.cube.workexperience.twentyquestions.data.managers.TwentyQuestionsManager
import kotlinx.coroutines.flow.map

class AnswerViewModel : ViewModel() {

    /**
     * Data class representing the state of the answer screen
     */
    data class ViewState(
        val mainTitle: String? = null
    )

    fun getState() = TwentyQuestionsManager.getState().map { state ->
        ViewState(
            mainTitle = "To be implemented!"
        )
    }
}