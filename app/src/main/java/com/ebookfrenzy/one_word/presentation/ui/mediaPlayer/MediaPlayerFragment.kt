package com.ebookfrenzy.one_word.presentation.ui.mediaPlayer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ebookfrenzy.one_word.data.model.ResourceGeneralVideoModel
import com.ebookfrenzy.one_word.databinding.MediaPlayerFragmentBinding
import com.ebookfrenzy.one_word.presentation.adapter.VideoListAdapter
import com.ebookfrenzy.one_word.util.ResourceDummyData
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MediaPlayerFragment : Fragment(), VideoListAdapter.Interaction  {

    private var _binding: MediaPlayerFragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val mediaPlayerViewModel: MediaPlayerViewModel by viewModels()
    private lateinit var videoRecyclerView: RecyclerView
    private lateinit var videoRvAdapter: VideoListAdapter

//    private var url: String = "https://assets.mixkit.co/videos/preview/mixkit-hands-of-a-tailor-working-12528-small.mp4"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MediaPlayerFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    mediaPlayerViewModel.uiState.collect {

                    }
                }

                launch {
                    mediaPlayerViewModel.uiEvent.collect {

                    }
                }
            }
        }

        /** initialize the recycler_view **/
        videoRecyclerView = binding.individualVideoScreenFragmentRecyclerView

        /** set up the recycler_view layout manager **/
        videoRecyclerView.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            videoRvAdapter = VideoListAdapter(this@MediaPlayerFragment)
            adapter = videoRvAdapter
            videoRvAdapter.submitList(ResourceDummyData.videoItem)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemSelected(position: Int, item: ResourceGeneralVideoModel) {
        TODO("Not yet implemented")
    }

}