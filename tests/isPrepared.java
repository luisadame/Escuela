import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class isPrepared extends StudentTest {

    /**
     * Test that a student is prepared if its average is greater that 7
     * and all subjects pass.
     */
    @Test
    void testIsPrepared() {
        for (String subject: luis.subjectNames) {
            luis.setSubjectGrade(subject, 8.0);
        }
        assertTrue(luis.isPrepared());

        for (String subject: luis.subjectNames) {
            luis.setSubjectGrade(subject, 7.0);
        }
        assertFalse(luis.isPrepared());

        for (String subject: luis.subjectNames) {
            luis.setSubjectGrade(subject, 10.0);
        }
        luis.subjects.replace("Maths", 4.9);
        assertFalse(luis.isPrepared());
    }
}
