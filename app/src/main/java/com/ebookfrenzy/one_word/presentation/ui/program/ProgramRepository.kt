package com.ebookfrenzy.one_word.presentation.ui.program

import com.ebookfrenzy.one_word.data.model.ProgramData
import com.ebookfrenzy.one_word.util.Resource
import kotlinx.coroutines.flow.Flow

interface ProgramRepository {
    suspend fun getProgram(): Flow<Resource<ProgramData>>
}