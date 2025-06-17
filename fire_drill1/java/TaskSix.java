public class TaskSix {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            if (i >= 4 && i % 4 == 0) {
                int temp = i;
                int count = 0;
                 while(count <= 4){
                 System.out.println(temp);
                 temp = temp * i;
                 count ++;


                 }

            }
        }
    }
}


