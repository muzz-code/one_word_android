package com.ebookfrenzy.one_word.presentation.ui.program

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.RecyclerView
import com.ebookfrenzy.one_word.databinding.FragmentProgramBinding
import com.ebookfrenzy.one_word.presentation.adapter.ProgramAdapter
import com.ebookfrenzy.one_word.presentation.ui.BaseFragment
import com.ebookfrenzy.one_word.util.Resource
import com.ebookfrenzy.one_word.util.handleApiError
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ProgramFragment : BaseFragment() {

    private var _binding: FragmentProgramBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val programViewModel: ProgramViewModel by viewModels()
    private lateinit var  programAdapter: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProgramBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        programViewModel.getPrograms()
        onProgramReady()
//        lifecycleScope.launch {
//            repeatOnLifecycle(Lifecycle.State.STARTED) {
//                launch {
//                    programViewModel.uiState.collect {
//
//                    }
//                }
//
//                launch {
//                    programViewModel.uiEvent.collect {
//
//                    }
//                }
//            }
//        }
    }

    private fun onProgramReady(){
        programAdapter = binding.programItemRecyclerView
        lifecycleScope.launch {
            programViewModel.programs.collectLatest {
                when(it){
                    is Resource.Loading -> {
                        progressDialog.showDialogFragment("Updating..")
                    }
                    is Resource.Error -> {
                        progressDialog.hideProgressDialog()
                        handleApiError(it, mainRetrofit, requireView(), )
                    }
                    is Resource.Success -> {
                        progressDialog.hideProgressDialog()
                        programAdapter.adapter = it.data?.let { it1 -> ProgramAdapter(it1.data) }
                        Log.d("onProgramReady", "onProgramReady: ${it.data?.data}")
                    }
                    }
                }
            }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}