package com.ebookfrenzy.one_word.di

import com.ebookfrenzy.one_word.data.remote.ApiService
import com.ebookfrenzy.one_word.presentation.ui.program.ProgramImpRepoImpl
import com.ebookfrenzy.one_word.presentation.ui.program.ProgramRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun programRepository(
         apiService: ApiService,
//        userRegDTOMapper: UserRegDTOMapper,
//        loginCredentialsDTOMapper: LoginCredentialsDTOMapper,
    ): ProgramRepository {
        return ProgramImpRepoImpl(apiService)
    }
}