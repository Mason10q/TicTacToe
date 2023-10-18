package com.example.tic

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    private val _gameResult = MutableLiveData<String>()
    val gameResult: LiveData<String> = _gameResult


}