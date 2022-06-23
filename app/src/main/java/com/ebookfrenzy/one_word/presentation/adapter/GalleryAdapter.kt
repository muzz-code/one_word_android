package com.ebookfrenzy.one_word.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.ebookfrenzy.one_word.R
import com.ebookfrenzy.one_word.data.model.GalleryData
import com.ebookfrenzy.one_word.databinding.GalleryRecyclerviewItemBinding

class GalleryAdapter(private val interaction: Interaction? = null) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val diffCallback = object : DiffUtil.ItemCallback<GalleryData>() {

        override fun areItemsTheSame(oldItem: GalleryData, newItem: GalleryData): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: GalleryData, newItem: GalleryData): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = GalleryRecyclerviewItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(
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

    fun submitList(list: List<GalleryData>) {
        differ.submitList(list)
    }

    class ViewHolder constructor(
        private var binding: GalleryRecyclerviewItemBinding,
        private val interaction: Interaction?
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: GalleryData) = with(itemView) {
            itemView.setOnClickListener {
                interaction?.onItemSelected(adapterPosition, item)
            }
            binding.galleryImage.load(item.imageUrl) {
                placeholder(R.drawable.ic_baseline_radio_24)
            }
        }
    }

    interface Interaction {
        fun onItemSelected(position: Int, item: GalleryData)
    }
}