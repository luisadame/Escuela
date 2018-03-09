import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class passedSubjectBetween extends SchoolTest {

    @Test
    void testPassedSubjectBetween() {
        // Clear the students to make a more specific set of students.
        Student.students.clear();
        // Make the set and save them in an array.
        ArrayList<Student> expected = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Student k = new Student();
            if(i == 2) {
                k.setSubjectGrade("Physics", 6.0);
                expected.add(k);
            }
            if(i == 3) {
                k.setSubjectGrade("Physics", 7.0);
                expected.add(k);
            }
        }
        // Assert there are 2 students between 5 and 8.
        ArrayList<Student> actual = school.passedSubjectBetween("Physics", 5.0, 8.0);
        assertArrayEquals(expected.toArray(), actual.toArray());
    }
}
