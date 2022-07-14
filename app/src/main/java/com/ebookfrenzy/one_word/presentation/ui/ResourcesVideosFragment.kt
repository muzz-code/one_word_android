package com.ebookfrenzy.one_word.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ebookfrenzy.one_word.data.model.ResourceGeneralVideoModel
import com.ebookfrenzy.one_word.databinding.FragmentResourcesVideosBinding
import com.ebookfrenzy.one_word.presentation.adapter.VideoListAdapter
import com.ebookfrenzy.one_word.util.ResourceDummyData

class ResourcesVideosFragment : Fragment(), VideoListAdapter.Interaction {
    private var _binding: FragmentResourcesVideosBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    private lateinit var videoRecyclerView: RecyclerView
    private lateinit var videoRvAdapter: VideoListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentResourcesVideosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*Initialise View*/
        videoRecyclerView = binding.resourcesVideoFragmentVideosRecyclerView

        /*Initialise RecyclerView*/
        videoRecyclerView.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            videoRvAdapter = VideoListAdapter(this@ResourcesVideosFragment)
            adapter = videoRvAdapter
            videoRvAdapter.submitList(ResourceDummyData.videoItem)
        }
    }

    override fun onItemSelected(position: Int, item: ResourceGeneralVideoModel) {
//        findNavController().navigate(ResourcesVideosFragmentDirections.actionResourcesVideosFragmentToMediaPlayerFragment())
    }


}