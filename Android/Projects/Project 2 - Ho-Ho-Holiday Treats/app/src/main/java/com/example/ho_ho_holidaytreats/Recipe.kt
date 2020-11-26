package com.example.ho_ho_holidaytreats

import android.app.Activity
import android.content.Intent
import android.graphics.drawable.Drawable
import android.graphics.drawable.TransitionDrawable
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_recipe.*
import kotlinx.android.synthetic.main.activity_recipe.rootLayout

class Recipe : AppCompatActivity() {
    //Variable declarations:
    private var recipeNumber: Int? = null
    private var recipeName: String? = null
    private var recipeInfo: String? = null
    private var recipeIngredients: Array<String>? = null
    private var recipeDetails: String? = null
    private var recipeCitation: String? = null
    private var recipeURL: String? = null
    var imageNumber: Int = 0
    var isStopped: Boolean = true
    var isPlaying: Boolean = false
    var startTime: Long? = null
    var timeLeft = startTime
    var countDownInterval: Long = 1000
    var images: Array<Drawable?> = arrayOf()
    lateinit var recipeTimer: CountDownTimer //https://developer.android.com/reference/android/os/CountDownTimer
    lateinit var mediaPlayer: MediaPlayer //https://developer.android.com/guide/topics/media/mediaplayer
    //I got the audio file from: https://www.musicscreen.org/royalty-free-music-christmas.php


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe)

        //Get the information from the Intent
        recipeNumber = intent.getIntExtra("recipeNumber", 0)
        recipeName = intent.getStringExtra("recipeName")
        recipeInfo = intent.getStringExtra("recipeInfo")
        recipeIngredients = intent.getStringArrayExtra("recipeIngredients")
        timeLeft = intent.getLongExtra("recipeTimer", 0)
        startTime = intent.getLongExtra("recipeTimer", 0)
        recipeDetails = intent.getStringExtra("recipeDetails")
        recipeCitation = intent.getStringExtra("recipeCitation")
        recipeURL = intent.getStringExtra("recipeURL")

        //Indicate that the information was successfully received
        recipeNumber.let{ Log.i("Recipe number received", it.toString())}
        recipeName?.let{ Log.i("Name received", it)}
        recipeInfo?.let{ Log.i("Info received", it)}
        recipeIngredients?.let{ Log.i("Ingredients received", it.toString())}
        timeLeft?.let{ Log.i("Timer value received", it.toString())}
        recipeDetails?.let{ Log.i("Recipe received", it)}
        recipeCitation?.let{ Log.i("Citation received", it)}
        recipeURL?.let{ Log.i("URL received", it)}

        //Fill in TextViews
        recipeName?.let{recipeTitleTextView.text = it}
        recipeInfo?.let {recipeInfoTextView.text = it}
        recipeDetails?.let{recipeTextView.text = it}
        recipeCitation?.let{citationTextView.text = it}

        //Fill in the checkboxes
        recipeIngredients?.get(0).let {checkBox1.text = it}
        recipeIngredients?.get(1).let {checkBox2.text = it}
        recipeIngredients?.get(2).let {checkBox3.text = it}
        recipeIngredients?.get(3).let {checkBox4.text = it}
        recipeIngredients?.get(4).let {checkBox5.text = it}
        recipeIngredients?.get(5).let {checkBox6.text = it}
        recipeIngredients?.get(6).let {checkBox7.text = it}
        recipeIngredients?.get(7).let {checkBox8.text = it}
        recipeIngredients?.get(8).let {checkBox9.text = it}
        recipeIngredients?.get(9).let {checkBox10.text = it}
        recipeIngredients?.get(10).let {checkBox11.text = it}
        recipeIngredients?.get(11).let {checkBox12.text = it}
        recipeIngredients?.get(12).let {checkBox13.text = it}
        recipeIngredients?.get(13).let {checkBox14.text = it}
        recipeIngredients?.get(14).let {checkBox15.text = it}

        //Set the starting image and image array based on the recipe number:
        when (recipeNumber) {
            1 -> {
                images = arrayOf(getDrawable(R.drawable.recipe1image1), getDrawable(R.drawable.recipe1image2), getDrawable(R.drawable.recipe1image3))
                mainImageView.setImageResource(R.drawable.recipe1image1)
                circleIndicatorImageView.setImageResource(R.drawable.circle1)
            }
            2 -> {
                images = arrayOf(getDrawable(R.drawable.recipe2image1), getDrawable(R.drawable.recipe2image2), getDrawable(R.drawable.recipe2image3))
                mainImageView.setImageResource(R.drawable.recipe2image1)
                circleIndicatorImageView.setImageResource(R.drawable.circle1)
            }
            3 -> {
                images = arrayOf(getDrawable(R.drawable.recipe3image1), getDrawable(R.drawable.recipe3image2), getDrawable(R.drawable.recipe3image3))
                mainImageView.setImageResource(R.drawable.recipe3image1)
                circleIndicatorImageView.setImageResource(R.drawable.circle1)
            }
            4 -> {
                images = arrayOf(getDrawable(R.drawable.recipe4image1), getDrawable(R.drawable.recipe4image2), getDrawable(R.drawable.recipe4image3))
                mainImageView.setImageResource(R.drawable.recipe4image1)
                circleIndicatorImageView.setImageResource(R.drawable.circle1)
            }
        }

        mediaPlayer = MediaPlayer.create(this, R.raw.jinglebells) //Initialize the MediaPlayer

        //Load the recipe's website when the "View Recipe On Website" button is pressed
        websiteButton.setOnClickListener {
            loadWebsite()
        }

        //When the start/stop button is clicked:
        startStopButton.setOnClickListener {
            if (!isStopped) { //If the timer is going:
                pauseTimer() //Pause the timer
            } else { //If the timer has stopped:
                startTimer() //Start the timer
            }
        }

        //When the reset button is clicked:
        resetButton.setOnClickListener {
            resetTimer() //Reset the timer
        }

        displayTime() //Display the remaining time in the TextView
    }

    //Function to start the timer
    //Got help with the countdown timer from: https://www.youtube.com/watch?v=MDuGwI6P-X8 and https://www.youtube.com/watch?v=LMYQS1dqfo8
    fun startTimer() {
        //Create a new CountDownTimer object
        recipeTimer = object : CountDownTimer(timeLeft!!, countDownInterval) {
            override fun onTick(millisUntilFinished: Long) { //While the timer is still going:
                timeLeft = millisUntilFinished //Set the time remaining on the timer
                displayTime() //Display the time in the TextView
            }

            override fun onFinish() { //When the timer is complete:
                isStopped = true //Set isStopped to true
                mediaPlayer.start() //Start the music
                isPlaying = true //Set isPlaying to true
                timerView.setText("All Done!") //Display completion message
                startStopButton.isVisible = false //Hide the start/stop button
                resetButton.isVisible = true //Make the reset button visible
            }
        }.start() //Start the timer

        isStopped = false //Set isStopped to false
        startStopButton.text = "STOP" //Change the start/stop button to stop
        resetButton.isVisible = false //Hide the reset button while the timer is active
    }

    //Function to pause the timer
    fun pauseTimer() {
        recipeTimer.cancel() //Pause the timer
        isStopped = true //Set isStopped to true
        startStopButton.setText("START") //Change the start/stop button back to start
        resetButton.isVisible = true //Make the reset button visible
    }

    //Function to reset the timer
    fun resetTimer() {
        mediaPlayer.pause() //Pause the music
        isPlaying = false //Set isPlaying to false

        //If the start/stop button is invisible (after the timer finishes)
        if (!startStopButton.isVisible) {
            startStopButton.isVisible = true //Make it visible again
        }
        timeLeft = startTime //Reset the time left to the original time
        displayTime() //Display the time on the TextView
        startStopButton.setText("START") //Change the start/stop button back to start
        isStopped = true //Set isStopped to true
    }

    //Function to display the remaining time on the TextView
    fun displayTime() {
        if (timeLeft!! <= 1000) { //If there is less than a second left:
            timerView.setText("All Done!") //Display completion message
        } else {
            var minutes = timeLeft?.div(60000) //Convert milliseconds to minutes
            var seconds = (timeLeft?.div(1000))?.rem(60) //Convert milliseconds to seconds
            timerView.setText("$minutes:$seconds") //Display the time
        }
    }

    //Implicit Intent: Open a browser app based on the given URL
    fun loadWebsite() {
        var intent = Intent() //Create Intent
        intent.action = Intent.ACTION_VIEW //Set the action
        intent.data = recipeURL?.let{ Uri.parse(recipeURL)} //Parse the string and apply it to the data property

        //Verify that there is an app that can deal with the intent
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Snackbar.make(rootLayout, "Website failed to open.", Snackbar.LENGTH_SHORT).show() //Show a snackbar
        }
    }

    //Add a fade animation to the image swapping using the TransitionDrawable class
    //https://stackoverflow.com/questions/7161500/creating-animation-on-imageview-while-changing-image-resource
    fun setImageDrawableWithAnimation(imageView: ImageView, drawable: Drawable?, duration: Int) {
        val currentDrawable = imageView.drawable //Get the current image in the ImageView
        val transitionDrawable = TransitionDrawable(arrayOf(currentDrawable, drawable)) //Create a TransitionDrawable with the current and next image
        imageView.setImageDrawable(transitionDrawable) //Set the image in the ImageView
        transitionDrawable.startTransition(duration) //Start the fade transition between both images
    }

    //Function to swap images when the right arrow is pressed:
    fun rightButton(view: View) {
        imageNumber += 1 //Increment the imageNumber by 1
        when (imageNumber) {
            0 -> { //Display first image
                setImageDrawableWithAnimation(mainImageView, images[0], 300)
                setImageDrawableWithAnimation(circleIndicatorImageView, getDrawable(R.drawable.circle1), 300)
            }
            1 -> { //Display second image
                setImageDrawableWithAnimation(mainImageView, images[1], 300)
                setImageDrawableWithAnimation(circleIndicatorImageView, getDrawable(R.drawable.circle2), 300)
            }
            2 -> { //Display third image
                setImageDrawableWithAnimation(mainImageView, images[2], 300)
                setImageDrawableWithAnimation(circleIndicatorImageView, getDrawable(R.drawable.circle3), 300)
            }
            3 -> { //If the imageNumber is 3, display the first image (to allow for a loop)
                setImageDrawableWithAnimation(mainImageView, images[0], 300)
                setImageDrawableWithAnimation(circleIndicatorImageView, getDrawable(R.drawable.circle1), 300)
                imageNumber = 0
            }
            else -> println("ERROR") //Display an error
        }
    }

    //Function to swap images when the left arrow is pressed:
    fun leftButton(view: View) {
        imageNumber -= 1 //Decrement imageNumber by 1
        when (imageNumber) {
            -1 -> { //If the imageNumber is -1, display the third image (to allow for a loop)
                setImageDrawableWithAnimation(mainImageView, images[2], 300)
                setImageDrawableWithAnimation(circleIndicatorImageView, getDrawable(R.drawable.circle3), 300)
                imageNumber = 2
            }
            0 -> { //Display first image
                setImageDrawableWithAnimation(mainImageView, images[0], 300)
                setImageDrawableWithAnimation(circleIndicatorImageView, getDrawable(R.drawable.circle1), 300)
            }
            1 -> { //Display second image
                setImageDrawableWithAnimation(mainImageView, images[1], 300)
                setImageDrawableWithAnimation(circleIndicatorImageView, getDrawable(R.drawable.circle2), 300)
            }
            2 -> { //Display third image
                setImageDrawableWithAnimation(mainImageView, images[2], 300)
                setImageDrawableWithAnimation(circleIndicatorImageView, getDrawable(R.drawable.circle3), 300)
            }
            else -> println("ERROR") //Display an error
        }
    }

    //Function to restore the app's UI
    fun updateUI() {
        when (imageNumber) {
            -1 -> { //If the imageNumber is -1, display the third image (to allow for a loop)
                setImageDrawableWithAnimation(mainImageView, images[2], 300)
                setImageDrawableWithAnimation(circleIndicatorImageView, getDrawable(R.drawable.circle3), 300)
                imageNumber = 2
            }
            0 -> { //Display first image
                setImageDrawableWithAnimation(mainImageView, images[0], 300)
                setImageDrawableWithAnimation(circleIndicatorImageView, getDrawable(R.drawable.circle1), 300)
            }
            1 -> { //Display second image
                setImageDrawableWithAnimation(mainImageView, images[1], 300)
                setImageDrawableWithAnimation(circleIndicatorImageView, getDrawable(R.drawable.circle2), 300)
            }
            2 -> { //Display third image
                setImageDrawableWithAnimation(mainImageView, images[2], 300)
                setImageDrawableWithAnimation(circleIndicatorImageView, getDrawable(R.drawable.circle3), 300)
            }
            3 -> { //If the imageNumber is 3, display the first image (to allow for a loop)
                setImageDrawableWithAnimation(mainImageView, images[0], 300)
                setImageDrawableWithAnimation(circleIndicatorImageView, getDrawable(R.drawable.circle1), 300)
                imageNumber = 0
            }
        }
    }

    //Function to save the current app instance
    override fun onSaveInstanceState(outState: Bundle) {
        imageNumber.let{outState.putInt("imageNumber", it)} //Save the image number
        timeLeft?.let{outState.putLong("timeLeft", it)} //Save the time left on the timer
        isStopped.let{outState.putBoolean("isStopped", it)} //Save the state of the timer
        isPlaying.let{outState.putBoolean("isPlaying", it)} //Save the state of the media player
        mediaPlayer.currentPosition.let{outState.putInt("songTime", it)} //Save the current position of the song

        //If the media player is playing, pause it
        if (mediaPlayer.isPlaying) {
            mediaPlayer.pause()
        }
        super.onSaveInstanceState(outState)
    }
    //Function to restore the previous app instance
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        imageNumber = savedInstanceState.getInt("imageNumber") //Restore the image number
        timeLeft = savedInstanceState.getLong("timeLeft") //Restore the time left on the timer
        isStopped = savedInstanceState.getBoolean("isStopped") //Restore the timer's state
        isPlaying = savedInstanceState.getBoolean("isPlaying") //Restore the media player's state

        //https://stackoverflow.com/questions/17917994/how-to-play-audio-continuously-while-orientation-changes-in-android
        var songPosition = savedInstanceState.getInt("songTime") //Get the song time
        mediaPlayer.seekTo(songPosition) //Restore the song from the right timer

        updateUI() //Update the UI with the restored values
        displayTime() //Display the correct time on the timer TextView
        if (!isStopped) //If the timer was not stopped before the rotation:
            startTimer() //Start the timer again
        if (isPlaying) //If the timer was playing before the rotation:
            mediaPlayer.start() //Start the media player again
    }

    //When the back button is pressed:
    override fun onBackPressed() {
        //Prevent the music from playing on the home screen:
        if (mediaPlayer.isPlaying) {
            mediaPlayer.pause()
        }
        super.onBackPressed()
        finish()
    }
}