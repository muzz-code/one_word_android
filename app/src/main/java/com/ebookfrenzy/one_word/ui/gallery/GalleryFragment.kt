package com.ebookfrenzy.one_word.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.ebookfrenzy.one_word.R
import com.ebookfrenzy.one_word.adapter.GalleryAdapter
import Model.GalleryData
import com.ebookfrenzy.one_word.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null
    lateinit var galleryAdapter: GalleryAdapter

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root


        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        galleryAdapter = GalleryAdapter {

        }
        val recyclerView = binding.galleryFragmentRecyclerView
        val galleryList = listOf<GalleryData>(
            GalleryData(1, R.drawable.one_word_logo),
            GalleryData(2, R.drawable.one_word_logo),
            GalleryData(3, R.drawable.one_word_logo),
            GalleryData(4, R.drawable.one_word_logo),
            GalleryData(5, R.drawable.one_word_logo)
        )
        recyclerView.adapter = galleryAdapter
        galleryAdapter.submitList(galleryList)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}