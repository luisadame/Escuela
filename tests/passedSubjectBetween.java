import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class passedSubjectBetween extends SchoolTest {

    @BeforeEach
    void beforeEach() {
        Student.students.clear();
    }

    @Test
    void testPassedSubjectBetween() {
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

    /**
     * Here there should be three students in the array given
     * which are inside the range.
     */
    @Test
    void testWithDecimalsOfDifference() {
        ArrayList<Student> expected = new ArrayList<>();
        double grade = 5.9;
        for (int i = 0; i < 6; i++) {
            Student k = new Student();
            k.setSubjectGrade("Physics", grade);
            if(i >= 2 && i <= 4) {
                expected.add(k);
            }
            grade += 0.05;
        }
        ArrayList<Student> actual = school.passedSubjectBetween("Physics", 6.0, 6.1);
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    void testWithNoDifference() {
        ArrayList<Student> expected = new ArrayList<>();
        double grade = 5.9;
        for (int i = 0; i < 6; i++) {
            Student k = new Student();
            k.setSubjectGrade("Physics", grade);
            if(i == 2) {
                expected.add(k);
            }
            grade += 0.05;
        }
        ArrayList<Student> actual = school.passedSubjectBetween("Physics", 6.0, 6.0);
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    void testWithUnexpectedDifference() {
        ArrayList<Student> expected = new ArrayList<>();
        double grade = 5.9;
        for (int i = 0; i < 6; i++) {
            Student k = new Student();
            k.setSubjectGrade("Physics", grade);
            grade += 0.05;
        }
        ArrayList<Student> actual = school.passedSubjectBetween("Physics", 6.2, 6.0);
        assertArrayEquals(expected.toArray(), actual.toArray());
    }
}
