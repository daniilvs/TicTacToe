package com.example.tictactoe

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class Game : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
    }

    fun buttonOnClick(view: View) {
        val clickedButton = view as Button
        var buttonID = 0
        when (clickedButton.id) {
            R.id.button0 -> buttonID = 1
            R.id.button1 -> buttonID = 2
            R.id.button2 -> buttonID = 3
            R.id.button3 -> buttonID = 4
            R.id.button4 -> buttonID = 5
            R.id.button5 -> buttonID = 6
            R.id.button6 -> buttonID = 7
            R.id.button7 -> buttonID = 8
            R.id.button8 -> buttonID = 9
        }

        play(buttonID, clickedButton)

    }

    private val player1 = mutableListOf<Int>()
    private val player2 = mutableListOf<Int>()

    private var activePlayer = 1

    private fun play(buttonID: Int, clickedButton: Button) {
        if (activePlayer == 1) {
            clickedButton.text = "X"
            clickedButton.setBackgroundColor(Color.parseColor("#ff8442"))
            player1.add(buttonID)
            activePlayer = 2
        }
        else {
            clickedButton.text = "O"
            clickedButton.setBackgroundColor(Color.parseColor("5ec2d1"))
            player2.add(buttonID)
            activePlayer = 1
        }
        clickedButton.isEnabled = false
        whoWon()
    }

    private fun whoWon() {
        var winner = -1
        when {
            player1.containsAll(listOf(1, 2, 3)) ||
                    player1.containsAll(listOf(4, 5, 6)) ||
                    player1.containsAll(listOf(7, 8, 9)) ||
                    player1.containsAll(listOf(1, 4, 7)) ||
                    player1.containsAll(listOf(2, 5, 8)) ||
                    player1.containsAll(listOf(3, 6, 9)) ||
                    player1.containsAll(listOf(1, 5, 9)) ||
                    player1.containsAll(listOf(7, 5, 3)) -> winner = 1
            player2.containsAll(listOf(1, 2, 3)) ||
                    player2.containsAll(listOf(4, 5, 6)) ||
                    player2.containsAll(listOf(7, 8, 9)) ||
                    player2.containsAll(listOf(1, 4, 7)) ||
                    player2.containsAll(listOf(2, 5, 8)) ||
                    player2.containsAll(listOf(3, 6, 9)) ||
                    player2.containsAll(listOf(1, 5, 9)) ||
                    player2.containsAll(listOf(7, 5, 3)) -> winner = 2
        }

        when (winner) {
            1 -> {
                Toast.makeText(this, "Player 1 wins this game", Toast.LENGTH_LONG).show()
                stopLockTask()
            }
            2 -> {
                Toast.makeText(this, "Player 2 wins this game", Toast.LENGTH_LONG).show()
                stopLockTask()
            }
            -1 -> {
                Toast.makeText(this, "Draw", Toast.LENGTH_LONG).show()
                stopLockTask()
            }
        }
    }
}

