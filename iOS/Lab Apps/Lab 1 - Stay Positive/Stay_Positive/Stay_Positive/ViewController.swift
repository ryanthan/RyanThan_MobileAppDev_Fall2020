//
//  ViewController.swift
//  Stay_Positive
//
//  Created by Ryan Than on 9/6/20.
//  Copyright © 2020 Ryan Than. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var image: UIImageView!
    
    @IBOutlet weak var quote: UILabel!
    
    @IBAction func changeQuoteOrImage(_ sender: UIButton) {
        if sender.tag == 1 { //If user taps "Be Happy" button
            image.image = UIImage(named: "happyBall") //Change image
            quote.text = "“Be happy for this moment. This moment is your life.” – Omar Khayyam" //Change quote
        } else if sender.tag == 2 { //If user taps "Be Inspired" button
            image.image = UIImage(named: "happyDraw") //Change image
            quote.text = "“The greatest discovery of all time is that a person can change his future by merely changing his attitude.” - Oprah Winfrey" //Change quote
        }
    }
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }


}

