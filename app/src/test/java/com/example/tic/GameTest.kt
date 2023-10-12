package com.example.tic

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach

internal class GameTest {

    private lateinit var game: Game

    @BeforeEach
    fun setUp(){
        game = Game()
    }

    @Test
    fun changeOrder() {
        val crossClass= Player.CrossPlayer::class
        val circleClass = Player.CirclePlayer::class
        game.changeOrder()
        assertEquals(crossClass, game.orderPlayer::class)
        game.changeOrder()
        assertEquals(circleClass, game.orderPlayer::class)
    }

    @Test
    fun makeMove() {
        val x = 0
        val y = 0

        game.makeMove(x, y)

        assertEquals(true, game.orderPlayer.positions[0][0])
    }

    @Test
    fun getIconId() {
        var icon = 0

        if(game.orderPlayer::class == Player.CirclePlayer::class){
            icon = R.drawable.ic_circle
        } else {
            icon = R.drawable.ic_cross
        }

        assertEquals(icon, game.getIconId())
    }

    @Test
    fun checkWinning() {
        game.makeMove(0, 0)
        game.makeMove(0, 1)

        assertEquals(false, game.checkWinning(0, 1))

        game.makeMove(0, 2)

        assertEquals(true, game.checkWinning(0, 2))
    }
}