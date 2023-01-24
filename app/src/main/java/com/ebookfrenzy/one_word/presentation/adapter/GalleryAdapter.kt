package com.ebookfrenzy.one_word.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import coil.load
import com.ebookfrenzy.one_word.R
import com.ebookfrenzy.one_word.data.model.GalleryData
import com.ebookfrenzy.one_word.databinding.GalleryRecyclerviewItemBinding
import java.io.File

class GalleryAdapter: ListAdapter<GalleryData, GalleryAdapter.ViewHolder>(DiffCallback) {

    class ViewHolder(val binding: GalleryRecyclerviewItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(galleryData: GalleryData) {
            binding.apply {
                galleryImage.load(galleryData.imageUrl)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = GalleryRecyclerviewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
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