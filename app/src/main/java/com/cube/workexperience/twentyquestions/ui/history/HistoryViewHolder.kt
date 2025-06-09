package com.cube.workexperience.twentyquestions.ui.history

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.cube.workexperience.twentyquestions.databinding.ViewMessageBinding

class HistoryViewHolder(private val binding: ViewMessageBinding): RecyclerView.ViewHolder(binding.root) {

    constructor(parent: ViewGroup): this(ViewMessageBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    fun populate(data: HistoryMessageItem) {
        binding.apply {
            textMessage.text = data.message
            textMessage.textAlignment = if (data.alignEnd) {
                TextView.TEXT_ALIGNMENT_VIEW_END
            } else {
                TextView.TEXT_ALIGNMENT_VIEW_START
            }
            root.setCardBackgroundColor(root.resources.getColor(data.backgroundColourResId, root.context.theme))
            val iconDrawable = ResourcesCompat.getDrawable(textMessage.resources, data.iconResId, textMessage.context.theme)
            if (data.alignEnd) {
                textMessage.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, iconDrawable, null)
            } else {
                textMessage.setCompoundDrawablesRelativeWithIntrinsicBounds(iconDrawable, null, null, null)
            }
        }
    }

}