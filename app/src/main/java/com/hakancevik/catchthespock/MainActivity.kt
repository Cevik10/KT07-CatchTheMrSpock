package com.hakancevik.catchthespock

import android.graphics.Color

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ImageView

import com.hakancevik.catchthespock.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var scoreCount = 0
    private var imageArray = ArrayList<ImageView>()
    private var runnable: Runnable = Runnable { }
    private var handler: Handler = Handler(Looper.getMainLooper())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.startButton.visibility = View.VISIBLE
        binding.InfoText.visibility = View.VISIBLE
        binding.spockImage.visibility = View.VISIBLE

        binding.scoreText.visibility = View.GONE
        binding.timeText.visibility = View.GONE
        binding.gridLayout.visibility = View.GONE

        imageArray = arrayListOf(
            binding.spockImage1,
            binding.spockImage2,
            binding.spockImage3,
            binding.spockImage4,
            binding.spockImage5,
            binding.spockImage6,
            binding.spockImage7,
            binding.spockImage8,
            binding.spockImage9
        )


    }


    fun incScore(view: View) {
        scoreCount += 1
        binding.scoreText.text = "Score: $scoreCount"
    }

    fun startGame(view: View) {
        binding.startButton.visibility = View.GONE
        binding.InfoText.visibility = View.GONE
        binding.spockImage.visibility = View.GONE

        binding.scoreText.visibility = View.VISIBLE
        binding.timeText.visibility = View.VISIBLE
        binding.gridLayout.visibility = View.VISIBLE

        scoreCount = 0
        binding.scoreText.text = "Score: $scoreCount"
        binding.timeText.text = "Time: 20 s"

        hideImage()

        object : CountDownTimer(15251, 1000) {
            override fun onTick(p0: Long) {
                binding.timeText.text = "Time: ${p0 / 1000}"
            }

            override fun onFinish() {
                handler.removeCallbacks(runnable)
                for (i in 0..8) {
                    imageArray[i].visibility = View.INVISIBLE
                }

                binding.timeText.text = "Time Over!"

                binding.startButton.visibility = View.VISIBLE
                binding.startButton.text = "Restart!"

                binding.InfoText.visibility = View.VISIBLE
                binding.InfoText.text = "Your Score: $scoreCount"
                binding.InfoText.setTextColor(Color.YELLOW)

                binding.spockImage.visibility = View.VISIBLE

                binding.scoreText.visibility = View.GONE
                binding.timeText.visibility = View.GONE
                binding.gridLayout.visibility = View.GONE


            }

        }.start()


    }

    private fun hideImage() {


        runnable = object : Runnable {
            override fun run() {

                for (i in 0..8) {
                    imageArray[i].visibility = View.INVISIBLE
                }

                val randomNumber = (0..8).random()
                imageArray[randomNumber].visibility = View.VISIBLE

                handler.postDelayed(this, 650)

            }

        }
        handler.post(runnable)


    }


}