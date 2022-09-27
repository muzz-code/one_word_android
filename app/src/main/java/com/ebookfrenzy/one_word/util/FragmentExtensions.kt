package com.ebookfrenzy.one_word.util

import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import retrofit2.Retrofit

fun <T> Fragment.handleApiError(
    failure: Resource.Error<T>,
    retrofit: Retrofit,
    view: View,
//    sessionManager: SessionManager,
//    database: CladsDatabase
) {
    val errorResponseUtil = ErrorResponseUtil(retrofit)
    when (failure.isNetworkError) {
        true -> {
            view.showSnackBar("Poor Internet Connection. Retry")
        }
        else -> {
            try {
                val error = failure.errorBody?.let { it1 -> errorResponseUtil.parseError(it1) }
                val errorMessage = error?.message
                if (errorMessage != null) {

                } else {
                    view.showSnackBar("Something went wrong!... Retry")
                }
            } catch (e: Exception) {
                view.showSnackBar("Bad request. Check Input again.")
            }
        }
    }
}