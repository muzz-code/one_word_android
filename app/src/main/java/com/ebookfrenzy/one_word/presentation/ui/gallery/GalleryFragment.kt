package com.ebookfrenzy.one_word.presentation.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ebookfrenzy.one_word.databinding.FragmentGalleryBinding
import com.ebookfrenzy.one_word.presentation.adapter.GalleryAdapter
import com.ebookfrenzy.one_word.util.ResourceDummyData.galleryList
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null
    private lateinit var galleryAdapter: GalleryAdapter
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.apply {
            galleryAdapter = GalleryAdapter()
            binding.galleryFragmentRecyclerView.adapter = galleryAdapter
            galleryAdapter.submitList(galleryList)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}