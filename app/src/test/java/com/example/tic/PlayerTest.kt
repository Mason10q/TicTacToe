package com.example.tic

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class PlayerTest {

    private lateinit var player: Player.CirclePlayer

    @BeforeEach
    fun setUp() {
        player = Player.CirclePlayer()
    }

    @Test
    fun isRowWinning() {
        val x = 1

        for (y in 0..2) {
            player.positions[x][y] = true
        }

        assertEquals(true, player.isRowWinning(x))

        player.positions[x][0] = false
        assertEquals(false, player.isRowWinning(x))
    }

    @Test
    fun isColumnWinning() {
        val y = 0

        for (x in 0..2) {
            player.positions[x][y] = true
        }

        assertEquals(true, player.isRowWinning(y))

        player.positions[2][y] = false
        assertEquals(false, player.isRowWinning(y))
    }

    @Test
    fun isDiagonalsWinning() {
        player.positions[0][0] = true
        player.positions[1][1] = true
        player.positions[2][2] = true

        assertEquals(true, player.isDiagonalsWinning())

        player.positions[0][2] = true
        player.positions[2][0] = true
        player.positions[1][1] = false

        assertEquals(false, player.isDiagonalsWinning())
    }

    @Test
    fun putItem() {
        val x = 2
        val y = 2

        player.putItem(x, y)

        assertEquals(true, player.positions[x][y])
    }

    @Test
    fun isWinning() {
        val x = 2
        val y = 1

        player.positions[x][y] = true
        assertEquals(false, player.isWinning(x, y))

        player.positions[x][0] = true
        player.positions[x][2] = true

        assertEquals(true, player.isWinning(x, y))
    }

    @Test
    fun getIconId() {
        val circleIcon = R.drawable.ic_circle
        assertEquals(circleIcon, player.getIconId())
    }
}