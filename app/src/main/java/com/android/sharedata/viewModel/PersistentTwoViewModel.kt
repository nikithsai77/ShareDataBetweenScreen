package com.android.sharedata.viewModel

import javax.inject.Inject
import dagger.hilt.android.lifecycle.HiltViewModel
import com.android.sharedata.domain.GetMovie
import androidx.lifecycle.ViewModel

@HiltViewModel
class PersistentTwoViewModel @Inject constructor(private val getMovie: GetMovie) : ViewModel() {

    fun getMovie(): String {
        return getMovie.getMovie()
    }

    fun clearMovieName() {
        getMovie.clearMovieName()
    }

    override fun onCleared() {
        super.onCleared()
        println("kk PersistentTwoViewModel is Cleared.")
    }
}