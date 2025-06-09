package com.cube.workexperience.twentyquestions.ui.history

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

class HistoryAdapter : ListAdapter<HistoryMessageItem, HistoryViewHolder>(ItemCallback) {

    object ItemCallback : DiffUtil.ItemCallback<HistoryMessageItem>() {
        override fun areItemsTheSame(
            oldItem: HistoryMessageItem,
            newItem: HistoryMessageItem
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: HistoryMessageItem,
            newItem: HistoryMessageItem
        ): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HistoryViewHolder {
        return HistoryViewHolder(parent)
    }

    override fun onBindViewHolder(
        holder: HistoryViewHolder,
        position: Int
    ) {
        val data = getItem(position)
        holder.populate(data)
    }

}