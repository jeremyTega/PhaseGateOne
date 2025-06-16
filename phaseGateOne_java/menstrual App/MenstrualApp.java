import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
public class MenstrualApp{

        public static LocalDate startDate(int year, int month, int day){
            LocalDate startDate = null;
            try{
            return startDate = LocalDate.of(year,month,day);

            }catch(Exception e){
            System.out.println("invalid date:" + e.getMessage());
            return null;
            }

        }

        public static List<LocalDate> predictOvulationPeriod(LocalDate startDate){
            List<LocalDate> ovulationDates = new ArrayList<>();
            for(int i = 14; i<= 19; i++){
                ovulationDates.add(startDate.plusDays(i));
            }
             //return startDate.plusDays(14);
                return ovulationDates;
        }

        public static List<LocalDate> safePerods(LocalDate startDate){
         List<LocalDate> safePeriod = new ArrayList<>();
            for(int i = 6; i<= 9; i++){
                safePeriod.add(startDate.plusDays(i));
            }

                return safePeriod;
        }



public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the Menstrual Period Calculator");

        System.out.print("Enter the day of the first day of menstruation: ");
        int day = input.nextInt();

        System.out.print("Enter the month of menstruation start: ");
        int month = input.nextInt();

        System.out.print("Enter the year of menstruation start: ");
        int year = input.nextInt();

        LocalDate start = startDate(year, month, day);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
        System.out.println("Start Date: " + start.format(formatter));


        List<LocalDate> ovulationDates = predictOvulationPeriod(start);
         List<LocalDate> saveDates = safePerods(start);


        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");

        System.out.println("Predicted Ovulation Window:");
        for (LocalDate saves : saveDates) {
            System.out.println(saves);
        }

        System.out.println("Predicted Ovulation Window:");
        for (LocalDate date : ovulationDates) {
            System.out.println(date);
        }

            //LocalDate ovulationDate = predictOvulationPeriod(start);


            //System.out.println("Predicted Ovulation Date: " + ovulationDate.format(formatter));

    }

}
