const prompt = require("prompt-sync")()

let creditCard = prompt("enter credit card ")
creditCard = creditCard.trim()
let cardType = ""
let cardValid = ""
const cardLength = creditCard.length;

if (creditCard.startsWith("4")) {
    cardType = "Visa Card"
} else if (creditCard.startsWith("5")) {
    cardType = "MasterCard"
} else if (creditCard.startsWith("37")) {
    cardType = "American Express Card"
} else if (creditCard.startsWith("6")) {
    cardType = "Discovery Card"
} else {
    cardType = "Invalid Card"
}

let evenSum = 0
let oddSum = 0
let temp = 0

for (let i = cardLength - 1; i >= 0; i--) {
    let digit = parseInt(creditCard[i], 10)
    temp++;

    if (temp % 2 === 0) {
        digit *= 2;
        if (digit > 9) {
            digit -= 9
        }
        evenSum += digit
    } else {
        oddSum += digit
    }
}

const totalSum = evenSum + oddSum
if(totalSum % 10 == 0){
    cardValid = "Valid"
}else{
    cardValid = "Invalid"
}


console.log("Credit Card Number:", creditCard)
console.log("Card Type:", cardType)
console.log("Card Length:", cardLength)
console.log("Even Sum:", evenSum)
console.log("Odd Sum:", oddSum)
console.log("Card Validity:", cardValid)
