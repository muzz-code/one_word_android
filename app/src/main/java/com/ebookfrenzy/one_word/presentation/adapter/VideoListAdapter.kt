package com.ebookfrenzy.one_word.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.ebookfrenzy.one_word.R
import com.ebookfrenzy.one_word.data.model.ResourceGeneralVideoModel
import com.ebookfrenzy.one_word.databinding.VideoListBinding

class VideoListAdapter(private val interaction: Interaction? = null) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val diffCallback = object : DiffUtil.ItemCallback<ResourceGeneralVideoModel>() {

        override fun areItemsTheSame(
            oldItem: ResourceGeneralVideoModel,
            newItem: ResourceGeneralVideoModel
        ): Boolean {
            return oldItem.videoTitle == newItem.videoTitle
        }

        override fun areContentsTheSame(
            oldItem: ResourceGeneralVideoModel,
            newItem: ResourceGeneralVideoModel
        ): Boolean {
            return oldItem == newItem
        }

    }
    private val differ = AsyncListDiffer(this, diffCallback)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val binding = VideoListBinding.inflate(
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

    fun submitList(list: List<ResourceGeneralVideoModel>) {
        differ.submitList(list)
    }

    class ViewHolder
    constructor(
        private val binding: VideoListBinding,
        private val interaction: Interaction?
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ResourceGeneralVideoModel) = with(itemView) {
            itemView.setOnClickListener {
                interaction?.onItemSelected(adapterPosition, item)
            }
            binding.videoListItemTextView.text = item.videoTitle

            binding.videoListItemImageView.load(item.videoThumbnail) {
                placeholder(R.drawable.ic_menu_slideshow)
            }
        }
    }

    interface Interaction {
        fun onItemSelected(position: Int, item: ResourceGeneralVideoModel)
    }
}