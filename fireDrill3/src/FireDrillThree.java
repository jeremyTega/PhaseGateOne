import java.util.Scanner;


public class FireDrillThree {

    public static int[] taskOne(){
        Scanner scanner = new Scanner(System.in);
        int[] scores = new int[10];
        for (int i = 0; i < scores.length; i++) {
            System.out.print("Enter score " + (i + 1) + ": ");
            scores[i] = scanner.nextInt();
        }

        return scores;

    }



    public static int[] taskTwo(){
        Scanner scanner = new Scanner(System.in);
        int[] scores = new int[10];
        for (int i = 0; i < scores.length; i++) {
            System.out.print("Enter score " + (i + 1) + ": ");
            scores[i] = scanner.nextInt();
        }
        System.out.println("horizontally :");
        for (int score : scores) {
            System.out.print(score + " ");
        }
        return scores;

    }

    public static int[] taskThree(){
        Scanner scanner = new Scanner(System.in);
        int[] scores = new int[10];
        for (int i = 0; i < scores.length; i++) {
            System.out.print("Enter score " + (i + 1) + ": ");
            scores[i] = scanner.nextInt();
        }
        for (int score : scores) {
            System.out.println(score);
        }

        return scores;
    }

    public static int[] taskFour(int[] arr1) {

        int size = (arr1.length + 1) / 2;
        int[] result = new int[size];

        int j = 0;
        for (int i = 0; i < arr1.length; i++) {
            if (i % 2 == 0) {
                result[j] = arr1[i];
                j++;
            }
        }
        return result;
    }


    public static int[] taskFive(int[] arr1) {
        int size = (arr1.length + 1) / 2;
        int[] result = new int[size];

        int j = 0;
        for (int i = 0; i < arr1.length; i++) {
            if (i % 2 != 0) {
                result[j] = arr1[i];
                j++;
            }
        }
        return result;
    }


    public static int taskSix(int[] arr) {
        int[] newArr = taskFour(arr);
        int sum = 0;
        for (int value : newArr) {
            sum += value;
        }
        return sum;
    }

    public static int taskSeven(int[] arr) {
        int[] newArr = taskFive(arr);
        int sum = 0;
        for (int value : newArr) {
            sum += value;
        }
        return sum;
    }









}





