package com.ebookfrenzy.one_word.presentation.ui.share

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.ebookfrenzy.one_word.databinding.FragmentShareBinding
import kotlinx.coroutines.launch

class ShareFragment : Fragment() {

    private var _binding: FragmentShareBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentShareBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        shareApp()
    }

    private fun shareApp() {
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, "Hey, here is a link to download one word tv")
            type = "text/plain"
        }
        startActivity(Intent.createChooser(sendIntent, "Share with"))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}