import java.util.Scanner;
public class schoolGrade {

    public static int[][] student(int numberOfStudents, int numberOfSubjects, Scanner input) {
        int[][] studentGradeSystem = new int[numberOfStudents][numberOfSubjects];
        int total = 0;

        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println("Entering scores for Student " + (i + 1));
            for (int j = 0; j < numberOfSubjects; j++) {
                System.out.print("Enter score for Subject " + (j + 1) + ": ");
                int score = input.nextInt();
                while (score < 0 || score > 100) {
                    System.out.print("Invalid score. Enter score between 0 and 100: ");
                    score = input.nextInt();
                }
                studentGradeSystem[i][j] = score;
            }
        }

        return studentGradeSystem;
    }



    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int numberOfStudents = input.nextInt();

        System.out.print("Enter number of subjects: ");
        int numberOfSubjects = input.nextInt();


        int[][] studentGradeSystem = student(numberOfStudents, numberOfSubjects, input);

        int [] totals = new int[numberOfStudents];
        double[] averages = new double[numberOfStudents];

        for (int i = 0; i < numberOfStudents; i++) {
            int total = 0;
            for (int j = 0; j < numberOfSubjects; j++) {
                total += studentGradeSystem[i][j];
            }
            totals[i] = total;
            averages[i] = (double) total / numberOfSubjects;
        }




        System.out.println("\n--- Student Scores ---");
        for (int i = 0; i < numberOfStudents; i++) {
            System.out.print("Student " + (i + 1) + ": ");
            for (int j = 0; j < numberOfSubjects; j++) {
                System.out.print(studentGradeSystem[i][j] + " ");
            }
            System.out.printf("| Total: %d | Average: %.2f\n", totals[i], averages[i]);
        }






    }
}
