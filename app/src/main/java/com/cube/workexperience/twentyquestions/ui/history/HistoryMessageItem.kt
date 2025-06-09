package com.cube.workexperience.twentyquestions.ui.history

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes

/**
 * Data class representing a single message shown in the history.
 *
 * @param id The unique ID of the message.
 * @param message The message to show.
 * @param backgroundColourResId The Android resource ID for the background colour of the card.
 * @param alignEnd Whether the message should be aligned to the end.
 * @param iconResId The Android resource ID for the icon to show at the aligned end of the card.
 */
data class HistoryMessageItem(
    val id: Int,
    val message: String,
    @ColorRes val backgroundColourResId: Int,
    val alignEnd: Boolean,
    @DrawableRes val iconResId: Int
)
