package com.ebookfrenzy.one_word.data.model


data class ResponseWrapper<T>(
    val message: String,
    val `data`: T,
    val status: Int
)