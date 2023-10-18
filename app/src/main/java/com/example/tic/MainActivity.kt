package com.example.tic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.tic.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val viewModel by lazy { ViewModelProvider(this)[MainViewModel::class.java] }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.container.addView(createTable())

        viewModel.gameResult.observe(this) { result ->
            endGame(result)
        }
    }

    private fun createTable() = TableLayout(this).apply{
        layoutParams = TableLayout.LayoutParams(
            TableLayout.LayoutParams.MATCH_PARENT,
            TableLayout.LayoutParams.MATCH_PARENT
        )

        for (x in 0..2) {
            addView(createRow(x))
        }
    }

    private fun createRow(x: Int) = TableRow(this).apply {
        for (y in 0..2) {
            addView(createButton(x, y))
        }
    }

    private fun createButton(x: Int, y: Int) =ImageButton(this).apply {
        setOnClickListener { v ->
            makeMove(v, x, y)
        }
    }


    private fun makeMove(v: View, x: Int, y: Int){
        v.setBackgroundResource(viewModel.getIconId())
        viewModel.makeMove(x, y)
        v.isEnabled = false
    }

    private fun endGame(result: String){
        val textView = TextView(this)
        textView.text = result
        binding.container.removeAllViews()
        binding.container.addView(textView)
    }

}