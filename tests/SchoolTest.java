import org.junit.jupiter.api.*;
import java.util.Random;

class SchoolTest extends Test {

    static School school;

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
        super.afterEach();
        Student.students.clear();
    }
}