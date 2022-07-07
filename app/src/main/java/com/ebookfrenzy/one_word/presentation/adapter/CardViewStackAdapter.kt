package com.ebookfrenzy.one_word.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ebookfrenzy.one_word.data.model.CardViewData
import com.ebookfrenzy.one_word.databinding.CardViewItemsBinding

class CardViewStackAdapter(private val interaction: Interaction? = null) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val diffCallback = object : DiffUtil.ItemCallback<CardViewData>() {

        override fun areItemsTheSame(oldItem: CardViewData, newItem: CardViewData): Boolean {
            return oldItem.cardViewImage == newItem.cardViewImage
        }

        override fun areContentsTheSame(oldItem: CardViewData, newItem: CardViewData): Boolean {
            return oldItem == newItem
        }

    }
    private val differ = AsyncListDiffer(this, diffCallback)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val binding = CardViewItemsBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder (
            binding,
            interaction
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ViewHolder -> {
                holder.bind(differ.currentList[position])
            }
        }
    }
    override fun getItemCount(): Int {
        return differ.currentList.size
    }


    fun submitList(list: List<CardViewData>) {
        differ.submitList(list)
    }

    class ViewHolder
    constructor(
        private val binding: CardViewItemsBinding,
        private val interaction: Interaction?
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CardViewData) = with(itemView) {
            itemView.setOnClickListener {
                interaction?.onItemSelected(absoluteAdapterPosition, item)
            }
        }
    }
    interface Interaction {
        fun onItemSelected(position: Int, item: CardViewData)
    }
}