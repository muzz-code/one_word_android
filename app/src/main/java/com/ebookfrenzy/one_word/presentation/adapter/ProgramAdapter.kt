package com.ebookfrenzy.one_word.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ebookfrenzy.one_word.R
import com.ebookfrenzy.one_word.data.model.ProgramData



class ProgramAdapter(private val imageList: List<ProgramData>) :
    RecyclerView.Adapter<ProgramAdapter.ProgramViewHolder>() {
    class ProgramViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val imageView: ImageView = itemView.findViewById(R.id.gallery_image)
        val programTime = itemView.findViewById(R.id.program_time) as TextView
        val programTitle = itemView.findViewById(R.id.program_title) as TextView
        val programMinister = itemView.findViewById(R.id.program_minister) as TextView
        val programTimeRange = itemView.findViewById(R.id.program_date_range) as TextView
        fun bind(data: ProgramData) {
            programTitle.text = data.title
            programTimeRange.text = data.day
            programTime.text = data.hour
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProgramViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.program_items, parent, false)
        return ProgramViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProgramViewHolder, position: Int) {
        val currentItem = imageList[position]
        holder.bind(currentItem)
    }

    override fun getItemCount(): Int {
        return imageList.size
    }
}