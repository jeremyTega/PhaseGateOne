import java.util.Scanner;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class myContact {
    

   public static Map<String, String> addContact(String name, String address, String phone, String email) {
     Map<String, String> contact = new HashMap<>();
    try {
        
        if (name == null || name.isEmpty() ||
             address == null || address.isEmpty() ||
             phone == null || phone.isEmpty() ||
             email == null || email.isEmpty()) {
    
    throw new IllegalArgumentException("All fields must be filled");
     }

       
            contact.put("Name", name);
            contact.put("Address", address);
            contact.put("Phone", phone);
            contact.put("Email", email);
        
    } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
        return null;
    }catch (Exception e) {
        System.out.println( e.getMessage());
        return null;
    }
     return contact;
    
}

public static String removeContact(ArrayList<Map<String, String>> phoneBook, String phone) {
    try {
        if(phone == null || phone.isEmpty()){
             throw new IllegalArgumentException("phone cannot be empty");
        }
        for (int i = 0; i < phoneBook.size(); i++) {
            if (phoneBook.get(i).get("Phone").equals(phone)) {
                phoneBook.remove(i);
                return "contact removed successfuly";
            }
        }
        return null;
    } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
        return null;
     } catch (Exception e) {
        System.out.println( e.getMessage());
        return null;
    }
}

public static Map<String, String> findByPhone(ArrayList<Map<String, String>> phoneBook, String phone) {
    
    try {
              if(phone == null || phone.isEmpty()){
             throw new IllegalArgumentException("phone cannot be empty");
        }
        for (Map<String, String> contact : phoneBook) {
            if (contact.get("Phone").equals(phone)) {
                return contact;
            }
        }
        return null;
    }catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
        return null;
    }
     catch (Exception e) {
        System.out.println( e.getMessage());
        return null;
    }
}


public static ArrayList<Map<String, String>> findByFirstName(ArrayList<Map<String, String>> phoneBook, String firstName) {
    ArrayList<Map<String, String>> find = new ArrayList<>();
    try {

                 if(firstName == null || firstName.isEmpty()){
             throw new IllegalArgumentException("phone cannot be empty");
        }
        for (Map<String, String> contact : phoneBook) {
            if (contact.get("Name").split(" ")[0].equalsIgnoreCase(firstName)) {
                find.add(contact);
            }
        }
        return find;
    }catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
        return null;
    }
     catch (Exception e) {
        System.out.println( e.getMessage());
        return null;
    }
}


public static ArrayList<Map<String, String>> findByLastName(ArrayList<Map<String, String>> phoneBook, String lastName) {
    ArrayList<Map<String, String>> find = new ArrayList<>();
    try {

         if(lastName == null || lastName.isEmpty()){
             throw new IllegalArgumentException("phone cannot be empty");
        }
        for (Map<String, String> contact : phoneBook) {
            if (contact.get("Name").split(" ")[0].equalsIgnoreCase(lastName)) {
                find.add(contact);
            }
        }
        return find;
    }catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
        return null;
    }
     catch (Exception e) {
        System.out.println( e.getMessage());
        return null;
    }
}


public static Map<String, String> editContact(ArrayList<Map<String, String>> phoneBook, String phone, String newName, String newAddress, String newEmail) {
    try {

        if (newName == null || newName.isEmpty() ||
             newAddress == null || newAddress.isEmpty() ||
               newEmail == null || newEmail.isEmpty()) {
    
    throw new IllegalArgumentException("All fields must be filled");
     }

        for (Map<String, String> contact : phoneBook) {
            if (contact.get("Phone").equals(phone)) {
                contact.put("Name", newName);
                contact.put("Address", newAddress);
                contact.put("Email", newEmail);
                return contact;
            }
        }
        return null;
    
    }catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
        return null;}
    catch (Exception e) {
        System.out.println("An unexpected error occurred: " + e.getMessage());
        return null;
    }
}


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Map<String, String>> phoneBook = new ArrayList<>();

        while (true) {
            System.out.println("===welcome please choose one===");
            System.out.println("1. Add Contact");
            System.out.println("2. Remove Contact");
            System.out.println("3. Find by Phone Number");
            System.out.println("4. Find by First Name");
            System.out.println("5. Find by Last Name");
            System.out.println("6. Edit Contact");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            int userChoice = input.nextInt();
            input.nextLine();

            if (userChoice == 1) {
                while(true){
                System.out.print(" Enter first Name: ");
                String Name = input.nextLine();
                System.out.print(" Enter Addresse: ");
                String address = input.nextLine();
                System.out.print(" Enter phone Number: ");
                String phone = input.nextLine();
                System.out.print("enter email: ");
               String email = input.nextLine();
                Map<String, String> contact = addContact(Name, address, phone, email);
                if(contact != null){
                    phoneBook.add(contact);
                    System.out.println("contact added successfully");
                    break;
                }else{
                    System.err.println("press 1 to start again and any other number to exit");
                    int answer = input.nextInt();
                    if(answer == 1) continue;
                    else{
                        break;
                    }
                  }                
                     }
                    }
                else if (userChoice == 2) {
                    while(true){
                    System.out.print("Enter phone number to remove: ");
                    String phone = input.nextLine();
                    String result = removeContact(phoneBook, phone);
                    if(result != null){
                     System.out.println("contact added successfully");
                     break;
                }else{
                    System.err.println("press 1 to start again and any other number to exit");
                    int answer = input.nextInt();
                    if(answer == 1) continue;
                    else{
                        break;
                    }
                  }
                }
                }

                else if (userChoice == 3) {
                    while(true){
                    System.out.print("Enter phone number to search: ");
                    String phone = input.nextLine();
                    Map<String, String> found = findByPhone(phoneBook, phone);
                    if (found != null) {
                        System.out.println(found);
                        break;
                    } else {
                        System.out.println("Contact not found.");
                        break;
                    }
                }
            }

                else if (userChoice == 4) {
                    System.out.print("Enter first name to search: ");
                    String firstName = input.nextLine();
                    ArrayList<Map<String, String>> results = findByFirstName(phoneBook, firstName);
                    if (!results.isEmpty()) {
                        for (Map<String, String> i : results) {
                            System.out.println(i);
                        }
                    } else {
                        System.out.println("Contact not found.");
                        break;
                    }
                }

                else if (userChoice == 5) {
                    System.out.print("Enter last name to search");
                    String lastName = input.nextLine();
                    ArrayList<Map<String, String>> results = findByLastName(phoneBook, lastName);
                    if (!results.isEmpty()) {
                        for (Map<String, String> i : results) {
                            System.out.println(i);
                        }
                        break;
                    } else {
                        System.out.println("Contact not found.");
                    }
                }

                else if (userChoice == 6) {
                    while(true){
                    System.out.print("Enter phone number of contact to edit: ");
                    String phone = input.nextLine();
                    System.out.print("Enter new name");
                    String name = input.nextLine();
                    System.out.print("Enter new address");
                    String address = input.nextLine();
                    System.out.print("Enter new email");
                    String email = input.nextLine();
                    Map<String, String> updated = editContact(phoneBook, phone, name, address, email);
                     if(updated != null){
                    phoneBook.add(updated);
                    System.out.println("contact added successfully");
                }else{
                    System.err.println("press 1 to start again and any other number to exit");
                    int answer = input.nextInt();
                    if(answer == 1) continue;
                    break;
                }
            }



        }


    }
}
}
