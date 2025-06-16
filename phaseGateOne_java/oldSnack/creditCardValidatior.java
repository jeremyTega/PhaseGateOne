import java.util.Scanner;
public class creditCardValidatior{
public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    String cardType = "";
    int cardLength = 0;
    String cardValid= "";
    System.out.println("enter credit card");
    String creditCard = input.nextLine().trim();
    cardLength = creditCard.length();
    if(creditCard.startsWith("4")){
        cardType = "Visa cards";

    }else if (creditCard.startsWith("5")){
        cardType = " Master card";
    }else if (creditCard.startsWith("37")){
        cardType = " american express card";
    }else if (creditCard.startsWith("6")){
        cardType = "Discovery Card";
    }else{
        cardType = "Invalid Card ";
    }
    int evenSum = 0;
    int oddSum = 0;
    int temp = 0;
    char[] cardDigit = creditCard.toCharArray();
     for (int i = cardDigit.length - 1; i >= 0; i--) {
            int digit = Character.getNumericValue(cardDigit[i]);
            temp++;

            if (temp % 2 == 0) {
                digit *= 2;
                if (digit > 9) {
                    digit -= 9;
                }
                evenSum += digit;
            } else {
                oddSum += digit;
            }


        }

        int totalSum = evenSum + oddSum;
        if(totalSum % 10 == 0){
            cardValid = "Valid";
        }else{
                cardValid = "Invalid";
        }


        System.out.println("Credit card Type:" + cardType);
        System.out.println("Credit card Number:" + creditCard);
        System.out.println("Credit card Digit Length:" + cardLength);
        System.out.println("credit card validity" + cardValid);

}
}
