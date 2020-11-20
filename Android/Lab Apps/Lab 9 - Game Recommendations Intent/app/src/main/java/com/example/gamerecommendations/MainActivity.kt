package com.example.gamerecommendations

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toolbar
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //Global variables to keep track of to allow for saving the state on rotation
    var message: String = ""
    var imageID: Int? = null
    var reviewText: String? = ""
    private var gameData = GameData()
    private var selectedGame = -1
    private val REQUEST_CODE = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Set the ImageView to be a general image
        imageID = R.drawable.videogames
        //Event Listener:
        learnMoreButton.setOnClickListener{
            if (selectedGame == -1) { //If no game has been recommended:
                Snackbar.make(rootLayout, "Please get a recommendation first.", Snackbar.LENGTH_SHORT).show() //Show a snackbar
            } else {
                gameData.suggestGame(selectedGame) //Get the necessary information
                //Make sure the gathered information is correct
                Log.i("game suggested", gameData.name)
                Log.i("url suggested", gameData.url)

                //Intent
                val intent = Intent(this, GameInfo::class.java)
                intent.putExtra("gameName", gameData.name)
                intent.putExtra("gameTrailerURL", gameData.url)

                //Start an intent that will return data back
                startActivityForResult(intent, REQUEST_CODE)
            }
        }
    }

    //Function to recommend a game based on the choices
    fun findGame(view: View) {
        val checkedRadioButtonID = typeOfGame.checkedRadioButtonId //Get the id of the checked radio button

        if (checkedRadioButtonID == -1) { //If the user hasn't selected a radio button
            Snackbar.make(rootLayout, "Please select a game type.", Snackbar.LENGTH_SHORT).show() //Show snackbar
        } else {
            val typeOfGameText = findViewById<RadioButton>(checkedRadioButtonID).text //Get the selected radio button's text
            when (typeOfGameText) {
                "Action" -> { //Action Game
                    if (checkBox1.isChecked && checkBox2.isChecked) { //With engaging story and great soundtrack
                        if (switch1.isChecked) { //IS Child friendly
                            when (spinner.selectedItem) {
                                "Playstation" -> {
                                    message = "You should play: Okami"
                                    imageID = R.drawable.okami
                                    selectedGame = 0
                                }
                                "Nintendo" -> {
                                    message = "You should play: The Legend of Zelda"
                                    imageID = R.drawable.zelda
                                    selectedGame = 1
                                }
                            }
                        } else { //IS NOT Child Friendly
                            when (spinner.selectedItem) {
                                "Playstation" -> {
                                    message = "You should play: Devil May Cry V"
                                    imageID = R.drawable.devilmaycry
                                    selectedGame = 2
                                }
                                "Nintendo" -> {
                                    message = "You should play: No More Heroes"
                                    imageID = R.drawable.nomoreheroes
                                    selectedGame = 3
                                }
                            }
                        }
                    } else if (checkBox1.isChecked) { //With engaging story
                        if (switch1.isChecked) { //IS Child friendly
                            when (spinner.selectedItem) {
                                "Playstation" -> {
                                    message = "You should play: Undertale"
                                    imageID = R.drawable.undertale
                                    selectedGame = 4
                                }
                                "Nintendo" -> {
                                    message = "You should play: Earthbound"
                                    imageID = R.drawable.earthbound
                                    selectedGame = 5
                                }
                            }
                        } else { //IS NOT Child Friendly
                            when (spinner.selectedItem) {
                                "Playstation" -> {
                                    message = "You should play: The Last of Us"
                                    imageID = R.drawable.lastofus
                                    selectedGame = 6
                                }
                                "Nintendo" -> {
                                    message = "You should play: Final Fantasy VII"
                                    imageID = R.drawable.ff7
                                    selectedGame = 7
                                }
                            }
                        }
                    } else if (checkBox2.isChecked) { //With great soundtrack
                        if (switch1.isChecked) { //IS Child friendly
                            when (spinner.selectedItem) {
                                "Playstation" -> {
                                    message = "You should play: Journey"
                                    imageID = R.drawable.journey
                                    selectedGame = 8
                                }
                                "Nintendo" -> {
                                    message = "You should play: Splatoon"
                                    imageID = R.drawable.splatoon
                                    selectedGame = 9
                                }
                            }
                        } else { //IS NOT Child Friendly
                            when (spinner.selectedItem) {
                                "Playstation" -> {
                                    message = "You should play: Nier Automata"
                                    imageID = R.drawable.nier
                                    selectedGame = 10
                                }
                                "Nintendo" -> {
                                    message = "You should play: Transistor"
                                    imageID = R.drawable.transistor
                                    selectedGame = 11
                                }
                            }
                        }
                    } else { //If no features are selected, show a snackbar
                        Snackbar.make(rootLayout, "Please select at least one feature.", Snackbar.LENGTH_SHORT).show()
                    }
                }
                "Platformer" -> { //Platforming Game
                    if (checkBox1.isChecked && checkBox2.isChecked) { //With engaging story and great soundtrack
                        if (switch1.isChecked) { //IS Child friendly
                            when (spinner.selectedItem) {
                                "Playstation" -> {
                                    message = "You should play: Little Big Planet 3"
                                    imageID = R.drawable.littlebigplanet
                                    selectedGame = 12
                                }
                                "Nintendo" -> {
                                    message = "You should play: Mario Odyssey"
                                    imageID = R.drawable.mario
                                    selectedGame = 13
                                }
                            }
                        } else { //IS NOT Child Friendly
                            when (spinner.selectedItem) {
                                "Playstation" -> {
                                    message = "You should play: Little Nightmares"
                                    imageID = R.drawable.littlenightmares
                                    selectedGame = 14
                                }
                                "Nintendo" -> {
                                    message = "You should play: Hollow Knight"
                                    imageID = R.drawable.hollowknight
                                    selectedGame = 15
                                }
                            }
                        }
                    } else if (checkBox1.isChecked) { //With engaging story
                        if (switch1.isChecked) { //IS Child friendly
                            when (spinner.selectedItem) {
                                "Playstation" -> {
                                    message = "You should play: Ori & The Blind Forest"
                                    imageID = R.drawable.ori
                                    selectedGame = 16
                                }
                                "Nintendo" -> {
                                    message = "You should play: Megaman ZX"
                                    imageID = R.drawable.zx
                                    selectedGame = 17
                                }
                            }
                        } else { //IS NOT Child Friendly
                            when (spinner.selectedItem) {
                                "Playstation" -> {
                                    message = "You should play: Indivisible"
                                    imageID = R.drawable.indivisible
                                    selectedGame = 18
                                }
                                "Nintendo" -> {
                                    message = "You should play: Celeste"
                                    imageID = R.drawable.celeste
                                    selectedGame = 19
                                }
                            }
                        }
                    } else if (checkBox2.isChecked) { //With great soundtrack
                        if (switch1.isChecked) { //IS Child friendly
                            when (spinner.selectedItem) {
                                "Playstation" -> {
                                    message = "You should play: Sonic Mania"
                                    imageID = R.drawable.sonic
                                    selectedGame = 20
                                }
                                "Nintendo" -> {
                                    message = "You should play: Super Metroid"
                                    imageID = R.drawable.metroid
                                    selectedGame = 21
                                }
                            }
                        } else { //IS NOT Child Friendly
                            when (spinner.selectedItem) {
                                "Playstation" -> {
                                    message = "You should play: Castlevania"
                                    imageID = R.drawable.castlevania
                                    selectedGame = 22
                                }
                                "Nintendo" -> {
                                    message = "You should play: Cuphead"
                                    imageID = R.drawable.cuphead
                                    selectedGame = 23
                                }
                            }
                        }
                    } else { //If no features are selected, show a snackbar
                        Snackbar.make(rootLayout, "Please select at least one feature.", Snackbar.LENGTH_SHORT).show()
                    }
                }
            }
        }
        updateUI() //Update the UI with the saved values
    }

    //Get the review text from the GameInfo activity
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if((requestCode == REQUEST_CODE) && (resultCode == Activity.RESULT_OK)) {
            reviewText = data?.getStringExtra("review")
            reviewTextView.setText(data?.let{data.getStringExtra("review")}) //Set the text in the TextView
        }
    }

    //Function to update the TextView and ImageView
    fun updateUI() {
        recommendationText.text = message
        imageID?.let {imageView.setImageResource(it)}
        reviewTextView.text = reviewText
    }

    //Function to save the current app instance
    override fun onSaveInstanceState(outState: Bundle) {
        message.let { outState.putString("message", it)} //Save TextView message
        imageID?.let{outState.putInt("image", it)} //Save ImageView image
        selectedGame.let{outState.putInt("game", it)} //Save the selected game value
        reviewText?.let{outState.putString("review", it)} //Save the review text
        super.onSaveInstanceState(outState)
    }
    //Function to restore the previous app instance
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        message = savedInstanceState.getString("message", "") //Restore the TextView message
        imageID = savedInstanceState.getInt("image") //Restore the ImageView image
        selectedGame = savedInstanceState.getInt("game") //Restore the selected game value
        reviewText = savedInstanceState.getString("review") //Restore the review text
        updateUI() //Update the UI with the restored values
    }
}