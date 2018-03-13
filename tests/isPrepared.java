import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class isPrepared extends StudentTest {

    /**
     * Test that a student is prepared if its average is greater than 7
     * and all subjects pass.
     */
    @Test
    void testIsPrepared() {
        luis.setAVG(8.0);
        assertTrue(luis.isPrepared());

        luis.setAVG(7.0);
        assertFalse(luis.isPrepared());

        luis.setAVG(10.0);
        luis.subjects.replace("Maths", 4.9);
        assertFalse(luis.isPrepared());
    }

    /**
     * Usar la tecnica de particiones equivalentes y valores limites.
     * Use equivalents partitions technique and limit values.
     */
    @Test
    void testIsPreparedWithInvalidCase() {
        luis.setAVG(6.9);
        assertFalse(luis.isPrepared());

        luis.setAVG(10.1);
        assertFalse(luis.isPrepared());

        luis.setAVG(Integer.MIN_VALUE);
        assertFalse(luis.isPrepared());

        luis.setAVG(Integer.MAX_VALUE);
        assertFalse(luis.isPrepared());
    }
}
