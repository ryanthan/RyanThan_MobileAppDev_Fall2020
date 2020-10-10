//
//  ViewController.swift
//  Project1FeatureTest
//
//  Created by Ryan Than on 9/26/20.
//  Copyright © 2020 Ryan Than. All rights reserved.
//

import UIKit
import AVFoundation

class ViewController: UIViewController {
    @IBOutlet weak var mainScrollView: UIScrollView!
    
    @IBOutlet weak var checkBox: UIButton!
    @IBOutlet weak var CheckBoxLabel: UILabel!
    @IBOutlet weak var checkBox2: UIButton!
    @IBOutlet weak var CheckBoxLabel2: UILabel!
    
    @IBOutlet weak var TimerLabel: UILabel!
    @IBOutlet weak var StartPauseButton: UIButton!
    
    var RecipeTimer = Timer()
    var TimerDisplay = 300
    var isPaused = true
    var audioPlayer = AVAudioPlayer()

    var imageArray = [UIImage(named: "Image1"), UIImage(named: "Image2"), UIImage(named: "Image3")]
    
    
    //Learned how to make the timer from here: https://www.youtube.com/watch?v=z2Jq5U-stag
    //Function to start/pause the timer
    @IBAction func StartPauseButton(_ sender: Any) {
        if isPaused == true {
            RecipeTimer = Timer.scheduledTimer(timeInterval: 1, target: self, selector: #selector(Action), userInfo: nil, repeats: true)
            StartPauseButton.setTitle("Pause", for: .normal)
            isPaused = false
        } else if isPaused == false {
            RecipeTimer.invalidate()
            StartPauseButton.setTitle("Start", for: .normal)
            isPaused = true
        }
    }
    //Function to reset the timer when the reset button is pressed
    @IBAction func ResetButton(_ sender: Any) {
        if StartPauseButton.isHidden == true {
            StartPauseButton.isHidden = false
        }
        audioPlayer.stop()
        RecipeTimer.invalidate()
        TimerDisplay = 3
        DisplayTime(TimerDisplay)
        StartPauseButton.setTitle("Start", for: .normal)
        isPaused = true
    }
    //Function to count down the timer
    @objc func Action() {
        if(TimerDisplay > 0){
            DisplayTime(TimerDisplay)
            TimerDisplay -= 1
        } else {
            audioPlayer.play()
            StartPauseButton.isHidden = true
            TimerLabel.text = "All Done!"
        }
    }
    //Function to display time as "- minutes and - seconds"
    func DisplayTime(_ count: Int) {
        TimerDisplay = count
        let minutes = String(TimerDisplay / 60)
        let seconds = String(TimerDisplay % 60)
        TimerLabel.text = "\(minutes) minutes and \(seconds) seconds"
    }
    
    
    //The following functions are used to make each checkbox function separately
    @IBAction func checkBox(_ sender: UIButton) {
        updateCheckbox(sender, CheckBoxLabel)
    }
    @IBAction func checkBox2(_ sender: UIButton) {
        updateCheckbox(sender, CheckBoxLabel2)
    }
    //This function changes the button image and text color
    //Learned how to change button image from here: https://stackoverflow.com/questions/38041688/how-to-change-button-image-in-swift/38041892
    func updateCheckbox(_ sender: UIButton, _ label: UILabel) {
        sender.isSelected.toggle()
        if sender.isSelected == true {
            sender.setImage(UIImage(named: "Selected")?.withRenderingMode(.alwaysOriginal), for: .selected)
            label.textColor = UIColor.systemGray
        } else {
            sender.setImage(UIImage(named: "NotSelected")?.withRenderingMode(.alwaysOriginal), for: .normal)
            label.textColor = UIColor.black
        }
    }
    
    
    // Do any additional setup after loading the view.
    override func viewDidLoad() {
        super.viewDidLoad()
        
        //Display the time in the label
        TimerDisplay = 3
        DisplayTime(TimerDisplay)
        
        //Create a new AVAudioPlayer object and initialize it with the path to the sound file
        //Learned how to play sound from here: https://codewithchris.com/avaudioplayer-tutorial/
        //Audio file from here: https://www.zedge.net/ringtone/6756d08c-214b-4ae8-b31c-7634f132ee40
        let sound = Bundle.main.path(forResource: "radar", ofType: "mp3")
        do {
            audioPlayer = try AVAudioPlayer(contentsOf: URL(fileURLWithPath: sound!))
        }
        catch {
            print("ERROR: The audio file could not be found!")
        }
        
        //Make the scrollable image gallery
        //Learned how to make image gallery here: https://www.youtube.com/watch?v=LaWnv5sRpho
        for i in 0..<imageArray.count {
            let imageView = UIImageView()
            imageView.image = imageArray[i]
            imageView.contentMode = .scaleAspectFill
            let xPosition = self.mainScrollView.frame.width * CGFloat(i)
            imageView.frame = CGRect(x: xPosition, y: 0, width: self.mainScrollView.frame.width, height: self.mainScrollView.frame.height)
            mainScrollView.contentSize.width = mainScrollView.frame.width * CGFloat(i + 1)
            mainScrollView.addSubview(imageView)
        }
        
        //Set the inital checkbox images
        checkBox.setImage(UIImage(named: "NotSelected")?.withRenderingMode(.alwaysOriginal), for: .normal)
        checkBox2.setImage(UIImage(named: "NotSelected")?.withRenderingMode(.alwaysOriginal), for: .normal)
    }
}

