package com.example.tic

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class Repository {

    val game = Game()

    var counter: Int = 0

    fun getIconId() = 0

    fun makeMove(x: Int, y: Int, checkWin: () -> Unit) {
        return
    }

}

