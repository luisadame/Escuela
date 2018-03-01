import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    @Test
    void testIsPrepared() {
        Student luis = new Student();
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
}