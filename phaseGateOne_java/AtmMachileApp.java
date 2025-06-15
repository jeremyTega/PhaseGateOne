import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AtmMachineApp {


    public static List<String> createAccount(String firstName, String lastName, int pin, float amount) {
        List<String> accountDetails = new ArrayList<>();
        accountDetails.add(firstName);
        accountDetails.add(lastName);
        accountDetails.add(String.valueOf(pin));
        accountDetails.add(String.format("%.2f", amount));
        return accountDetails;
    }

    public static float checkAccountBalance(int pin){



    }
    // public static void viewAccount(List<String> account) {
    //     System.out.println("\nAccount Details:");
    //     System.out.println("Name: " + account.get(0) + " " + account.get(1));
    //     System.out.println("PIN: " + account.get(2));
    //     System.out.println("Balance: " + account.get(3));
    // }

    // Deposit amount into account
    public static void deposit(List<String> account, float amount) {
        float currentBalance = Float.parseFloat(account.get(3));
        currentBalance += amount;
        account.set(3, String.format("%.2f", currentBalance));
        System.out.println("Deposited successfully. New balance: " + account.get(3));
    }

    // Withdraw amount from account
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

    // Delete an account
    public static void deleteAccount(List<List<String>> accounts, int index) {
        if (index >= 0 && index < accounts.size()) {
            accounts.remove(index);
            System.out.println("Account deleted successfully.");
        } else {
            System.out.println("Invalid account index.");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<List<String>> accounts = new ArrayList<>();
        boolean exit = false;

        while (!exit) {
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
                    if (accounts.size() < 10) {
                        input.nextLine(); // Consume newline
                        System.out.print("Enter first name: ");
                        String firstName = input.nextLine();
                        System.out.print("Enter last name: ");
                        String lastName = input.nextLine();
                        System.out.print("Enter PIN: ");
                        int pin = input.nextInt();
                        float amount = 0.00f;
                        accounts.add(createAccount(firstName, lastName, pin, amount));
                        System.out.println("Account created successfully.");
                    } else {
                        System.out.println("Maximum account limit reached.");
                    }
                    break;

                case 2:
                    if (!accounts.isEmpty()) {
                        System.out.print("Enter account index to view (0 to " + (accounts.size() - 1) + "): ");
                        int index = input.nextInt();
                        if (index >= 0 && index < accounts.size()) {
                            viewAccount(accounts.get(index));
                        } else {
                            System.out.println("Invalid account index.");
                        }
                    } else {
                        System.out.println("No accounts available.");
                    }
                    break;

                case 3:
                    if (!accounts.isEmpty()) {
                        System.out.print("Enter account index to deposit (0 to " + (accounts.size() - 1) + "): ");
                        int index = input.nextInt();
                        if (index >= 0 && index < accounts.size()) {
                            System.out.print("Enter amount to deposit: ");
                            float amount = input.nextFloat();
                            deposit(accounts.get(index), amount);
                        } else {
                            System.out.println("Invalid account index.");
                        }
                    } else {
                        System.out.println("No accounts available.");
                    }
                    break;

                case 4:
                    if (!accounts.isEmpty()) {
                        System.out.print("Enter account index to withdraw (0 to " + (accounts.size() - 1) + "): ");
                        int index = input.nextInt();
                        if (index >= 0 && index < accounts.size()) {
                            System.out.print("Enter amount to withdraw: ");
                            float amount = input.nextFloat();
                            withdraw(accounts.get(index), amount);
                        } else {
                            System.out.println("Invalid account index.");
                        }
                    } else {
                        System.out.println("No accounts available.");
                    }
                    break;

                case 5:
                    if (!accounts.isEmpty()) {
                        System.out.print("Enter account index to delete (0 to " + (accounts.size() - 1) + "): ");
                        int index = input.nextInt();
                        if (index >= 0 && index < accounts.size()) {
                            deleteAccount(accounts, index);
                        } else {
                            System.out.println("Invalid account index.");
                        }
                    } else {
                        System.out.println("No accounts available.");
                    }
                    break;

                case 6:
                    exit = true;
                    System.out.println("Thank you for using Tega Bank.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        input.close();
    }
}
