import java.util.Scanner;
public class schoolGrade {

    public static int[][] student(int numberOfStudents, int numberOfSubjects, Scanner input) {
        int[][] studentGradeSystem = new int[numberOfStudents][numberOfSubjects];


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
            System.out.printf("| Total: %d | Average: %.2f\n", totals[i], averages[i]); //ranks[i]);
        }


        for (int i = 0; i < numberOfSubjects; i ++ ){
            int highestScore = 0;
            int totalScore = 0;
            int numberOfPasses = 0;
            int numberOfFails = 0;
            int lowestScore = 101;
            String highStudent = "";
            String lowStudent = "";

            for(int j = 0; j < numberOfStudents; j++){
              int score = studentGradeSystem[j][i];
              totalScore+=score;
              if(score > highestScore ){
                highestScore = score;
                highStudent = "Student" + (j +1);
              }
              if(score < lowestScore){
                lowestScore = score;
                lowStudent = "Student" + (j +1);
              }
              if (score >= 50){
                numberOfPasses++;
              }else{
                numberOfFails++;
              }



            }
            System.out.println("subject " + (i +1));
            System.out.println("Highest scoring studdent is  " + highStudent + " scoring " + highestScore);
            System.out.println("Lowest scoring studdent is  " + lowStudent + " scoring " + lowestScore);
            System.out.println("total score is " +  totalScore);
            System.out.println("number of pass is "+ numberOfPasses);
            System.out.println("number of fail is "+ numberOfFails);


        }

        int generalTotalScore = 0;
        double generalAverageScore = 0.0;
        int bestScore = 0;
        String bestStudent = "";

        for (int i = 0; i < numberOfStudents; i++) {
            generalTotalScore += totals[i];
            if (totals[i] > bestScore) {
                bestScore = totals[i];
                bestStudent = "Student " + (i + 1);
            }
        }

        generalAverageScore = (double) generalTotalScore / (numberOfStudents * numberOfSubjects);

        System.out.println("\n--- General Summary ---");
        System.out.println("General Total Score of all students: " + generalTotalScore);
        System.out.printf("General Average Score: %.2f\n", generalAverageScore);
        System.out.println("Best Graduating Student: " + bestStudent + " with total score of " + bestScore);











    }
}
