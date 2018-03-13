import org.junit.jupiter.api.Test;

import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class howLongInSchool extends StudentTest {

    /**
     * Test the method that calculates how long the student has been in school.
     * Use of decision coverage technique.
     */
    @Test
    void testValidCase() {
        // Create a date from where we are going to calculate the time passed.
        GregorianCalendar date = new GregorianCalendar(2018, 0, 1);
        luis.setAtSchoolSince(1, 1, 2017);
        assertEquals("365 days", luis.howLongInSchool(date));
    }

    @Test
    void testLeapYears() {
        GregorianCalendar date = new GregorianCalendar(2017, 0, 1);
        luis.setAtSchoolSince(1, 1, 2016);
        assertEquals("366 days", luis.howLongInSchool(date));
    }

    @Test
    void testInvalidCase() {
        GregorianCalendar date = new GregorianCalendar(2018, 0, 1);
        luis.setAtSchoolSince(5, 4, 2000);
        assertNotEquals("365 days", luis.howLongInSchool(date));
    }
}
