const prompt = require('prompt-sync')()
const currentDateTime = new Date()
const localeString = currentDateTime.toLocaleString()

let myStore = [
    {
        name: "SEMI COLON STORES",
        branch: "MAIN BRANCH",
        phone: "0808182545",
        date: localeString,
        cashierName: ""
    }
];

let customerName = prompt("What is the customer's name? ")
let vatRate = 7.5
let subTotal = 0

while (true) {
    let item = prompt("What did the customer buy? ")
    let quantity = Number(prompt("How many pieces? "))
    let price = Number(prompt("How much per unit? "))
    let total = quantity * price

    myStore.push({
        item: item,
        quantity: quantity,
        price: price,
        total: total
    });

    let addMore = prompt("Do you want to add more items? (yes/no) ");
    addMore = addMore.toLowerCase()
    if (addMore !== "yes") {
        break;
    }
}

let sellerName = prompt("What is your name? ")
myStore[0].cashierName = sellerName;

let discount = Number(prompt("Enter discount amount: "))
for (let i = 1; i < myStore.length; i++) {
    subTotal += myStore[i].total;
}

let vat = (subTotal * vatRate) / 100
let billTotal = subTotal + vat - discount


console.log(`Store: ${myStore[0].name}`)
console.log(`Branch: ${myStore[0].branch}`)
console.log(`Phone: ${myStore[0].phone}`)
console.log(`Date: ${myStore[0].date}`)
console.log(`Cashier: ${myStore[0].cashierName}`)
console.log(`Customer: ${customerName}`)

console.log("\nItems Purchased:")
for (const item of myStore.slice(1)) {
    console.log(`${item.quantity} x ${item.item} @ ₦${item.price.toFixed(2)} each = ₦${item.total.toFixed(2)}`)
}

console.log(`\nSubtotal: ₦${subTotal.toFixed(2)}`)
console.log(`VAT @${vatRate}%: ₦${vat.toFixed(2)}`)
console.log(`Discount: ₦${discount.toFixed(2)}`)
console.log(`Total: ₦${billTotal.toFixed(2)}`)
console.log(`this is not a reciept kindly pay${billTotal}`)

let amountGiven = Number(prompt("How much did the customer pay? "))
while (amountGiven < billTotal) {
    console.log("Amount given is less than the total. Please enter a valid amount.")
    amountGiven = Number(prompt("How much did the customer pay? "))
}

let change = amountGiven - billTotal
console.log("\n--- RECEIPT ---")
console.log(`Store: ${myStore[0].name}`)
console.log(`Branch: ${myStore[0].branch}`)
console.log(`Phone: ${myStore[0].phone}`)
console.log(`Date: ${myStore[0].date}`)
console.log(`Cashier: ${myStore[0].cashierName}`)
console.log(`Customer: ${customerName}`)
console.log("\nItems Purchased:")
for (const item of myStore.slice(1)) {
    console.log(`${item.quantity} x ${item.item} @ ₦${item.price.toFixed(2)} each = ₦${item.total.toFixed(2)}`)
}
console.log(`\nSubtotal: ₦${subTotal.toFixed(2)}`)
console.log(`VAT @${vatRate}%: ₦${vat.toFixed(2)}`)
console.log(`Discount: ₦${discount.toFixed(2)}`)
console.log(`Total: ₦${billTotal.toFixed(2)}`)

console.log(`Amount Paid: ₦${amountGiven.toFixed(2)}`)
console.log(`Change: ₦${change.toFixed(2)}`)
console.log("\nThank you for shopping with us!")
