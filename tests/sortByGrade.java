import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class sortByGrade extends SchoolTest {

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
}
