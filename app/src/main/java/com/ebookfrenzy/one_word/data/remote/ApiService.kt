package com.ebookfrenzy.one_word.data.remote

import com.ebookfrenzy.one_word.data.model.Data
import com.ebookfrenzy.one_word.data.model.ResponseWrapper
import retrofit2.http.GET

//https://one-word-tv-backend.herokuapp.com/api/v1/OneTvProgram/GetAllPrograms
interface ApiService {
    @GET("OneTvProgram/GetAllPrograms")
    suspend fun getPrograms(): ResponseWrapper<Data>
}