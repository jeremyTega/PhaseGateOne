import java.util.Scanner;

public class myContact {
    static String[] firstName = new String[1000];
     static String[] lastName = new String[1000];
    static String[] phoneNumber = new String[1000];
     static String[] Address = new String[1000];
      static String[] Email = new String[1000];
    static int count = 0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

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
                System.out.print(" Enter first Name: ");
                firstName[count] = input.nextLine();
                System.out.print(" Enter last Name: ");
                lastName[count] = input.nextLine();
                System.out.print(" Enter phone Number: ");
                phoneNumber[count] = input.nextLine();
                 System.out.print("enter email: ");
                Email[count] = input.nextLine();
                 System.out.print("enter address: ");
                Address[count] = input.nextLine();
                   System.out.println("Contact added.");
                System.out.println(firstName[count]);
                System.out.println(lastName[count]);
                System.out.println(phoneNumber[count]);
                count++;
                }


        }


    }
}
