myContact = []

def addContact(name, address, phone, email):
    person = {
        "name": name.lower(),
        "address": address,
        "telephone": phone,
        "email": email
    }
    myContact.append(person)
    return "Contact added successfully."

def removeContact(phone):
    for person in myContact:
        if person["telephone"] == phone:
            myContact.remove(person)
            return "Contact removed successfully."
    return "Contact not found."

def findContactByFirstName(firstName):
    firstName = firstName.lower()
    for person in myContact:
        name_parts = person["name"].split()
        if firstName == name_parts[0]:
            return person
    return f"{firstName} not available as firstName in contact."

def findContactByLastName(lastName):
    lastName = lastName.lower()
    for person in myContact:
        name_parts = person["name"].split()
        if lastName == name_parts[1]:
            return person
    return f"{lastName} not available as lastname in contact."

def editContact(phone):
    for person in myContact:
        if person["telephone"] == phone:
            print("Contact found:")
            print(person)

            print("\nWhat do you want to change?")
            print("1. Name")
            print("2. Address")
            print("3. Telephone")
            print("4. Email")
            choice = input("Enter your choice (1-4): ")

            if choice == "1":
                new_name = input("Enter new name: ")
                person["name"] = new_name.lower()
            elif choice == "2":
                new_address = input("Enter new address: ")
                person["address"] = new_address
            elif choice == "3":
                new_phone = input("Enter new phone number: ")
                person["telephone"] = new_phone
            elif choice == "4":
                new_email = input("Enter new email: ")
                person["email"] = new_email
            else:
                print("Invalid option.")

            print("\nContact updated successfully:")
            print(person)
            return

    print("Contact with that phone number not found.")



while True:
    print("\n--- Welcome to Your Phone Book ---")
    print("1. Add Contact")
    print("2. Remove Contact")
    print("3. Find Contact by First Name")
    print("4. Find Contact by Last Name")
    print("5. Edit Contact")
    print("6. Exit")

    try:
        choice = int(input("Enter your choice (1-6): "))
    except ValueError:
        print("Please enter a valid number.")
        continue

    if choice == 1:
        name = input("Enter name for person: ")
        address = input("Enter address: ")
        phone = input("Enter phone number: ")
        email = input("Enter email: ")
        print(addContact(name, address, phone, email))

    elif choice == 2:
        phone = input("Enter phone number to remove: ")
        print(removeContact(phone))

    elif choice == 3:
        firstName = input("Enter first name to search: ")
        print(findContactByFirstName(firstName))

    elif choice == 4:
        lastName = input("Enter last name to search: ")
        print(findContactByLastName(lastName))

    elif choice == 5:
        phone = input("Enter the phone number of the contact to edit: ")
        editContact(phone)

    elif choice == 6:
            break

    else:
        print("Invalid input. Please enter a number between 1 and 6.")
