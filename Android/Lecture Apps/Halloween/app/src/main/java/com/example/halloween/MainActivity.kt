package com.example.halloween

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    //Example of defining variable at the class level for use in any functions
    lateinit var editName: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun sayBoo(view: View) {
        //TextView
        val booText = findViewById<TextView>(R.id.textMessage) //Get the TextView id

        //EditText
        editName = findViewById(R.id.editTextName) //Get the EditText id
        val name = editName.text //Get the text entered into the EditText

        //Message
        booText.setText("Happy Halloween " + name + "!") //Set the label text

        //Image
        val imageGhost = findViewById<ImageView>(R.id.imageView) //Get the imageView id
        imageGhost.setImageResource(R.drawable.ghost) //Set the image into the imageView
    }
}