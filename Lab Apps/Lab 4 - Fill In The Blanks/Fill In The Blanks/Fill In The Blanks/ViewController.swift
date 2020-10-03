//
//  ViewController.swift
//  Fill In The Blanks
//
//  Created by Ryan Than on 10/1/20.
//  Copyright © 2020 Ryan Than. All rights reserved.
//

import UIKit

class ViewController: UIViewController, UITextFieldDelegate {
    //Variable declarations
    @IBOutlet weak var nounTextField: UITextField!
    @IBOutlet weak var verbTextField: UITextField!
    @IBOutlet weak var numLabel1: UILabel!
    @IBOutlet weak var numLabel2: UILabel!
    @IBOutlet weak var numStepper1: UIStepper!
    @IBOutlet weak var numStepper2: UIStepper!
    @IBOutlet weak var storyLabel: UILabel!
    var numOfVillainsPerHero: Float = 0.0
    
    //Function to update first stepper
    @IBAction func updateNumber1(_ sender: UIStepper) {
        if numStepper1.value == 2 {
            numLabel1.text = "Number: 2"
        } else {
            numLabel1.text = "Number: \(String(format: "%.0f", numStepper1.value))"
        }
    }
    
    //Function to update second stepper
    @IBAction func updateNumber2(_ sender: UIStepper) {
        if numStepper2.value == 2 {
            numLabel2.text = "Number: 2"
        } else {
            numLabel2.text = "Number: \(String(format: "%.0f", numStepper2.value))"
        }
    }
    
    //Function to fill in the blanks when the button is pressed
    @IBAction func fillInBlanks(_ sender: UIButton) {
        let numOfHeroes = numStepper1.value
        let numOfVillains = numStepper2.value
        numOfVillainsPerHero = Float(numOfVillains/numOfHeroes) //Perform the calculation
        
        //If either text field is empty, show an alert
        if (nounTextField.text!.isEmpty || verbTextField.text!.isEmpty) {
            //create a UIAlertController object
            let alert = UIAlertController(title: "Warning", message: "The text fields cannot be empty!", preferredStyle: UIAlertController.Style.alert)
            //create a UIAlertAction object for the button
            let okAction = UIAlertAction(title: "OK", style: UIAlertAction.Style.default, handler: nil)
            alert.addAction(okAction)
            present(alert, animated: true, completion: nil)
        } else { //Fill in the blanks of the story
            let noun = nounTextField.text!
            let verb = verbTextField.text!
            let numHeroesText = String(format: "%.0f", numStepper1.value)
            let numVillainsText = String(format: "%.0f", numStepper1.value)
            
            storyLabel.text = "Once upon a time, the kingdom was protected by a group of \(numHeroesText) heroes. The kingdom lived in peace until one day, the evil \(noun) began their attack! There were \(numVillainsText) \(noun) in total so it was up to each hero to \(verb) about \(String(format: "%.0f", numOfVillainsPerHero)) \(noun). Will the heroes prevail or will the \(noun) overwhelm the kingdom?"
        }
    }

    // Do any additional setup after loading the view.
    override func viewDidLoad() {
        super.viewDidLoad()
        //Set the delegates to allow the keyboard to be dismissed
        nounTextField.delegate = self
        verbTextField.delegate = self
        
        //Code to dismiss keyboard when tapping outside of a text field (from Beginning iPhone Development with Swift 5, Chapter 7, page 165)
        let tap: UITapGestureRecognizer = UITapGestureRecognizer(target: self, action: #selector(self.dismissKeyboard))
        view.addGestureRecognizer(tap)
    }
    
    //Function to dismiss the keyboard when the return button is pressed
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        textField.resignFirstResponder()
        return true
    }
    
    //Function to dismiss the keyboard when the user taps outside the text field
    @objc func dismissKeyboard() {
        view.endEditing(true)
    }
}

