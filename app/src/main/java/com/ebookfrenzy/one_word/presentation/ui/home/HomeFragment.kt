package com.ebookfrenzy.one_word.presentation.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AnimationUtils
import android.view.animation.LinearInterpolator
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DiffUtil
import animation.startAnimation
import com.ebookfrenzy.one_word.R
import com.ebookfrenzy.one_word.data.model.CardViewData
import com.ebookfrenzy.one_word.databinding.FragmentHomeBinding
import com.ebookfrenzy.one_word.presentation.adapter.CardViewStackAdapter
import com.ebookfrenzy.one_word.presentation.adapter.GalleryAdapter
import com.ebookfrenzy.one_word.presentation.adapter.UpcomingProgramsAdapter
import com.ebookfrenzy.one_word.util.ResourceDummyData
import com.ebookfrenzy.one_word.util.ResourceDummyData.upcomingPrograms
//import com.yuyakaido.android.cardstackview.*
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var upcomingProgramsAdapter: UpcomingProgramsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            upcomingProgramsAdapter = UpcomingProgramsAdapter()
            binding.upcomingProgramsRv.adapter = upcomingProgramsAdapter
            upcomingProgramsAdapter.submitList(upcomingPrograms)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}