package com.example.ho_ho_holidaytreats

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //Variable Declarations:
    private var recipeData = RecipesData()
    private val REQUEST_CODE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //When the recipe 1 button is pressed:
        recipe1Button.setOnClickListener{
            recipeData.suggestRecipe(1) //Get the necessary information
            //Make sure the gathered information is correct
            Log.i("recipe number suggested", recipeData.recipeNum.toString())
            Log.i("recipe name suggested", recipeData.name)
            Log.i("info suggested", recipeData.info)
            Log.i("ingredients suggested", recipeData.ingredients.toString())
            Log.i("timer value suggested", recipeData.timerValue.toString())
            Log.i("recipe suggested", recipeData.recipe)
            Log.i("citation suggested", recipeData.citation)
            Log.i("URL suggested", recipeData.url)

            //Intent
            val intent = Intent(this, Recipe::class.java)
            intent.putExtra("recipeNumber", recipeData.recipeNum)
            intent.putExtra("recipeName", recipeData.name)
            intent.putExtra("recipeInfo", recipeData.info)
            intent.putExtra("recipeIngredients", recipeData.ingredients)
            intent.putExtra("recipeTimer", recipeData.timerValue)
            intent.putExtra("recipeDetails", recipeData.recipe)
            intent.putExtra("recipeCitation", recipeData.citation)
            intent.putExtra("recipeURL", recipeData.url)

            //Start an intent
            startActivityForResult(intent, REQUEST_CODE)
        }

        //When the recipe 2 button is pressed:
        recipe2Button.setOnClickListener{
            recipeData.suggestRecipe(2) //Get the necessary information
            //Make sure the gathered information is correct
            Log.i("recipe number suggested", recipeData.recipeNum.toString())
            Log.i("recipe name suggested", recipeData.name)
            Log.i("info suggested", recipeData.info)
            Log.i("ingredients suggested", recipeData.ingredients.toString())
            Log.i("timer value suggested", recipeData.timerValue.toString())
            Log.i("recipe suggested", recipeData.recipe)
            Log.i("citation suggested", recipeData.citation)
            Log.i("URL suggested", recipeData.url)

            //Intent
            val intent = Intent(this, Recipe::class.java)
            intent.putExtra("recipeNumber", recipeData.recipeNum)
            intent.putExtra("recipeName", recipeData.name)
            intent.putExtra("recipeInfo", recipeData.info)
            intent.putExtra("recipeIngredients", recipeData.ingredients)
            intent.putExtra("recipeTimer", recipeData.timerValue)
            intent.putExtra("recipeDetails", recipeData.recipe)
            intent.putExtra("recipeCitation", recipeData.citation)
            intent.putExtra("recipeURL", recipeData.url)

            //Start an intent
            startActivityForResult(intent, REQUEST_CODE)
        }

        //When the recipe 3 button is pressed:
        recipe3Button.setOnClickListener{
            recipeData.suggestRecipe(3) //Get the necessary information
            //Make sure the gathered information is correct
            Log.i("recipe number suggested", recipeData.recipeNum.toString())
            Log.i("recipe name suggested", recipeData.name)
            Log.i("info suggested", recipeData.info)
            Log.i("ingredients suggested", recipeData.ingredients.toString())
            Log.i("timer value suggested", recipeData.timerValue.toString())
            Log.i("recipe suggested", recipeData.recipe)
            Log.i("citation suggested", recipeData.citation)
            Log.i("URL suggested", recipeData.url)

            //Intent
            val intent = Intent(this, Recipe::class.java)
            intent.putExtra("recipeNumber", recipeData.recipeNum)
            intent.putExtra("recipeName", recipeData.name)
            intent.putExtra("recipeInfo", recipeData.info)
            intent.putExtra("recipeIngredients", recipeData.ingredients)
            intent.putExtra("recipeTimer", recipeData.timerValue)
            intent.putExtra("recipeDetails", recipeData.recipe)
            intent.putExtra("recipeCitation", recipeData.citation)
            intent.putExtra("recipeURL", recipeData.url)

            //Start an intent
            startActivityForResult(intent, REQUEST_CODE)
        }

        //When the recipe 4 button is pressed:
        recipe4Button.setOnClickListener{
            recipeData.suggestRecipe(4) //Get the necessary information
            //Make sure the gathered information is correct
            Log.i("recipe number suggested", recipeData.recipeNum.toString())
            Log.i("recipe name suggested", recipeData.name)
            Log.i("info suggested", recipeData.info)
            Log.i("ingredients suggested", recipeData.ingredients.toString())
            Log.i("timer value suggested", recipeData.timerValue.toString())
            Log.i("recipe suggested", recipeData.recipe)
            Log.i("citation suggested", recipeData.citation)
            Log.i("URL suggested", recipeData.url)

            //Intent
            val intent = Intent(this, Recipe::class.java)
            intent.putExtra("recipeNumber", recipeData.recipeNum)
            intent.putExtra("recipeName", recipeData.name)
            intent.putExtra("recipeInfo", recipeData.info)
            intent.putExtra("recipeIngredients", recipeData.ingredients)
            intent.putExtra("recipeTimer", recipeData.timerValue)
            intent.putExtra("recipeDetails", recipeData.recipe)
            intent.putExtra("recipeCitation", recipeData.citation)
            intent.putExtra("recipeURL", recipeData.url)

            //Start an intent
            startActivityForResult(intent, REQUEST_CODE)
        }
    }
}