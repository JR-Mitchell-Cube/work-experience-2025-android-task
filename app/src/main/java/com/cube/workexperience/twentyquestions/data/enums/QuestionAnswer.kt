package com.cube.workexperience.twentyquestions.data.enums

/**
 * Enum class representing the ways in which a question may be answered.
 * Enums are useful for situations where there are a fixed number of possible options a variable or
 * parameter can take.
 * In this case, extra properties can be associated with the enum constants to provide data
 * associated with the fixed options.
 *
 * @param messageDisplayText The text to display for a message with this answer.
 */
enum class QuestionAnswer(val messageDisplayText: String) {
    /**
     * An answer of Yes to the question.
     */
    YES("Yes"),

    /**
     * An answer of No to the question.
     */
    NO("No"),

    /**
     * The question was guessing the object, and guessed correctly!
     */
    GUESSED_CORRECTLY("Well done! You guessed correctly!")
}