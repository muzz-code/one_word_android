package com.ebookfrenzy.one_word.data.remote

import com.ebookfrenzy.one_word.data.model.ProgramDataResponse
import retrofit2.http.GET

interface ApiService {
    @GET("OneTvProgram/GetAllPrograms")
    suspend fun getPrograms(): ProgramDataResponse
}