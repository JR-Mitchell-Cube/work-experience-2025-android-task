package com.cube.workexperience.twentyquestions.ui.history

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.cube.workexperience.twentyquestions.databinding.ViewMessageBinding

/**
 * In Android development, a [RecyclerView] is used to show a scrollable list of items which may
 * have their data changed or updated, and is optimised for having large numbers of items without
 * UI lag.
 * The ViewHolder class holds a single item of UI to display in the list, and provides functionality
 * to update this UI whenever needed.
 */
class HistoryViewHolder(private val binding: ViewMessageBinding) :
    RecyclerView.ViewHolder(binding.root) {

    constructor(parent: ViewGroup) : this(
        ViewMessageBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    /**
     * Updates the UI of this [HistoryViewHolder] to reflect the data which it should display.
     * @param data The data to display in this viewholder.
     */
    fun populate(data: HistoryMessageItem) {
        binding.apply {
            textMessage.text = data.message
            textMessage.textAlignment = if (data.alignEnd) {
                TextView.TEXT_ALIGNMENT_VIEW_END
            } else {
                TextView.TEXT_ALIGNMENT_VIEW_START
            }
            root.setCardBackgroundColor(
                root.resources.getColor(
                    data.backgroundColourResId,
                    root.context.theme
                )
            )
            val iconDrawable = ResourcesCompat.getDrawable(
                textMessage.resources,
                data.iconResId,
                textMessage.context.theme
            )
            if (data.alignEnd) {
                textMessage.setCompoundDrawablesRelativeWithIntrinsicBounds(
                    /* start = */ null,
                    /* top = */ null,
                    /* end = */ iconDrawable,
                    /* bottom = */ null
                )
            } else {
                textMessage.setCompoundDrawablesRelativeWithIntrinsicBounds(
                    /* start = */ iconDrawable,
                    /* top = */ null,
                    /* end = */ null,
                    /* bottom = */ null
                )
            }
        }
    }

}