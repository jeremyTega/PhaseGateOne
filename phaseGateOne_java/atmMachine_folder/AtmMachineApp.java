import java.util.ArrayList;
import java.util.Scanner;

public class AtmMachineApp {

    public static ArrayList<String> createAccount(String firstName, String lastName,  String phoneNumber, int pin, float amount) {
    int length = String.valueOf(pin).length();
    ArrayList<String> accountDetails = new ArrayList<>();
    try {
        if (firstName == null || firstName.isEmpty()) {
            throw new IllegalArgumentException("First name cannot be empty.");
        }
        if (lastName == null || lastName.isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be empty.");
        }
        if (pin <= 0) {
            throw new IllegalArgumentException("PIN must be a positive integer.");
        }
        if (length != 4) {
            throw new IllegalArgumentException("Length of PIN must be 4.");
        }
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative.");
        }
        accountDetails.add(firstName);
        accountDetails.add(lastName);
        accountDetails.add(phoneNumber); 
        accountDetails.add(String.valueOf(pin));
        accountDetails.add(String.format("%.2f", amount));
    } catch (IllegalArgumentException e) {
        System.out.println("Error: " + e.getMessage());
        return null;
    } catch (Exception e) {
        System.out.println("An unexpected error occurred: " + e.getMessage());
        return null;
    }
    return accountDetails;
}

public static String deleteAccount(ArrayList<ArrayList<String>> accounts, String phoneNumber) {
    try {
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            throw new IllegalArgumentException("phoneNumber must not be empty");
        }

        for (int i = 0; i < accounts.size(); i++) {
            ArrayList<String> account = accounts.get(i);
            if ( account.get(2).equals(phoneNumber)) {
                accounts.remove(i); 
                return "Account with phone number " + phoneNumber + " deleted successfully.";
            }
        }

        return "Account with phone number " + phoneNumber + " not found.";

    } catch (IllegalArgumentException e) {
        System.out.println("Error: " + e.getMessage());
        return null;
    } catch (Exception e) {
        System.out.println("An unexpected error occurred: " + e.getMessage());
        return null;
    }
}

public static String deposit(ArrayList<ArrayList<String>> accounts, String phoneNumber, int pin, float amount){
      
try {
    int length = String.valueOf(pin).length();
    if (pin <= 0) {
            throw new IllegalArgumentException("PIN must be a positive integer.");
        }
    if (length != 4) {
            throw new IllegalArgumentException("Length of PIN must be 4.");
        }
        for(int i = 0; i < accounts.size(); i++){
              ArrayList<String> account = accounts.get(i);
              if(account.get(2).equals(phoneNumber)){
                    String tempPin = account.get(3);
                    if(tempPin.equals(String.valueOf(pin))){
                    float currentBalance = Float.parseFloat(account.get(4));
                    currentBalance += amount;

                    account.set(4, String.format("%.2f", currentBalance));
                            return "Deposit successful. New balance: ₦" + currentBalance;
                    }else{
                        return "incorrect pin";
                    }
              }


        }

    
} catch (IllegalArgumentException e) {
        System.out.println("Error: " + e.getMessage());
        return null;
        }catch (Exception e) {
     System.out.println("An unexpected error occurred: " + e.getMessage());
        return null;
}
   return "Account with phone number " + phoneNumber + " not found.";

}


public static String changePin(ArrayList<ArrayList<String>> accounts, String phoneNumber, int oldPin, int newPin) {
        try {
        int length = String.valueOf(oldPin).length();
        if (oldPin <= 0 || length != 4) {
            throw new IllegalArgumentException("Old PIN must be a 4-digit positive number.");
        }
        for (int i = 0; i < accounts.size(); i++) {
            ArrayList<String> account = accounts.get(i);

            if (account.size() >= 4 && account.get(2).equals(phoneNumber)) {
                String storedPin = account.get(3);

                if (storedPin.equals(String.valueOf(oldPin))) {
                    
                    int newLength = String.valueOf(newPin).length();

                    if (newPin <= 0 || newLength != 4) {
                        return "New PIN must be a 4-digit positive number.";
                    }
                    account.set(3, String.valueOf(newPin)); 
                    return "PIN updated successfully.";
                } else {
                    return "Incorrect old PIN.";
                }
            }
        }

        return "Account with phone number " + phoneNumber + " not found.";

    } catch (IllegalArgumentException e) {
        System.out.println("Error: " + e.getMessage());
        return null;
    } catch (Exception e) {
        System.out.println("An unexpected error occurred: " + e.getMessage());
        return null;
    }
}



   


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<ArrayList<String>> accounts = new ArrayList<>();
        

        while (true) {
            System.out.println("\n==== Welcome to Tega Bank ====");
            System.out.println("1. Create Account");
            System.out.println("2. Delete Account");
            System.out.println("3. Deposit");
            System.out.println("4. change pin");
            System.out.println("5. Delete Account");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                while(true){
                        input.nextLine();
                        System.out.print("Enter first name: ");
                        String firstName = input.nextLine();
                        System.out.print("Enter last name: ");
                        String lastName = input.nextLine();
                        System.out.print("Enter phoneNumber: ");
                        String phoneNumber = input.nextLine();
                        System.out.print("Enter PIN: ");
                        int pin = input.nextInt();
                        float amount = 0.00f;
                        ArrayList<String> account = createAccount(firstName, lastName, phoneNumber, pin, amount);
                        if(account != null){
                            System.out.println("Account created successfully.");
                            // for (String detail : account) {
                            //     System.out.println(detail);
                                        //}
                                       System.out.println("account number:"  + account.get( 2));
                                         System.out.println("account pin:"  + account.get( 3));
                                         System.out.println("Balance:"  + account.get( 4));
                            accounts.add(account);
                        }else{
                        System.out.println("Details not correct");
                        continue;

                          }
                          break;
                        }
                        break;
                      case 2:
                            input.nextLine(); 
                            while (true) {
                                System.out.print("Enter phone number to delete: ");
                                String phone = input.nextLine();
                                String result = deleteAccount(accounts, phone);
                                System.out.println(result);
                                
                                if (result != null) {
                                    break; 
                                }else{
                                    continue;
                                }
                                 
                            }
                            break;
                        case 3:
                        input.nextLine();
                        while(true){
                            System.out.println("Enter phoneNumber");
                            String phoneNumber = input.nextLine();
                            System.out.println("Enter Pin");
                            int pin = input.nextInt();
                             System.out.println("Enter amount to deposit");
                            float amount = input.nextFloat();
                            String result = deposit(accounts, phoneNumber,pin,amount);
                            System.out.println(result);
                        if (result != null) {
                                       break; 
                                }else{
                                    continue;
                                }
                            }
                            

               default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

    }
}





//  public static void deposit(List<String> account, float amount) {
//         float currentBalance = Float.parseFloat(account.get(3));
//         currentBalance += amount;
//         account.set(3, String.format("%.2f", currentBalance));
//         System.out.println("Deposited successfully. New balance: " + account.get(3));
//     }


//     public static void withdraw(List<String> account, float amount) {
//         float currentBalance = Float.parseFloat(account.get(3));
//         if (amount <= currentBalance) {
//             currentBalance -= amount;
//             account.set(3, String.format("%.2f", currentBalance));
//             System.out.println("Withdrawn successfully. New balance: " + account.get(3));
//         } else {
//             System.out.println("Insufficient balance.");
//         }
//     }




