import random
random_Acc_number = random.randint(100000000, 999999999)

Accounts = []


def createAccount(firstName, lastName,  pin):
    account = {
        "accountNumber":random_Acc_number,
        "firstName": firstName,
        "lastName": lastName,
        "pin": pin,
        "balance": 0.00
    }
    Accounts.append(account)
    return account


def closeAccount(account_number):
    for account in Accounts:
        if account_number == account["accountNumber"]:
            Accounts.remove(account)
            return f"accounts {account} has been deleted"

    return f" {account_number} not found"


def depositMoney(account_number, amount):
    for account in Accounts:
        if account_number == account["accountNumber"]:
            account["balance"] += amount
            return f"{account} \n Deposit successful. New balance: {account['balance']}"
    return f"Account number {account_number} not found"


def withdrawMoney(account_number, pin, amount):
    for account in Accounts:
        if account_number == account["accountNumber"]:
            if account["pin"] != pin:
                return "Incorrect PIN"
            if amount <= 0:
                return "Withdrawal amount must be greater than zero"
            if account["balance"] < amount:
                return "Insufficient funds"

            account["balance"] -= amount
            return f"Withdrawal successful. New balance: ₦{account['balance']:.2f}"

    return f"Account number {account_number} not found"




def changePin(account_number, new_pin):
    for account in Accounts:
        if account_number == account["accountNumber"]:
            account["pin"] = new_pin
            return "PIN has been updated successfully"
    return f"Account number {account_number} not found"


def transferMoney(userAccount, recipientAccount, pin, amount):
    sender = None
    receiver = None

    for account in Accounts:
        if account["accountNumber"] == userAccount:
            sender = account
        elif account["accountNumber"] == recipientAccount:
            receiver = account

    if sender is None:
        return f"Sender account {userAccount} not found"
    if receiver is None:
        return f"Recipient account {recipientAccount} not found"
    if sender["balance"] < amount:
        return f"Insufficient balance in account {userAccount}"


    sender["balance"] -= amount
    receiver["balance"] += amount

    return f"Transfer of {amount} from {userAccount} to {recipientAccount} successful \n {sender} \n {receiver}"
