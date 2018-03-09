import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class isNotPreparedAndShould extends SchoolTest {

    /**
     * - In the random set of students there is going to be for sure a student
     *  that is not prepared.
     * - Then clear the students. Make a new student. Make it prepared.
     * - Now the method returns false because there are no students unprepared.
     */
    @Test
    @DisplayName("Test if there are students who are not prepared and are 18.")
    void testIsNotPreparedAndShould() {
        assertTrue(school.studentsNotPreparedAndShould());
        Student.students.clear();
        Student luis = new Student();
        luis.age = 18;
        luis.setAVG(7.1);
        assertFalse(school.studentsNotPreparedAndShould());
    }
}
