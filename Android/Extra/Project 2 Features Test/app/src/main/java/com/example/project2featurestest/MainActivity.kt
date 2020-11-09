package com.example.project2featurestest

import android.graphics.drawable.Drawable
import android.graphics.drawable.TransitionDrawable
import android.media.MediaPlayer
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    //Variable declarations:
    var imageNumber = 0
    var isStopped = true
    var timeLeft: Long = 5000
    var millisInFuture: Long = 5000
    var countDownInterval: Long = 1000
    lateinit var mediaPlayer: MediaPlayer //https://developer.android.com/guide/topics/media/mediaplayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        displayTime(millisInFuture) //Display the time
        mediaPlayer = MediaPlayer.create(this, R.raw.jinglebells) //Initialize the MediaPlayer
    }

    //https://developer.android.com/reference/kotlin/android/os/CountDownTimer
    //https://stackoverflow.com/questions/54095875/kotlin-simple-countdown-timer
    //https://android--code.blogspot.com/2018/04/android-kotlin-countdowntimer-start.html
    fun timer(millisInFuture: Long, countDownInterval: Long): CountDownTimer {
        return object: CountDownTimer(millisInFuture, countDownInterval) {
            override fun onTick(millisUntilFinished: Long) { //When the timer is active:
                if(isStopped == true) { //If isStopped is true:
                    resetButton.isVisible = true //Make the reset button visible
                    cancel() //Stop the timer
                    timeLeft = millisUntilFinished //Record how much time is left (to allow for resuming)
                    displayTime(millisUntilFinished) //Display the time
                } else {
                    resetButton.isVisible = false //Hide the reset button
                    displayTime(millisUntilFinished) //Display the time
                }
            }

            //When the countdown is over:
            override fun onFinish() {
                mediaPlayer.start() //Start the music
                timerView.setText("All Done!") //Display completion message
                startStopButton.isVisible = false //Hide the start/stop button
                resetButton.isVisible = true //make the reset button visible
            }
        }
    }

    //https://stackoverflow.com/questions/7161500/creating-animation-on-imageview-while-changing-image-resource
    fun setImageDrawableWithAnimation(imageView: ImageView, drawable: Drawable?, duration: Int) {
        val currentDrawable = imageView.drawable
        if (currentDrawable == null) {
            imageView.setImageDrawable(drawable)
            return
        }
        val transitionDrawable = TransitionDrawable(arrayOf(currentDrawable, drawable))
        imageView.setImageDrawable(transitionDrawable)
        transitionDrawable.startTransition(duration)
    }

    //Function for when the right arrow is pressed:
    fun rightButton(view: View) {
        imageNumber += 1 //Increment the imageNumber by 1
        when (imageNumber) {
            0 -> { //Display first image
                setImageDrawableWithAnimation(imageView, getDrawable(R.drawable.image1), 300)
                setImageDrawableWithAnimation(imageView2, getDrawable(R.drawable.circle1), 300)
//                imageView.setImageResource(R.drawable.image1)
//                imageView2.setImageResource(R.drawable.circle1)
            }
            1 -> { //Display second image
                setImageDrawableWithAnimation(imageView, getDrawable(R.drawable.image2), 300)
                setImageDrawableWithAnimation(imageView2, getDrawable(R.drawable.circle2), 300)
//                imageView.setImageResource(R.drawable.image2)
//                imageView2.setImageResource(R.drawable.circle2)
            }
            2 -> { //Display third image
                setImageDrawableWithAnimation(imageView, getDrawable(R.drawable.image3), 300)
                setImageDrawableWithAnimation(imageView2, getDrawable(R.drawable.circle3), 300)
//                imageView.setImageResource(R.drawable.image3)
//                imageView2.setImageResource(R.drawable.circle3)
            }
            3 -> { //If the imageNumber is 3, display the first image (to allow for a loop)
                setImageDrawableWithAnimation(imageView, getDrawable(R.drawable.image1), 300)
                setImageDrawableWithAnimation(imageView2, getDrawable(R.drawable.circle1), 300)
//                imageView.setImageResource(R.drawable.image1)
//                imageView2.setImageResource(R.drawable.circle1)
                imageNumber = 0
            }
            else -> println("ERROR") //Display an error
        }
    }

    //Function for when the left arrow is pressed:
    fun leftButton(view: View) {
        imageNumber -= 1 //Decrement imageNumber by 1
        when (imageNumber) {
            -1 -> { //If the imageNumber is -1, display the third image (to allow for a loop)
                setImageDrawableWithAnimation(imageView, getDrawable(R.drawable.image3), 300)
                setImageDrawableWithAnimation(imageView2, getDrawable(R.drawable.circle3), 300)
//                imageView.setImageResource(R.drawable.image3)
//                imageView2.setImageResource(R.drawable.circle3)
                imageNumber = 2
            }
            0 -> { //Display first image
                setImageDrawableWithAnimation(imageView, getDrawable(R.drawable.image1), 300)
                setImageDrawableWithAnimation(imageView2, getDrawable(R.drawable.circle1), 300)
//                imageView.setImageResource(R.drawable.image1)
//                imageView2.setImageResource(R.drawable.circle1)
            }
            1 -> { //Display second image
                setImageDrawableWithAnimation(imageView, getDrawable(R.drawable.image2), 300)
                setImageDrawableWithAnimation(imageView2, getDrawable(R.drawable.circle2), 300)
//                imageView.setImageResource(R.drawable.image2)
//                imageView2.setImageResource(R.drawable.circle2)
            }
            2 -> { //Display third image
                setImageDrawableWithAnimation(imageView, getDrawable(R.drawable.image3), 300)
                setImageDrawableWithAnimation(imageView2, getDrawable(R.drawable.circle3), 300)
//                imageView.setImageResource(R.drawable.image3)
//                imageView2.setImageResource(R.drawable.circle3)
            }
            else -> println("ERROR") //Display an error
        }
    }

    //Function to start/stop the timer
    fun startStopTimer(view: View) {
        if(isStopped == true){ //If the timer is paused/stopped and the START button is pressed:
            isStopped = false //Change isStopped to false
            timer(timeLeft, countDownInterval).start() //Start the timer
            startStopButton.setText("STOP") //Change the button to say STOP
        } else { //If the STOP button is pressed
            isStopped = true //Change isStopped to true
            startStopButton.setText("START") //Change the button to say START
        }
    }

    //Function to reset the timer
    fun resetTimer(view: View) {
        mediaPlayer.pause() //Pause the music

        //If the start/stop button is invisible (after the timer finishes)
        if (startStopButton.isVisible == false) {
            startStopButton.isVisible = true //Make it visible again
        }
        timeLeft = millisInFuture //Reset the time left to the original time
        displayTime(timeLeft) //Display the time on the TextView
        startStopButton.setText("START") //Change the start/stop button back to start
        isStopped = true //Set isStopped to true
    }

    //Function to display the remaining time on the TextView
    fun displayTime(time: Long) {
        var minutes = time / 60000 //Convert milliseconds to minutes
        var seconds = time / 1000 //Convert milliseconds to seconds
        timerView.setText("Time Remaining: " + minutes + ":" + seconds) //Display the time
    }
}