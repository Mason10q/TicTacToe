package com.example.tic

import androidx.annotation.DrawableRes

sealed class Player(@DrawableRes private val iconId: Int) {

    val positions = arrayOf(
        arrayOf(false, false, false),
        arrayOf(false, false, false),
        arrayOf(false, false, false)
    )

    fun isRowWinning(x: Int): Boolean = true

    fun isColumnWinning(y: Int): Boolean = true

    fun isDiagonalsWinning(): Boolean = true

    fun putItem(x: Int, y: Int) {
        return
    }

    fun isWinning(x: Int, y: Int): Boolean = true

    fun getIconId(): Int = 1

    class CrossPlayer: Player(R.drawable.ic_cross)
    class CirclePlayer: Player(R.drawable.ic_circle)

}