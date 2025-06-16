import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class MenstrualApp {

    public static LocalDate startDate(int year, int month, int day) {
        try {
            return LocalDate.of(year, month, day);
        } catch (Exception e) {
            System.out.println( e.getMessage());
            return null;
        }
    }

    public static List<LocalDate> predictOvulationPeriod(LocalDate startDate) {
        List<LocalDate> ovulationDates = new ArrayList<>();
        for (int i = 14; i <= 19; i++) {
            ovulationDates.add(startDate.plusDays(i));
        }
        return ovulationDates;
    }

    public static List<LocalDate> safePeriods(LocalDate startDate) {
        List<LocalDate> safePeriod = new ArrayList<>();
        for (int i = 6; i <= 9; i++) {
            safePeriod.add(startDate.plusDays(i));
        }
        return safePeriod;
    }

    public static LocalDate predictedPeriodStop(LocalDate startDate, int periodLength) {
        return startDate.plusDays(periodLength - 1); 
    }

    public static LocalDate nextPeriodStart(LocalDate startDate, int cycleLength) {
        return startDate.plusDays(cycleLength);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");

        System.out.println(" Welcome to the Menstrual Period Tracker");


        System.out.print("Enter the first day of your current menstruation (day): ");
        int day = input.nextInt();
        System.out.print("Enter the month: ");
        int month = input.nextInt();
        System.out.print("Enter the year: ");
        int year = input.nextInt();

        System.out.print("Enter your average cycle length in days (e.g. 28): ");
        int cycleLength = input.nextInt();

        System.out.print("Enter your average menstrual duration in days (e.g. 5): ");
        int periodLength = input.nextInt();

       
        LocalDate start = startDate(year, month, day);
        if (start == null) return;

        System.out.println("\n Menstrual Start Date: " + start.format(formatter));
        System.out.println(" Predicted Period End Date: " + predictedPeriodStop(start, periodLength).format(formatter));
        System.out.println("\n✅ Predicted Safe Days:");
        for (LocalDate date : safePeriods(start)) {
            System.out.println(" - " + date.format(formatter));
        }

        System.out.println("\n Predicted Ovulation Window:");
        for (LocalDate date : predictOvulationPeriod(start)) {
            System.out.println(" - " + date.format(formatter));
        }
        System.out.println("\n Your next period is expected to start around: " +
            nextPeriodStart(start, cycleLength).format(formatter));
    }
}
