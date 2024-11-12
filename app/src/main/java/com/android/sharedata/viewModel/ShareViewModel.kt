package com.android.sharedata.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.sharedata.data.Movie

class ShareViewModel: ViewModel() {
    private val mutableLiveData = MutableLiveData<Movie>()
    val liveData : LiveData<Movie> = mutableLiveData

    fun setValue(movie: Movie) {
        mutableLiveData.value = movie
    }
}