package com.example.tic

import androidx.annotation.DrawableRes

sealed class Player(@DrawableRes private val iconId: Int) {

    val positions = arrayOf(
        arrayOf(false, false, false),
        arrayOf(false, false, false),
        arrayOf(false, false, false)
    )

    fun isRowWinning(x: Int): Boolean = (positions[x][0] && positions[x][1] && positions[x][2])

    private fun isColumnWinning(y: Int): Boolean = (positions[0][y] && positions[1][y] && positions[2][y])

    fun isDiagonalsWinning(): Boolean =
        positions[1][1] && ((positions[0][0] && positions[2][2]) || (positions[0][2] && positions[2][0]))

    fun putItem(x: Int, y: Int) {
        positions[x][y] = true
    }

    fun isWinning(x: Int, y: Int): Boolean{
        return (isRowWinning(x) || isColumnWinning(y) || isDiagonalsWinning())
    }

    fun getIconId() = iconId

    class CrossPlayer: Player(R.drawable.ic_cross)
    class CirclePlayer: Player(R.drawable.ic_circle)
}

