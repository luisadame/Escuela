import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * A valid grade is considered to be between 0 and 10.
 * With a maximum of two decimal points for the grade.
 * Use of equivalent partitions and limit values techniques.
 */
public class getAVG extends StudentTest {

    double min = 0;
    double max = 10;

    @Test
    void testValidValues() {
        luis.setAVG(min);
        assertEquals(min, luis.getAVG());
        luis.setAVG(7.25);
        assertEquals(7.25, luis.getAVG());
        luis.setAVG(max);
        assertEquals(max, luis.getAVG());
    }

    /**
     * In these tests apart from using the black box techniques,
     * we make statement coverage tests by making sure that the grade doesn't change.
     */
    @Test
    void testInferiorMinusOneValue() {
        luis.setAVG(min - 1);
        assertNotEquals(min - 1, luis.getAVG());
    }

    @Test
    void testSuperiorPlusOneValue() {
        luis.setAVG(max + 1);
        assertNotEquals(max + 1, luis.getAVG());
    }

    @Test
    void testTwoDecimalPointsInferior() {
        luis.setAVG(0.01);
        assertEquals(0.01, luis.getAVG());
        luis.setAVG(-0.01);
        assertNotEquals(-0.01, luis.getAVG());
    }

    @Test
    void testTwoDecimalPointsSuperior() {
        luis.setAVG(9.99);
        assertEquals(9.99, luis.getAVG());
        luis.setAVG(10.01);
        assertNotEquals(10.01, luis.getAVG());
    }
}
