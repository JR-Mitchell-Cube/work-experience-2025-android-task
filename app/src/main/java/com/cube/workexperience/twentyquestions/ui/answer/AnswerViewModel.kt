package com.cube.workexperience.twentyquestions.ui.answer

import androidx.lifecycle.ViewModel
import com.cube.workexperience.twentyquestions.data.managers.TwentyQuestionsManager
import kotlinx.coroutines.flow.map

/**
 * In the MVVM architecture, the ViewModel is responsible for converting the business logic into
 * a data representation that can be easily displayed to the user.
 * The Android framework provides a [ViewModel] class which we extend here, which can be used for
 * this purpose.
 * This is the ViewModel for the [AnswerFragment].
 */
class AnswerViewModel : ViewModel() {

    /**
     * Data class representing the state of the answer screen
     */
    data class ViewState(
        val mainTitle: String? = null
    )

    /**
     * Get the current state for the Answer screen.
     */
    fun getState() = TwentyQuestionsManager.getState().map { state ->
        ViewState(
            mainTitle = "To be implemented!"
        )
    }
}