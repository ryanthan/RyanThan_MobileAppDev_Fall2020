package com.example.gamerecommendations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toolbar
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //Variables to keep track of message and image ID to allow for saving the state on rotation
    var message: String = ""
    var imageID: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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
                                }
                                "Nintendo" -> {
                                    message = "You should play: The Legend of Zelda"
                                    imageID = R.drawable.zelda
                                }
                            }
                        } else { //IS NOT Child Friendly
                            when (spinner.selectedItem) {
                                "Playstation" -> {
                                    message = "You should play: Devil May Cry V"
                                    imageID = R.drawable.devilmaycry
                                }
                                "Nintendo" -> {
                                    message = "You should play: No More Heroes"
                                    imageID = R.drawable.nomoreheroes
                                }
                            }
                        }
                    } else if (checkBox1.isChecked) { //With engaging story
                        if (switch1.isChecked) { //IS Child friendly
                            when (spinner.selectedItem) {
                                "Playstation" -> {
                                    message = "You should play: Undertale"
                                    imageID = R.drawable.undertale
                                }
                                "Nintendo" -> {
                                    message = "You should play: Earthbound"
                                    imageID = R.drawable.earthbound
                                }
                            }
                        } else { //IS NOT Child Friendly
                            when (spinner.selectedItem) {
                                "Playstation" -> {
                                    message = "You should play: The Last of Us"
                                    imageID = R.drawable.lastofus
                                }
                                "Nintendo" -> {
                                    message = "You should play: Final Fantasy VII"
                                    imageID = R.drawable.ff7
                                }
                            }
                        }
                    } else if (checkBox2.isChecked) { //With great soundtrack
                        if (switch1.isChecked) { //IS Child friendly
                            when (spinner.selectedItem) {
                                "Playstation" -> {
                                    message = "You should play: Journey"
                                    imageID = R.drawable.journey
                                }
                                "Nintendo" -> {
                                    message = "You should play: Splatoon"
                                    imageID = R.drawable.splatoon
                                }
                            }
                        } else { //IS NOT Child Friendly
                            when (spinner.selectedItem) {
                                "Playstation" -> {
                                    message = "You should play: Nier Automata"
                                    imageID = R.drawable.nier
                                }
                                "Nintendo" -> {
                                    message = "You should play: Transistor"
                                    imageID = R.drawable.transistor
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
                                }
                                "Nintendo" -> {
                                    message = "You should play: Mario Odyssey"
                                    imageID = R.drawable.mario
                                }
                            }
                        } else { //IS NOT Child Friendly
                            when (spinner.selectedItem) {
                                "Playstation" -> {
                                    message = "You should play: Little Nightmares"
                                    imageID = R.drawable.littlenightmares
                                }
                                "Nintendo" -> {
                                    message = "You should play: Hollow Knight"
                                    imageID = R.drawable.hollowknight
                                }
                            }
                        }
                    } else if (checkBox1.isChecked) { //With engaging story
                        if (switch1.isChecked) { //IS Child friendly
                            when (spinner.selectedItem) {
                                "Playstation" -> {
                                    message = "You should play: Ori & The Blind Forest"
                                    imageID = R.drawable.ori
                                }
                                "Nintendo" -> {
                                    message = "You should play: Megaman ZX"
                                    imageID = R.drawable.zx
                                }
                            }
                        } else { //IS NOT Child Friendly
                            when (spinner.selectedItem) {
                                "Playstation" -> {
                                    message = "You should play: Indivisible"
                                    imageID = R.drawable.indivisible
                                }
                                "Nintendo" -> {
                                    message = "You should play: Celeste"
                                    imageID = R.drawable.celeste
                                }
                            }
                        }
                    } else if (checkBox2.isChecked) { //With great soundtrack
                        if (switch1.isChecked) { //IS Child friendly
                            when (spinner.selectedItem) {
                                "Playstation" -> {
                                    message = "You should play: Sonic Mania"
                                    imageID = R.drawable.sonic
                                }
                                "Nintendo" -> {
                                    message = "You should play: Super Metroid"
                                    imageID = R.drawable.metroid
                                }
                            }
                        } else { //IS NOT Child Friendly
                            when (spinner.selectedItem) {
                                "Playstation" -> {
                                    message = "You should play: Castlevania"
                                    imageID = R.drawable.castlevania
                                }
                                "Nintendo" -> {
                                    message = "You should play: Cuphead"
                                    imageID = R.drawable.cuphead
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

    //Function to update the TextView and ImageView
    fun updateUI() {
        recommendationText.text = message
        imageID?.let {imageView.setImageResource(it)}
    }

    //Function to save the current app instance
    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString("message", message) //Save TextView message
        imageID?.let {outState.putInt("image", it)} //Save ImageView image
        super.onSaveInstanceState(outState)
    }
    //Function to restore the previous app instance
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        message = savedInstanceState.getString("message", "") //Restore the TextView message
        imageID = savedInstanceState.getInt("image") //Restore the ImageView image
        updateUI() //Update the UI with the restored values
    }
}