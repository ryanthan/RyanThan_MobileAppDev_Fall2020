package com.example.happybirthday

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    //Declare the variables for use in functions:
    lateinit var mainTextView: TextView
    lateinit var editName: EditText
    lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    //Function to change TextView and ImageView when the button is pressed
    fun happyBirthday(view: View) {
        //TextView
        mainTextView = findViewById(R.id.textView) //Get the TextView id

        //EditText
        editName = findViewById(R.id.editText) //Get the EditText id
        val name = editName.text //Get the text entered into the EditText

        //Change TextView message
        mainTextView.setText("It's your birthday! Happy Birthday " + name + "!")

        //Image
        imageView = findViewById(R.id.imageView) //Get the imageView id
        imageView.setImageResource(R.drawable.cake) //Set the image into the imageView
    }
}