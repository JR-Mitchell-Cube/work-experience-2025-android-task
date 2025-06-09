package com.cube.workexperience.twentyquestions.ui.history

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

/**
 * In Android development, a [androidx.recyclerview.widget.RecyclerView] is used to show a
 * scrollable list of items which may have their data changed or updated, and is optimised for
 * having large numbers of items without UI lag.
 * The UI for each individual item is wrapped in a ViewHolder class - see [HistoryViewHolder].
 * The Adapter plays the role of taking the list of data to be displayed and ensuring all of the
 * UI for this data is correctly set up to display.
 * It is responsible for creating any new views, and for updating the Views based on the data they
 * need to show.
 */
class HistoryAdapter : ListAdapter<HistoryMessageItem, HistoryViewHolder>(ItemCallback) {

    /**
     * This [ItemCallback] object is used by the inherited [ListAdapter] class to figure out how
     * the list of data has changed.
     * If an update list is provided, it is used to work out for each item whether it has been
     * added, removed, moved, or updated, based on two conditions - if it counts as the same item,
     * and if it has the same data.
     */
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

    /**
     * This overridden method creates a new [HistoryViewHolder], e.g the UI for a new item,
     * whenever needed.
     */
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HistoryViewHolder {
        return HistoryViewHolder(parent)
    }

    /**
     * This overridden method configures the UI of a single item based on the data at a given
     * position.
     */
    override fun onBindViewHolder(
        holder: HistoryViewHolder,
        position: Int
    ) {
        val data = getItem(position)
        holder.populate(data)
    }

}