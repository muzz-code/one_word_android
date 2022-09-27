package com.ebookfrenzy.one_word.presentation.ui.program

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ebookfrenzy.one_word.data.model.ProgramData
import com.ebookfrenzy.one_word.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProgramViewModel @Inject constructor(
    private val repository: ProgramRepository
) : ViewModel() {
    // UI state exposed to the UI
    private val _uiState = MutableStateFlow("This is gallery Fragment")
    val uiState: StateFlow<String> = _uiState.asStateFlow()

    private val _programs = MutableStateFlow<Resource<ProgramData>>(Resource.Loading())
    val programs = _programs.asStateFlow()

    private val _uiEvent = Channel<String>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun getPrograms() {
        _programs.value = Resource.Loading()
        viewModelScope.launch(Dispatchers.IO) {
            val result = repository.getProgram()
            result.collect(){
                _programs.value = it
                Log.d("getPrograms", "getPrograms: ${it.data?.data} ")
            }
        }
        //        _uiState.value = "This is gallery Fragment"

    }

}