package com.ebookfrenzy.one_word.adapter

import Model.GalleryData
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ebookfrenzy.one_word.R
import com.ebookfrenzy.one_word.databinding.GalleryRecyclerviewItemBinding


class GalleryAdapter(private val onItemClick: (GalleryData) -> Unit) :
    ListAdapter<GalleryData, GalleryAdapter.GalleryViewHolder>(DiffCallback) {
    class GalleryViewHolder(
        val binding: GalleryRecyclerviewItemBinding,
        private val onItemClick: (GalleryData) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(galleryData: GalleryData){
            Glide.with(binding.root.context)
                .load(galleryData.imageUrl)
                .placeholder(R.drawable.ic_baseline_radio_24)
                .into(binding.galleryImage)
            binding.galleryRootLayout.setOnClickListener {
                onItemClick.invoke(galleryData)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {

        val binding = GalleryRecyclerviewItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return GalleryViewHolder(binding, onItemClick)
    }

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

object DiffCallback : DiffUtil.ItemCallback<GalleryData>() {
    override fun areItemsTheSame(
        oldItem: GalleryData,
        newItem: GalleryData
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: GalleryData,
        newItem: GalleryData
    ): Boolean {
        return oldItem == newItem
    }
}