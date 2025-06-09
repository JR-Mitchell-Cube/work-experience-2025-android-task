package com.cube.workexperience.twentyquestions.data.state

import com.cube.workexperience.twentyquestions.data.enums.QuestionAnswer

typealias QuestionAnswerPair = Pair<String, QuestionAnswer?>

/**
 * Data class representing the state of the Twenty Questions game.
 *
 * @param questionerName The name of the user who is asking the Twenty Questions.
 * @param answererName The name of the user who is answering yes/no to the questions.
 * @param guessObject The object, place, or person that the questioner is trying to guess.
 * @param responseHistory The history of all questions that have been asked and answers given.
 */
data class TwentyQuestionsGameState(
    val questionerName: String? = null,
    val answererName: String? = null,
    val guessObject: String? = null,
    val responseHistory: List<QuestionAnswerPair> = emptyList()
)