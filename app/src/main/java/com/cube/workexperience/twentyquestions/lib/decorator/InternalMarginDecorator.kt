package com.cube.workexperience.twentyquestions.lib.decorator

import android.content.res.Resources
import android.graphics.Rect
import android.view.View
import androidx.annotation.DimenRes
import androidx.annotation.Px
import androidx.recyclerview.widget.RecyclerView

/**
 * [RecyclerView.ItemDecoration] implementation which creates a vertical margin in-between
 * consecutive items.
 *
 * @param verticalMarginPx The margin, in pixels, to place in-between consecutive items
 */
class InternalMarginDecorator(@Px private val verticalMarginPx: Int) : RecyclerView.ItemDecoration() {

    /**
     * [RecyclerView.ItemDecoration] implementation which creates a vertical margin in-between consecutive items
     *
     * @param resources The resources to retrieve the margin size from
     * @param verticalMarginDimenResId Resource ID for the margin to place in-between consecutive items
     */
    constructor(
        resources: Resources,
        @DimenRes verticalMarginDimenResId: Int,
    ) : this(resources.getDimensionPixelSize(verticalMarginDimenResId))

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        with(outRect) {
            if (parent.getChildAdapterPosition(view) != 0) {
                top = verticalMarginPx
            }
        }
    }
}