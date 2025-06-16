import methodsAtmMachine

while True:
    print("\n====== WELCOME ======")
    print("1. Create Account")
    print("2. Close Account")
    print("3. Deposit Money")
    print("4. Withdraw Money")
    print("5. Change PIN")
    print("6. Transfer Money")
    print("7. Exit")

    choice = input("Enter your choice (1-7): ")

    if choice == "1":
        first = input("Enter First Name: ")
        last = input("Enter Last Name: ")

        while True:
            pin = input("Set 4-digit PIN: ")
            if pin.isdigit() and len(pin) == 4:
                 break
            else:
                 print("Invalid PIN. Please enter exactly 4 digits (numbers only).")

        print(methodsAtmMachine.createAccount(first, last, pin))

    elif choice == "2":
        acc = int(input("Enter your account number: "))
        print(methodsAtmMachine.closeAccount(acc))

    elif choice == "3":
        acc = int(input("Enter your account number: "))
        amt = int(input("Enter amount to deposit: "))
        # while True:
        #      if amt.isdigit():
        #         break
        #      else:
        #          print("Invalid amount. Please enter a correct amount.")


        print(methodsAtmMachine.depositMoney(acc, amt))

    elif choice == "4":
        acc = int(input("Enter your account number: "))
        amt = float(input("Enter amount to withdraw: "))
        print(withdrawMoney(acc, amt))

    elif choice == "5":
        acc = int(input("Enter your account number: "))

        # while True:
        #     new_pin = input("Set new 4-digit PIN: ")
        #     if new_pin.isdigit() and len(new_pin) == 4:
        #          break
        #     else:
        #          print("Invalid PIN. Please enter exactly 4 digits (numbers only).")
        print(methodsAtmMachine.changePin(acc, new_pin))

    elif choice == "6":
        sender = int(input("Enter your account number: "))
        receiver = int(input("Enter recipient's account number: "))
        amt = float(input("Enter amount to transfer: "))
        print(methodsAtmMachine.transferMoney(sender, receiver, amt))

    elif choice == "7":
           break

    else:
        print("Invalid choice. Please try again.")






