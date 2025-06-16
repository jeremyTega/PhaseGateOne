import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Checkout {
    public static List<String> items(String item, int price){
    List<String> items = new ArrayList<>();
        items.add(item);
        item.add(String.valueOf(price));
        return items;
    }
    public static void main(String[]args){
    Scanner input = new Scanner (System.in);
        System.out.println("what is the costumer`s Name");
        String customerName = input.nextLine();
    }
}
