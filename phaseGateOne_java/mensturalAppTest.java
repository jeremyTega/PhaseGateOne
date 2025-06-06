import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class mensturalAppTest {

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

        List<LocalDate> ovulationDates = MenstrualApp.safePerods(startDate);
        assertEquals(4, ovulationDates.size());
         assertTrue(ovulationDates.contains(LocalDate.of(2025, 6, 7)));
         assertTrue(ovulationDates.contains(LocalDate.of(2025, 6, 8)));
        assertTrue(ovulationDates.contains(LocalDate.of(2025, 6, 9)));
         assertTrue(ovulationDates.contains(LocalDate.of(2025, 6, 10)));

    }

}
