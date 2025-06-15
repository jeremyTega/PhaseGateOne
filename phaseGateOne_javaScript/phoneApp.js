const prompt = require("prompt-sync")()
const myContact = []

function addContact(name, address, phone, email) {
    const person = {
        name: name.toLowerCase(),
        address,
        telephone: phone,
        email,
    };
    myContact.push(person);
    return "Contact added successfully."
}

function removeContact(phone) {
    for (let i = 0; i < myContact.length; i++) {
        if (myContact[i].telephone === phone) {
            myContact.splice(i, 1);
            return "Contact removed successfully."
        }
    }
    return "Contact not found."
}

function findContactByFirstName(firstName) {
    firstName = firstName.toLowerCase()
    for (const person of myContact) {
        const nameParts = person.name.split(" ")
        if (nameParts[0] === firstName) return person
    }
    return `${firstName} not available as first name in contact.`
}

function findContactByLastName(lastName) {
    lastName = lastName.toLowerCase()
    for (const person of myContact) {
        const nameParts = person.name.split(" ")
        if (nameParts[1] === lastName) return person
    }
    return `${lastName} not available as last name in contact.`
}

function editContact(phone) {
    for (let person of myContact) {
        if (person.telephone === phone) {
            console.log("Contact found:", person);
            const choice = prompt("What do you want to change? (1-Name, 2-Address, 3-Phone, 4-Email)")

            switch (choice) {
                case "1":
                    person.name = prompt("Enter new name: ").toLowerCase()
                    break;
                case "2":
                    person.address = prompt("Enter new address: ")
                    break;
                case "3":
            person.telephone = prompt("Enter new phone number: ")
                    break;
            case "4":
                    person.email = prompt("Enter new email: ")
            break;
                default:
                    console.log("Invalid choice.")
            }

            console.log("Contact updated:", person)
            return;
        }
    }
    console.log("Contact not found.")
}

