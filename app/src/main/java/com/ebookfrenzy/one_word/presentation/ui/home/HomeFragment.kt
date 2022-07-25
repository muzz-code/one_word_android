package com.ebookfrenzy.one_word.presentation.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
import com.ebookfrenzy.one_word.util.ResourceDummyData
import com.yuyakaido.android.cardstackview.*
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment(){

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val homeViewModel: HomeViewModel by viewModels()
    private lateinit var cardStackView: CardStackView
    private lateinit var manager: CardStackLayoutManager
    private val cardStackAdapter by lazy { CardViewStackAdapter() }

    private var dummyRvItems = ResourceDummyData.cardViewDummyData


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
        lifecycleScope.launch {
            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    homeViewModel.uiState.collect {

                    }
                }

                launch {
                    homeViewModel.uiEvent.collect {

                    }
                }
            }
        }



//        // setting the animation variable
//        val animation =
//            AnimationUtils.loadAnimation(requireContext(), R.anim.circle_explosion_anime).apply {
//                duration = 400
//                interpolator = AccelerateDecelerateInterpolator()
//            }
//
//        // setup for the card stack view
//        cardStackView = binding.stackCardView
//        manager = CardStackLayoutManager(requireContext(), this)
//        cardStackAdapter.submitList(dummyRvItems)
//        initialize()
//
//        // setting the animation on the fab
//        binding.fab.setOnClickListener {
//
//                // navigate after animation
//                findNavController().navigate(HomeFragmentDirections.actionNavHomeToResourcesVideosFragment())
//
//        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
//
//    private fun initialize() {
//        manager.apply {
//            setStackFrom(StackFrom.Top)
//            setVisibleCount(2)
//            setTranslationInterval(12.0f)
//            setScaleInterval(0.95f)
//            setSwipeThreshold(0.3f)
//            setMaxDegree(20.0f)
//            setDirections(Direction.FREEDOM)
//            setCanScrollHorizontal(true)
//            setCanScrollVertical(true)
//            setSwipeableMethod(SwipeableMethod.AutomaticAndManual)
//            setOverlayInterpolator(LinearInterpolator())
//        }
//        binding.stackCardView.apply {
//            itemAnimator.apply {
//                if (this is DefaultItemAnimator) {
//                    supportsChangeAnimations = false
//                }
//            }
//            layoutManager = manager
//            adapter = cardStackAdapter
//
//
//        }
//    }

//    override fun onCardDragging(direction: Direction?, ratio: Float) {}
//
//    override fun onCardSwiped(direction: Direction?) {}
//
//    override fun onCardRewound() {}
//
//    override fun onCardCanceled() {}
//
//    override fun onCardAppeared(view: View?, position: Int) {}
//
//    override fun onCardDisappeared(view: View?, position: Int) {
//        val item = dummyRvItems[position]
//        addLast(item)
//        dummyRvItems = cardStackAdapter.getCardViewItems()
//
//    }

//
//    /**Recycling the last card on the dashboard*/
//    private fun addLast(item: CardViewData) {
//        val old = cardStackAdapter.getCardViewItems()
//        val new = mutableListOf<CardViewData>().apply {
//            addAll(old)
//            addAll(List(1){item})
//        }
//        val callback = CardViewDiffCallback(old, new)
//        val result = DiffUtil.calculateDiff(callback)
//        cardStackAdapter.submitList(new)
//        result.dispatchUpdatesTo(cardStackAdapter)
//    }
}