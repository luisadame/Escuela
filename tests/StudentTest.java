import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    Student luis;

    @BeforeAll
    static void beforeAll() {
        for (int i = 0; i < 11; i++) {
            Student k = new Student();
            for (String subject: k.subjectNames) {
                k.setSubjectGrade(subject, (double) i);
            }
        }
    }

    @BeforeEach
    void beforeEach() {
        this.luis = new Student();
    }

    @Test
    void testIsPrepared() {
        for (String subject: luis.subjectNames) {
            luis.setSubjectGrade(subject, 8.0);
        }
        assertTrue(luis.isPrepared());
        for (String subject: luis.subjectNames) {
            luis.setSubjectGrade(subject, 7.0);
        }
        assertFalse(luis.isPrepared());
        for (String subject: luis.subjectNames) {
            luis.setSubjectGrade(subject, 10.0);
        }
        luis.subjects.replace("Maths", 4.9);
        assertFalse(luis.isPrepared());
    }

    @Test
    void testIsMorePrepared() {
        // Set the average grade to a prepared level for luis
        for (String subject: luis.subjectNames) {
            luis.setSubjectGrade(subject, 8.0);
        }

        // Get the first student who has a greater grade.
        Student better = luis.isMorePrepared();
        assertNotNull(better);
        assertTrue(better.getAVG() > luis.getAVG());
    }
}