package com.ebookfrenzy.one_word.presentation.ui.home

import androidx.recyclerview.widget.DiffUtil
import com.ebookfrenzy.one_word.data.model.CardViewData

class CardViewDiffCallback(
    private val old: List<CardViewData>,
    private val new: List<CardViewData>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return old.size
    }

    override fun getNewListSize(): Int {
        return new.size
    }

    override fun areItemsTheSame(oldPosition: Int, newPosition: Int): Boolean {
        return old[oldPosition].hashCode() == new[newPosition].hashCode()
    }

    override fun areContentsTheSame(oldPosition: Int, newPosition: Int): Boolean {
        return old[oldPosition].cardViewImage == new[newPosition].cardViewImage
    }

}