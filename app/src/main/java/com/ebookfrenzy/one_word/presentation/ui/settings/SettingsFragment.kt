package com.ebookfrenzy.one_word.presentation.ui.settings

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ebookfrenzy.one_word.R
import com.ebookfrenzy.one_word.databinding.FragmentSettingsBinding
import com.ebookfrenzy.one_word.presentation.ui.settings.SettingsAdapter
import com.ebookfrenzy.one_word.util.ResourceDummyData.settingsList

class SettingsFragment : Fragment() {
    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!
    private lateinit var settingsAdapter: SettingsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSettingsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        settingsAdapter = SettingsAdapter{
            when(it.position) {
                0 -> findNavController().navigate(R.id.privacyPolicyFragment)
                1 -> shareApp()
            }
        }
        binding.settingsItemsRv.adapter = settingsAdapter
        settingsAdapter.submitList(settingsList)
    }

    private fun shareApp() {
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, "Hey, here is a link to download one word tv")
            type = "text/plain"
        }
        startActivity(Intent.createChooser(sendIntent, "Share with"))
    }
}