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
        orderPlayer = playersChanges[orderPlayer]!!
    }

    fun makeMove(x: Int, y: Int) {
        orderPlayer.putItem(x, y)
    }

    fun getIconId() = orderPlayer.getIconId()

    fun checkWinning(x: Int, y: Int) = orderPlayer.isWinning(x, y)
}