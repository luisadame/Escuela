import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class isMorePrepared extends StudentTest {

    /**
     * Test that isMorePrepared returns a student that is more prepared than the current one,
     * based on the average grade in all subjects.
     *
     *  - First create a set of students that range between 1 to 10 in their average grade.
     *  - Set the average of a student to a value that is know to be worse than other student.
     *  - Assert that exists a better student based on the created one.
     *  - Modify the created one to have the maximum average.
     *  - Assert there is no one better.
     */
    @Test
    void testIsMorePrepared() {
        // Set the average grade to a prepared level for luis
        for (String subject: luis.subjectNames) {
            luis.setSubjectGrade(subject, 8.0);
        }

        // Get the first student who has a greater grade.
        Student better = luis.isMorePrepared();
        assertNotNull(better);
        assertTrue(better.getAVG() > luis.getAVG());

        // Set the average grade to the maximum
        for (String subject: luis.subjectNames) {
            luis.setSubjectGrade(subject, 10.0);
        }
        // Assert there is no one better.
        assertNull(luis.isMorePrepared());
    }
}
