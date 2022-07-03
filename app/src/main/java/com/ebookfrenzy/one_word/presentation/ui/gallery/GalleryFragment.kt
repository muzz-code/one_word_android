package com.ebookfrenzy.one_word.presentation.ui.gallery

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.ebookfrenzy.one_word.R
import com.ebookfrenzy.one_word.data.model.GalleryData
import com.ebookfrenzy.one_word.databinding.FragmentGalleryBinding
import com.ebookfrenzy.one_word.presentation.adapter.GalleryAdapter
import com.ebookfrenzy.one_word.util.ResourceDummyData
import com.ebookfrenzy.one_word.util.ResourceDummyData.galleryList
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import kotlin.math.abs

@AndroidEntryPoint
class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null
    private lateinit var galleryAdapter: GalleryAdapter
    private val galleryViewModel: GalleryViewModel by viewModels()
    private lateinit var viewpager2: ViewPager2
    private lateinit var handler: Handler
    private lateinit var imageList: ArrayList<Int>



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

        init()
        setUpTransformer()

        viewpager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                handler.removeCallbacks(runnable)
                handler.postDelayed(runnable, 2000)
            }
        })

//        lifecycleScope.launch {
//            repeatOnLifecycle(Lifecycle.State.STARTED){
//                launch {
//                    galleryViewModel.uiState.collect{
//
//                    }
//                }
//
//                launch {
//                    galleryViewModel.uiEvent.collect{
//
//                    }
//                }
//            }
//        }
    }

    override fun onPause() {
        super.onPause()
        handler.removeCallbacks(runnable)
    }

    override fun onResume() {
        super.onResume()
        handler.postDelayed(runnable, 2000)
    }

    private val runnable = Runnable {
        viewpager2.currentItem ++
    }

    private fun init() {
        viewpager2 = binding.galleryFragmentRecyclerView
        handler = Handler(Looper.myLooper()!!)
        imageList = ArrayList()

        imageList.add(R.drawable.ocean_view)
        imageList.add(R.drawable.ocean_view)
        imageList.add(R.drawable.ocean_view)
        imageList.add(R.drawable.ocean_view)
        imageList.add(R.drawable.ocean_view)
        imageList.add(R.drawable.ocean_view)
        imageList.add(R.drawable.ocean_view)

        galleryAdapter = GalleryAdapter(imageList, viewpager2)

        viewpager2.adapter = galleryAdapter
        viewpager2.offscreenPageLimit = 3
        viewpager2.clipToPadding = false
        viewpager2.clipChildren = false
        viewpager2.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

    }

    private fun setUpTransformer(){
        val transformer = CompositePageTransformer()
        transformer.addTransformer(MarginPageTransformer(40))
        transformer.addTransformer { page, position ->
            val r = 1 - abs(position)
            page.scaleY = 0.8f + r * 0.14f
        }
        viewpager2.setPageTransformer(transformer)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}