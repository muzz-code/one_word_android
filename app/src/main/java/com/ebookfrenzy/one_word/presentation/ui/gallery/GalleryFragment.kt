package com.ebookfrenzy.one_word.presentation.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.ebookfrenzy.one_word.data.model.GalleryData
import com.ebookfrenzy.one_word.databinding.FragmentGalleryBinding
import com.ebookfrenzy.one_word.presentation.adapter.GalleryAdapter
import com.ebookfrenzy.one_word.util.ResourceDummyData.galleryList
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class GalleryFragment : Fragment(), GalleryAdapter.Interaction {

    private var _binding: FragmentGalleryBinding? = null
    private lateinit var galleryAdapter: GalleryAdapter

    private val galleryViewModel: GalleryViewModel by viewModels()

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
        galleryAdapter = GalleryAdapter(this)
        val recyclerView = binding.galleryFragmentRecyclerView

        recyclerView.adapter = galleryAdapter
        galleryAdapter.submitList(galleryList)

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                launch {
                    galleryViewModel.uiState.collect{

                    }
                }

                launch {
                    galleryViewModel.uiEvent.collect{

                    }
                }
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemSelected(position: Int, item: GalleryData) {

    }
}