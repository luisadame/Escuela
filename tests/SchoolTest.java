import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class SchoolTest {

    static School school;

    @BeforeAll
    static void prepareObjects() {
        school = new School();
        for (int i = 0; i < 20; i++) {
            Student k = new Student();
            if( i == 1 ) k.age = 18;
            if( i % 2 == 0)
                k.age = (int) Math.floor(Math.random() * 19) + 17;
            k.setGrade(Math.floor(Math.random() * 10) + 1);
        }
    }

    @Test
    void sortByGradeTest() {

        for (ArrayList<Student> students: school.sortByGrade(5.0)) {
            for(Student student: students) {
                System.out.println(student.getGrade());
            }
            System.out.println("---");
        }

        ArrayList<Double> results = school.sortByGrade(5.0).stream()
                                    .flatMap(Collection::stream)
                                    .collect(Collectors.toCollection(ArrayList::new))
                                    .stream().map(Student::getGrade)
                                    .collect(Collectors.toCollection(ArrayList::new));

        assertFalse(results.contains(5.0));
    }

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
        ArrayList<Student> actual = school.passedSubjectBetweent("Physics", 5.0, 8.0);
        assertArrayEquals(expected.toArray(), actual.toArray());
    }
}