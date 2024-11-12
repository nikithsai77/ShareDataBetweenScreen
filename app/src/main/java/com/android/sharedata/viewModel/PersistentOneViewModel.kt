package com.android.sharedata.viewModel

import androidx.lifecycle.ViewModel
import com.android.sharedata.data.Movie
import com.android.sharedata.domain.GetMovie
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PersistentOneViewModel @Inject constructor(private val getMovie: GetMovie) : ViewModel() {

    fun setMovie() {
        getMovie.setMovie(Movie(name = "The Mummy"))
    }

    fun getMovie(): String {
        return if (getMovie.getMovie().equals(other = "No Movie Saved", ignoreCase = true)) "Click Here To Store The Movie" else getMovie.getMovie()
    }

}