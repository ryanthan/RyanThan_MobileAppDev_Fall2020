//
//  ViewController.swift
//  Beatles
//
//  Created by Ryan Than on 9/10/20.
//  Copyright © 2020 Ryan Than. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    @IBOutlet weak var beatlesImage: UIImageView!
    @IBOutlet weak var titleLabel: UILabel!
    @IBOutlet weak var fontSizeLabel: UILabel!
    @IBOutlet weak var capitalSwitch: UISwitch!
    @IBOutlet weak var fontSizeSlider: UISlider!
    @IBOutlet weak var imageControl: UISegmentedControl!
    
    func updateImage() {
        if imageControl.selectedSegmentIndex == 0 {
            beatlesImage.image = UIImage(named: "beatles1")
            titleLabel.text = "Young Beatles"
        } else if imageControl.selectedSegmentIndex == 1 {
            beatlesImage.image = UIImage(named: "beatles2")
            titleLabel.text = "Not-So-Young Beatles"
        }
    }
    
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
    
    @IBAction func updateFont(_ sender: UISwitch) {
        updateCaps()
    }
    
    @IBAction func changeFontSize(_ sender: UISlider) {
        //Get new value:
        let fontSize = sender.value //float
        
        //Update slider label text
        fontSizeLabel.text = String(format: "%.0f", fontSize)
        
        //Change the label text size
        let fontSizeCGFloat = CGFloat(fontSize)
        titleLabel.font = UIFont.systemFont(ofSize: fontSizeCGFloat)
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }


}

