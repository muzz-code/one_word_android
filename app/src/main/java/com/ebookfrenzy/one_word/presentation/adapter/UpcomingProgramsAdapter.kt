package com.ebookfrenzy.one_word.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.ebookfrenzy.one_word.R
import com.ebookfrenzy.one_word.data.model.ProgramData
import com.ebookfrenzy.one_word.data.model.ProgramDataResponse
import com.ebookfrenzy.one_word.databinding.UpcomingRvItemBinding

class UpcomingProgramsAdapter: ListAdapter<ProgramData, UpcomingProgramsAdapter.ViewHolder>(ProgramDiffCallback) {

    class ViewHolder(val binding: UpcomingRvItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(programData: ProgramData) {
            binding.apply {
                upcomingProgramIv.load(programData.image)
                programTitle.text = programData.title
                programDate.text = programData.day
                programTime.text = programData.hour
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = UpcomingRvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}


object ProgramDiffCallback : DiffUtil.ItemCallback<ProgramData>() {
    override fun areItemsTheSame(
        oldItem: ProgramData,
        newItem: ProgramData
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: ProgramData,
        newItem: ProgramData
    ): Boolean {
        return oldItem == newItem
    }

}