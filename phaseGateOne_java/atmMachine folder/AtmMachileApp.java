import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AtmMachineApp {

    public static List<String> createAccount(String firstName, String lastName,  String phoneNumber, int pin, float amount) {
    int length = String.valueOf(pin).length();
    List<String> accountDetails = new ArrayList<>();
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
        accountDetails.add(String.valueOf(pin));
        accountDetails.add(phoneNumber);
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


public static void deleteAccount(String phoneNumber) {

    }

    public static void deposit(List<String> account, float amount) {
        float currentBalance = Float.parseFloat(account.get(3));
        currentBalance += amount;
        account.set(3, String.format("%.2f", currentBalance));
        System.out.println("Deposited successfully. New balance: " + account.get(3));
    }


    public static void withdraw(List<String> account, float amount) {
        float currentBalance = Float.parseFloat(account.get(3));
        if (amount <= currentBalance) {
            currentBalance -= amount;
            account.set(3, String.format("%.2f", currentBalance));
            System.out.println("Withdrawn successfully. New balance: " + account.get(3));
        } else {
            System.out.println("Insufficient balance.");
        }
    }




    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<List<String>> accounts = new ArrayList<>();
        boolean active = false;

        while (!active) {
            System.out.println("\n==== Welcome to Tega Bank ====");
            System.out.println("1. Create Account");
            System.out.println("2. View Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
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
                        List<String> account = createAccount(firstName, lastName, phoneNumber, pin, amount);
                        if(account != null){
                            System.out.println("Account created successfully.");
                            accounts.add(account);
                        }else{
                        System.out.println("Details not correct");
                        continue;

                          }
                          break;
                        }

               default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

    }
}




