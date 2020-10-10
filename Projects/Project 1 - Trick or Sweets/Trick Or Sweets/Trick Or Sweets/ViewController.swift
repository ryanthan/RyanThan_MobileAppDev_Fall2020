//
//  ViewController.swift
//  Trick Or Sweets
//
//  Created by Ryan Than on 10/3/20.
//  Copyright © 2020 Ryan Than. All rights reserved.
//
//  I used a font called Henny Penny for this assignment. I learned how to include custom fonts here: https://developer.apple.com/documentation/uikit/text_display_and_fonts/adding_a_custom_font_to_your_app
//  And I got the font from here: https://www.fontsquirrel.com/fonts/henny-penny

import UIKit
import AVFoundation

class ViewController: UIViewController {
    //All of the connected outlets
    @IBOutlet weak var recipeSelector: UISegmentedControl!
    @IBOutlet weak var imageScrollView: UIScrollView!
    @IBOutlet weak var recipeTitleLabel: UILabel!
    @IBOutlet weak var infoLabel: UILabel!
    @IBOutlet weak var checkBox1: UIButton!
    @IBOutlet weak var checkBoxLabel1: UILabel!
    @IBOutlet weak var checkBox2: UIButton!
    @IBOutlet weak var checkBoxLabel2: UILabel!
    @IBOutlet weak var checkBox3: UIButton!
    @IBOutlet weak var checkBoxLabel3: UILabel!
    @IBOutlet weak var checkBox4: UIButton!
    @IBOutlet weak var checkBoxLabel4: UILabel!
    @IBOutlet weak var checkBox5: UIButton!
    @IBOutlet weak var checkBoxLabel5: UILabel!
    @IBOutlet weak var checkBox6: UIButton!
    @IBOutlet weak var checkBoxLabel6: UILabel!
    @IBOutlet weak var checkBox7: UIButton!
    @IBOutlet weak var checkBoxLabel7: UILabel!
    @IBOutlet weak var checkBox8: UIButton!
    @IBOutlet weak var checkBoxLabel8: UILabel!
    @IBOutlet weak var checkBox9: UIButton!
    @IBOutlet weak var checkBoxLabel9: UILabel!
    @IBOutlet weak var checkBox10: UIButton!
    @IBOutlet weak var checkBoxLabel10: UILabel!
    @IBOutlet weak var checkBox11: UIButton!
    @IBOutlet weak var checkBoxLabel11: UILabel!
    @IBOutlet weak var checkBox12: UIButton!
    @IBOutlet weak var checkBoxLabel12: UILabel!
    @IBOutlet weak var checkBox13: UIButton!
    @IBOutlet weak var checkBoxLabel13: UILabel!
    @IBOutlet weak var checkBox14: UIButton!
    @IBOutlet weak var checkBoxLabel14: UILabel!
    @IBOutlet weak var recipeLabel: UILabel!
    @IBOutlet weak var timerLabel: UILabel!
    @IBOutlet weak var startPauseButton: UIButton!
    @IBOutlet weak var resetButton: UIButton!
    @IBOutlet weak var citationLabel: UILabel!
    
    //Variable declarations for use in functions:
    //Image arrays for each recipe
    var imageArray = [UIImage(named: "Recipe1-Image1"), UIImage(named: "Recipe1-Image2"), UIImage(named: "Recipe1-Image3")]
    var imageArray2 = [UIImage(named: "Recipe2-Image1"), UIImage(named: "Recipe2-Image2"), UIImage(named: "Recipe2-Image3")]
    var imageArray3 = [UIImage(named: "Recipe3-Image1"), UIImage(named: "Recipe3-Image2"), UIImage(named: "Recipe3-Image3")]
    
    var RecipeTimer = Timer() //Timer object
    var TimerDisplay = 0 //Timer value (in seconds)
    var isPaused = true //Bool variable to keep track of timer state
    var audioPlayer = AVAudioPlayer() //Audio player object
    
    
    //Segmented control:
    @IBAction func selectRecipe(_ sender: UISegmentedControl) {
        updateRecipe() //Update everything according to the selected recipe
    }
    
    //Function to add images to scroll view based on selected recipe
    //Learned how to make image gallery here: https://www.youtube.com/watch?v=LaWnv5sRpho
    func imageScroll(_ imageArray: [UIImage?]) {
        for i in 0..<imageArray.count {
            let imageView = UIImageView() //Create a UIImage view
            imageView.image = imageArray[i] //Set the image
            imageView.contentMode = .scaleAspectFill //Set the image to aspect fill
            let xPosition = self.imageScrollView.frame.width * CGFloat(i) //Calculate the x position (for scrolling)
            imageView.frame = CGRect(x: xPosition, y: 0, width: self.imageScrollView.frame.width, height: self.imageScrollView.frame.height) // Set the parameters of the image view
            imageScrollView.contentSize.width = imageScrollView.frame.width * CGFloat(i + 1) //Conform the scroll view to allow for image scrolling
            imageScrollView.addSubview(imageView) //Add the imageView to the scroll view
        }
    }
    
    //The following functions are used to make each checkbox and corresponding label function separately
    @IBAction func checkBox1(_ sender: UIButton) {
        updateCheckbox(sender, checkBoxLabel1)
    }
    @IBAction func checkBox2(_ sender: UIButton) {
        updateCheckbox(sender, checkBoxLabel2)
    }
    @IBAction func checkBox3(_ sender: UIButton) {
        updateCheckbox(sender, checkBoxLabel3)
    }
    @IBAction func checkBox4(_ sender: UIButton) {
        updateCheckbox(sender, checkBoxLabel4)
    }
    @IBAction func checkBox5(_ sender: UIButton) {
        updateCheckbox(sender, checkBoxLabel5)
    }
    @IBAction func checkBox6(_ sender: UIButton) {
        updateCheckbox(sender, checkBoxLabel6)
    }
    @IBAction func checkBox7(_ sender: UIButton) {
        updateCheckbox(sender, checkBoxLabel7)
    }
    @IBAction func checkBox8(_ sender: UIButton) {
        updateCheckbox(sender, checkBoxLabel8)
    }
    @IBAction func checkBox9(_ sender: UIButton) {
        updateCheckbox(sender, checkBoxLabel9)
    }
    @IBAction func checkBox10(_ sender: UIButton) {
        updateCheckbox(sender, checkBoxLabel10)
    }
    @IBAction func checkBox11(_ sender: UIButton) {
        updateCheckbox(sender, checkBoxLabel11)
    }
    @IBAction func checkBox12(_ sender: UIButton) {
        updateCheckbox(sender, checkBoxLabel12)
    }
    @IBAction func checkBox13(_ sender: UIButton) {
        updateCheckbox(sender, checkBoxLabel13)
    }
    @IBAction func checkBox14(_ sender: UIButton) {
        updateCheckbox(sender, checkBoxLabel14)
    }
    
    //Function to change the button images and label text colors when checked/not checked
    //Learned how to change button image from here: https://stackoverflow.com/questions/38041688/how-to-change-button-image-in-swift/38041892
    func updateCheckbox(_ sender: UIButton, _ label: UILabel) {
        sender.isSelected.toggle() //Toggle between selected and not selected
        if sender.isSelected == true { //If the checkbox is selected:
            sender.setImage(UIImage(named: "Checked")?.withRenderingMode(.alwaysOriginal), for: .selected) //Change to the "Checked" image
            label.textColor = UIColor.systemGray //Change the text color to gray
        } else { //If the checkbox is not selected:
            sender.setImage(UIImage(named: "NotChecked")?.withRenderingMode(.alwaysOriginal), for: .normal) //Change to the "NotChecked" image
            label.textColor = UIColor.white //Change the text color to white
        }
    }
    
    //Function to reset all of the checkboxes and labels to their default state
    func resetCheckboxesAndLabels() {
        checkBox1.isSelected = false
        checkBox1.setImage(UIImage(named: "NotChecked")?.withRenderingMode(.alwaysOriginal), for: .normal)
        checkBoxLabel1.textColor = UIColor.white
        
        checkBox2.isSelected = false
        checkBox2.setImage(UIImage(named: "NotChecked")?.withRenderingMode(.alwaysOriginal), for: .normal)
        checkBoxLabel2.textColor = UIColor.white
        
        checkBox3.isSelected = false
        checkBox3.setImage(UIImage(named: "NotChecked")?.withRenderingMode(.alwaysOriginal), for: .normal)
        checkBoxLabel3.textColor = UIColor.white
        
        checkBox4.isSelected = false
        checkBox4.setImage(UIImage(named: "NotChecked")?.withRenderingMode(.alwaysOriginal), for: .normal)
        checkBoxLabel4.textColor = UIColor.white
        
        checkBox5.isSelected = false
        checkBox5.setImage(UIImage(named: "NotChecked")?.withRenderingMode(.alwaysOriginal), for: .normal)
        checkBoxLabel5.textColor = UIColor.white
        
        checkBox6.isSelected = false
        checkBox6.setImage(UIImage(named: "NotChecked")?.withRenderingMode(.alwaysOriginal), for: .normal)
        checkBoxLabel6.textColor = UIColor.white
        
        checkBox7.isSelected = false
        checkBox7.setImage(UIImage(named: "NotChecked")?.withRenderingMode(.alwaysOriginal), for: .normal)
        checkBoxLabel7.textColor = UIColor.white
        
        checkBox8.isSelected = false
        checkBox8.setImage(UIImage(named: "NotChecked")?.withRenderingMode(.alwaysOriginal), for: .normal)
        checkBoxLabel8.textColor = UIColor.white
        
        checkBox9.isSelected = false
        checkBox9.setImage(UIImage(named: "NotChecked")?.withRenderingMode(.alwaysOriginal), for: .normal)
        checkBoxLabel9.textColor = UIColor.white
        
        checkBox10.isSelected = false
        checkBox10.setImage(UIImage(named: "NotChecked")?.withRenderingMode(.alwaysOriginal), for: .normal)
        checkBoxLabel10.textColor = UIColor.white
        
        checkBox11.isSelected = false
        checkBox11.setImage(UIImage(named: "NotChecked")?.withRenderingMode(.alwaysOriginal), for: .normal)
        checkBoxLabel11.textColor = UIColor.white
        
        checkBox12.isSelected = false
        checkBox12.setImage(UIImage(named: "NotChecked")?.withRenderingMode(.alwaysOriginal), for: .normal)
        checkBoxLabel12.textColor = UIColor.white
        
        checkBox13.isSelected = false
        checkBox13.setImage(UIImage(named: "NotChecked")?.withRenderingMode(.alwaysOriginal), for: .normal)
        checkBoxLabel13.textColor = UIColor.white
        
        checkBox14.isSelected = false
        checkBox14.setImage(UIImage(named: "NotChecked")?.withRenderingMode(.alwaysOriginal), for: .normal)
        checkBoxLabel14.textColor = UIColor.white
    }
    
    //Function to update entire app depending on what recipe is selected
    func updateRecipe() {
        if recipeSelector.selectedSegmentIndex == 0 { //Spider Cookies recipe
            resetCheckboxesAndLabels() //Reset all of the checkboxes and labels
            resetTimer() //Reset the timer
            //Fill in recipe name, pictures, info, ingredients, recipe, and timer
            recipeTitleLabel.text = "Peanut Butter Spider Cookies"
            imageScroll(imageArray)
            infoLabel.text = "Total Time: 55 min.  |  Cook Time: 12 min. Servings: 24 Cookies"
            checkBox12.isHidden = false
            checkBox13.isHidden = false
            checkBox14.isHidden = false
            checkBoxLabel12.isHidden = false
            checkBoxLabel13.isHidden = false
            checkBoxLabel14.isHidden = false
            checkBoxLabel1.text = "1/4 cup of shortening"
            checkBoxLabel2.text = "1/4 cup of peanut butter"
            checkBoxLabel3.text = "1/4 cup of packed brown sugar"
            checkBoxLabel4.text = "1/4 cup of white sugar"
            checkBoxLabel5.text = "1/2 egg, beaten"
            checkBoxLabel6.text = "1 tablespoon of milk"
            checkBoxLabel7.text = "1/2 tablespoon of vanilla extract"
            checkBoxLabel8.text = "3/4 cup and 2 tablespoons of flour"
            checkBoxLabel9.text = "1/2 teaspoon of baking soda"
            checkBoxLabel10.text = "1/4 teaspoon of salt"
            checkBoxLabel11.text = "12 chocolate candy spheres"
            checkBoxLabel12.text = "24 decorative candy eyeballs"
            checkBoxLabel13.text = "1/4 cup of prepared chocolate frosting"
            checkBoxLabel14.text = "2 tablespoons of sugar (for rolling)"
            recipeLabel.text = "1. Preheat oven to 375 degrees F (190 degrees C). Line baking sheets with baking parchment.\n\n2. Beat shortening, peanut butter, brown sugar, and white sugar together with an electric mixer until smooth. Beat egg into the creamy mixture until fully incorporated. Stir milk and vanilla extract into the mixture until smooth.\n\n3. Mix flour, baking soda, and salt together in a small bowl; add to the wet mixture in the large bowl and stir until completely incorporated into a dough. Divide and shape dough into 24 balls.\n\n4. Spread 1/4 cup white sugar into a wide, shallow bowl. Roll dough balls in sugar to coat and arrange about 2 inches apart onto prepared baking sheets.\n\n5. Bake in preheated oven until golden brown, 10 to 12 minutes. Remove cookies from oven and quickly press a dimple into the middle of each cookie using the blunt end of a wooden spoon. Cool cookies on sheets for 10 minutes before transferring to a wire cooling rack to cool completely. Swipe down for the timer!\n\n6. Cut each chocolate sphere into two hemispheres. Put one piece atop each cookie with the rounded side facing upwards.\n\n7. Spoon frosting into a pastry bag with a small round tip or a plastic freezer bag with one end snipped off. Dab a small amount of frosting onto the back of each candy eyeball and stick two onto each chocolate candy to resemble eyes. Then pipe frosting in four thin lines, starting at the base of the candy, on each side atop the cookie to resemble spider legs.\n\n8. Let frosting harden at room temperature, about 30 minutes. Enjoy immediately or store cookies in an airtight container."
            TimerDisplay = 720
            DisplayTime(TimerDisplay)
            citationLabel.text = "Recipe Citation: “Peanut Butter Spider Cookies.” Allrecipes, https://www.allrecipes.com/recipe/240007/peanut-butter-spider-cookies/. Accessed 26 Sept. 2020."
            
        } else if recipeSelector.selectedSegmentIndex == 1 { //Skeleton Cookies recipe
            resetCheckboxesAndLabels() //Reset all of the checkboxes and labels
            resetTimer() //Reset the timer
            //Fill in recipe name, pictures, info, ingredients, recipe, and timer
            recipeTitleLabel.text = "Chocolate-Cinnamon Skeleton Cookies"
            imageScroll(imageArray2)
            infoLabel.text = "Total Time: 5 hrs.  |  Cook Time: 15 min. Servings: 14 Cookies"
            checkBox12.isHidden = false
            checkBox13.isHidden = false
            checkBox14.isHidden = false
            checkBoxLabel12.isHidden = false
            checkBoxLabel13.isHidden = false
            checkBoxLabel14.isHidden = false
            checkBoxLabel1.text = "1 3/4 cup of all-purpose flour"
            checkBoxLabel2.text = "3/4 cup of unsweetened cocoa powder"
            checkBoxLabel3.text = "1 tablespoon of ground cinnamon"
            checkBoxLabel4.text = "3/4 teaspoon of baking soda"
            checkBoxLabel5.text = "1/4 teaspoon of baking powder"
            checkBoxLabel6.text = "1/2 teaspoon of salt"
            checkBoxLabel7.text = "2 sticks of unsalted butter (room temp)"
            checkBoxLabel8.text = "1 1/4 cups of granulated sugar"
            checkBoxLabel9.text = "1/2 cup of packed dark brown sugar"
            checkBoxLabel10.text = "1 large egg"
            checkBoxLabel11.text = "1 teaspoon of pure vanilla extract"
            checkBoxLabel12.text = "1 cup of confectioner's sugar"
            checkBoxLabel13.text = "1 tablespoon of meringue powder"
            checkBoxLabel14.text = "1 to 2 tablespoons of water"
            recipeLabel.text = "1. Make the cookies: Whisk the flour, cocoa powder, cinnamon, baking soda, baking powder and salt in a medium bowl. Beat the butter, granulated sugar and brown sugar in a large bowl with a mixer on medium-high speed until light and fluffy, about 5 minutes. Beat in the egg and vanilla until creamy, 1 to 2 minutes. Reduce the mixer speed to low. Gradually add the flour mixture and beat until combined, about 2 minutes. Divide the dough in half; pat each piece into a disk and wrap in plastic wrap. Refrigerate until firm, 1 hour.\n\n2. Roll out each dough disk between 2 sheets of parchment paper until 1/4 inch thick. Refrigerate until firm, about 2 hours.\n\n3. Position racks in the upper and lower thirds of the oven and preheat to 350 degrees F. Line 2 baking sheets with parchment paper. Cut the dough into shapes using a 4 1/2-inch gingerbread man cookie cutter and arrange 2 inches apart on the prepared pans. Reroll the scraps and cut out more cookies. (If the dough is too soft, freeze 10 minutes before cutting.) Refrigerate until firm, 15 minutes. Bake, switching the pans halfway through, until the cookies are set but still soft, 15 minutes. Let cool 10 minutes on the pans, then transfer to racks to cool completely.\n\n4. Make the icing: Beat the confectioners' sugar, meringue powder and water in a bowl with a mixer on high speed until smooth and thick. Transfer to a resealable plastic bag and snip off a corner. Pipe skulls and bones onto the cookies. Let set 30 minutes.\n\n5. To decorate the cookies, first make the outline of the skull, eyes, nose, mouth and bones. Then thin some icing with a little water and pipe into the outline of the skull; use a toothpick to help."
            TimerDisplay = 900
            DisplayTime(TimerDisplay)
            citationLabel.text = "Recipe Citation: “Chocolate-Cinnamon Skeleton Cookies.” Food Network, https://www.foodnetwork.com/recipes/food-network-kitchen/chocolate-cinnamon-skeleton-cookies-3853803. Accessed 26 Sept. 2020."
        
        } else if recipeSelector.selectedSegmentIndex == 2 { //Mummy Pies recipe
            resetCheckboxesAndLabels() //Reset all of the checkboxes and labels
            resetTimer() //Reset the timer
            //Fill in recipe name, pictures, info, ingredients, recipe, and timer
            recipeTitleLabel.text = "Pumpkin Mummy Hand Pies"
            imageScroll(imageArray3)
            infoLabel.text = "Total Time: 55 min.  |  Cook Time: 25 min. Servings: 6 Hand Pies"
            checkBoxLabel1.text = "1/4 cup of canned pumpkin"
            checkBoxLabel2.text = "2 tablespoons of sweet condensed milk"
            checkBoxLabel3.text = "1/4 teaspoon of ground cinnamon"
            checkBoxLabel4.text = "1/4 teaspoon of ground ginger"
            checkBoxLabel5.text = "1/4 teaspoon of ground nutmeg"
            checkBoxLabel6.text = "Kosher salt (to taste)"
            checkBoxLabel7.text = "2 refrigerated pie crusts (thawed)"
            checkBoxLabel8.text = "All purpose flour for dusting"
            checkBoxLabel9.text = "1 large egg"
            checkBoxLabel10.text = "12 raisins or decorative candy eyeballs"
            checkBoxLabel11.text = "1/2 cup of powdered sugar (optional)"
            checkBox12.isHidden = true
            checkBox13.isHidden = true
            checkBox14.isHidden = true
            checkBoxLabel12.isHidden = true
            checkBoxLabel13.isHidden = true
            checkBoxLabel14.isHidden = true
            recipeLabel.text = "1. Preheat the oven to 350 degrees F.\n\n2. Add the pumpkin, sweetened condensed milk, cinnamon, ginger, nutmeg and a pinch of salt to a medium bowl and stir to combine.\n\n3. Roll out 1 pie crust on a lightly floured surface with a rolling pin to form a rectangle about 9 inches by 12 inches. Square off the crust with a knife, reserving the scraps for decorating. Cut the pie crust into 6 equal rectangles, each about 3 inches by 6 inches. Transfer to a parchment-lined baking sheet.\n\n4. Roll out the other pie crust to the same thickness as the first. Cut into thin strips about 1/4 inch wide and 7 inches long. Repeat with the reserved dough scraps. Transfer the strips to a parchment-lined baking sheet.\n\n5. Add 1 heaping tablespoon of the filling to the center of each rectangular crust. Use the back of a spoon to spread out the filling, leaving about a 1/2-inch border around the edges.\n\n6. Lightly beat the egg with 1 tablespoon water in a small bowl. Use a pastry brush to brush the edges of the pies with the egg wash. Layer the strips of dough, varying the angle of each strip to create a mummy look. Seal the edges with a fork and use a paring knife to trim the overhang. Lightly brush the tops of the hand pies with the egg wash. Add 2 raisins to each pie for the eyes.\n\n7. Bake, rotating the pan halfway through for even color, until golden brown, 20 to 25 minutes. Cool on a baking rack slightly, about 5 minutes.\n\nServe as is or decorate with a simple icing. Combine the confectioners' sugar in a small bowl with 1/2 teaspoon water. Stir until smooth and glossy. Transfer the icing to a resealable plastic bag and snip off the corner. Pipe the icing onto the hand pies using the stripes of pie crust as a guide."
            TimerDisplay = 1500
            DisplayTime(TimerDisplay)
            citationLabel.text = "Recipe Citation: “Mummy Hand Pies.” Food Network, https://www.foodnetwork.com/recipes/food-network-kitchen/mummy-hand-pies-3687680. Accessed 26 Sept. 2020."
        }
    }
    
    //Learned how to make the timer from here: https://www.youtube.com/watch?v=z2Jq5U-stag
    //Start/pause the timer when the button is pressed
    @IBAction func StartPauseButton(_ sender: UIButton) {
        if isPaused == true { //If the timer is paused and the button is pressed:
            RecipeTimer = Timer.scheduledTimer(timeInterval: 1, target: self, selector: #selector(Action), userInfo: nil, repeats: true) //Start the timer
            startPauseButton.setTitle("Pause", for: .normal) //Change the button to "Pause"
            isPaused = false //Change the isPaused bool to false
        } else if isPaused == false {
            RecipeTimer.invalidate() //Stop the timer
            startPauseButton.setTitle("Start", for: .normal) //Change the button to "Start"
            isPaused = true //Change the isPaused bool to true
        }
    }
    
    //Reset the timer when the button is pressed
    @IBAction func ResetButton(_ sender: UIButton) {
        resetTimer()
    }
    
    //Function to reset timer
    func resetTimer() {
        //If the start/pause button is hidden, make it visible
        if startPauseButton.isHidden == true {
            startPauseButton.isHidden = false
        }
        audioPlayer.stop() //Stop the music if it is playing
        RecipeTimer.invalidate() //Stop the timer
        //Reset the timer based on the current recipe:
        if recipeSelector.selectedSegmentIndex == 0 {
            TimerDisplay = 720
        } else if recipeSelector.selectedSegmentIndex == 1 {
            TimerDisplay = 900
        } else if recipeSelector.selectedSegmentIndex == 2 {
            TimerDisplay = 1500
        }
        DisplayTime(TimerDisplay) //Display the time
        startPauseButton.setTitle("Start", for: .normal) //Change the button to "Start"
        isPaused = true //Change the isPaused bool to true
    }
    
    //Function to count down the timer and play audio when the timer hits zero
    @objc func Action() {
        if(TimerDisplay > 0){ //While the timer is still active:
            DisplayTime(TimerDisplay) //Display the time
            TimerDisplay -= 1 //Decrease by 1 second
        } else { //If the timer is done:
            audioPlayer.play() //Play the audio
            startPauseButton.isHidden = true //Hide the start/pause button
            timerLabel.text = "All Done!" //Change the label to display completion message
        }
    }
    
    //Function to display time as "00: minutes: seconds"
    func DisplayTime(_ count: Int) {
        TimerDisplay = count
        let minutes = String(TimerDisplay / 60)
        let seconds = String(TimerDisplay % 60)
        timerLabel.text = "00: \(minutes): \(seconds)"
    }
    
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        //Change the font size of the segmented control
        //Learned how to change font size here: https://stackoverflow.com/questions/2280391/change-font-size-of-uisegmentedcontrol
        let font = UIFont.systemFont(ofSize: 12)
        recipeSelector.setTitleTextAttributes([NSAttributedString.Key.font: font], for: .normal)
        
        //Round the corners of the info label, timer label, and the two timer buttons
        infoLabel.layer.masksToBounds = true
        infoLabel.layer.cornerRadius = 10
        infoLabel.layer.borderWidth = 3
        
        timerLabel.layer.masksToBounds = true
        timerLabel.layer.cornerRadius = 10
        timerLabel.layer.borderWidth = 3
        
        startPauseButton.layer.cornerRadius = 7
        startPauseButton.layer.borderWidth = 3
        startPauseButton.layer.borderColor = UIColor.orange.cgColor
        
        resetButton.layer.cornerRadius = 7
        resetButton.layer.borderWidth = 3
        resetButton.layer.borderColor = UIColor.orange.cgColor
        
        recipeSelector.selectedSegmentIndex = 0 //Set the starting recipe
        updateRecipe() //Fill in all of the required info
        
        
        //Create a AVAudioPlayer object and initialize it with the path to the sound file
        //Learned how to play sound from here: https://codewithchris.com/avaudioplayer-tutorial/
        //Audio file from here: http://freemusicarchive.org/music/Loyalty_Freak_Music/WITCHY_BATTY_SPOOKY_HALLOWEEN_IN_SEPTEMBER_/A_ghost_Waltz
        let sound = Bundle.main.path(forResource: "A Ghost Waltz", ofType: "mp3") //Get the URL
        do {
            audioPlayer = try AVAudioPlayer(contentsOf: URL(fileURLWithPath: sound!)) //Initialize audio player with URL
        }
        catch {
            print("ERROR: The audio file could not be found!") //If the sound file can't be found, throw an error
        }
    }
}
