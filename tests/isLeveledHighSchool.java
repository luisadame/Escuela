import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test with no students, with one, and many.
 */
public class isLeveledHighSchool extends SchoolTest {

    @BeforeEach
    void clearStudents() {
        Student.students.clear();
    }

    @Test
    void testWithNoStudents() {
        assertFalse(school.isLeveledHighSchool());
    }

    /**
     * If there's just one student and it is prepared then the school should be leveled.
     * With this one I make use of the technique statement coverage and decision coverage.
     * Making sure that if there are not prepared students returns false,
     * and if there are only prepared students it returns true.
     */
    @Test
    void testWithOneStudent() {
        Student k = new Student();
        k.setAVG(5.0);
        assertFalse(school.isLeveledHighSchool());
        k.setAVG(8.0);
        assertTrue(school.isLeveledHighSchool());
    }

    /**
     * This test is actually the one that is testing the difference in grades
     * and calculating if it is a leveledHighSchool
     */
    @Test
    void testWithManyStudents() {
        // Make a new set of students that are all above 5.
        // the difference in grades is less than 2
        for (int i = 0; i < 10; i++) {
            Student k = new Student();
            if( i <=4 ) {
                k.setAVG(6.0);
            }else{
                k.setAVG(7.5);
            }
        }
        assertTrue(school.isLeveledHighSchool());
        Student.students.clear();
        // Make a new set of students that are all above 5.
        // the difference in grades is greater than 2
        for (int i = 0; i < 10; i++) {
            Student k = new Student();
            if( i <=4 ) {
                k.setAVG(5.0);
            }else{
                k.setAVG(7.5);
            }
        }
        assertFalse(school.isLeveledHighSchool());
    }

    /**
     * Create a set of students who are not prepared.
     */
    @Test
    void testWithNoPreparedStudents() {
        for (int i = 0; i < 10; i++) {
            Student k = new Student();
            k.setAVG(6.25);
        }
        assertFalse(school.isLeveledHighSchool());
    }

    /**
     * Create a set of students who are prepared.
     */
    @Test
    void testWithPreparedStudents() {
        for (int i = 0; i < 10; i++) {
            Student k = new Student();
            k.setAVG(7.25);
        }
        assertTrue(school.isLeveledHighSchool());
    }
}
