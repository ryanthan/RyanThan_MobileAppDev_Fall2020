package com.example.ho_ho_holidaytreats

//Data class to store recipe information:
data class RecipesData(var recipeNum: Int = 0, var name: String = "", var info: String = "", var ingredients: Array<String> = arrayOf(""),
                       var timerValue: Long = 0, var recipe: String = "", var citation: String = "", var url: String = "") {

    //Suggest the recipe based on the recipe number
    fun suggestRecipe(recipeNumber: Int) {
        setRecipeNumber(recipeNumber)
        setRecipeName(recipeNumber)
        setRecipeInfo(recipeNumber)
        setRecipeIngredients(recipeNumber)
        setRecipeTimer(recipeNumber)
        setRecipe(recipeNumber)
        setRecipeCitation(recipeNumber)
        setRecipeURL(recipeNumber)
    }

    //Set the recipe number
    private fun setRecipeNumber(recipeNumber: Int){
        recipeNum = when (recipeNumber) {
            1 -> 1
            2 -> 2
            3 -> 3
            4 -> 4
            else -> 0
        }
    }

    //Set the recipe name based on the number
    private fun setRecipeName(recipeNumber: Int){
        name = when (recipeNumber) {
            1 -> "Gingerbread Cookies"
            2 -> "Reindeer Brownies"
            3 -> "Bûche de Noël"
            4 -> "Christmas Light Cupcakes"
            else -> "..."
        }
    }

    //Set the recipe cooking information
    private fun setRecipeInfo(recipeNumber: Int){
        info = when (recipeNumber) {
            1 -> "Total Time: 3 hrs. | Cook Time: 15 min.  Servings: 24-36 Cookies"
            2 -> "Total Time: 3 hrs. | Cook Time: 40 min.  Servings: 16 Brownies"
            3 -> "Total Time: 3 hrs. | Cook Time: 12 min.  Servings: 8 Servings"
            4 -> "Total Time: 1 hr. | Cook Time: 22 min.  Servings: 12 Cupcakes"
            else -> "..."
        }
    }

    //Set the ingredients for each recipe
    private fun setRecipeIngredients(recipeNumber: Int){
        ingredients = when (recipeNumber) {
            1 -> arrayOf("3 1/2 cups all-purpose flour", "1 tablespoon ground ginger", "2 teaspoons ground cinnamon",
                    "1 teaspoon baking soda", "1 teaspoon fine salt", "1/4 teaspoon ground allspice", "1/4 teaspoon ground cloves",
                    "6 tablespoons unsalted butter, melted", "1 tablespoon vegetable shortening, melted", "2/3 cup light brown sugar",
                    "3/4 cup molasses", "1 large egg", "3 1/2 cup confectioners' sugar", "2 tablespoons meringue powder", "Food coloring, if desired")
            2 -> arrayOf("2 sticks unsalted butter, melted", "1 1/2 cups sugar", "1 teaspoon vanilla extract", "3 large eggs",
                    "1 cup all-purpose flour", "1/2 cup unsweetened cocoa powder", "1 teaspoon fine salt", "1/2 teaspoon baking powder",
                    "2 cups regular semisweet chocolate chips", "16 small Tootsie rolls", "16 red or brown M&M's", "16 mini vanilla wafer cookies",
                    "16 mini marshmallows", "32 mini semisweet chocolate chips", "32 mini peppermint candy canes")
            3 -> arrayOf("6 large eggs, separated", "1/2 cup all-purpose flour", "1/4 cup unsweetened cocoa powder",
                    "3/4 cup granulated sugar, divided", "1/4 teaspoon kosher salt", "1 1/4 cup heavy cream", "1/4 cup powdered sugar",
                    "2 teaspoons gelatin (optional)", "1 teaspoon vanilla extract", "1 stick of butter, softened", "1 1/2 cup powdered sugar",
                    "5 tablespoons cocoa powder", "1 teaspoon vanilla extract", "3 tablespoons heavy cream", "Pinch of kosher salt for filling & frosting")
            4 -> arrayOf("1 2/3 cups all-purpose flour", "1/3 cup cocoa powder", "2 teaspoons baking powder",
                    "1/4 teaspoon salt", "1/2 cup light brown sugar", "1 cup granulated sugar", "5 tablespoons unsalted butter",
                    "1 cup whole milk", "2 eggs", "1 teaspoon vanilla extract", "3 1/2 cups powdered sugar",
                    "10 1/2 tablespoons unsalted butter", "3 tablespoons whole milk", "Black icing pen", "Plenty of M&M's")
            else -> arrayOf("...")
        }
    }

    //Set the starting amount of time on the timer
    //Change any of these to a small value (like 5000) to hear the timer music!
    private fun setRecipeTimer(recipeNumber: Int){
        timerValue = when (recipeNumber) {
            1 -> 900000
            2 -> 2400000
            3 -> 720000
            4 -> 1320000
            else -> 0
        }
    }

    //Set each recipe
    private fun setRecipe(recipeNumber: Int){
        when (recipeNumber) {
            1 -> recipe = "1. For the cookies: Whisk together the flour, ginger, cinnamon, baking soda, salt, allspice and cloves in a large bowl.\n" +
                    "\n" + "2. Mix the butter, shortening, brown sugar and molasses in the bowl of a stand mixer fitted with the paddle attachment. Beat in the egg. Beat the dry ingredients into the wet ingredients in two additions. Divide the dough in half, wrap in plastic and pat to 1/2-inch thick. Refrigerate for 2 hours. \n" +
                    "\n" + "3. Preheat the oven to 350 degrees F. \n" +
                    "\n" + "4. On a lightly floured surface, roll out one piece of dough to 1/4-inch thick, dusting with flour if needed. Cut into 3- to 5-inch cookies with a gingerbread man cutter or desired shape. Brush off the excess flour and refrigerate for 15 minutes. Repeat with the second piece of dough.\n" +
                    "\n" + "5. Bake the cookies in batches until they are golden around the edges, 12 to 15 minutes. Transfer to a wire rack and cool completely.\n" +
                    "\n" + "6. For the royal icing: Whisk the confectioners' sugar with the meringue powder in the bowl of a stand mixer fitted with a paddle attachment. Beat in 6 tablespoons of water until well combined and you have stiff glossy peaks, adding 1 tablespoon more water at a time to reach a smooth pipeable consistency. Mix in food coloring as desired. Fill pastry bags fitted with tips. Decorate the gingerbread cookies with the icing.\n" +
                    "\n" + "Additional Note: When measuring flour, we spoon it into a dry measuring cup and level off excess. (Scooping directly from the bag compacts the flour, resulting in dry baked goods.) "
            2 -> recipe = "1. Preheat the oven to 350 degrees F. Butter the bottom and sides of two 8-inch round cake pans. Cut two 8-inch circles out of parchment paper and line the bottoms of the cake pans with the parchment.\n" +
                    "\n" + "2. Stir together the butter, sugar, vanilla and eggs in a medium bowl. In another bowl, whisk together the flour, cocoa powder, salt and baking powder. Add the dry ingredients to the wet ingredients and stir until just combined. Stir in 1 cup of the regular chocolate chips and divide the batter between the prepared pans, smoothing the tops. Bake until a crust begins to form around the edges, the edges pull away from the pan and a toothpick inserted in the center comes out clean, 35 to 40 minutes.  \n" +
                    "\n" + "3. Meanwhile, halve the candy chews lengthwise. Use your fingers to shape each half into a teardrop shape for the reindeer's ears and set aside. Melt 2 tablespoons of the remaining regular chocolate chips in a heat-proof bowl in a microwave in 20 second intervals.  \n" +
                    "\n" + "4. Use a dab of the melted chocolate to stick a red candy-coated chocolate onto each of the vanilla wafers to make noses and set aside. \n" +
                    "\n" + "5. Cut each mini marshmallow in half crosswise. Insert one mini chocolate chip, pointed-side down, into the flat, cut side of each marshmallow piece to make eyes and set aside.\n" +
                    "\n" + "6. As soon as the brownies come out of the oven, sprinkle the top of each brownie round evenly with half of the remaining regular chocolate chips (7 tablespoons each) and let stand until the chips melt, about 5 minutes. Spread the chocolate evenly over the top of the brownies with a spatula.\n" +
                    "\n" + "7. Let the brownies cool fully in the pans on cooling racks, about 1 hour. Cut each circle into 8 equal triangles with a knife. Use a small offset spatula or pie server to lift each triangle out of the pan.\n" +
                    "\n" + "8. To assemble: Arrange the brownies so that the longest, sharpest point faces you and gently press a cookie-nose on that point of each brownie. To make antlers: Using the tip of a paring knife or a skewer, poke two small holes in the top side of each brownie, about 1/2 inch from the corners, and insert a mini candy cane in each hole. For the ears, press a piece of candy chew on each corner below the candy cane antlers. Press 2 of the mini marshmallow eyes next to each other in the center of each brownie. "
            3 -> recipe = "1. Preheat oven to 350°. Line a jelly roll pan with parchment paper and grease with cooking spray. In a medium bowl mix together flour, cocoa powder, and salt. \n" +
                    "\n" + "2. In a large bowl beat egg yolks until thick. Slowly add ½ cup sugar and beat until pale then beat in flour mixture.\n" +
                    "\n" + "3. In another large bowl beat egg whites until soft peaks form. Add remaining ¼ cup sugar a little at a time and continue to beat until stiff peaks form. Gently fold egg whites into batter in two batches.\n" +
                    "\n" + "4. Pour batter into prepared pan and spread into an even layer. Bake until top springs back when lightly pressed, 12 minutes.\n" +
                    "\n" + "5. Dust a clean kitchen towel with powdered sugar and invert warm cake onto towel. Peel off parchment paper.\n" +
                    "\n" + "6. Starting at the short end, use the towel to tightly roll cake into a log. Let cool completely.\n" +
                    "\n" + "7. Make filling: if using gelatin, place 2 tablespoons cold water in a shallow microwave-safe bowl and sprinkle gelatin in an even layer on top. Let bloom for 5 to 10 minutes, then microwave for 10 seconds until gelatin is runny—do not overheat! \n" +
                    "\n" + "8. In a large bowl, beat together heavy cream, powdered sugar, pure vanilla extract, and a pinch of salt, until medium peaks form. If using gelatin, strain and stream into whipped cream at this point while continuing to beat the cream. Refrigerate until ready to use.\n" +
                    "\n" + "9. When cake is cool, unroll and spread filling evenly over cake. Roll cake back into a log, using the towel to help create a tight roll. Place seam side down on a baking sheet and refrigerate until well chilled, 1 hour.\n" +
                    "\n" + "10. Make frosting: In a large bowl beat butter until smooth. Add powdered sugar and cocoa powder and beat until no lumps remain then beat in vanilla, heavy cream, and salt.\n" +
                    "\n" + "11. When ready to serve, trim ends and frost cake with chocolate buttercream. Dust lightly with powdered sugar and top with chocolate curls. Place cranberries and rosemary on log to create mistletoe."
            4 -> recipe = "1. Preheat oven to 190°C. Sift the dry ingredients together into a bowl.\n" +
                    "\n" + "2. In a separate bowl beat together the butter and two sugars until creamy.\n" +
                    "\n" + "3. Meanwhile, in another bowl/jug whisk together the milk, eggs and vanilla extract.\n" +
                    "\n" + "4. Add 1/2 of the wet ingredients into the butter mixture and mix on a slow/medium speed slowly adding all of the dry ingredients.\n" +
                    "\n" + "5. Scrape down your bowl and beat in the remaining wet ingredients. Once mixture is smooth, evenly divide it into the cupcake cases.\n" +
                    "\n" + "6. Bake in the oven for 18-22 minutes or until a skewer comes out clean.\n" +
                    "\n" + "7. For the buttercream sift the icing sugar into a bowl and beat it into the butter. Once sandy pour in the milk to combine. \n" +
                    "\n" + "8. Beat for a good 5 minutes until the icing is paler in colour and is light and fluffy. Place the icing into a piping bag with a star tip and pipe swirls onto each cupcake.\n" +
                    "\n" + "9. Using a black icing pen pipe a continuous squiggly line around the cupcake to look like the cable to the lights.\n" +
                    "\n" + "10. Place M&M's along the black icing as Christmas lights."
            else -> recipe = "..."
        }
    }

    //Set the recipe citation
    private fun setRecipeCitation(recipeNumber: Int){
        citation = when (recipeNumber) {
            1 -> "Kitchen, Food Network. “The Best Gingerbread Cookies.” Food Network, Food Network, 27 Jan. 2017, www.foodnetwork.com/recipes/food-network-kitchen/perfect-gingerbread-men-recipe-2105453. "
            2 -> "Kitchen, Food Network. “Christmas Reindeer Brownies.” Food Network, Food Network, 3 Feb. 2017, www.foodnetwork.com/recipes/food-network-kitchen/christmas-reindeer-brownies-3561587. "
            3 -> "Gore Associate Food Editor Makinze is the Associate Food Editor for Delish.com., Makinze. “Bûche De Noël (Yule Log Cake).” Delish, 4 Dec. 2019, www.delish.com/cooking/recipe-ideas/a24276998/buche-de-noel-yule-log-cake-recipe/. "
            4 -> "Tastemade. “Holiday Lights Cupcakes.” Tastemade, www.tastemade.com/videos/holiday-lights-cupcakes. "
            else -> "..."
        }
    }

    //Set the recipe URL
    private fun setRecipeURL(recipeNumber: Int){
        url = when (recipeNumber) {
            1 -> "https://www.foodnetwork.com/recipes/food-network-kitchen/perfect-gingerbread-men-recipe-2105453"
            2 -> "https://www.foodnetwork.com/recipes/food-network-kitchen/christmas-reindeer-brownies-3561587"
            3 -> "https://www.delish.com/cooking/recipe-ideas/a24276998/buche-de-noel-yule-log-cake-recipe/"
            4 -> "https://www.tastemade.com/videos/holiday-lights-cupcakes"
            else -> "..."
        }
    }
}
