package com.android.sharedata.viewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.MutableStateFlow

class SharedViewModel : ViewModel() {
    private val _stateFlow = MutableStateFlow(value = 0)
    val stateFlow = _stateFlow.asStateFlow()

    fun updateState() {
        _stateFlow.value++
    }

    override fun onCleared() {
        super.onCleared()
        println("kk ViewModel Cleared")
    }
}