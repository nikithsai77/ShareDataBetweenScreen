package com.android.sharedata.domain

import com.android.sharedata.data.Movie

class GetMovieImpl : GetMovie {
    private var movie: Movie? = null

    override fun getMovie(): String {
        return movie?.name ?: "No Movie Saved"
    }

    override fun setMovie(movie: Movie) {
        this.movie = movie
    }

    override fun clearMovieName() {
        movie = null
    }
}