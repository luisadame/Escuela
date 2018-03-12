import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class isCourseApproved extends StudentTest {

    /**
     * Use of decision coverage technique.
     */
    @Test
    void testIsCourseApproved() {
        luis.setAVG(5.0);
        assertTrue(luis.isCourseApproved());
        // As soon as I fail a subject it should return false.
        luis.setSubjectGrade("Physics", 4.9);
        assertFalse(luis.isCourseApproved());
    }
}
