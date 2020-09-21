//
//  ViewController.swift
//  An Astronaut's Guide
//
//  Created by Ryan Than on 9/19/20.
//  Copyright © 2020 Ryan Than. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    @IBOutlet weak var spaceImage: UIImageView!
    @IBOutlet weak var titleLabel: UILabel!
    @IBOutlet weak var imageControl: UISegmentedControl!
    @IBOutlet weak var fontSizeSlider: UISlider!
    @IBOutlet weak var fontSizeLabel: UILabel!
    @IBOutlet weak var capitalSwitch: UISwitch!
    
    //Variable declarations
    let font1 = "Times New Roman"
    let font2 = "Courier New"
    let font3 = "MarkerFelt-Thin"
    
    //Function to update image, label text, label color, and label font
    func updateImage() {
        if imageControl.selectedSegmentIndex == 0 {
            spaceImage.image = UIImage(named: "Sun")
            titleLabel.text = "The Sun: The inside can reach over 27 million degrees Fahrenheit!"
            titleLabel.textColor = UIColor.systemOrange
            titleLabel.font = UIFont(name: font1, size: titleLabel.font.pointSize)
        } else if imageControl.selectedSegmentIndex == 1 {
            spaceImage.image = UIImage(named: "Moon")
            titleLabel.text = "The Moon: The same side of the moon is always facing Earth!"
            titleLabel.textColor = UIColor.systemGray2
            titleLabel.font = UIFont(name: font2, size: titleLabel.font.pointSize)
        } else if imageControl.selectedSegmentIndex == 2 {
            spaceImage.image = UIImage(named: "Stars")
            titleLabel.text = "Stars: There are about 100 thousand million stars in the Milky Way alone!"
            titleLabel.textColor = UIColor.systemYellow
            titleLabel.font = UIFont(name: font3, size: titleLabel.font.pointSize)
        }
    }
    
    //Function to update capitalization of the label text
    func updateCaps() {
        if capitalSwitch.isOn {
            titleLabel.text = titleLabel.text?.uppercased()
        } else {
            titleLabel.text = titleLabel.text?.lowercased()
        }
    }
    
    @IBAction func changeInfo(_ sender: UISegmentedControl) {
        updateImage()
        updateCaps()
    }
    
    @IBAction func capitalizeFont(_ sender: UISwitch) {
        updateCaps()
    }
    
    @IBAction func changeFontSize(_ sender: UISlider) {
        //Get new value:
        let fontSize = sender.value //float
        
        //Update slider label text
        fontSizeLabel.text = String(format: "%.0f", fontSize)
        
        //Change the label text size and keep the same font
        let fontSizeCGFloat = CGFloat(fontSize)
        if imageControl.selectedSegmentIndex == 0 {
            titleLabel.font = UIFont(name: font1, size: fontSizeCGFloat)
        } else if imageControl.selectedSegmentIndex == 1 {
            titleLabel.font = UIFont(name: font2, size: fontSizeCGFloat)
        } else if imageControl.selectedSegmentIndex == 2 {
            titleLabel.font = UIFont(name: font3, size: fontSizeCGFloat)
        } else {
            titleLabel.font = UIFont.systemFont(ofSize: fontSizeCGFloat)
        }
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        
        //Change background color of segmented control
        //Help from here: https://stackoverflow.com/questions/56436559/how-to-change-the-colors-of-a-segment-in-a-uisegmentedcontrol-in-ios-13
        imageControl.backgroundColor = UIColor.systemGray5 //Change the color to gray
        
        //Change the "off" color of the switch to gray for it to be visible with black background
        //Help from here: https://stackoverflow.com/questions/10348869/change-color-of-uiswitch-in-off-state
        capitalSwitch.backgroundColor = UIColor.systemGray5 //Change the color to gray
        capitalSwitch.layer.cornerRadius = 16.0 //Round the corners to match the switch shape
    }
}
