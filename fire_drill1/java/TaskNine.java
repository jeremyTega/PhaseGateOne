public class TaskNine {
    public static void main(String[] args) {
    int totalSum = 0;

        for (int i = 1; i <= 10; i++) {

            if (i >= 4 && i % 4 == 0) {
                int temp = i;
                int count = 0;
                int sum = 0;
                 while(count <= 4){
                 sum = sum + temp;


                 temp = temp * i;

                 count ++;


                 }
                 System.out.println(sum);
                 totalSum += sum;



            }

        }
        System.out.println(totalSum * totalSum);

    }
}


