package com.hakancevik.catchthespock

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.core.view.isVisible
import com.hakancevik.catchthespock.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var scoreCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.startButton.isVisible = true
        binding.InfoText.isVisible = true
        binding.spockImage.isVisible = true

        binding.scoreText.isVisible = false
        binding.timeText.isVisible = false
        binding.gridLayout.isVisible = false


    }


    fun incScore(view: View) {
        scoreCount += 1
    }
}