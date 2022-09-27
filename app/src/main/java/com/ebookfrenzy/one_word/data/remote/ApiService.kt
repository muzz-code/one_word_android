package com.ebookfrenzy.one_word.data.remote

import com.ebookfrenzy.one_word.data.model.ProgramData
import retrofit2.http.GET

interface ApiService {
    @GET("OneTvProgram/GetAllPrograms")
    suspend fun getPrograms(): ProgramData
}