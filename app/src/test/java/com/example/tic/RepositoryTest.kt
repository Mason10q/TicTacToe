package com.example.tic

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class RepositoryTest {

    private lateinit var repository: Repository

    @BeforeEach
    fun setUp() {
        repository = Repository()
    }

    @Test
    fun getIconId() {
        var icon = 0

        if(repository.game.orderPlayer::class == Player.CirclePlayer::class){
            icon = R.drawable.ic_circle
        } else {
            icon = R.drawable.ic_cross
        }

        Assertions.assertEquals(icon, repository.getIconId())
    }

    @Test
    fun makeMove() {
        val x = 1
        val y = 2
        repository.makeMove(x, y) {x, y -> }

        repository.game.changeOrder()
        Assertions.assertEquals(true, repository.game.orderPlayer.positions[x][y])
    }
}

