package com.cube.workexperience.twentyquestions.data.state

import com.cube.workexperience.twentyquestions.data.enums.QuestionAnswer

typealias QuestionAnswerPair = Pair<String, QuestionAnswer?>

/**
 * Data class representing the state of the Twenty Questions game
 */
data class TwentyQuestionsGameState(
    val questionerName: String? = null,
    val answererName: String? = null,
    val guessObject: String? = null,
    val responseHistory: List<QuestionAnswerPair> = emptyList()
)