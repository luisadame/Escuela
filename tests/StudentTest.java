import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    Student luis;
    static int nTests = 0;

    /**
     * Create a set of students which grades are from 0 to 10.
     */
    @BeforeAll
    static void beforeAll() {
        System.out.println("Student Tests:");
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

    @AfterEach
    void afterEach() {
        System.out.println("\tTests done: " + ++nTests);
    }

    /**
     * Test that a student is prepared if its average is greater that 7
     * and all subjects pass.
     */
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
    void testGetAvg() {
        Student k = new Student();
        k.setAVG(7.0);
        assertEquals(7.0, k.getAVG());
        assertNotEquals(7.1, k.getAVG());
    }

    @Test
    void testIsCourseApproved() {
        luis.setAVG(5.0);
        assertTrue(luis.isCourseApproved());
        // As soon as I fail a subject it should return false.
        luis.setSubjectGrade("Physics", 4.9);
        assertFalse(luis.isCourseApproved());
    }

    /**
     * Test that isMorePrepared returns a student that is more prepared than the current one,
     * based on the average grade in all subjects.
     *
     *  - First create a set of students that range between 1 to 10 in their average grade.
     *  - Set the average of a student to a value that is know to be worse than other student.
     *  - Assert that exists a better student based on the created one.
     *  - Modify the created one to have the maximum average.
     *  - Assert there is no one better.
     */
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

        // Set the average grade to the maximum
        for (String subject: luis.subjectNames) {
            luis.setSubjectGrade(subject, 10.0);
        }
        // Assert there is no one better.
        assertNull(luis.isMorePrepared());
    }

    /**
     * Test that sameGradeAs returns true if two students have the same grade in every subject.
     */
    @Test
    void testSameGradesAs() {
        // Create a student that has the same marks as one of the previously created.
        Student newStudent = new Student();
        for (String subject: newStudent.subjectNames) {
            newStudent.setSubjectGrade(subject, 0.0);
        }
        // Assert that the new student has the same marks and that it doesnt.
        assertTrue(newStudent.sameGradesAs(Student.students.get(0)));
        assertFalse(newStudent.sameGradesAs(Student.students.get(5)));
    }

    /**
     * Test the method that calculates how long the student has been in school.
     */
    @Test
    void testHowLongInSchool() {
        // Create a date from where we are going to calculate the time passed.
        GregorianCalendar date = new GregorianCalendar(2018, 1 - 1, 1);
        luis.setAtSchoolSince(1, 1, 2017);
        // Then  give the difference
        assertEquals("365 days", luis.howLongInSchool(date));
        luis.setAtSchoolSince(5, 4, 2000);
        assertNotEquals("365 days", luis.howLongInSchool(date));
    }
}