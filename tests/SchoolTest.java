import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SchoolTest {

    static School school;

    @BeforeAll
    static void prepareObjects() {
        school = new School();
        for (int i = 0; i < 20; i++) {
            (new Student()).setGrade(Math.floor(Math.random() * 10) + 1);
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

    }
}