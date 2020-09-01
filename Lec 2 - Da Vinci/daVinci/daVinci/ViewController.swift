//
//  ViewController.swift
//  daVinci
//
//  Created by Ryan Than on 9/1/20.
//  Copyright © 2020 Ryan Than. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var artImage: UIImageView!
    
    @IBAction func chooseArt(_ sender: UIButton) {
        if sender.tag == 1 {
            artImage.image = UIImage(named: "LadyWithAnErmine")
        } else if sender.tag == 2 {
            artImage.image = UIImage(named: "SectionedSkull")
        }
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }


}

