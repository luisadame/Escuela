import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class isLeveledHighSchool extends SchoolTest {

    @Test
    void testIsLeveledHighSchool() {
        // Clear the students.
        Student.students.clear();
        // Make a new set of students that are all above 5.
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
}
