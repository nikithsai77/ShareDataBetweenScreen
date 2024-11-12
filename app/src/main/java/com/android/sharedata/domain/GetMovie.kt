package com.android.sharedata.domain

import com.android.sharedata.data.Movie

interface GetMovie {
    fun getMovie(): String
    fun setMovie(movie: Movie)
    fun clearMovieName()
}