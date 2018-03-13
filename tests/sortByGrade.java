import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Makes use of statement coverage.
 * Hace uso de la cobertura de sentencias creando conjuntos específicos
 * de notas.
 */
public class sortByGrade extends SchoolTest {

    /**
     * Helper.
     */
    void printObjects(double grade) {
        System.out.println("\tSorted by grade test.");
        for (ArrayList<Student> students: school.sortByGrade(grade)) {
            StringBuilder grades = new StringBuilder("\t{");
            for (int i = 0; i < students.size(); i++) {
                Student student = students.get(i);
                if (i != students.size() - 1) {
                    grades.append(student.getGrade()).append(", ");
                } else {
                    grades.append(student.getGrade());
                }
            }
            grades.append("}");
            System.out.println(grades);
        }
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
        printObjects(5.0);
        ArrayList<Double> results = school.sortByGrade(5.0).stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toCollection(ArrayList::new))
                .stream().map(Student::getGrade)
                .collect(Collectors.toCollection(ArrayList::new));

        assertFalse(results.contains(5.0));
    }

    @Test
    void withGradesMoreThanExpected() {
        Student.students.clear();
        int n = 15;
        for (int i = 0; i < n; i++) {
            Student k = new Student();
            k.setGrade(7.0);
        }
        printObjects(5.0);
        ArrayList<ArrayList<Student>> results = school.sortByGrade(5.0);

        assertTrue(results.get(0).isEmpty());
        assertTrue(results.get(1).containsAll(Student.students));
    }

    @Test
    void withGradesLessThanExpected() {
        Student.students.clear();
        int n = 15;
        for (int i = 0; i < n; i++) {
            Student k = new Student();
            k.setGrade(3.0);
        }
        printObjects(5.0);
        ArrayList<ArrayList<Student>> results = school.sortByGrade(5.0);

        assertTrue(results.get(1).isEmpty());
        assertTrue(results.get(0).containsAll(Student.students));
    }
}
