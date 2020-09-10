import UIKit

var message : String = "Hello World"

let classMax : Int = 20
//classMax = 30 //ERROR: Can't change a constant

var age : Int
age = 20
//age = "hello //ERROR: Can't assign age(int) to a different type (string)

var name = "Ryan" //Swift has type inference, in this case, it assumes name is a string

print("Hello World") //Has a new line at the end
print("Hi " + name) //Can concatenate name to string
print("My name is \(name)") //Can put variable in the quotations


//Type Conversion
let a = 42
let b = 0.0492
//let c = a + b //ERROR: Can't add an int and a double
let c = Double(a) + b //This works by converting a to Double


//Tuples
let violet = ("#EE82EE", 238, 130, 239)
print("Violet is \(violet.3)") //Access tuple variables using .0, .1, .2, .3, etc.
let (hex, red, green, blue) = violet
print("Violet is \(hex)")


//a...b - Closed Range (a to b, including a AND b)
//a..<b - Half Open (a to b, NOT including b)
//...b OR a... - One Sided Range


//Conditionals
var young = "You're young"
var notyoung = "You're not young"

if age < 21 {
    print(young)
} else {
    print(notyoung)
}

age < 21 ? young : notyoung //Swift ternary operator, equivalent to above if-else statement


//Switch Statement
switch age {
    case 0...5: print("You're a wee bitty one")
    case 6...21: print("Enjoy school")
    case 22...55: print("Welcome to the real world")
default: print("I don't know what you're doing")
}


//For Loops
for count in 0...age {
    print(count) //Will print 0 - age
}


//Functions
func sayHi() {
    print("Hi!")
}
sayHi()

func sayHello(first: String, last: String) {
    print("Hello \(first) \(last)")
}
sayHello(first: "Bill", last: "Adams")

//By using firstName first, you can use first or firstName in the function
func sayWhat(firstName first: String, lastName last: String) {
    print("What \(first) \(last)?")
}
sayWhat(firstName: "Stacey", lastName: "Smith")

//By using the underscore, you don't have to type the parameter in the function call
func sayWhere(_ place: String) {
    print(place)
}
sayWhere("CU Boulder")

func sayWho(firstName: String, lastName: String) -> String {
    return "Who is " + firstName + lastName + "?"
}
let msg2 = sayWho(firstName: "Lady", lastName: "Gaga")
print(msg2)


//Optionals
var score : Int?
score = 80
//print("Score is \(score)")

//If it is not nil, force unwrap the value with the !
if score != nil {
    print("Score is \(score!)")
}

//If score != nil, assign it to constant currentScore. Removes need for exclamation point
if let currentScore = score {
    print("My current score is \(currentScore)")
}

let newScore : Int! = 95
print("My new score is \(newScore)")
