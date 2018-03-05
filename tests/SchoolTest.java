import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class SchoolTest {

    static School school;
    static int nTests = 0;

    @BeforeAll
    static void beforeAll() {
        System.out.println("School Tests:");
    }

    /**
     * Create a set of students which ages are ranged from 17 to 19.
     * Set their grades through 1 to 10.
     */
    @BeforeEach
    void prepareObjects() {
        school = new School();
        Random rand = new Random();

        for (int i = 0; i < 20; i++) {
            Student k = new Student();
            if( i == 1 ) k.age = 18;
            if( i % 2 == 0)
                k.age = rand.nextInt(19) + 17;
            k.setGrade(rand.nextInt(10) + 1);
        }
    }
    @AfterEach
    void afterEach() {
        Student.students.clear();
        System.out.println("\tTests done: " + ++nTests);
    }

    /**
     * Test that sortByGrades returns an array of two arrays which
     * contains the grades below the given grade and above.
     *
     * - Get the the value returned from sortByGrade, flatten the arrays,
     *  map the values to the grades.
     * - Assert the given grade is not present in the array of grades.
     */
    @Test
    void sortByGradeTest() {

        System.out.println("\tSorted by grade test.");
        for (ArrayList<Student> students: school.sortByGrade(5.0)) {
            StringBuilder grades = new StringBuilder("\t{");
            for (int i = 0; i < students.size(); i++) {
                Student student = students.get(i);
                if (i == students.size() - 1) {
                    grades.append(student.getGrade()).append("}");
                } else {
                    grades.append(student.getGrade()).append(", ");
                }
            }
            System.out.println(grades);
        }

        ArrayList<Double> results = school.sortByGrade(5.0).stream()
                                    .flatMap(Collection::stream)
                                    .collect(Collectors.toCollection(ArrayList::new))
                                    .stream().map(Student::getGrade)
                                    .collect(Collectors.toCollection(ArrayList::new));

        assertFalse(results.contains(5.0));
    }

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