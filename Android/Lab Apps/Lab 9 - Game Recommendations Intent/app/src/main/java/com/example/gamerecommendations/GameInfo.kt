package com.example.gamerecommendations

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_game_info.*
import kotlinx.android.synthetic.main.activity_main.*

class GameInfo : AppCompatActivity() {
    private var gameName:String? = null
    private var gameTrailerURL:String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_info)

        //Get the information from the Intent
        gameName = intent.getStringExtra("gameName")
        gameTrailerURL = intent.getStringExtra("gameTrailerURL")

        //Indicate that the information was successfully received
        gameName?.let{ Log.i("name received", it)}
        gameTrailerURL?.let{ Log.i("URL received", it)}

        //Fill in the TextViews
        gameName?.let{gameInterestTextView.text = "Are you interested in $gameName? Watch the trailer below!"}
        gameName?.let{haveYouPlayedText.text = "Have you played $gameName? Leave a review below!"}

        //Load the YouTube video when the button is pressed
        trailerButton.setOnClickListener {
            loadVideo()
        }
    }

    //Implicit Intent: Open the YouTube app based on the given URL
    fun loadVideo() {
        var intent = Intent() //Create Intent
        intent.action = Intent.ACTION_VIEW //Set the action
        intent.data = gameTrailerURL?.let{ Uri.parse(gameTrailerURL)} //Parse the string and apply it to the data property

        //Verify that there is an app that can deal with the intent
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Snackbar.make(rootLayout, "Video cannot be opened.", Snackbar.LENGTH_SHORT).show() //Show a snackbar
        }
    }

    //Explicit Intent: Function to send the review data back to the main activity
    fun onSubmit(view: View) {
        val data = Intent() //Create Intent
        data.putExtra("review", gameReviewEditText.text.toString()) //Add the text from the EditText
        setResult(Activity.RESULT_OK, data) //Set the result and give it a result code
        super.onBackPressed()
        finish()
    }
}