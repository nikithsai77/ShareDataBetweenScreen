package com.android.sharedata.di

import com.android.sharedata.domain.GetMovie
import com.android.sharedata.domain.GetMovieImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Module {

    @Singleton
    @Provides
    fun getMovie() : GetMovie {
        return GetMovieImpl()
    }

}