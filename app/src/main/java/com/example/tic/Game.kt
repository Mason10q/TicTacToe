package com.example.tic

class Game {

    private val crossPlayer = Player.CrossPlayer()
    private val circlePlayer = Player.CirclePlayer()

    private val playersChanges = mapOf<Player, Player>(
        crossPlayer to circlePlayer,
        circlePlayer to crossPlayer
    )

    var orderPlayer: Player = circlePlayer

    fun changeOrder() {
        return
    }

    fun makeMove(x: Int, y: Int) {
        return
    }

    fun getIconId() = 1

    fun checkWinning(x: Int, y: Int) = false
}