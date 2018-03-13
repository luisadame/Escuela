import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class sameGradeAs extends StudentTest {

    /**
     * Test that sameGradeAs returns true if two students have the same grade in every subject.
     * Use of decision coverage, by creating two cases which one will return true and the other false.
     */
    @Test
    void testSameGradesAs() {
        // Create a student that has the same marks as one of the previously created.
        Student newStudent = new Student();
        newStudent.setAVG(0);
        // Assert that the new student has the same marks and that it doesnt.
        assertTrue(newStudent.sameGradesAs(Student.students.get(0)));
        assertFalse(newStudent.sameGradesAs(Student.students.get(5)));
    }
}
