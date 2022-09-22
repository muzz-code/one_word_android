package com.ebookfrenzy.one_word.util

import com.ebookfrenzy.one_word.data.model.ResponseWrapper
import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Response
import retrofit2.Retrofit
import java.io.IOException
import javax.inject.Inject



class ErrorResponseUtil @Inject
constructor
    (var retrofit: Retrofit) {
    fun parseError(response: Response<*>): ResponseWrapper<String> {
        val converter: Converter<ResponseBody, ResponseWrapper<String>> = retrofit
            .responseBodyConverter(ResponseWrapper::class.java, arrayOfNulls<Annotation>(0))

        return try {
            converter.convert(response.errorBody()!!)!!
        } catch (e: IOException) {
            return ResponseWrapper("IO Exception ", "null", 69)
        }
    }
}
