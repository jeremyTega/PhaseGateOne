import java.util.ArrayList;
import java.util.Scanner;
public class Checkout {

    public static ArrayList<String> createItem(String item, int quantity, int pricePerUnit) {
        ArrayList<String> itemDetails = new ArrayList<>();
        int subTotal = 0;
        int discount = 0;
        float vat = 17.50;
        itemDetails.add(item);
        itemDetails.add(String.valueOf(quantity));
        itemDetails.add(String.valueOf(pricePerUnit));
        itemDetails.add(String.valueOf(quantity * pricePerUnit));
        return itemDetails;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<ArrayList<String>> checkOut = new ArrayList<>();

        while (true) {
            System.out.println("What did the user buy?");
            String item = input.nextLine();

            System.out.println("How many pieces?");
            int quantity = input.nextInt();

            System.out.println("How much per unit?");
            int pricePerUnit = input.nextInt();
            input.nextLine();

            ArrayList<String> itemDetails = createItem(item, quantity, pricePerUnit);
            checkOut.add(itemDetails);

            System.out.println("Do you want to add more items? (yes/no)");
            String addMore = input.nextLine().toLowerCase();

            if (!addMore.equals("yes")) {
                break;
            }
        }
        System.out.println("\nCheckout Summary:");
        for (ArrayList<String> item : checkOut) {
            System.out.println("Item: " + item.get(0));
            System.out.println("Quantity: " + item.get(1));
            System.out.println("Price per unit: " + item.get(2));
            System.out.println("Total: " + item.get(3));
            System.out.println();
        }


    }
}
