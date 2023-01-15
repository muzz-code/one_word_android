package com.ebookfrenzy.one_word.presentation.ui.program

import com.ebookfrenzy.one_word.data.model.ProgramDataResponse
import com.ebookfrenzy.one_word.data.remote.ApiService
import com.ebookfrenzy.one_word.util.Resource
import com.ebookfrenzy.one_word.util.SafeApiCall
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import retrofit2.Response
import javax.inject.Inject

class ProgramImpRepoImpl @Inject constructor( private val apiService: ApiService):  ProgramRepository, SafeApiCall()   {
//    override suspend fun getProgram(): Flow<Resource<ResponseWrapper<Data>>> {
//      return  apiService.getPrograms()
//    }
    override suspend fun getProgram(): Flow<Resource<ProgramDataResponse>> = flow {
        emit(Resource.Loading())
        try {
            val response = safeApiCall { apiService.getPrograms() }
            emit(response)
        } catch (e: Exception) {
            when (e) {
                is HttpException -> emit(Resource.Error( false, e.response()?.errorBody() as Response<Any>, null , "HttpException"))
                is IOException -> emit(Resource.Error( false, null, null , "No Internet Connection, Please check your internet connection"))
                is java.net.UnknownHostException -> emit(Resource.Error(false, null, null, "Something went wrong"))
                else -> emit(Resource.Error(false, null, null, "Something went wrong"))
            }
        }
    }


}