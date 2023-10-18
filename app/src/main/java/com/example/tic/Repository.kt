package com.example.tic

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class Repository {

    val game = Game()

    var counter: Int = 0

    fun getIconId() = game.getIconId()

    fun makeMove(x: Int, y: Int, checkWin: (Int, Int) -> Unit) {
        counter += 1
        game.makeMove(x, y)

        checkWin(x, y)

        game.changeOrder()
    }

}

