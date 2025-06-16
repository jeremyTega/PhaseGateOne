const prompt = require("prompt-sync")()


let accounts = []

function generateAccountNumber() {
    return Math.floor(Math.random() * 900000000) + 100000000;
}

function createAccount(firstName, lastName, pin) {
    const accountNumber = generateAccountNumber()
    const account = {
        accountNumber,
        firstName,
        lastName,
        pin,
        balance: 0.00
    };
    accounts.push(account);
    return account;
}



function closeAccount(accountNumber) {
    for (let i = 0; i < accounts.length; i++) {
        if (accounts[i].accountNumber === accountNumber) {
            const deletedAccount = accounts.splice(i, 1);
            return `Account ${deletedAccount[0].accountNumber} has been deleted.`
        }
    }
    return `Account number ${accountNumber} not found.`
}




function depositMoney(accountNumber, amount) {
    for (let i = 0; i < accounts.length; i++) {
        if (accounts[i].accountNumber === accountNumber) {
            accounts[i].balance += amount
            return `Deposit successful. New balance: ₦${accounts[i].balance.toFixed(2)}`
        }
    }
    return `Account number ${accountNumber} not found.`
}


function withdrawMoney(accountNumber, pin, amount) {
    for (let i = 0; i < accounts.length; i++) {
        if (accounts[i].accountNumber === accountNumber) {
            const account = accounts[i]
            if (account.pin !== pin) {
                return 'Incorrect PIN.'
            }
            if (amount <= 0) {
                return 'Withdrawal amount must be greater than zero.';
            }
            if (account.balance < amount) {
                return 'Insufficient funds.'
            }
            account.balance -= amount
            return `Withdrawal successful. New balance: ₦${account.balance.toFixed(2)}`
        }
    }
    return `Account number ${accountNumber} not found.`
}


function changePin(accountNumber, newPin) {
    for (let i = 0; i < accounts.length; i++) {
        if (accounts[i].accountNumber === accountNumber) {
            accounts[i].pin = newPin;
            return 'PIN has been updated successfully.'
        }
    }
    return `Account number ${accountNumber} not found.`
}


function transferMoney(senderAccountNumber, recipientAccountNumber, pin, amount) {
    let sender = null
    let recipient = null

    for (let i = 0; i < accounts.length; i++) {
        if (accounts[i].accountNumber === senderAccountNumber) {
            sender = accounts[i];
        } else if (accounts[i].accountNumber === recipientAccountNumber) {
            recipient = accounts[i];
        }
    }

    if (!sender) {
        return `Sender account ${senderAccountNumber} not found.`;
    }
    if (!recipient) {
        return `Recipient account ${recipientAccountNumber} not found.`;
    }
    if (sender.pin !== pin) {
        return 'Incorrect PIN.'
    }
    if (sender.balance < amount) {
        return 'Insufficient funds.'
    }

    sender.balance -= amount
    recipient.balance += amount
    return `Transfer of ₦${amount} from ${senderAccountNumber} to ${recipientAccountNumber} successful.`
}

 function mainMenu() {
    while (true) {
        console.log('\n====== WELCOME ======');
        console.log('1. Create Account')
        console.log('2. Close Account')
        console.log('3. Deposit Money')
        console.log('4. Withdraw Money')
        console.log('5. Change PIN')
        console.log('6. Transfer Money')
        console.log('7. Exit')

        const userChoice = prompt('Enter your choice (1-7): ')

        switch (userChoice) {
            case '1':
                let firstName = prompt('Enter First Name: ');
                let lastName =  prompt('Enter Last Name: ');
                let pin;
                while (true) {
                    pin = prompt('Set 4-digit PIN: ');
                if (pin.length === 4 && !isNaN(pin)) {
                     break;
                    } else {
                console.log('Invalid PIN. Please enter exactly 4 digits.');
            }
                }
                let account = createAccount(firstName, lastName, pin);
                console.log(`Account created successfully. Account Number: ${account.accountNumber}`);
                break

            case '2':
               let number = Number(prompt('Enter your account number: '))
            console.log(closeAccount(number));
                break;

            case '3':
                let userAcc = Number(prompt('Enter your account number: '));
             let depositAmount = Number( prompt('Enter amount to deposit: '));
               console.log(depositMoney(userAcc, depositAmount));
            break;

            case '4':
                let useraccount = Number(prompt('Enter your account number: '));
                let withdrawPin =  prompt('Enter your PIN: ');
                let withdrawAmount = Number( prompt('Enter amount to withdraw: '));
                console.log(withdrawMoney(useraccount, withdrawPin, withdrawAmount));
                break;

            case '5':
                let myAccount = Number(prompt('Enter your account number: '));
                let newPin;
                while (true) {
                    newPin = prompt('Enter new 4-digit PIN: ');
                    if (newPin.length === 4 && !isNaN(newPin)) {
                        break;
                    } else {
                        console.log('Invalid PIN. Please enter exactly 4 digits.');
                    }
                }
                console.log(changePin(myAccount, newPin));
                break;

            case '6':
                let senderAccNumber = Number(prompt('Enter your account number: '));
            let recipientAccNumber = Number(prompt('Enter recipient account number: '));
        let transferPin =  prompt('Enter your PIN: ');
        let transferAmount = Number(prompt('Enter amount to transfer: '));
                console.log(transferMoney(senderAccNumber, recipientAccNumber, transferPin, transferAmount));
                break;

            case '7':
                return;

            default:
                console.log('Invalid choice. Please try again.');
            break;
        }
    }
}

mainMenu();
