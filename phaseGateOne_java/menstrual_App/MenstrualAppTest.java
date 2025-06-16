
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.List;


public class MenstrualAppTest {

    @Test
    public void testValidDate() {
        int year = 2025;
        int month = 6;
        int day = 6;

        LocalDate expected = LocalDate.of(year, month, day);
        LocalDate actual = MenstrualApp.startDate(year, month, day);

        assertEquals(expected, actual);
    }

    @Test
    public void testInvalidDate() {
        int year = 2025;
        int month = 2;
        int day = 30;

        LocalDate actual = MenstrualApp.startDate(year, month, day);
        //assertNull(actual);
    }

    @Test
    public void testPredictOvulationPeriod() {
        LocalDate startDate = LocalDate.of(2025, 6, 1);
        List<LocalDate> ovulationDates = MenstrualApp.predictOvulationPeriod(startDate);

        assertEquals(6, ovulationDates.size());
        assertTrue(ovulationDates.contains(LocalDate.of(2025, 6, 15)));
        assertTrue(ovulationDates.contains(LocalDate.of(2025, 6, 16)));
        assertTrue(ovulationDates.contains(LocalDate.of(2025, 6, 17)));
        assertTrue(ovulationDates.contains(LocalDate.of(2025, 6, 18)));
        assertTrue(ovulationDates.contains(LocalDate.of(2025, 6, 19)));
        assertTrue(ovulationDates.contains(LocalDate.of(2025, 6, 20)));
    }

    @Test
    public void testSafePeriod() {
        LocalDate startDate = LocalDate.of(2025, 6, 1);
        List<LocalDate> safeDates = MenstrualApp.safePeriods(startDate);

        assertEquals(4, safeDates.size());
        assertTrue(safeDates.contains(LocalDate.of(2025, 6, 7)));
        assertTrue(safeDates.contains(LocalDate.of(2025, 6, 8)));
        assertTrue(safeDates.contains(LocalDate.of(2025, 6, 9)));
        assertTrue(safeDates.contains(LocalDate.of(2025, 6, 10)));
    }

    @Test
    public void testPredictNextPeriodDate() {
        LocalDate startDate = LocalDate.of(2025, 6, 1);
        int cycleLength = 28;

        LocalDate nextPeriod = MenstrualApp.nextPeriodStart(startDate, cycleLength);
        assertEquals(LocalDate.of(2025, 6, 29), nextPeriod);
    }

    @Test
    public void testPredictPeriodEndDate() {
        LocalDate startDate = LocalDate.of(2025, 6, 1);
        int periodLength = 5;

        LocalDate periodEnd = MenstrualApp.predictedPeriodStop(startDate, periodLength);
        assertEquals(LocalDate.of(2025, 6, 5), periodEnd);
    }
}
