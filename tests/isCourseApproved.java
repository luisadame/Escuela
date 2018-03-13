import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class isCourseApproved extends StudentTest {

    double min = 5.00;
    double max = 10.00;

    /**
     * Use of decision coverage technique.
     */
    @Test
    void testValidCases() {
        luis.setAVG(min);
        assertTrue(luis.isCourseApproved());
        luis.setAVG(max);
        assertTrue(luis.isCourseApproved());
    }

    @Test
    void testInferiorValue() {
        luis.setSubjectGrade("Physics", min - 0.01);
        assertFalse(luis.isCourseApproved());
    }

    @Test
    void testSuperiorValue() {
        luis.setSubjectGrade("Physics", max + 0.01);
        assertFalse(luis.isCourseApproved());
    }

    @Test
    void testNullValue() {
        luis.subjects.replace("Physics", null);
        assertFalse(luis.isCourseApproved());
    }

    @Test
    void testAbscenceOfGrades() {
        luis.subjects.replaceAll((k, v) -> null);
        assertFalse(luis.isCourseApproved());
    }
}
