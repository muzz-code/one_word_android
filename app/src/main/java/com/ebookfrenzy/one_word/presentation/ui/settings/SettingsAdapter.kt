package com.ebookfrenzy.one_word.presentation.ui.settings

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ebookfrenzy.one_word.data.model.SettingsItems
import com.ebookfrenzy.one_word.databinding.SettingsRvItemBinding

class SettingsAdapter(private val onItemClick: (SettingsItems) -> Unit) :
    ListAdapter<SettingsItems, SettingsAdapter.ViewHolder>(DiffCallback) {

    class ViewHolder(
        val binding: SettingsRvItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(settingsItems: SettingsItems, onItemClick: (SettingsItems) -> Unit) {
            binding.apply {
                settingItemIcon.setImageResource(settingsItems.itemIcon)
                settingItemEndIcon.setImageResource(settingsItems.itemEndIcon)
                settingItemTitle.text = settingsItems.itemText
                settingsRootLayout.setOnClickListener {
                    onItemClick.invoke(settingsItems)
                }
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            SettingsRvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), onItemClick)
    }
}


object DiffCallback : DiffUtil.ItemCallback<SettingsItems>() {
    override fun areItemsTheSame(
        oldItem: SettingsItems,
        newItem: SettingsItems
    ): Boolean {
        return oldItem.itemText == newItem.itemText
    }

    override fun areContentsTheSame(
        oldItem: SettingsItems,
        newItem: SettingsItems
    ): Boolean {
        return oldItem == newItem
    }

}