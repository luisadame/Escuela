import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class sameGradeAs extends StudentTest {

    /**
     * Test that sameGradeAs returns true if two students have the same grade in every subject.
     */
    @Test
    void testSameGradesAs() {
        // Create a student that has the same marks as one of the previously created.
        Student newStudent = new Student();
        newStudent.setAVG(0.0);
        // Assert that the new student has the same marks and that it doesnt.
        assertTrue(newStudent.sameGradesAs(Student.students.get(0)));
        assertFalse(newStudent.sameGradesAs(Student.students.get(5)));
    }
}
