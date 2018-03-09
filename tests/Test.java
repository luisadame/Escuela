import org.junit.jupiter.api.AfterEach;

public class Test {

    static int nTests = 0;

    @AfterEach
    void afterEach() {
        System.out.println("\tTests done: " + ++nTests);
    }
}
