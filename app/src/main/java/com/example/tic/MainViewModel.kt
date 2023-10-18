package com.example.tic

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    private val repo = Repository()

    private val _gameResult = MutableLiveData<String>()
    val gameResult: LiveData<String> = _gameResult

    fun getIconId() = repo.getIconId()

    fun checkWin(x: Int, y: Int){
        if(repo.game.checkWinning(x, y)){
            _gameResult.postValue("Победа")
            return
        }

        if(repo.counter == 9){
            _gameResult.postValue("Ничья")
            return
        }
    }
    fun makeMove(x: Int, y: Int){
        repo.makeMove(x, y, ::checkWin)
    }


}