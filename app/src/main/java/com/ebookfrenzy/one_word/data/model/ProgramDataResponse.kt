package com.ebookfrenzy.one_word.data.model

data class ProgramDataResponse(
    val data: List<ProgramData>,
    val message: String,
    val status: Boolean
)