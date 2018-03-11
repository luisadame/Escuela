import org.junit.jupiter.api.*;

class StudentTest extends Test {

    Student luis;

    /**
     * Create a set of students which grades are from 0 to 10.
     */
    @BeforeAll
    static void beforeAll() {
        for (int i = 0; i < 11; i++) {
            Student k = new Student();
            for (String subject: k.subjectNames) {
                k.setSubjectGrade(subject, (double) i);
            }
        }

        // add a null element
        Student.students.set(7, null);
    }

    @BeforeEach
    void beforeEach() {
        this.luis = new Student();
    }
}